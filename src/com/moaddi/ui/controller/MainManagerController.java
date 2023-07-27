package com.moaddi.ui.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.moaddi.service.CustomerService;
import com.moaddi.service.LockService;
import com.moaddi.service.MachineService;
import com.moaddi.service.UserRoleService;
import com.moaddi.service.WarehouseService;
import com.moaddi.service.dto.CustomerDTO;
import com.moaddi.service.dto.LockDTO;
import com.moaddi.service.dto.MachineDTO;
import com.moaddi.service.dto.UserRoleDTO;
import com.moaddi.service.dto.WarehouseDTO;
import com.moaddi.ui.forms.AccountForm;
import com.moaddi.ui.forms.WarehouseForm;

@Controller
public class MainManagerController {

	/* code for mail */
	@Autowired
	private JavaMailSender mailSender;
	/* code for mail */
	@Autowired
	private CustomerService customerService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private WarehouseService warehouseService;
	@Autowired
	private MachineService machineService;
	@Autowired
	private LockService lockService;

	@RequestMapping("/mainmanager/signout")
	public String showSignout(HttpServletRequest response) {

		return "redirect:../otherlogin.htm?suMsg=Your successfully Signedout";
	}
	@RequestMapping("/mainmanager/mainmanagerhome")
	public String mainManagerHome() {

		return "mainmanagerhome.page";

	}
	@RequestMapping("/mainmanager/createaccount")
	public String showCreateAccount(HttpServletRequest response) {

		if (response.getParameter("u") != null) {
			return "mainmanagercreate"
					+ response.getParameter("u").toLowerCase() + ".page";
		} else {
			return "mainmanagercreatemanager.page";
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/mainmanager/checkaccount")
	public @ResponseBody
	String getCheckAccountInJSON(@RequestParam("userId")
	String userId) {

		Map<String, Object> userAccount = null;

		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		if (userId != null && !userId.trim().equals("")) {
			userAccount = customerService.loadCustomer(userId.trim());
			if (userAccount != null) {
				System.out.println(userAccount);
				try {
					result = mapper.writeValueAsString(userAccount);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				result = "fail";
			}

		}

		return result;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/mainmanager/createaccount")
	public String createAccount(AccountForm accountForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println(accountForm.getUserRole() + "role");
		if (accountForm != null) {
			UserRoleDTO userRoleDTO = new UserRoleDTO();
			userRoleDTO.setAccountKind("Company");
			userRoleDTO.setCity(accountForm.getCity());
			userRoleDTO.setCountry(accountForm.getCountry());
			userRoleDTO.setCreatedBy(1L);
			userRoleDTO.setCustomerId(accountForm.getCustomerId());
			userRoleDTO.setFullName(accountForm.getFullName());
			userRoleDTO.setDocumentFileName(accountForm.getDoc()
					.getOriginalFilename());
			userRoleDTO.setStatus("Active");
			userRoleDTO.setUserRole(accountForm.getUserRole());
			/** getting of countrycode and email code start heare ************** */
			String countryCode = accountForm.getCountryCode();
			String email = accountForm.getEmail();
			System.out.println(email + "email");
			String NewString = countryCode.replace("+", "");
			String NewRole = accountForm.getUserRole().substring(0, 2);

			System.out.println(NewString + "NewString");
			/** *********generate random userId and password***************** */
			int n = 3;
			Random randGen = new Random();

			int startNum = (int) Math.pow(10, n - 1);
			int range = (int) (Math.pow(10, n) - startNum + 1);

			int randomuserId = randGen.nextInt(range) + startNum;
			String userId = NewString + NewRole + randomuserId;
			System.out.println(userId + "user role basedon");
			int randomPassword = randGen.nextInt(range) + startNum;
			String password = NewString + randomPassword;
			/* code start mail ################################ */
           try
           {
			SimpleMailMessage email1 = new SimpleMailMessage();
			email1.setTo(email);
			email1.setSubject("Your userName and Password");
			email1.setText("userIdNo:" + userId + "password is:" + password);

			// sends the e-mail
			mailSender.send(email1);
           }
           catch(Exception e)
           {
        	   e.printStackTrace();
           }
			// send userId password to user roles table
			System.out.println(userId + "randomuserId");
			System.out.println(password + "randomPassword");
			userRoleDTO.setUserId(userId);
			userRoleDTO.setPassword(password);

			/* code end mail ################################ */

			/** creation of userId and password code end heare ************** */

			Long userRoleId = userRoleService.saveUserRole(userRoleDTO);
			
			
			if (accountForm.getUserRole().equalsIgnoreCase("Warehouse")) {
				accountForm.setUserRole("UserWarehouse");
			}
			if (userRoleId != null) {

				MultipartFile multiFile = accountForm.getDoc();
				try {
					// just to show that we have actually received the file

					String fileName = multiFile.getOriginalFilename();

					String path = request.getSession().getServletContext()
							.getRealPath("/");

					// making directories for our required path.
					byte[] bytes = multiFile.getBytes();
					File directory = new File(path + "/uploads/documents/"
							+ userRoleId);
					directory.mkdirs();
					// saving the file
					File file = new File(directory.getAbsolutePath()
							+ System.getProperty("file.separator") + fileName);
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(file));
					stream.write(bytes);
					stream.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
			}

		}

		return "redirect:createaccount.htm?u="
				+ accountForm.getUserRole().toLowerCase() + "&s=succ";
	}

	/*
	 * @RequestMapping(method = RequestMethod.POST, value =
	 * "/mainmanager/createaccount") public String createAccount(AccountForm
	 * accountForm, ModelMap modelMap, HttpServletRequest request,
	 * HttpServletResponse response) { if (accountForm != null) { UserRoleDTO
	 * userRoleDTO = new UserRoleDTO(); userRoleDTO.setAccountKind("Company");
	 * userRoleDTO.setCity(accountForm.getCity());
	 * userRoleDTO.setCountry(accountForm.getCountry());
	 * userRoleDTO.setCreatedBy(1L);
	 * userRoleDTO.setCustomerId(accountForm.getCustomerId());
	 * userRoleDTO.setDocumentFileName(accountForm.getDoc()
	 * .getOriginalFilename()); userRoleDTO.setStatus("Active");
	 * userRoleDTO.setUserRole(accountForm.getUserRole());
	 * 
	 * Long userRoleId=userRoleService.saveUserRole(userRoleDTO);
	 * if(accountForm.getUserRole().equalsIgnoreCase("Warehouse")) {
	 * accountForm.setUserRole("UserWarehouse"); } if(userRoleId!=null) {
	 * 
	 * MultipartFile multiFile = accountForm.getDoc(); try { // just to show
	 * that we have actually received the file
	 * 
	 * String fileName=multiFile.getOriginalFilename();
	 * 
	 * String path=request.getSession().getServletContext().getRealPath("/");
	 * 
	 * //making directories for our required path. byte[] bytes =
	 * multiFile.getBytes(); File directory= new File(path+
	 * "/uploads/documents/"+userRoleId); directory.mkdirs(); // saving the file
	 * File file=new
	 * File(directory.getAbsolutePath()+System.getProperty("file.separator")+fileName);
	 * BufferedOutputStream stream = new BufferedOutputStream( new
	 * FileOutputStream(file)); stream.write(bytes); stream.close(); } catch
	 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); } } }
	 * 
	 * return
	 * "redirect:createaccount.htm?u="+accountForm.getUserRole().toLowerCase()+"&s=succ"; }
	 */

	@RequestMapping("/mainmanager/controlaccount")
	public String showContollAccount() {

		return "mainmanagercontrolaccount.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/mainmanager/checkaccountstatus")
	public @ResponseBody
	String getCheckAccountStatusInJSON(@RequestParam("userId")
	String userId, @RequestParam("accountKind")
	String accountKind, @RequestParam("accountName")
	String accountName, HttpServletRequest request) {

		Map<String, Object> userAccount = null;
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		Long customerId = 0L;
		if (userId != null && !userId.trim().equals("") && accountKind != null
				&& !accountKind.trim().equals("") && accountName != null
				&& !accountName.trim().equals("")) {
			/* userAccount = customerService.loadCustomer(userId.trim()); */
			userAccount = userRoleService.loadUser(userId.trim());

			/*
			 * for (Map.Entry<String, Object> entry : userAccount.entrySet()) {
			 * System.out.println("Key = " + entry.getKey() + ", Value = " +
			 * entry.getValue()); if(entry.getKey().equals("customerId")) {
			 * customerId=(Long) entry.getValue(); } }
			 * System.out.println(customerId+"customerId1");
			 * System.out.println(customerId+"customerId"); CustomerDTO
			 * customerDTO = customerService.loadCustomer(customerId);
			 * 
			 * System.out.println(customerDTO.getFullName()+"fullmame");
			 * if(customerDTO!=null) request.setAttribute("customer",
			 * customerDTO);
			 */
			if (userAccount != null) {
				System.out.println(userAccount);
				try {
					if (accountName.trim().equalsIgnoreCase("Customer")) {
						result = mapper.writeValueAsString(userAccount);
					} else {
						System.out.println(userAccount);
						Map<String, Object> userRole = userRoleService
								.loadUser(accountName, accountKind,
										(Long) userAccount.get("customerId"));
						System.out.println(userRole);
						if (userRole != null) {
							userAccount.putAll(userRole);
							System.out.println("u..." + userAccount);
							result = mapper.writeValueAsString(userAccount);

						} else {
							result = "fail";
						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				result = "fail";
			}

		}

		return result;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/mainmanager/updateaccountstatus")
	public String updtaeAccountStatus(HttpServletRequest request,
			HttpServletResponse response) {

		userRoleService.modifyUserStatus(new Long(request
				.getParameter("userRoleId")), request
				.getParameter("accountStatus"));

		return "redirect:controlaccount.htm?s="
				+ request.getParameter("accountStatus");
	}

	@RequestMapping("/mainmanager/createwarehouse")
	public String showCreateWarehouse() {

		return "mainmanagercreatelocationwarehouse.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/mainmanager/checkwarehousesno")
	public @ResponseBody
	String getCheckWarehouseInJSON(@RequestParam("warehouseSNO")
	String warehouseSNO) {

		String result = null;

		if (warehouseSNO != null) {
			try {
				boolean isExists = warehouseService
						.isWarehouseExist(warehouseSNO.toUpperCase());

				if (isExists) {
					return "{\"msg\":\"fail\"}";
				} else {
					return "{\"msg\":\"success\"}";
				}

			} catch (Exception e) {
				e.printStackTrace();
				return "fail";
			}
		}
		return result;
	}

	@RequestMapping("/mainmanager/viewaccount")
	public String showViewAccount(HttpServletRequest request) {

		String cid = request.getParameter("cid");
		String uid = request.getParameter("uid");
		if (cid != null && uid != null && !cid.trim().equals("")
				&& !uid.trim().equals("")) {
			Long customerId = new Long(cid);
			Long userRoleId = new Long(uid);
			CustomerDTO customerDTO = customerService.loadCustomer(customerId);
			UserRoleDTO userRoleDTO = userRoleService.loadUserRole(userRoleId);
			if (customerDTO != null) {
				request.setAttribute("customer", customerDTO);
			}
			if (userRoleDTO != null) {
				request.setAttribute("userRole", userRoleDTO);
			}
		}
		return "mainmanagerviewaccount.page";

	}

	@RequestMapping("/mainmanager/viewpage")
	public String showViewPage(HttpServletRequest request) {

		String page = request.getParameter("page");
		String pid = request.getParameter("id");
		if (page != null && pid != null && !page.trim().equals("")
				&& !pid.trim().equals("")) {
			Long id = new Long(pid);
			if (page.equalsIgnoreCase("Warehouse Page")) {
				WarehouseDTO warehouseDTO = warehouseService.loadWarehouse(id);
				request.setAttribute("warehouse", warehouseDTO);
				return "mainmanagerviewwarehouse.page";
			}

			if (page.equalsIgnoreCase("Machine Page")) {
				/*
				 * MachineDTO machineDTO=machineService.loadMachine(id);
				 * request.setAttribute("machine", machineDTO);
				 */
				MachineDTO machineDTO = machineService.loadMachine(id);
				Long wareHouseid = machineDTO.getWarehouseId();
				System.out.println(wareHouseid);
				WarehouseDTO warehouseDTO = (WarehouseDTO) warehouseService
						.loadWarehouse(wareHouseid);
				request.setAttribute("machine", machineDTO);
				request.setAttribute("warehouse", warehouseDTO);
				return "mainmanagerviewmachine.page";

			}
			if (page.equalsIgnoreCase("Lock Page")) {
				/*
				 * LockDTO lockDTO=lockService.loadLock(id);
				 * request.setAttribute("lock",lockDTO);
				 */
				LockDTO lockDTO = lockService.loadLock(id);
				Long wareHouseid = lockDTO.getWarehouseId();
				System.out.println(wareHouseid);
				WarehouseDTO warehouseDTO = (WarehouseDTO) warehouseService
						.loadWarehouse(wareHouseid);
				System.out.println(warehouseDTO);
				request.setAttribute("warehouse", warehouseDTO);
				request.setAttribute("lock", lockDTO);
				return "mainmanagerviewlock.page";

			}

		}
		return "redirect:controlpage.htm";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/mainmanager/createwarehouse")
	public String createWarehouse(WarehouseForm warehouseForm,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) {
		if (warehouseForm != null) {
			WarehouseDTO warehouseDTO = new WarehouseDTO();
			warehouseDTO.setAddress(warehouseForm.getAddress());
			warehouseDTO.setCity(warehouseForm.getCity());
			warehouseDTO.setCountry(warehouseForm.getCountry());
			warehouseDTO.setStatus("Active");
			warehouseDTO.setWarehouseSno(warehouseForm.getWarehouseSNO()
					.toUpperCase());
			warehouseDTO.setCreatedBy(1L);
			warehouseService.saveWarehouse(warehouseDTO);

		}

		return "redirect:createwarehouse.htm?s=success";
	}

	@RequestMapping("/mainmanager/controlpage")
	public String showContollPage() {

		return "mainmanagercontrolpage.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/mainmanager/checkpagestatus")
	public @ResponseBody
	String getCheckPageStatusInJSON(@RequestParam("id")
	String id, @RequestParam("pageName")
	String pageName) {
		String result = null;
		if (pageName != null) {
			ObjectMapper mapper = new ObjectMapper();
			if (pageName.trim().equalsIgnoreCase("Warehouse Page")) {
				Map<String, Object> warehouse = warehouseService
						.loadWareHouse(id);
				if (warehouse != null) {
					try {
						result = mapper.writeValueAsString(warehouse);
					} catch (JsonGenerationException e) {

						e.printStackTrace();
					} catch (JsonMappingException e) {

						e.printStackTrace();
					} catch (IOException e) {

						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					result = "fail";
				}
			}

			if (pageName.trim().equalsIgnoreCase("Machine Page")) {
				Map<String, Object> machine = machineService.loadMachine(id);
				if (machine != null) {
					try {
						Long warehouseId = (Long) machine.get("warehouseId");
						if (warehouseId != null) {
							machine.putAll(warehouseService
									.loadWareHouse(warehouseId));
						}
						result = mapper.writeValueAsString(machine);
					} catch (JsonGenerationException e) {

						e.printStackTrace();
					} catch (JsonMappingException e) {

						e.printStackTrace();
					} catch (IOException e) {

						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					result = "fail";
				}
			}
			if (pageName.trim().equalsIgnoreCase("Lock Page")) {
				Map<String, Object> lock = lockService.loadLock(id);
				if (lock != null) {
					try {
						Long warehouseId = (Long) lock.get("warehouseId");
						if (warehouseId != null) {
							lock.putAll(warehouseService
									.loadWareHouse(warehouseId));
						}
						result = mapper.writeValueAsString(lock);
					} catch (JsonGenerationException e) {

						e.printStackTrace();
					} catch (JsonMappingException e) {

						e.printStackTrace();
					} catch (IOException e) {

						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					result = "fail";
				}
			}
		}

		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/mainmanager/updatepagestatus")
	public String updtaePageStatus(HttpServletRequest request,
			HttpServletResponse response) {
		String pageName = request.getParameter("page");
		if (pageName != null) {

			if (pageName.trim().equalsIgnoreCase("Warehouse Page")) {
				warehouseService.modifyWarehouseStatus(new Long(request
						.getParameter("id")), request
						.getParameter("pageStatus"));
			}
		}

		return "redirect:controlpage.htm?p=" + pageName + "&s="
				+ request.getParameter("pageStatus");
	}

	@RequestMapping("/mainmanager/companybalance")
	public String showCompanyBalance() {

		return "mainmanagercompanybalance.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/mainmanager/checkcompanybalance")
	public @ResponseBody
	String getCheckBalanceInJSON(@RequestParam("accountKind")
	String accountKind, @RequestParam("city")
	String city, @RequestParam("country")
	String country) {
		String result = null;
		String currency = "SR";
		double totalcost = 0;

		if (country != null) {

			if (country.equalsIgnoreCase("Saudi Arabia")) {
				currency = "SR";

			} else if (country.equalsIgnoreCase("Qatar")) {
				currency = "QAR";

			} else if (country.equalsIgnoreCase("United Arab Emirates")) {
				currency = "AED";

			} else if (country.equalsIgnoreCase("Kuwait")) {
				currency = "KWD";

			} else if (country.equalsIgnoreCase("Bahrain")) {
				currency = "BHD";

			} else if (country.equalsIgnoreCase("Oman")) {
				currency = "OMR";

			} else if (country.equalsIgnoreCase("Egypt")) {
				currency = "EGP";

			} else if (country.equalsIgnoreCase("India")) {
				currency = "INR";

			}

		}
		if (country == null
				|| country.trim().equals("")
				|| country.trim().equalsIgnoreCase("All")
				&& (city == null || city.trim().equals("") || city.trim()
						.equalsIgnoreCase("All"))
				&& (accountKind == null || accountKind.trim().equals("") || accountKind
						.trim().equalsIgnoreCase("All"))) {
			totalcost = machineService.loadMachinesCost()
					+ machineService.loadMachineSalesCost()
					+ lockService.loadLocksCost()
					+ lockService.loadLockSalesCost();
		} else if (country == null
				|| country.trim().equals("")
				|| country.trim().equalsIgnoreCase("All")
				&& (city == null || city.trim().equals("") || city.trim()
						.equalsIgnoreCase("All"))
				&& (accountKind != null && accountKind.trim().equalsIgnoreCase(
						"Company"))) {
			totalcost = machineService.loadMachinesCost()
					+ lockService.loadLocksCost();
		} else if (country == null
				|| country.trim().equals("")
				|| country.trim().equalsIgnoreCase("All")
				&& (city == null || city.trim().equals("") || city.trim()
						.equalsIgnoreCase("All"))
				&& (accountKind != null && accountKind.trim().equalsIgnoreCase(
						"Agency"))) {
			totalcost = machineService.loadMachineSalesCost()
					+ lockService.loadLockSalesCost();

		} else {
			if (accountKind != null
					&& accountKind.trim().equalsIgnoreCase("Company")) {
				List<Long> warehouseIdsList = warehouseService
						.loadWarehouseIdList(country, city);
				if (warehouseIdsList != null && warehouseIdsList.size() > 0) {

					totalcost = machineService
							.loadMachinesCost(warehouseIdsList)
							+ lockService.loadLocksCost(warehouseIdsList);

				}
			} else if (accountKind != null
					&& accountKind.trim().equalsIgnoreCase("Agency")) {
				List<Long> warehouseIdsList = warehouseService
						.loadWarehouseIdList(country, city, "Agency");
				if (warehouseIdsList != null && warehouseIdsList.size() > 0) {

					totalcost = machineService
							.loadMachineSalesCost(warehouseIdsList)
							+ lockService.loadLockSalesCost(warehouseIdsList);

				}
			} else if (accountKind == null || accountKind.trim().equals("")
					|| accountKind.trim().equalsIgnoreCase("All")) {
				List<Long> warehouseIdsList = warehouseService
						.loadWarehouseIdList(country, city);
				totalcost = machineService.loadMachinesCost(warehouseIdsList)
						+ lockService.loadLocksCost(warehouseIdsList);

				List<Long> awarehouseIdsList = warehouseService
						.loadWarehouseIdList(country, city, "Agency");
				if (warehouseIdsList != null && warehouseIdsList.size() > 0) {

					totalcost = totalcost
							+ machineService
									.loadMachineSalesCost(warehouseIdsList)
							+ lockService.loadLockSalesCost(awarehouseIdsList);

				}

			}

		}

		result = "{\"totalCost\":\" " + totalcost + " \",\"currency\":\""
				+ currency + "\"}";

		return result;
	}

	@RequestMapping("/mainmanager/accountinfo")
	public String showAccountInfo() {

		return "mainmanageraccountinfo.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/mainmanager/checkaccountinfo")
	public @ResponseBody
	String getCheckAccountInfoInJSON(@RequestParam("accountKind")
	String accountKind, @RequestParam("city")
	String city, @RequestParam("country")
	String country) {

		Long count = 0L;
		if (accountKind != null
				&& accountKind.trim().equalsIgnoreCase("Customer")
				|| accountKind.trim().equalsIgnoreCase("ALL")) {
			count = customerService.loadAccountCount(country, city, "");

		}
		if (accountKind != null
				&& !accountKind.trim().equalsIgnoreCase("Customer")) {
			count = count
					+ userRoleService.loadAccountCount(country, city,
							accountKind);
		}
		System.out.println("\"");

		return "{\"count\":\"" + count + "\"}";
	}

	@RequestMapping("/mainmanager/warehouseplaceinfo")
	public String showWarehousePlaceInfo() {

		return "mainmanagerwarehouseplaceinfo.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/mainmanager/checkwarehouseplaceinfo")
	public @ResponseBody
	String getCheckWarehousePlaceInfoInJSON(@RequestParam("city")
	String city, @RequestParam("country")
	String country) {

		Long warehouseCount = 0L;
		Long lockCount = 0L;
		Long machineCount = 0L;
		Double totalCost = 0D;
		Long agencyWarehouseCount = 0L;
		warehouseCount = warehouseService.loadWarehouseCount(country, city);
		agencyWarehouseCount = warehouseService.loadWarehouseCount(country,
				city, "Agency");
		;
		if ((country == null || country.trim().equals("") || country.trim()
				.equalsIgnoreCase("ALL"))
				&& (city == null || city.trim().equals("") || city.trim()
						.equalsIgnoreCase("ALL"))) {
			machineCount = machineService.loadMachineCount();
			lockCount = lockService.loadLockCount();
			totalCost = machineService.loadMachinesCost()
					+ lockService.loadLocksCost();

		} else {
			List<Long> warehouseIdsList = warehouseService.loadWarehouseIdList(
					country, city);
			if (warehouseIdsList != null && warehouseIdsList.size() > 0) {
				machineCount = machineService
						.loadMachineCount(warehouseIdsList);
				lockCount = lockService.loadLockCount(warehouseIdsList);
				totalCost = machineService.loadMachinesCost(warehouseIdsList)
						+ lockService.loadLocksCost(warehouseIdsList);

			}
		}

		return "{\"warehouseCount\":\"" + warehouseCount
				+ "\",\"lockCount\":\"" + lockCount + "\",\"machineCount\":\""
				+ machineCount + "\",\"totalCost\":\"" + totalCost
				+ "\",\"agencyWarehouseCount\":\"" + agencyWarehouseCount
				+ "\"}";
	}

	@RequestMapping("/mainmanager/warehouseagencyinfo")
	public String showWarehouseAgencyInfo() {

		return "mainmanagerwarehouseagencyinfo.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/mainmanager/checkwarehouseagencyinfo")
	public @ResponseBody
	String getCheckWarehouseAgencyInfoInJSON(@RequestParam("agencyId")
	String agencyId) {

		String result = null;
		Map<String, Object> agency = userRoleService.loadCustomer(agencyId);

		System.out.println(agencyId);
		System.out.println(agency);

		if (agency != null) {
			try {

				Long userRoleId = (Long) agency.get("userRoleId");
				if (userRoleId != null) {
					ObjectMapper mapper = new ObjectMapper();

					Long lockCount = lockService.loadLockSalesCount(userRoleId);
					Long machineCount = machineService
							.loadMachineSalesCount(userRoleId);
					Double totalCost = machineService
							.loadMachineSalesCost(userRoleId)
							+ lockService.loadLockSalesCost(userRoleId);
					Long agencyWarehouseCount = warehouseService
							.loadWarehouseCount(userRoleId, "Agency");
					;

					result = "{\"agency\":" + mapper.writeValueAsString(agency)
							+ ",\"lockCount\":\"" + lockCount
							+ "\",\"machineCount\":\"" + machineCount
							+ "\",\"totalCost\":\"" + totalCost
							+ "\",\"agencyWarehouseCount\":\""
							+ agencyWarehouseCount + "\"}";

				} else {
					return "fail";
				}
			} catch (JsonGenerationException e) {

				e.printStackTrace();
			} catch (JsonMappingException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			result = "fail";
		}

		return result;
	}

	@RequestMapping("/mainmanager/machinesplaceinfo")
	public String showMachinePlaceInfo() {

		return "mainmanagermachineplaceinfo.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/mainmanager/checkmachineplaceinfo")
	public @ResponseBody
	String getCheckMachinePlaceInfoInJSON(@RequestParam("city")
	String city, @RequestParam("country")
	String country, @RequestParam("machineModel")
	String machineModel) {

		Long machineCount = 0L;
		double totalCost = 0;
		Long agencyMachineCount = 0L;

		if ((country == null || country.trim().equals("") || country.trim()
				.equalsIgnoreCase("ALL"))
				&& (city == null || city.trim().equals("") || city.trim()
						.equalsIgnoreCase("ALL"))
				&& (machineModel == null || machineModel.trim().equals("") || machineModel
						.equalsIgnoreCase("All"))) {
			machineCount = machineService.loadMachineCount();
			agencyMachineCount = machineService.loadMachineSalesCount();
			totalCost = machineService.loadMachinesCost();

		} else if ((country == null || country.trim().equals("") || country
				.trim().equalsIgnoreCase("ALL"))
				&& (city == null || city.trim().equals("") || city.trim()
						.equalsIgnoreCase("ALL"))
				&& (machineModel != null && !machineModel.trim()
						.equalsIgnoreCase("ALL"))) {
			machineCount = machineService.loadMachineCount(machineModel);
			agencyMachineCount = machineService
					.loadMachineSalesCount(machineModel);
			totalCost = machineService.loadMachinesCost(machineModel);

		}

		else {
			List<Long> warehouseIdsList = warehouseService.loadWarehouseIdList(
					country, city);
			if (warehouseIdsList != null && warehouseIdsList.size() > 0) {
				if (machineModel != null && !machineModel.trim().equals("")
						&& !machineModel.equalsIgnoreCase("All")) {
					machineCount = machineService.loadMachineCount(
							warehouseIdsList, machineModel);
					totalCost = machineService.loadMachinesCost(
							warehouseIdsList, machineModel);
					agencyMachineCount = machineService.loadMachineSalesCount(
							warehouseIdsList, machineModel);

				} else {
					machineCount = machineService
							.loadMachineCount(warehouseIdsList);
					totalCost = machineService
							.loadMachinesCost(warehouseIdsList);
					agencyMachineCount = machineService
							.loadMachineSalesCount(warehouseIdsList);
				}

			}
		}

		return "{\"machineCount\":\"" + machineCount + "\",\"totalCost\":\""
				+ totalCost + "\",\"agencyMachineCount\":\""
				+ agencyMachineCount + "\"}";
	}

	@RequestMapping("/mainmanager/locksplaceinfo")
	public String showLocksPlaceInfo() {

		return "mainmanagerlockplaceinfo.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/mainmanager/checklockplaceinfo")
	public @ResponseBody
	String getCheckLockPlaceInfoInJSON(@RequestParam("city")
	String city, @RequestParam("country")
	String country, @RequestParam("lockModel")
	String lockModel) {

		Long lockCount = 0L;
		double totalCost = 0;
		Long agencyLockCount = 0L;

		if ((country == null || country.trim().equals("") || country.trim()
				.equalsIgnoreCase("ALL"))
				&& (city == null || city.trim().equals("") || city.trim()
						.equalsIgnoreCase("ALL"))
				&& (lockModel == null || lockModel.trim().equals("") || lockModel
						.equalsIgnoreCase("All"))) {
			lockCount = lockService.loadLockCount();
			agencyLockCount = lockService.loadLockSalesCount();
			totalCost = lockService.loadLocksCost();

		} else if ((country == null || country.trim().equals("") || country
				.trim().equalsIgnoreCase("ALL"))
				&& (city == null || city.trim().equals("") || city.trim()
						.equalsIgnoreCase("ALL"))
				&& (lockModel != null && !lockModel.trim().equalsIgnoreCase(
						"ALL"))) {
			lockCount = lockService.loadLockCount(lockModel);
			agencyLockCount = lockService.loadLockSalesCount(lockModel);
			totalCost = lockService.loadLocksCost(lockModel);

		}

		else {
			List<Long> warehouseIdsList = warehouseService.loadWarehouseIdList(
					country, city);
			if (warehouseIdsList != null && warehouseIdsList.size() > 0) {
				if (lockModel != null && !lockModel.trim().equals("")
						&& !lockModel.equalsIgnoreCase("All")) {
					lockCount = lockService.loadLockCount(warehouseIdsList,
							lockModel);
					totalCost = lockService.loadLocksCost(warehouseIdsList,
							lockModel);
					agencyLockCount = lockService.loadLockSalesCount(
							warehouseIdsList, lockModel);

				} else {
					lockCount = lockService.loadLockCount(warehouseIdsList);
					totalCost = lockService.loadLocksCost(warehouseIdsList);
					agencyLockCount = lockService
							.loadLockSalesCount(warehouseIdsList);
				}

			}
		}

		return "{\"lockCount\":\"" + lockCount + "\",\"totalCost\":\""
				+ totalCost + "\",\"agencyLockCount\":\"" + agencyLockCount
				+ "\"}";
	}

	@RequestMapping("/mainmanager/machinesagencyinfo")
	public String showMachineAgencyInfo() {

		return "mainmanagermachineagencyinfo.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/mainmanager/checkmachineagencyinfo")
	public @ResponseBody
	String getCheckMachineAgencyInfoInJSON(@RequestParam("agencyId")
	String agencyId) {

		Long machineCount = 0L;

		String result = null;
		Map<String, Object> agency = userRoleService.loadCustomer(agencyId);

		System.out.println(agencyId);
		System.out.println(agency);

		if (agency != null) {
			try {

				Long userRoleId = (Long) agency.get("userRoleId");
				if (userRoleId != null) {
					ObjectMapper mapper = new ObjectMapper();

					machineCount = machineService
							.loadMachineSalesCount(userRoleId);

					result = "{\"agency\":" + mapper.writeValueAsString(agency)
							+ ",\"machineCount\":\"" + machineCount + "\"}";

				} else {
					return "fail";
				}
			} catch (JsonGenerationException e) {

				e.printStackTrace();
			} catch (JsonMappingException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			result = "fail";
		}

		return result;
	}

	@RequestMapping("/mainmanager/locksagencyinfo")
	public String showLockAgencyInfo() {

		return "mainmanagerlockagencyinfo.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/mainmanager/checklockagencyinfo")
	public @ResponseBody
	String getCheckLockAgencyInfoInJSON(@RequestParam("agencyId")
	String agencyId) {

		Long lockCount = 0L;

		String result = null;
		Map<String, Object> agency = userRoleService.loadCustomer(agencyId);

		System.out.println(agencyId);
		System.out.println(agency);

		if (agency != null) {
			try {

				Long userRoleId = (Long) agency.get("userRoleId");
				if (userRoleId != null) {
					ObjectMapper mapper = new ObjectMapper();

					lockCount = lockService.loadLockSalesCount(userRoleId);

					result = "{\"agency\":" + mapper.writeValueAsString(agency)
							+ ",\"lockCount\":\"" + lockCount + "\"}";

				} else {
					return "fail";
				}
			} catch (JsonGenerationException e) {

				e.printStackTrace();
			} catch (JsonMappingException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			result = "fail";
		}

		return result;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/mainmanager/profile")
	public String AdminProfile(HttpServletRequest request) {
		System.out.println("hi");
		String cid = request.getParameter("cid");
		String uid = request.getParameter("uid");
		System.out.println(cid + "cid");
		System.out.println(uid + "uid");

		if (cid != null && uid != null && !cid.trim().equals("")
				&& !uid.trim().equals("")) {
			Long customerId = new Long(cid);
			Long userRoleId = new Long(uid);
			System.out.println(customerId + "customerId");
			System.out.println(userRoleId + "userRoleId");
			CustomerDTO customerDTO = customerService.loadCustomer(customerId);
			UserRoleDTO userRoleDTO = userRoleService.loadUserRole(userRoleId);
			if (customerDTO != null) {
				request.setAttribute("customer", customerDTO);
			}
			if (userRoleDTO != null) {
				request.setAttribute("userRole", userRoleDTO);
			}
		}
		return "mainmanagerprofile.page";
	}

	@RequestMapping("/mainmanager/changeprofile")
	public String ChangeProfile(HttpServletRequest request) {
		System.out.println("hi");
		String cid = request.getParameter("cid");
		String uid = request.getParameter("uid");
		System.out.println(cid + "cid");
		System.out.println(uid + "uid");

		if (cid != null && uid != null && !cid.trim().equals("")
				&& !uid.trim().equals("")) {
			Long customerId = new Long(cid);
			Long userRoleId = new Long(uid);
			System.out.println(customerId + "customerId");
			System.out.println(userRoleId + "userRoleId");
			CustomerDTO customerDTO = customerService.loadCustomer(customerId);
			UserRoleDTO userRoleDTO = userRoleService.loadUserRole(userRoleId);
			if (customerDTO != null) {
				request.setAttribute("customer", customerDTO);
			}
			if (userRoleDTO != null) {
				request.setAttribute("userRole", userRoleDTO);
			}
		}
		return "mainmanagerchangeProfile.page";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/mainmanager/updatepassword")
	public String updtaeAccountStatus1(HttpServletRequest request,
			HttpServletResponse response) {
		String cid = request.getParameter("customerId");
		String uid = request.getParameter("userRoleId");
		String usrpassord = request.getParameter("oldpassword");
		System.out.println("Password from form" + usrpassord);
		System.out.println(cid + "usser" + uid);
		System.out
				.println("password" + request.getParameter("confirmpassword"));
		ObjectMapper mapper = new ObjectMapper();
		String result = null;

		Long customerId = new Long(cid);
		Long userRoleId = new Long(uid);
		UserRoleDTO userRoleDTO = userRoleService.loadUserRole(userRoleId);

		String olddatabsepassword = userRoleDTO.getPassword();
		System.out.println("Oldpass" + olddatabsepassword);
		if (olddatabsepassword.equalsIgnoreCase(usrpassord)) {
			userRoleService.modifyUserPassord(new Long(request
					.getParameter("userRoleId")), request
					.getParameter("confirmpassword"));
		} else {
			return "mainmanagererror.page";
		}
		return "mainmanagersucess.page";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/mainmanager/updateNumber")
	public String updtaeN(HttpServletRequest request,
			HttpServletResponse response) {
		String cid = request.getParameter("customer");
		String uid = request.getParameter("userRole");
		String oldmobileNo = request.getParameter("oldmobileNo");

		Long customerId = new Long(cid);
		Long userRoleId = new Long(uid);

		CustomerDTO customerDTO = customerService.loadCustomer(customerId);
		String oldMobileNoDatabase = customerDTO.getMobileNo();

		if (oldmobileNo.equalsIgnoreCase(oldMobileNoDatabase)) {
			customerService.modifyUserNumber(new Long(request

			.getParameter("customer")), request.getParameter("mobileNo"));

		} else {

			return "mainmanagererror.page";
		}

		return "mainmanagersucess.page";
	}

}
