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

import com.moaddi.service.UserRoleService;

import com.moaddi.service.dto.CustomerDTO;

import com.moaddi.service.dto.UserRoleDTO;

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

	



	@RequestMapping("/mainmanager/controlpage")
	public String showContollPage() {

		return "mainmanagercontrolpage.page";

	}

	

	

	@RequestMapping("/mainmanager/companybalance")
	public String showCompanyBalance() {

		return "mainmanagercompanybalance.page";

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

	

	@RequestMapping("/mainmanager/warehouseagencyinfo")
	public String showWarehouseAgencyInfo() {

		return "mainmanagerwarehouseagencyinfo.page";

	}

	

	@RequestMapping("/mainmanager/machinesplaceinfo")
	public String showMachinePlaceInfo() {

		return "mainmanagermachineplaceinfo.page";

	}

	

	@RequestMapping("/mainmanager/locksplaceinfo")
	public String showLocksPlaceInfo() {

		return "mainmanagerlockplaceinfo.page";

	}

	
	@RequestMapping("/mainmanager/machinesagencyinfo")
	public String showMachineAgencyInfo() {

		return "mainmanagermachineagencyinfo.page";

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
