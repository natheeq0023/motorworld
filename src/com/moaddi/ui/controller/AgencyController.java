package com.moaddi.ui.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.moaddi.dao.BranchDAO;
import com.moaddi.dao.model.AgencyOrderRequestForm;
import com.moaddi.dao.model.BranchTL;
import com.moaddi.dao.model.MachineTL;
import com.moaddi.dao.model.OperatorOrderRequestForm;
import com.moaddi.service.BranchService;
import com.moaddi.service.CustomerService;
import com.moaddi.service.LockService;
import com.moaddi.service.MachineService;
import com.moaddi.service.UserRoleService;
import com.moaddi.service.WarehouseService;
import com.moaddi.service.dto.AgencyRequestDTO;
import com.moaddi.service.dto.BranchDTO;
import com.moaddi.service.dto.BranchSalesmanDTO;
import com.moaddi.service.dto.CustomerDTO;
import com.moaddi.service.dto.LockDTO;
import com.moaddi.service.dto.LockPriceDTO;
import com.moaddi.service.dto.MachineDTO;
import com.moaddi.service.dto.MachinePriceDTO;
import com.moaddi.service.dto.OperatorOrderDTO;
import com.moaddi.service.dto.OperatorOrderDetailsDTO;
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
import com.moaddi.ui.forms.OperatorRequestForm;
import com.moaddi.ui.forms.WarehouseForm;

@Controller
public class AgencyController {
	
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
	@RequestMapping(method = RequestMethod.GET, value = "/agency/checkwarehousesno")
	public @ResponseBody String getCheckWarehouseInJSON(@RequestParam("warehouseSNO")
			String warehouseSNO) {

				
				
				
				String result = null;
				
				
				
				
				if (warehouseSNO != null) {
					try {
						boolean isExists=warehouseService.isWarehouseExist(warehouseSNO.toUpperCase());
						
							
							if(isExists)
							{	
								return "{\"msg\":\"fail\"}";
							}
							else
							{
								return "{\"msg\":\"success\"}";
							}
					
					} catch (Exception e) {
						e.printStackTrace();
						return "fail";
					}
				}
				
				return result;
			}
			

	@RequestMapping("/agency/signout")
	public String showSignout(HttpServletRequest response) {

		return "redirect:../otherlogin.htm?suMsg=Your successfully Signedout";
	}

	@RequestMapping("/agency/agencyhome")
	public String showCreateAccount(HttpServletRequest response) {

		if (response.getParameter("u") != null) {
			return "agencyhome" + response.getParameter("u").toLowerCase()
					+ ".page";
		} else {
			return "agencyhome.page";
		}

	}

	@RequestMapping("/agencyreg")
	public String otherLogin() {

		return "agencyreg.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/checkagencyregaccount")
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

