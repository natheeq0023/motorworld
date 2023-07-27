package com.moaddi.ui.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

import com.moaddi.dao.BranchDAO;
import com.moaddi.dao.model.BranchTL;
import com.moaddi.dao.model.ItemPriceDTO;
import com.moaddi.dao.model.ItemQuantityTL;
import com.moaddi.dao.model.LockTL;
import com.moaddi.dao.model.MachinePartnerTL;
import com.moaddi.dao.model.MachineTL;
import com.moaddi.dao.model.UserRolesTL;
import com.moaddi.service.BranchService;
import com.moaddi.service.CustomerService;
import com.moaddi.service.ItemService;
import com.moaddi.service.LockService;
import com.moaddi.service.MachineService;
import com.moaddi.service.UserRoleService;
import com.moaddi.service.WarehouseService;
import com.moaddi.service.dto.AgencyRequestDTO;
import com.moaddi.service.dto.BranchDTO;
import com.moaddi.service.dto.BranchSalesmanDTO;
import com.moaddi.service.dto.CustomerDTO;
import com.moaddi.service.dto.ItemDTO;
import com.moaddi.service.dto.ItemQuantityDTO;
import com.moaddi.service.dto.ItemSupplierDTO;
import com.moaddi.service.dto.LocationDTO;
import com.moaddi.service.dto.LockDTO;
import com.moaddi.service.dto.LockPriceDTO;
import com.moaddi.service.dto.MachineDTO;
import com.moaddi.service.dto.MachineLockDTO;
import com.moaddi.service.dto.MachinePartnerDTO;
import com.moaddi.service.dto.MachinePriceDTO;
import com.moaddi.service.dto.MachineSupplierDTO;
import com.moaddi.service.dto.OperatorOrderDTO;
import com.moaddi.service.dto.OperatorOrderDetailsDTO;
import com.moaddi.service.dto.OperatorPartnerDetailsDTO;
import com.moaddi.service.dto.OperatorRequestDTO;
import com.moaddi.service.dto.OrderDTO;
import com.moaddi.service.dto.OrderDetailsDTO;
import com.moaddi.service.dto.UserRoleDTO;
import com.moaddi.service.dto.WarehouseDTO;
import com.moaddi.service.dto.WarehouseSalesmanDTO;
import com.moaddi.ui.forms.AccountForm;
import com.moaddi.ui.forms.AgencyOrderForm;
import com.moaddi.ui.forms.AgencyRequestForm;
import com.moaddi.ui.forms.BranchForm;
import com.moaddi.ui.forms.ConnectBranchForm;
import com.moaddi.ui.forms.ConnectWarehouseForm;
import com.moaddi.ui.forms.ItemForm;
import com.moaddi.ui.forms.ItemPriceForm;
import com.moaddi.ui.forms.ItemQuantityForm;
import com.moaddi.ui.forms.MachineLockForm;
import com.moaddi.ui.forms.MachinePartnerForm;
import com.moaddi.ui.forms.MachineSupForm;
import com.moaddi.ui.forms.OperatorPartnerForm;
import com.moaddi.ui.forms.OperatorRequestForm;
import com.moaddi.ui.forms.WarehouseForm;

@Controller
public class OperatorController {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private WarehouseService warehouseService;
	@Autowired
	private MachineService machineService;
	@Autowired
	private LockService lockService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private BranchService branchService;
	@Autowired
	private ItemService itemService;

	@RequestMapping(method = RequestMethod.GET, value = "/operator/checkwarehousesno")
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

	@RequestMapping("/operator/signout")
	public String showSignout(HttpServletRequest response) {

		return "redirect:../otherlogin.htm?suMsg=Your successfully Signedout";
	}

	@RequestMapping("/operator/operatorhome")
	public String showHome(HttpServletRequest response) {

		if (response.getParameter("u") != null) {
			return "operatorhome" + response.getParameter("u").toLowerCase()
					+ ".page";
		} else {
			return "operatorhome.page";
		}

	}

