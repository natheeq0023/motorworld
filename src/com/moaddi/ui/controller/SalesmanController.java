package com.moaddi.ui.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.moaddi.dao.model.BranchTL;
import com.moaddi.dao.model.MachineTL;
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
import com.moaddi.service.dto.LockSalesDTO;
import com.moaddi.service.dto.MachineDTO;
import com.moaddi.service.dto.MachinePriceDTO;
import com.moaddi.service.dto.MachineSalesDTO;
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
import com.moaddi.ui.forms.SalesTransferForm;
import com.moaddi.ui.forms.WarehouseForm;

@Controller
public class SalesmanController {

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

	@RequestMapping("/salesman/signout")
	public String showSignout(HttpServletRequest response) {

		return "redirect:../otherlogin.htm?suMsg=Your successfully Signedout";
	}

	@RequestMapping("/salesman/salesmanhome")
	public String showCreateAccount(HttpServletRequest response) {

		if (response.getParameter("u") != null) {
			return "salesmanhome" + response.getParameter("u").toLowerCase()
					+ ".page";
		} else {
			return "salesmanhome.page";
		}

	}

	@RequestMapping("/salesman/warehousemachines")
	public String machinePresent(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		if (userRoleDTO != null) {
			System.out.println("created by" + userRoleDTO.getUserRoleId());
			List<WarehouseDTO> warehouses = warehouseService
					.loadSalesmanWarehouses(userRoleDTO.getUserRoleId());
			request.setAttribute("warehouses", warehouses);
		}

		return "salesmanwarehousemachines.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/salesman/checkwarehousemachine")
	public @ResponseBody
	String getCheckWarehouseMachineInJSON(@RequestParam("warehouseId")
	String warehouseId, HttpServletRequest request) {
		String result = null;
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		ObjectMapper mapper = new ObjectMapper();

		List<MachineDTO> machines = machineService.loadAgencyMachines(
				userRoleDTO.getCreatedBy(), new Long(warehouseId));
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

	@RequestMapping("/salesman/warehouselocks")
	public String lockPresent(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		if (userRoleDTO != null) {
			System.out.println("created by" + userRoleDTO.getUserRoleId());
			List<WarehouseDTO> warehouses = warehouseService
					.loadSalesmanWarehouses(userRoleDTO.getUserRoleId());
			request.setAttribute("warehouses", warehouses);
		}

		return "salesmanwarehouselocks.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/salesman/checkwarehouselock")
	public @ResponseBody
	String getCheckWarehouseLockInJSON(@RequestParam("warehouseId")
	String warehouseId, HttpServletRequest request) {
		String result = null;
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		ObjectMapper mapper = new ObjectMapper();

		List<LockDTO> locks = lockService.loadAgencyLocks(userRoleDTO
				.getCreatedBy(), new Long(warehouseId));
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

	/* operator request form */

	@RequestMapping("/salesman/createoperator")
	public String showAgencyRequest(HttpServletRequest request) {

		return "operatorrequest.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/salesman/checkaccount")
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

	@RequestMapping(method = RequestMethod.POST, value = "/salesman/createoperatoraccount")
	public String agencyRequest(OperatorRequestForm operatorRequestForm,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("hello");
		OperatorRequestDTO operatorRequestDTO = new OperatorRequestDTO();
		operatorRequestDTO.setCountry(operatorRequestForm.getCountry());
		operatorRequestDTO.setRequesterName(operatorRequestForm.getFullName());
		System.out.println(operatorRequestForm.getFullName() + "Full nAme");
		operatorRequestDTO.setOrganizationName(operatorRequestForm
				.getOrganizationName());
		operatorRequestDTO.setOrganizationType(operatorRequestForm
				.getOrganizationType());
		System.out
				.println("Salesman ID " + operatorRequestForm.getSalesManId());
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		if (userRoleDTO != null) {
			operatorRequestDTO.setCreatedBy(userRoleDTO.getUserRoleId());

		}
		operatorRequestDTO.setStreet(operatorRequestForm.getStreet());
		operatorRequestDTO.setCity(operatorRequestForm.getCity());
		operatorRequestDTO.setEmail(operatorRequestForm.getEmail());
		operatorRequestDTO.setMobileNo(operatorRequestForm.getMobileNo());
		operatorRequestDTO.setCustomerId(operatorRequestForm.getCustomerId());
		operatorRequestDTO.setStatus("Pending");
		operatorRequestDTO.setSalesManId(operatorRequestForm.getSalesManId());
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			operatorRequestDTO.setYearEstablished(sdf.parse(operatorRequestForm
					.getYearEstablished()));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/* code start mail ################################ */

		try
		{
		SimpleMailMessage email1 = new SimpleMailMessage();
		email1.setTo(operatorRequestForm.getEmail());
		email1.setSubject("NotificationFromMoaddi");
		email1
				.setText("We have received your request form for Operator.We are Proccesing your request Form it is taken 4 to 5 days");

		// sends the e-mail
		mailSender.send(email1);
		// send userId password to user roles table
		}catch (Exception e) {
			e.printStackTrace();
		}
		operatorRequestDTO.setDoc(operatorRequestForm.getDoc()
				.getOriginalFilename());
		Long operatorRequestId = customerService
				.saveOperatorRequests(operatorRequestDTO);
		if (operatorRequestId != null) {

			MultipartFile multiFile = operatorRequestForm.getDoc();
			try {
				// just to show that we have actually received the file

				String fileName = multiFile.getOriginalFilename();

				String path = request.getSession().getServletContext()
						.getRealPath("/");
				System.out.println(path + "path");
				// making directories for our required path.
				byte[] bytes = multiFile.getBytes();
				File directory = new File(path + "/uploads/operatorrequest/"
						+ operatorRequestId);
				System.out.println(directory + "directory");
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

		return "redirect:createoperator.htm?s=success";
	}
	@RequestMapping("/salesman/saleonline")
	public String showAgencyOrders(HttpServletRequest request,Model model) {
		
		String status=request.getParameter("q");
		if(status==null || status.trim().equals(""))
		{
			status="Accept";
			
		}
		List<OperatorOrderDTO> orders=machineService.loadOperatorOrders(status);
		System.out.println(orders);
		request.setAttribute("orders", orders);
		return "salesmanoperatororders.page";
	}
	@RequestMapping("/salesman/viewoperatororder")
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
			
			request.setAttribute("operator", operator);
			
		}
		return "salesmanviewoperatororder.page";
	}
	@RequestMapping(method = RequestMethod.POST, value = "/salesman/viewoperatororder")
	public String agencyOrderStatus(SalesTransferForm salesTransferForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		UserRoleDTO userRoleDTO=(UserRoleDTO)request.getSession().getAttribute("userRole");
		if(userRoleDTO!=null && salesTransferForm!=null)
		{
			if(salesTransferForm.getMachineSno()!=null && salesTransferForm.getMachineSno().length>0)
			{
				for(int index=0;index<salesTransferForm.getMachineSno().length;index++)
				{
					MachineSalesDTO machineSalesDTO=new MachineSalesDTO();
					Long machineId=machineService.loadMachineId(salesTransferForm.getMachineSno()[index]);
					machineSalesDTO.setMachineId(machineId);
					machineSalesDTO.setOrderId(salesTransferForm.getOrderId());
					machineService.saveAgencyMachineSales(machineSalesDTO);
					
				}
				
			}
			if(salesTransferForm.getLockSno()!=null && salesTransferForm.getLockSno().length>0)
			{
				
				for(int index=0;index<salesTransferForm.getLockSno().length;index++)
				{
					LockSalesDTO lockSalesDTO=new LockSalesDTO();
					Long lockId=lockService.loadLockId(salesTransferForm.getLockSno()[index]);
					lockSalesDTO.setLockId(lockId);
					lockSalesDTO.setOrderId(salesTransferForm.getOrderId());
					lockService.saveAgencyLockSales(lockSalesDTO);
					
				}
			}
			
			machineService.modifyOperatorOrder(salesTransferForm.getOrderId(), "Shifted", userRoleDTO.getUserRoleId());
			
		}
		
		return "redirect:saleonline.htm?s=success";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/salesman/checklocksno")
	public @ResponseBody String getCheckLockInJSON(@RequestParam("lockSno")
			String lockSno,HttpServletRequest request) {

				
				
				
				String result = null;
				
				
				UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
				
				if (lockSno != null) {
					try {
						boolean isExists=lockService.isAgencyLockAvailable(lockSno.toUpperCase(),userRoleDTO.getCreatedBy());
						
							
							if(isExists)
							{	
								return "{\"msg\":\"success\"}";
								
							}
							else
							{
								return "{\"msg\":\"fail\"}";
							}
					
					} catch (Exception e) {
						e.printStackTrace();
						return "{\"msg\":\"fail\"}";
					}
				}
				
				return result;
			}
	@RequestMapping(method = RequestMethod.GET, value = "/salesman/checkmachinesno")
	public @ResponseBody String getCheckMachineInJSON(@RequestParam("machineSno")
			String machineSno,HttpServletRequest  request) {

				
				
				
				String result = null;
				UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
				
				
				
				if (machineSno != null) {
					try {
						boolean isExists=machineService.isAgencyMachineAvailable(machineSno.toUpperCase(),userRoleDTO.getCreatedBy());
						
							
							if(isExists)
							{	
								return "{\"msg\":\"success\"}";
								
							}
							else
							{
								return "{\"msg\":\"fail\"}";
							}
					
					} catch (Exception e) {
						e.printStackTrace();
						return "{\"msg\":\"fail\"}";
					}
				}
				
				return result;
			}
	
	@RequestMapping(method = RequestMethod.GET, value = "/salesman/profile")
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
		return "salesmanprofile.page";
	}

	@RequestMapping("/salesman/changeprofile")
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
		return "salesmanchangeProfile.page";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/salesman/updatepassword")
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
			return "salesmanerror.page";
		}
		return "salesmansucess.page";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/salesman/updateNumber")
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

			return "salesmanerror.page";
		}

		return "salesmansucess.page";
	}

}