	@RequestMapping("/agency/createwarehouse")
	public String showCreateWarehouse() {

		return "agencycreatelocationwarehouse.page";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/agency/createwarehouse")
	public String createWarehouse(WarehouseForm warehouseForm,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) {

		if (warehouseForm != null) {
			WarehouseDTO warehouseDTO = new WarehouseDTO();
			warehouseDTO.setAddress(warehouseForm.getAddress());
			warehouseDTO.setCity(warehouseForm.getCity());
			warehouseDTO.setCountry(warehouseForm.getCountry());
			warehouseDTO.setStatus("Active");
			warehouseDTO.setWarehouseSno(warehouseForm.getWarehouseSNO().toUpperCase());
			warehouseDTO.setWarehouseType("Agency");
			UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
					.getAttribute("userRole");
			if (userRoleDTO != null) {
				warehouseDTO.setCreatedBy(userRoleDTO.getUserRoleId());

			}
			warehouseService.saveWarehouse(warehouseDTO);

		}

		return "redirect:createwarehouse.htm?s=success";
	}

	@RequestMapping("/agency/warehouses")
	public String warehouses(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		if (userRoleDTO != null) {
			List<WarehouseDTO> warehouses = warehouseService.getWarehouses(
					userRoleDTO.getUserRoleId(), "Agency");
			request.setAttribute("warehouses", warehouses);
		}

		return "agencywarehouses.page";

	}

	@RequestMapping("/agency/buyfromcompany")
	public String buyFromCompany(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		if (userRoleDTO != null) {
			
			List<WarehouseDTO> warehouses=warehouseService.getWarehouses(userRoleDTO.getUserRoleId(), "Agency");
			request.setAttribute("warehouses", warehouses);
		}

		return "agencybuyfromcompany.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/agency/checkmachineprice")
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

	
	@RequestMapping(method = RequestMethod.GET, value = "/agency/checklockprice")
	public @ResponseBody
	String getCheckLockPriceInJSON(@RequestParam("lockKind")
	String lockKind, @RequestParam("lockModel")
	String lockModel) {
		String result = null;

		ObjectMapper mapper = new ObjectMapper();

		LockPriceDTO lockPrice =lockService.loadLockPrice(
				lockKind, lockModel);
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
	@RequestMapping(method = RequestMethod.POST, value = "/agency/buyfromcompany")
	public String createOrder(AgencyOrderForm agencyOrderForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		if (userRoleDTO != null) {
			if(agencyOrderForm.getType()!=null)
			{
				OrderDTO orderDTO=new OrderDTO();
				orderDTO.setStatus("Pending");
				orderDTO.setCreatedBy(userRoleDTO.getUserRoleId());
				orderDTO.setWarehouseId(agencyOrderForm.getWarehouseId());
				orderDTO.setOrderType("online");
				System.out.println(agencyOrderForm.getWarehouseId()+".......");
				Long orderId=machineService.saveOrder(orderDTO);
				try
				{
					for (int index = 0; index < agencyOrderForm.getType().length; index++) {
						OrderDetailsDTO orderDetailsDTO=new OrderDetailsDTO();
						orderDetailsDTO.setModel(agencyOrderForm.getModel()[index]);
						orderDetailsDTO.setType(agencyOrderForm.getType()[index]);
						orderDetailsDTO.setOrderFor(agencyOrderForm.getOrderFor()[index]);
						orderDetailsDTO.setOrderId(orderId);
						orderDetailsDTO.setQuantity(agencyOrderForm.getQuantity()[index]);
						machineService.saveOrderDetails(orderDetailsDTO);
						
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		return "redirect:buyfromcompany.htm?s=success";
	}
	
	@RequestMapping("/agency/myorders")
	public String myOrders(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		if (userRoleDTO != null) {
			
			List<OrderDTO> orders=machineService.loadOrders(userRoleDTO.getUserRoleId());
			request.setAttribute("orders", orders);
		}

		return "agencymyorders.page";

	}
	
	@RequestMapping("/agency/viewmyorder")
	public String viewMyOrders(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		if (userRoleDTO != null) {
			
			String id=request.getParameter("i");
			Long requestId=new Long(id);
			
			if(requestId!=null)
			{
				OrderDTO order=machineService.loadOrder(requestId);
				request.setAttribute("order",order);
				
				List<OrderDetailsDTO> orderDetails=machineService.loadOrderDetails(requestId);
				if(orderDetails!=null)
				{
					request.setAttribute("orderDetails",orderDetails);
				}
				WarehouseDTO warehouseDTO=warehouseService.loadWarehouse(order.getWarehouseId());
				request.setAttribute("warehouse", warehouseDTO);
				if(order.getStatus().equalsIgnoreCase("Shifted"))
				{
					List<MachineDTO> machines=machineService.loadMachineSales(requestId);
					request.setAttribute("machines", machines);
					
					List<LockDTO> locks=lockService.loadLockSales(requestId);
					request.setAttribute("locks", locks);
				}
				
			}
		}

		return "agencyviewmyorders.page";

	}

	@RequestMapping("/agency/machinepresent")
	public String machinePresent(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		if (userRoleDTO != null) {
			System.out.println("created by"+userRoleDTO.getUserRoleId());
			List<WarehouseDTO> warehouses = warehouseService.getWarehouses(
					userRoleDTO.getUserRoleId(), "Agency");
			request.setAttribute("warehouses", warehouses);
		}

		return "agencywarehousemachines.page";

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/agency/checkwarehousemachine")
	public @ResponseBody
	String getCheckWarehouseMachineInJSON(@RequestParam("warehouseId")
	String warehouseId,HttpServletRequest request) {
		String result = null;
		UserRoleDTO userRoleDTO=(UserRoleDTO)request.getSession().getAttribute("userRole");
		ObjectMapper mapper = new ObjectMapper();

		List<MachineDTO> machines = machineService.loadAgencyMachines(userRoleDTO.getUserRoleId(), new Long(warehouseId));
		if (machines != null) {
			try {

				result = mapper.writeValueAsString(machines);
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
	
	@RequestMapping("/agency/lockpresent")
	public String lockPresent(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		if (userRoleDTO != null) {
			List<WarehouseDTO> warehouses = warehouseService.getWarehouses(
					userRoleDTO.getUserRoleId(), "Agency");
			request.setAttribute("warehouses", warehouses);
		}

		return "agencywarehouselocks.page";

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/agency/checkwarehouselock")
	public @ResponseBody
	String getCheckWarehouseLockInJSON(@RequestParam("warehouseId")
	String warehouseId,HttpServletRequest request) {
		String result = null;
		UserRoleDTO userRoleDTO=(UserRoleDTO)request.getSession().getAttribute("userRole");
		ObjectMapper mapper = new ObjectMapper();

		List<LockDTO> locks = lockService.loadAgencyLocks(userRoleDTO.getUserRoleId(), new Long(warehouseId));
		if (locks != null) {
			try {

				result = mapper.writeValueAsString(locks);
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
 /* Sales Man Code*/
	
	
	@RequestMapping("/agency/createsalesman")
	public String createsalesMan(HttpServletRequest request) {
		
		
		return "agencycreatesalesman.page";
		
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/agency/checkaccount")
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
	
	@RequestMapping(method = RequestMethod.POST, value = "/agency/createaccount")
	public String createAccount(AccountForm accountForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		UserRoleDTO agency=(UserRoleDTO)request.getSession().getAttribute("userRole");
		if (accountForm != null) {
			UserRoleDTO userRoleDTO = new UserRoleDTO();
			userRoleDTO.setAccountKind("Other Account");
			userRoleDTO.setCity(accountForm.getCity());
			userRoleDTO.setCountry(accountForm.getCountry());
			userRoleDTO.setCreatedBy(agency.getUserRoleId());
			userRoleDTO.setCustomerId(accountForm.getCustomerId());
			userRoleDTO.setDocumentFileName(accountForm.getDoc()
					.getOriginalFilename());
			userRoleDTO.setStatus("Active");
			userRoleDTO.setFullName(accountForm.getFullName());
			userRoleDTO.setUserRole(accountForm.getUserRole());
			
			/**getting of countrycode and email code start heare ***************/
			String countryCode=accountForm.getCountryCode();
			String email=accountForm.getEmail();
			System.out.println(email+"email");
			String NewString = countryCode.replace("+", "");
			String NewRole=accountForm.getUserRole().substring(0, 2);
			
			System.out.println(NewString+"NewString");
			/***********generate random userId and password******************/
			int n = 3;
			Random randGen = new Random();

			int startNum = (int) Math.pow(10, n-1);
			int range = (int) (Math.pow(10, n) - startNum + 1);
			
			int randomuserId = randGen.nextInt(range) + startNum;
			String userId=NewString+NewRole+randomuserId;
			System.out.println(userId+"user role basedon");
			int randomPassword = randGen.nextInt(range) + startNum;
			String password=NewString+randomPassword;
			 /*code start mail ################################*/
		 	  try
		 	  {
		 	  SimpleMailMessage email1 = new SimpleMailMessage();
		 	 email1.setTo(email);
		 	email1.setSubject("Your userName and Password");
		 	email1.setText("userIdNo:"+userId+"password is:"+password);
				
				// sends the e-mail
				mailSender.send(email1);
		 	  }
		 	  catch(Exception e)
		 	  {
		 		  e.printStackTrace();
		 	  }
		 	   //send userId password to user roles table
				System.out.println(userId+"randomuserId");
				System.out.println(password+"randomPassword");
				userRoleDTO.setUserId(userId);
				userRoleDTO.setPassword(password);
		 	   
		 	  /*code end mail ################################*/
			
			
			/**creation of userId and password code end heare ***************/
			
			
			
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
					BufferedOutputStream  stream = new BufferedOutputStream(
							new FileOutputStream(file));
					stream.write(bytes);
					stream.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
			}

		}
System.out.println(accountForm.getUserRole()+"role");
		return "redirect:createsalesman.htm?u="
				+ accountForm.getUserRole() + "&s=success";
	}
	
	@RequestMapping("/agency/createbranch")
	public String createBranch() {
		
		
		return "agencycreatebranch.page";
		
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/agency/createsbranch")
	public String createBranch(BranchForm branchForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		UserRoleDTO userRoleDTO=(UserRoleDTO)request.getSession().getAttribute("userRole");
		if (branchForm != null) {
			
			BranchDTO branchDTO = new BranchDTO();
			branchDTO.setBranchName(branchForm.getBranchName());
			branchDTO.setContact(branchForm.getContact());
			branchDTO.setLocation(branchForm.getLocation());
			branchDTO.setCreatedBy(userRoleDTO.getUserRoleId());
			System.out.println(".........."+userRoleDTO.getUserRoleId());
			branchService.saveBranch(branchDTO);
		

		}

		return "redirect:createbranch.htm?u="
				+ "BranchCreated" + "&s=success";
	}
	
	@RequestMapping("/agency/branches")
	public String branches(HttpServletRequest request) {
		UserRoleDTO userRoleDTO=(UserRoleDTO)request.getSession().getAttribute("userRole");
		
		List<BranchDTO> branches=branchService.loadBranches(userRoleDTO.getUserRoleId());
		request.setAttribute("branches", branches);
		
		return "agencybranches.page";
	
	}
	
	
	@RequestMapping("/agency/connectwarehouse")
	public String connectWarehouses(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		if (userRoleDTO != null) {
			List<WarehouseDTO> warehouses = warehouseService.getWarehouses(
					userRoleDTO.getUserRoleId(), "Agency");
			request.setAttribute("warehouses", warehouses);
		}

		return "agencyconnectwarehouse.page";

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/agency/checksalesman")
	public @ResponseBody
	String getCheckSalesManUserAccountInJSON(@RequestParam("userId")
	String userId,HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
		.getAttribute("userRole");
		Map<String, Object> user = null;
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		if (userId != null && !userId.trim().equals("")) {
			user = userRoleService.loadUser(userId.trim(),userRoleDTO.getUserRoleId());
			if (user != null) {
				
				try {
					result = mapper.writeValueAsString(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				result = "fail";
			}

		}

		return result;

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/agency/connectwarehouse")
	public String connectWarehouse(ConnectWarehouseForm connectWarehouseForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		if(connectWarehouseForm!=null && connectWarehouseForm.getWarehouseId()!=null && connectWarehouseForm.getWarehouseId().length>0)
		{
			WarehouseSalesmanDTO warehouseSalesmanDTO=new WarehouseSalesmanDTO();
			warehouseSalesmanDTO.setSalesmanId(connectWarehouseForm.getUserRoleId());
			for (Long warehouseId:connectWarehouseForm.getWarehouseId()) {
				warehouseSalesmanDTO.setWarehouseId(warehouseId);
				warehouseService.saveWarehouseSalesman(warehouseSalesmanDTO);
			}
		}
		
		return "redirect:connectwarehouse.htm?s=success";
		}
	@RequestMapping("/agency/connectbranch")
	public String connectBranch(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		if (userRoleDTO != null) {
			List<BranchDTO> branches = branchService.loadBranches(userRoleDTO.getUserRoleId());
			request.setAttribute("branches", branches);
		}

		return "agencyconnectbranch.page";

	}
	@RequestMapping(method = RequestMethod.POST, value = "/agency/connectbranch")
	public String connectBranch(ConnectBranchForm connectBranchForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		if(connectBranchForm!=null && connectBranchForm.getBranchId()!=null && connectBranchForm.getBranchId().length>0)
		{
			BranchSalesmanDTO branchSalesmanDTO=new BranchSalesmanDTO();
			branchSalesmanDTO.setSalesmanId(connectBranchForm.getUserRoleId());
			
			for (Long branchId:connectBranchForm.getBranchId()) {
				branchSalesmanDTO.setBranchId(branchId);
				branchService.saveBranchSalesman(branchSalesmanDTO);
			}
		}
		
		return "redirect:connectbranch.htm?s=success";
		}
	@RequestMapping("/agency/salesman")
	public String salesman(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		if (userRoleDTO != null) {
			List<Map<String, Object>> salesman = userRoleService.loadUsers(userRoleDTO.getUserRoleId(), "SalesMan");
			System.out.println(salesman);
			request.setAttribute("salesman", salesman);
		}

		return "agencysalesman.page";

	}
	
	@RequestMapping("/agency/viewoperator")
	public String showoperator(HttpServletRequest request,Model model) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
		.getAttribute("userRole");
		String status=request.getParameter("q");
		if(status==null || status.trim().equals(""))
		{
			status="Pending";
			
		}
		List<Map<String, Object>> operators=customerService.loadOperatorRequest(status,userRoleDTO.getUserRoleId());
		System.out.println(operators + "oper list");
		request.setAttribute("operators", operators);
		return "agencyoperator.page";
	}
	
	@RequestMapping("/agency/viewoperatordetails")
	public String showViewOperartor(HttpServletRequest request,Model model) {
		String id=request.getParameter("i");
		Long requestId=new Long(id);
		
		if(requestId!=null)
		{
			
			OperatorRequestDTO operatorRequestDTO=customerService.loadoperatorRequests(requestId);
			
			if(operatorRequestDTO!=null)
			{
				CustomerDTO customerDTO=customerService.loadCustomer(operatorRequestDTO.getCustomerId());
				request.setAttribute("customer", customerDTO);
				request.setAttribute("operator", operatorRequestDTO);
				
				System.out.println(operatorRequestDTO.getCountry()+"operator");
				System.out.println(operatorRequestDTO.getStatus()+"operator");
				System.out.println("Operator Request Details"+ operatorRequestDTO);
				
				System.out.println("Customer Details"+customerDTO);
				System.out.println(customerDTO.getCountry());
				
				
			}
			
		}
		return "agencyviewoperatordetails.page";

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/agency/viewoperatordetails")
	public String agencyStatus(OperatorRequestForm operatorRequestForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		OperatorRequestDTO operatorRequestDTO=new OperatorRequestDTO();
		operatorRequestDTO.setComment(operatorRequestForm.getComment());
		operatorRequestDTO.setOperatorRequestId(operatorRequestForm.getOperatorRequestId());
		
		UserRoleDTO userRoleDTO=new UserRoleDTO();
		userRoleDTO.setAccountKind("Other Account");
		userRoleDTO.setStatus("Active");
		userRoleDTO.setCreatedBy(1L);
		userRoleDTO.setCity(operatorRequestForm.getCity());
		userRoleDTO.setCountry(operatorRequestForm.getCountry());
		userRoleDTO.setFullName(operatorRequestForm.getFullName());
		userRoleDTO.setCustomerId(operatorRequestForm.getCustomerId());
		userRoleDTO.setUserRole("Operator");
		
		
		
		/**agency Id creation *************************/
		/**getting of countrycode and email code start heare ***************/
		String countryCode=operatorRequestForm.getCountryCode();
		String NewString = countryCode.replace("+", "");
		System.out.println(NewString+"NewString");
		String NewRole="OP";
		/***********generate random userId and password******************/
		if(operatorRequestForm.getStatus().equals("Accept"))
		{
		int n = 3;
		Random randGen = new Random();

		int startNum = (int) Math.pow(10, n-1);
		int range = (int) (Math.pow(10, n) - startNum + 1);
		
		int randomuserId = randGen.nextInt(range) + startNum;
		String userId=NewString+NewRole+randomuserId;
		System.out.println(userId+"user role basedon");
		int randomPassword = randGen.nextInt(range) + startNum;
		String password=NewString+randomPassword;
		
		 /*code start mail ################################*/
		String email=operatorRequestForm.getEmail();
		System.out.println(email+"email1");
	 	 SimpleMailMessage email1 = new SimpleMailMessage();
	 	 email1.setTo(email);
	 	email1.setSubject("YouruserName and Password");
	 	email1.setText(operatorRequestForm.getComment()+"  "+"userIdNo:"+userId+"   "+"password is:"+password);
			
			// sends the e-mail
			mailSender.send(email1);
	 	   //send userId password to user roles table
			System.out.println(userId+"randomuserId");
			System.out.println(password+"randomPassword");
			/*  code end mail ################################*/
			userRoleDTO.setUserId(userId);
			userRoleDTO.setPassword(password);
			Long userRoleId = userRoleService.saveUserRole(userRoleDTO);
			OperatorRequestDTO  operatorRequestDTO1 = null;
			customerService.modifyOperatorRequests(operatorRequestDTO1);
		}
		else if(operatorRequestForm.getStatus().equals("Reject"))
		{
			 /*code start mail ################################*/
			String email=operatorRequestForm.getEmail();
			System.out.println(email+"email1");
		 	 SimpleMailMessage email1 = new SimpleMailMessage();
		 	 email1.setTo(email);
		 	email1.setSubject("YourAgencyRequestISRejected");
		 	email1.setText("BecauseOfThisReason:"+operatorRequestForm.getComment());
				// sends the e-mail
				mailSender.send(email1);
				/*  code end mail ################################*/
				
			
		}
	 	
		
		 
		/**creation of userId and password code end heare ***************/
		
		/**agency Id end *************************/
		operatorRequestDTO.setStatus(operatorRequestDTO.getStatus());
		customerService.modifyOperatorRequests(operatorRequestDTO);
		
		return "redirect:viewoperator.htm?st="
		+ operatorRequestForm.getStatus() + "&s=success";
			
		}
	
	@RequestMapping("/agency/operatororders")
	public String showAgencyOrders(HttpServletRequest request,Model model) {
		
		String status=request.getParameter("q");
		if(status==null || status.trim().equals(""))
		{
			status="Pending";
			
		}
		List<OperatorOrderDTO> orders=machineService.loadOperatorOrders(status);
		System.out.println(orders);
		request.setAttribute("orders", orders);
		return "agencyoperatororders.page";
	}
	@RequestMapping("/agency/viewoperatororder")
	public String showViewAgencyOrder(HttpServletRequest request,Model model) {
		
		String id=request.getParameter("i");
		Long requestId=new Long(id);
		
		if(requestId!=null)
		{
			OperatorOrderDTO order=machineService.loadOperatorOrder(requestId);
			request.setAttribute("order",order);
			
			List<OperatorOrderDetailsDTO> orderDetails=machineService.loadOperatorOrderDetails(requestId);
			if(orderDetails!=null)
			{
				request.setAttribute("orderDetails",orderDetails);
			}
			WarehouseDTO warehouseDTO=warehouseService.loadWarehouse(order.getWarehouseId());
			request.setAttribute("warehouse", warehouseDTO);
			Map<String, Object> operator=customerService.loadCustomerUserRole(order.getCreatedBy());
			System.out.println(operator+"...opp");
			request.setAttribute("operator", operator);
			
		}
		return "agencyviewoperatororder.page";
	}
	@RequestMapping(method = RequestMethod.POST, value = "/agency/viewoperatororder")
	public String agencyOrderStatus(OperatorOrderRequestForm operatorOrderRequestForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		UserRoleDTO userRoleDTO=(UserRoleDTO)request.getSession().getAttribute("userRole");
		if(userRoleDTO!=null)
		{
			System.out.println("Status "+operatorOrderRequestForm.getStatus());
			machineService.modifyOperatorOrder(operatorOrderRequestForm.getOrderId(), operatorOrderRequestForm.getComment(), operatorOrderRequestForm.getStatus(), userRoleDTO.getUserRoleId());
		}
		
		return "redirect:operatororders.htm?q="
		+operatorOrderRequestForm.getStatus() + "&s=success";
	}
	
	
}