	@RequestMapping("/operator/createwarehouse")
	public String showCreateWarehouse() {

		return "operatorcreatelocationwarehouse.page";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/operator/createwarehouse")
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
			warehouseDTO.setWarehouseType("Operator");
			UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
					.getAttribute("userRole");
			if (userRoleDTO != null) {
				warehouseDTO.setCreatedBy(userRoleDTO.getUserRoleId());

			}
			warehouseService.saveWarehouse(warehouseDTO);

		}

		return "redirect:createwarehouse.htm?s=success";
	}

	@RequestMapping("/operator/warehouses")
	public String warehouses(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		if (userRoleDTO != null) {
			List<WarehouseDTO> warehouses = warehouseService.getWarehouses(
					userRoleDTO.getUserRoleId(), "Operator");
			request.setAttribute("warehouses", warehouses);
		}

		return "operatorwarehouses.page";

	}

	@RequestMapping("/operator/buyfromagency")
	public String buyFromCompany(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		if (userRoleDTO != null) {

			List<WarehouseDTO> warehouses = warehouseService.getWarehouses(
					userRoleDTO.getUserRoleId(), "Operator");
			request.setAttribute("warehouses", warehouses);
		}

		return "operatorbuyfromagency.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/operator/checkmachineprice")
	public @ResponseBody
	String getCheckMachinePriceInJSON(@RequestParam("machineKind")
	String machineKind, @RequestParam("machineModel")
	String machineModel) {
		String result = null;

		ObjectMapper mapper = new ObjectMapper();

		MachinePriceDTO machinePrice = machineService.loadMachinePrice(
				machineKind, machineModel);
		if (machinePrice != null) {
			try {

				result = mapper.writeValueAsString(machinePrice);
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

	@RequestMapping(method = RequestMethod.GET, value = "/operator/checklockprice")
	public @ResponseBody
	String getCheckLockPriceInJSON(@RequestParam("lockKind")
	String lockKind, @RequestParam("lockModel")
	String lockModel) {
		String result = null;

		ObjectMapper mapper = new ObjectMapper();

		LockPriceDTO lockPrice = lockService.loadLockPrice(lockKind, lockModel);
		if (lockPrice != null) {
			try {

				result = mapper.writeValueAsString(lockPrice);
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

	@RequestMapping(method = RequestMethod.POST, value = "/operator/buyfromagency")
	public String createOrder(AgencyOrderForm agencyOrderForm,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		if (userRoleDTO != null) {
			if (agencyOrderForm.getType() != null) {
				OperatorOrderDTO orderDTO = new OperatorOrderDTO();
				orderDTO.setStatus("Pending");
				orderDTO.setCreatedBy(userRoleDTO.getUserRoleId());
				orderDTO.setWarehouseId(agencyOrderForm.getWarehouseId());
				orderDTO.setOrderType("online");
				System.out
						.println(agencyOrderForm.getWarehouseId() + ".......");
				Long orderId = machineService.saveOperatorOrder(orderDTO);
				try {
					for (int index = 0; index < agencyOrderForm.getType().length; index++) {
						OperatorOrderDetailsDTO orderDetailsDTO = new OperatorOrderDetailsDTO();
						orderDetailsDTO
								.setModel(agencyOrderForm.getModel()[index]);
						orderDetailsDTO
								.setType(agencyOrderForm.getType()[index]);
						orderDetailsDTO.setOrderFor(agencyOrderForm
								.getOrderFor()[index]);
						orderDetailsDTO.setOrderId(orderId);
						orderDetailsDTO.setQuantity(agencyOrderForm
								.getQuantity()[index]);
						machineService
								.saveOperatorOrderDetails(orderDetailsDTO);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		return "redirect:buyfromagency.htm?s=success";
	}

	@RequestMapping("/operator/myorders")
	public String myOrders(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		if (userRoleDTO != null) {

			List<OperatorOrderDTO> orders = machineService
					.loadOperatorOrders(userRoleDTO.getUserRoleId());
			request.setAttribute("orders", orders);
		}

		return "operatormyorders.page";

	}

	@RequestMapping("/operator/viewmyorder")
	public String viewMyOrders(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		if (userRoleDTO != null) {

			String id = request.getParameter("i");
			Long requestId = new Long(id);

			if (requestId != null) {
				OperatorOrderDTO order = machineService
						.loadOperatorOrder(requestId);
				request.setAttribute("order", order);

				List<OperatorOrderDetailsDTO> orderDetails = machineService
						.loadOperatorOrderDetails(requestId);
				if (orderDetails != null) {
					request.setAttribute("orderDetails", orderDetails);
				}
				WarehouseDTO warehouseDTO = warehouseService
						.loadWarehouse(order.getWarehouseId());
				request.setAttribute("warehouse", warehouseDTO);
				if (order.getStatus().equalsIgnoreCase("Shifted")) {
					List<MachineDTO> machines = machineService
							.loadAgencyMachineSales(requestId);
					request.setAttribute("machines", machines);

					List<LockDTO> locks = lockService
							.loadAgencyLockSales(requestId);
					request.setAttribute("locks", locks);
				}

			}
		}

		return "operatorviewmyorders.page";

	}

	@RequestMapping("/operator/createaccount")
	public String showCreateAccount(HttpServletRequest response) {

		return "operatorcreatesupplier.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/operator/checkaccount")
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

	@RequestMapping(method = RequestMethod.POST, value = "/operator/createaccount")
	public String createAccount(AccountForm accountForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {

		if (accountForm != null) {
			UserRoleDTO userRole = (UserRoleDTO) request.getSession()
					.getAttribute("userRole");
			UserRoleDTO userRoleDTO = new UserRoleDTO();
			userRoleDTO.setAccountKind("Other Account");
			userRoleDTO.setCity(accountForm.getCity());
			userRoleDTO.setCountry(accountForm.getCountry());
			System.out.println(userRole.getUserRoleId() + " role id");
			userRoleDTO.setCreatedBy(userRole.getUserRoleId());
			userRoleDTO.setCustomerId(accountForm.getCustomerId());
			userRoleDTO.setFullName(accountForm.getFullName());
			userRoleDTO.setDocumentFileName(accountForm.getDoc()
					.getOriginalFilename());
			userRoleDTO.setStatus("Active");
			userRoleDTO.setUserRole("Supplier");
			//userRoleDTO.setUserRole("Partner");
			/** getting of countrycode and email code start heare ************** */
			String countryCode = accountForm.getCountryCode();
			String email = accountForm.getEmail();
			System.out.println(email + "email");
			String NewString = countryCode.replace("+", "");
			String NewRole = userRoleDTO.getUserRole().substring(0, 2);

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
			try {
				SimpleMailMessage email1 = new SimpleMailMessage();
				email1.setTo(email);
				email1.setSubject("Your userName and Password");
				email1
						.setText("userIdNo:" + userId + "password is:"
								+ password);

				// sends the e-mail
				mailSender.send(email1);
			} catch (Exception e) {
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

					e.printStackTrace();

				}
			}

		}

		return "redirect:createaccount.htm?s=succ";
	}

	@RequestMapping("/operator/machinelock")
	public String machineLock(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		List<LockDTO> locks = lockService.loadOperatorLocks(userRoleDTO
				.getUserRoleId(), "Connected");
		if (locks != null) {
			request.setAttribute("locks", locks);
		}

		return "operatormachinelock.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/operator/checknachine")
	public @ResponseBody
	String getCheckMachineInJSON(@RequestParam("machineSno")
	String machineSno, HttpServletRequest request) {
		String result = null;
		if (machineSno != null && !machineSno.trim().equals("")) {

			UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
					.getAttribute("userRole");
			MachineDTO machineDTO = machineService.operatorMachine(machineSno,
					userRoleDTO.getUserRoleId());
			if (machineDTO != null) {
				ObjectMapper mapper = new ObjectMapper();
				List<LockDTO> connectedLocks = lockService.loadMachineLocks(
						machineDTO.getMachineId(), "Connected");
				if (connectedLocks != null) {
					try {
						Map<String, Object> val = new HashMap<String, Object>();
						val.put("machine", machineDTO);
						val.put("connectedLocks", connectedLocks);
						result = mapper.writeValueAsString(val);
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
					try {
						Map<String, Object> val = new HashMap<String, Object>();
						val.put("machine", machineDTO);

						result = mapper.writeValueAsString(val);
					} catch (JsonGenerationException e) {

						e.printStackTrace();
					} catch (JsonMappingException e) {

						e.printStackTrace();
					} catch (IOException e) {

						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}

		}

		return result;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/operator/machinelock")
	public String connectMachineLock(MachineLockForm machineLockForm,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) {

		if (machineLockForm != null) {
			UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
					.getAttribute("userRole");
			if (machineLockForm.getConnectedLockId() != null
					&& machineLockForm.getConnectedLockId().length > 0) {
				StringBuffer lockIds = new StringBuffer(""
						+ machineLockForm.getConnectedLockId()[0] + "");
				for (int index = 1; index < machineLockForm
						.getConnectedLockId().length; index++) {
					lockIds.append(machineLockForm.getConnectedLockId()[index]);
					if (index < (machineLockForm.getConnectedLockId().length - 1)) {
						lockIds.append(",");
					}

				}

				machineService.modifyMachineLock(lockIds.toString(),
						machineLockForm.getMachineId(), userRoleDTO
								.getUserRoleId());

			} else {
				machineService.modifyMachineLock("", machineLockForm
						.getMachineId(), userRoleDTO.getUserRoleId());

			}
			if (machineLockForm.getLockId() != null
					&& machineLockForm.getLockId().length > 0) {
				for (Long lockId : machineLockForm.getLockId()) {
					MachineLockDTO machineLockDTO = new MachineLockDTO();
					machineLockDTO.setCreatedBy(userRoleDTO.getUserRoleId());
					machineLockDTO.setLockId(lockId);
					machineLockDTO.setMachineId(machineLockForm.getMachineId());
					machineLockDTO.setStatus("Connected");
					machineLockDTO.setCreatedBy(userRoleDTO.getUserRoleId());
					machineService.saveMachineLock(machineLockDTO);

				}
			}
		}
		return "redirect:machinelock.htm?s=success";

	}

	@RequestMapping("/operator/machinesupplier")
	public String machineSupplier(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");

		return "operatormachinesupplier.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/operator/checksupmachine")
	public @ResponseBody
	String getCheckMachineSupInJSON(@RequestParam("machineSno")
	String machineSno, HttpServletRequest request) {
		String result = null;
		if (machineSno != null && !machineSno.trim().equals("")) {

			UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
					.getAttribute("userRole");
			MachineDTO machineDTO = machineService.operatorMachine(machineSno,
					userRoleDTO.getUserRoleId());
			if (machineDTO != null) {
				ObjectMapper mapper = new ObjectMapper();
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("machine", machineDTO);
				List<Map<String, Object>> connectedSup = userRoleService
						.loadConnectedSuppliers(userRoleDTO.getUserRoleId(),
								machineDTO.getMachineId());
				if (connectedSup != null) {
					data.put("connectedSup", connectedSup);
				}
				List<Map<String, Object>> sups = userRoleService
						.loadNotConnectedSuppliers(userRoleDTO.getUserRoleId(),
								machineDTO.getMachineId());
				if (sups != null) {
					data.put("sups", sups);
				}
				try {
					result = mapper.writeValueAsString(data);
				} catch (JsonGenerationException e) {

					e.printStackTrace();
				} catch (JsonMappingException e) {

					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		System.out.println(result);
		return result;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/operator/machinesupplier")
	public String connectMachineSup(MachineSupForm machineSupForm,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) {

		if (machineSupForm != null) {
			UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
					.getAttribute("userRole");
			if (machineSupForm.getConnectedSupId() != null
					&& machineSupForm.getConnectedSupId().length > 0) {
				StringBuffer supIds = new StringBuffer(""
						+ machineSupForm.getConnectedSupId()[0] + "");
				for (int index = 1; index < machineSupForm.getConnectedSupId().length; index++) {
					supIds.append(machineSupForm.getConnectedSupId()[index]);
					if (index < (machineSupForm.getConnectedSupId().length - 1)) {
						supIds.append(",");
					}
				}
				machineService.modifyMachineSuppplier(supIds.toString(),
						machineSupForm.getMachineId(), userRoleDTO
								.getUserRoleId());
			} else {
				System.out.println("else");
				machineService.modifyMachineSuppplier("", machineSupForm
						.getMachineId(), userRoleDTO.getUserRoleId());
			}
			if (machineSupForm.getSupId() != null
					&& machineSupForm.getSupId().length > 0) {
				for (Long supId : machineSupForm.getSupId()) {
					MachineSupplierDTO machineSupplierDTO = new MachineSupplierDTO();
					machineSupplierDTO
							.setCreatedBy(userRoleDTO.getUserRoleId());
					machineSupplierDTO.setSupplierId(supId);
					machineSupplierDTO.setMachineId(machineSupForm
							.getMachineId());
					machineSupplierDTO.setStatus("Connected");
					machineSupplierDTO
							.setCreatedBy(userRoleDTO.getUserRoleId());
					machineService.saveMachineSupplier(machineSupplierDTO);

				}
			}
		}
		return "redirect:machinesupplier.htm?s=success";

	}
	
	@RequestMapping("/operator/createitem")
	public String showCreateItem() {
		
		return "operatorcreateitem.page";
		
	}
	@RequestMapping(method = RequestMethod.POST, value = "/operator/createitem")
	public String submitItemForm(ItemForm itemForm,ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {

		if (itemForm != null) {
			UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
			.getAttribute("userRole");
			ItemDTO itemDTO = new ItemDTO();
			itemDTO.setItemBarcode(itemForm.getItemBarcode().toUpperCase());
			itemDTO.setItemGruop(itemForm.getItemGruop());
			itemDTO.setItemIngredients(itemForm.getItemIngredients());
			itemDTO.setItemName(itemForm.getItemName());
			itemDTO.setItemSize(itemForm.getItemSize());
			itemDTO.setCreatedBy(userRoleDTO.getUserRoleId());
			itemDTO.setStatus("Active");
			
			
			itemDTO.setItemPhotoName(itemForm.getItemPhoto()
					.getOriginalFilename());
			
		
			
			Long itemId=itemService.saveItem(itemDTO);
			if (itemId != null) {

				MultipartFile multiFile = itemForm.getItemPhoto();
				try {
					// just to show that we have actually received the file

					String fileName = multiFile.getOriginalFilename();

					String path = request.getSession().getServletContext()
							.getRealPath("/");
                    System.out.println(path+"path");
					// making directories for our required path.
					byte[] bytes = multiFile.getBytes();
					File directory = new File(path + "/uploads/item/"
							+ itemId);
					System.out.println(directory+"directory");
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
		return "redirect:createitem.htm?s=success";

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/operator/checkitem")
	public @ResponseBody
	String getCheckItemInJSON(@RequestParam("itemBarcode")
	String itemBarcode) {

		Map<String, Object> item = null;
		
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		if (itemBarcode != null && !itemBarcode.trim().equals("")) {
			item = itemService.loadItems(itemBarcode.trim().toUpperCase());
					if (item != null) {
						
						try {
							result = mapper.writeValueAsString(item);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						
						result = "{\"msg\":\"fail\"}";
					}
				
			
		
			

		}
		System.out.println("result"+result);
		return result;

	}
	@RequestMapping("/operator/createitemprice")
	public String showCreateItemPrice() {
		
		return "operatorcreateitemprice.page";
		
	}
	@RequestMapping(method = RequestMethod.POST, value = "/operator/createitemprice")
	public String submitItemPriceForm(ItemPriceForm itemPriceForm,ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {

		if (itemPriceForm != null) {
			ItemPriceDTO itemPriceDTO=new ItemPriceDTO();
			UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
			.getAttribute("userRole");
			itemPriceDTO.setCreatedBy(userRoleDTO.getCreatedBy());
			itemPriceDTO.setDiscount(itemPriceForm.getDiscount());
			itemPriceDTO.setItemId(itemPriceForm.getItemId());
			itemPriceDTO.setPrice(itemPriceForm.getPrice());
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			
			try {
				
				itemPriceDTO.setFromDate(sdf.parse(itemPriceForm.getStartDate()));
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			try {
				itemPriceDTO.setToDate(sdf.parse(itemPriceForm.getEndDate()));
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			itemService.saveItemPrice(itemPriceDTO);
			
			
		}
		return "redirect:createitemprice.htm?s=success";
	}
	
	@RequestMapping("/operator/createitemquatinty")
	public String showCreateItemQuantity(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
		.getAttribute("userRole");
		if (userRoleDTO != null) {
			List<WarehouseDTO> warehouses = warehouseService.getWarehouses(
					userRoleDTO.getUserRoleId(), "Operator");
			request.setAttribute("warehouses", warehouses);
		}
		return "operatorcreateitemquantity.page";
		
	}
	@RequestMapping(method = RequestMethod.POST, value = "/operator/createitemquatinty")
	public String submitItemQuantityForm(ItemQuantityForm itemQuantityForm,ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
		.getAttribute("userRole");
		if(itemQuantityForm!=null && itemQuantityForm.getIquantity()!=null && itemQuantityForm.getIquantity().length>0)
		{
			ItemQuantityDTO itemQuantityDTO=new ItemQuantityDTO();
			
			for(int index=0;index<itemQuantityForm.getIquantity().length;index++)
			{
				itemQuantityDTO.setCreatedBy(userRoleDTO.getCreatedBy());
				long itId=itemQuantityForm.getItemId()[index];
				itemQuantityDTO.setItemId(itId);
				long waId=itemQuantityForm.getWarehouseId()[index];
				itemQuantityDTO.setWarehouseId(waId);
				itemQuantityDTO.setQuantity(itemQuantityForm.getIquantity()[index]);
				itemService.saveItemQuantity(itemQuantityDTO);
			}
			
		}

		return "redirect:createitemquatinty.htm?s=success";
	}
	
	@RequestMapping("/operator/itemsupplier")
	public String showCreateItemSupplier(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
		.getAttribute("userRole");
		if (userRoleDTO != null) {
			List<WarehouseDTO> warehouses = warehouseService.getWarehouses(
					userRoleDTO.getUserRoleId(), "Operator");
			request.setAttribute("warehouses", warehouses);
		}
		return "operatoritemsupplier.page";
		
	}
	@RequestMapping(method = RequestMethod.POST, value = "/operator/itemsupplier")
	public String submitItemSupplierForm(ItemQuantityForm itemQuantityForm,ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
		.getAttribute("userRole");
		if(itemQuantityForm!=null && itemQuantityForm.getIquantity()!=null && itemQuantityForm.getIquantity().length>0)
		{
			ItemSupplierDTO itemSupplierDTO=new ItemSupplierDTO();
			
			for(int index=0;index<itemQuantityForm.getIquantity().length;index++)
			{
				itemSupplierDTO.setCreatedBy(userRoleDTO.getCreatedBy());
				long itId=itemQuantityForm.getItemId()[index];
				itemSupplierDTO.setItemId(itId);
				long waId=itemQuantityForm.getWarehouseId()[index];
				itemSupplierDTO.setWarehouseId(waId);
				itemSupplierDTO.setQuantity(itemQuantityForm.getIquantity()[index]);
				long suId=itemQuantityForm.getSupplierId()[index];
				itemSupplierDTO.setSupplierId(suId);
				itemService.saveItemSupplier(itemSupplierDTO);
			}
			
		}

		return "redirect:itemsupplier.htm?s=success";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/operator/checksupplier")
	public @ResponseBody
	String getCheckSupplierInJSON(@RequestParam("userId")
	String userId,HttpServletRequest request) {

		Map<String, Object> supplier = null;
		
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		if (userId != null && !userId.trim().equals("")) {
			UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
			.getAttribute("userRole");
			System.out.println("userId...."+userId);
			supplier = userRoleService.loadUser(userId,userRoleDTO.getUserRoleId(),"Supplier");
					if (supplier != null) {
						
						try {
							result = mapper.writeValueAsString(supplier);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						
						result = "{\"msg\":\"fail\"}";
					}
				
			
		
			

		}
		System.out.println("result"+result);
		return result;

	}
	
	@RequestMapping("/operator/machinepartner")
	public String showMachinePartner(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
		.getAttribute("userRole");
		
		return "operatormachinepartner.page";
		
	}
	@RequestMapping(method = RequestMethod.GET, value = "/operator/checkpartner")
	public @ResponseBody
	String getCheckPartnerInJSON(@RequestParam("userId")
	String userId,HttpServletRequest request) {

		Map<String, Object> partner = null;
		
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		if (userId != null && !userId.trim().equals("")) {
			UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
			.getAttribute("userRole");
			System.out.println("userId...."+userId);
			partner = userRoleService.loadUser(userId,userRoleDTO.getUserRoleId(),"Partner");
					if (partner != null) {
						
						try {
							Map<String,Object> map=new HashMap<String, Object>();
							map.put("partner", partner);
							List<LocationDTO> locations=warehouseService.loadLocations((Long)partner.get("userRoleId"));
							if(locations!=null)
							{
								map.put("locations", locations);
							}
							result = mapper.writeValueAsString(map);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						
						result = "{\"msg\":\"fail\"}";
					}
				
			
		
			

		}
		System.out.println("result"+result);
		return result;

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/operator/checkpartmachine")
	public @ResponseBody
	String getCheckMachinePartInJSON(@RequestParam("machineSno")
	String machineSno, HttpServletRequest request) {
		String result = null;
		if (machineSno != null && !machineSno.trim().equals("")) {

			UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
					.getAttribute("userRole");
			MachineDTO machineDTO = machineService.operatorMachine(machineSno,
					userRoleDTO.getUserRoleId());
			if (machineDTO != null) {
				ObjectMapper mapper = new ObjectMapper();
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("machine", machineDTO);
				System.out.println(machineDTO.getMachineId()+" mid....");
				MachinePartnerDTO machinePartnerDTO=machineService.loadMachinePartner(machineDTO.getMachineId(), "Connected");
				System.out.println(machinePartnerDTO+"machinePartnerDTO...");
				if(machinePartnerDTO!=null)
				{
					LocationDTO locationDTO=warehouseService.loadLocation(machinePartnerDTO.getLoactionId());
					data.put("location", locationDTO);
					UserRoleDTO partner=userRoleService.loadUserRole(locationDTO.getCreatedBy());
					if(partner!=null)
					{
						data.put("partner", partner);
						
					}
				}
				try {
					result = mapper.writeValueAsString(data);
				} catch (JsonGenerationException e) {

					e.printStackTrace();
				} catch (JsonMappingException e) {

					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			else {
				
				result = "{\"msg\":\"fail\"}";
			}
		}
		System.out.println(result);
		return result;

	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/operator/machinepartner")
	public String submitMachinePartnerForm(MachinePartnerForm machinePartnerForm,ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
		.getAttribute("userRole");
		if(machinePartnerForm!=null ){
			if(machinePartnerForm.getConnectedLocationId()==null || machinePartnerForm.getConnectedLocationId().trim().equals("")|| !machinePartnerForm.getLocationId().equals(new Integer(machinePartnerForm.getConnectedLocationId())))
			{
				long machineId=machinePartnerForm.getMachineId();
				machineService.modifyMachinePartner(machineId, "DisConnected",userRoleDTO.getUserRoleId());
				MachinePartnerDTO machinePartnerDTO=new MachinePartnerDTO();
				machinePartnerDTO.setCreatedBy(userRoleDTO.getUserRoleId());
				long locationId=machinePartnerForm.getLocationId();
				long userRoleId=machinePartnerForm.getUserRoleId();
				machinePartnerDTO.setLoactionId(locationId);
				machinePartnerDTO.setMachineId(machineId);
				machinePartnerDTO.setPartnerId(userRoleId);
				machinePartnerDTO.setStatus("Connected");
				machineService.saveMachinePartner(machinePartnerDTO);
				
			}
			
			
		}

		return "redirect:machinepartner.htm?s=success";
	}
	/*Create Partner code*/
	
	@RequestMapping("/operator/addpartner")
	public String addPartner(HttpServletRequest request)
	{
		return "operatorcreatepartner.page";
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/operator/checkaccounts")
	public @ResponseBody
	String getCheckSalesManAccountInJSON(@RequestParam("userId")
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

	@RequestMapping(method = RequestMethod.POST, value = "/operator/sendtopartner")
	public String partnercontact (HttpServletRequest request, OperatorPartnerForm addPartnerForm){
		UserRoleDTO operator=(UserRoleDTO)request.getSession().getAttribute("userRole");
		String str = addPartnerForm.getCustomerId();
		System.out.println(str+"CUstomerid is");
		String str1=str.substring(0, 1);
	    long customerId = new Long(str1);
		System.out.println(customerId+"CUstomerid is"+addPartnerForm.getModel().length);
		
			try
				{
					for (int index = 0; index < addPartnerForm.getModel().length; index++) {
						OperatorPartnerDetailsDTO operatorPartnerDetailsDTO=new OperatorPartnerDetailsDTO();
						operatorPartnerDetailsDTO.setModel(addPartnerForm.getModel()[index]);
						operatorPartnerDetailsDTO.setCreatedBy(operator.getCreatedBy());
						operatorPartnerDetailsDTO.setEnddate(addPartnerForm.getEnddate());
						operatorPartnerDetailsDTO.setFullName(addPartnerForm.getFullName());
						operatorPartnerDetailsDTO.setStatus("Pending");
						operatorPartnerDetailsDTO.setUserRoleId(addPartnerForm.getUserRoleId());
						operatorPartnerDetailsDTO.setStartDate(addPartnerForm.getStartDate());
						operatorPartnerDetailsDTO.setMonth(addPartnerForm.getMonth());
						operatorPartnerDetailsDTO.setPercentage(addPartnerForm.getPercentage());
						operatorPartnerDetailsDTO.setContractId(addPartnerForm.getContractId());
						operatorPartnerDetailsDTO.setPartnerid(addPartnerForm.getPartnerid());
						operatorPartnerDetailsDTO.setUserId(addPartnerForm.getUserId());
						operatorPartnerDetailsDTO.setCustomerId(customerId);
						operatorPartnerDetailsDTO.setAmountmonth(addPartnerForm.getAmountmonth());
						operatorPartnerDetailsDTO.setAmountnow(addPartnerForm.getAmountnow());
						operatorPartnerDetailsDTO.setPercentagemonth(addPartnerForm.getPercentagemonth());
						userRoleService.saveOperatorDetails(operatorPartnerDetailsDTO);
						
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				return "redirect:addpartner.htm?s=sucess";
			}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/operator/profile")
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
		return "operatorprofile.page";
	}

	@RequestMapping("/operator/changeprofile")
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
		return "operatorchangeProfile.page";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/operator/updatepassword")
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
			return "operatorerror.page";
		}
		return "operatorsucess.page";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/operator/updateNumber")
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

			return "operatorerror.page";
		}

		return "operatorsucess.page";
	}

}
