package com.moaddi.ui.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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



import com.moaddi.service.CustomerService;

import com.moaddi.service.UserRoleService;
import com.moaddi.service.VehicleAdService;

import com.moaddi.service.dto.CustomerDTO;


import com.moaddi.service.dto.UserRoleDTO;
import com.moaddi.service.dto.VehicleAdDTO;
import com.moaddi.service.dto.VehicleServiceDTO;

import com.moaddi.ui.forms.AccountForm;
import com.moaddi.ui.forms.AgencyRequestForm;
import com.moaddi.ui.forms.BarcodeForm;
import com.moaddi.ui.forms.LockForm;
import com.moaddi.ui.forms.MachineForm;
import com.moaddi.ui.forms.VehicleAdForm;
import com.moaddi.ui.forms.VehicleServiceForm;
import com.moaddi.utility.OTPUtility;
import com.moaddi.utility.SendSmsUtility;

@Controller
public class AdministrationController {
	
	@Autowired
	private JavaMailSender mailSender;
	

	@Autowired
	private CustomerService customerService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private VehicleAdService vehicleAdService;

	
	
			
	

	@RequestMapping("/admin/adminhome")
	public String showCreateAccount(HttpServletRequest response) {

		if(response.getParameter("u")!=null)
		{
		 return "adminhome"+response.getParameter("u").toLowerCase()+".page";
		}
		else
		{
			return "adminhome.page";
		}

	}
	@RequestMapping(method = RequestMethod.GET, value = "/admin/createAd.htm")
	public String initMachineForm(Model model) {
		VehicleAdForm vehicleAdForm = new VehicleAdForm();
		model.addAttribute("createAd", vehicleAdForm);
		initModelList(model);
		return "admincreateAd.page";
	}
	
	private void initModelList(Model model) {
		// TODO Auto-generated method stub
		
	}
	/*************************barcode code start heare *********************************/
	
	@RequestMapping(method = RequestMethod.POST, value = "/admin/createmachinebarcode")
	public String submitMachineForm(BarcodeForm machineForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {

		if (machineForm != null) {
		
			System.out.println("control heare");

				MultipartFile multiFile = machineForm.getMachinePhoto();
				System.out.println("control heare 1");
				try {
					// just to show that we have actually received the file

					String fileName = multiFile.getOriginalFilename();
					System.out.println("control heare 1"+fileName);
					String duplicate="PDF_417.png";
					/*String path = request.getSession().getServletContext()
							.getRealPath("/");*/
					/*System.out.println("control heare 1"+path);*/
					// making directories for our required path.
					String path="C:\\";
					byte[] bytes = multiFile.getBytes();
					File directory = new File(path + "barcode");
					System.out.println("control heare 1"+path);
					directory.mkdirs();
					// saving the file
					File file = new File(directory.getAbsolutePath()
							+ System.getProperty("file.separator") + duplicate);
					System.out.println("control heare 2"+file);
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(file));
					stream.write(bytes);
					
					stream.close();
					
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
			}
		
		return "redirect:createmachine.htm?s=success";

	}
	
	/****************************barcode end code ****************************************/
	@RequestMapping("/admin/signout")
	public String showSignout(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			session.invalidate();
		}
		return "redirect:../otherlogin.htm?suMsg=Your successfully Signedout";
	}


	
	@RequestMapping(method = RequestMethod.POST, value = "/admin/createAd")
	public String submitAdForm(VehicleAdForm vehicleAdForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {

		if (vehicleAdForm != null) {
			VehicleAdDTO vehicleAdDTO = new VehicleAdDTO();
			vehicleAdDTO.setPrice(vehicleAdForm.getPrice());
			vehicleAdDTO.setStatus("Available");
			vehicleAdDTO.setTitle(vehicleAdForm.getTitle());
			vehicleAdDTO.setVtype(vehicleAdForm.getVtype());
			vehicleAdDTO.setVehiclePhotoName(vehicleAdForm.getVehiclePhoto().getOriginalFilename());
			
			
			Long adId = vehicleAdService.saveVehicleAd(vehicleAdDTO);
			if (adId != null) {

				MultipartFile multiFile = vehicleAdForm.getVehiclePhoto();
				try {
					// just to show that we have actually received the file

					String fileName = multiFile.getOriginalFilename();

					String path = request.getSession().getServletContext()
							.getRealPath("/");
                     System.out.println("path "+path);
					// making directories for our required path.
					byte[] bytes = multiFile.getBytes();
					File directory = new File(path + "/uploads/ad/"
							+ adId);
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
		return "redirect:createAd.htm?s=success";

	}


	

	
	
	@RequestMapping("/admin/createaccount")
	public String showCreateAccount(HttpServletRequest request,Model model) {
		
		String userRole=request.getParameter("u");
		if(userRole==null|| userRole.trim().equals(""))
		{
			userRole="Controller";
		}
		AccountForm accountForm=new AccountForm();
		accountForm.setUserRole(userRole);
		request.setAttribute("userRole", userRole);
		model.addAttribute("createaccount", accountForm);
		
		
		return "admincreateaccount.page";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/admin/checkaccount")
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

	@RequestMapping(method = RequestMethod.POST, value = "/admin/createaccount")
	public String createAccount(AccountForm accountForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		if (accountForm != null) {
			UserRoleDTO userRoleDTO = new UserRoleDTO();
			userRoleDTO.setAccountKind("Company");
			userRoleDTO.setCity(accountForm.getCity());
			userRoleDTO.setCountry(accountForm.getCountry());
			userRoleDTO.setCreatedBy(1L);
			userRoleDTO.setCustomerId(accountForm.getCustomerId());
			userRoleDTO.setDocumentFileName(accountForm.getDoc()
					.getOriginalFilename());
			userRoleDTO.setStatus("Active");
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
				+ accountForm.getUserRole() + "&s=success";
	}

	@RequestMapping("/admin/agency")
	public String showAgency(HttpServletRequest request,Model model) {
		
		String status=request.getParameter("q");
		if(status==null || status.trim().equals(""))
		{
			status="Pending";
			
		}
		List<Map<String, Object>> agencies=customerService.loadAgency(status);
		request.setAttribute("agencies", agencies);
		return "adminagency.page";
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET,value="/admin/profile")
	public String AdminProfile(HttpServletRequest request) {
		System.out.println("hi");
		String cid=request.getParameter("cid");
		String uid=request.getParameter("uid");
		System.out.println(cid+"cid");
		System.out.println(uid+"uid");
		
		if(cid!=null&&uid!=null && !cid.trim().equals("")&& !uid.trim().equals(""))
		{
			Long customerId=new Long(cid);
			Long userRoleId=new Long(uid);
			System.out.println(customerId+"customerId");
			System.out.println(userRoleId+"userRoleId");
			CustomerDTO customerDTO=customerService.loadCustomer(customerId);
			UserRoleDTO userRoleDTO=userRoleService.loadUserRole(userRoleId);
			if(customerDTO!=null)
			{
				request.setAttribute("customer", customerDTO);
			}
			if(userRoleDTO!=null)
			{
				request.setAttribute("userRole", userRoleDTO);
			}
		}
			return "adminprofile.page";
		}
	@RequestMapping("/admin/changeprofile")
	public String ChangeProfile(HttpServletRequest request) {
		System.out.println("hi");
		String cid=request.getParameter("cid");
		String uid=request.getParameter("uid");
		System.out.println(cid+"cid");
		System.out.println(uid+"uid");
		
		if(cid!=null&&uid!=null && !cid.trim().equals("")&& !uid.trim().equals(""))
		{
			Long customerId=new Long(cid);
			Long userRoleId=new Long(uid);
			System.out.println(customerId+"customerId");
			System.out.println(userRoleId+"userRoleId");
			CustomerDTO customerDTO=customerService.loadCustomer(customerId);
			UserRoleDTO userRoleDTO=userRoleService.loadUserRole(userRoleId);
			if(customerDTO!=null)
			{
				request.setAttribute("customer", customerDTO);
			}
			if(userRoleDTO!=null)
			{
				request.setAttribute("userRole", userRoleDTO);
			}
		}
		return "adminchangeProfile.page";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/updatepassword")
	public String updtaeAccountStatus(HttpServletRequest request,
			HttpServletResponse response) {
		String cid=request.getParameter("customerId");
		String uid=request.getParameter("userRoleId");
		String usrpassord = request.getParameter("oldpassword");
		System.out.println("Password from form"+usrpassord);
		System.out.println(cid +"usser"+ uid);
		System.out.println("password" +request.getParameter("confirmpassword"));
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		
		Long customerId=new Long(cid);
		Long userRoleId=new Long(uid);
		UserRoleDTO userRoleDTO=userRoleService.loadUserRole(userRoleId);
		
		String olddatabsepassword = userRoleDTO.getPassword();
		System.out.println("Oldpass"+olddatabsepassword);
		if(olddatabsepassword.equalsIgnoreCase(usrpassord))
		{
			userRoleService.modifyUserPassord(new Long(request
					.getParameter("userRoleId")), request
				.getParameter("confirmpassword"));
 	    }
		else
		{
			return "adminerror.page";
		}
			return "adminsucess.page";
		}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/updateNumber")
	public String updtaeN(HttpServletRequest request,
			HttpServletResponse response) {
		String cid=request.getParameter("customer");
		String uid=request.getParameter("userRole");
	String oldmobileNo =request.getParameter("oldmobileNo");

	   Long customerId=new Long(cid);
		Long userRoleId=new Long(uid);
		
		CustomerDTO customerDTO=customerService.loadCustomer(customerId);
		String oldMobileNoDatabase  =  	customerDTO.getMobileNo();
		
		if(oldmobileNo.equalsIgnoreCase(oldMobileNoDatabase))
		{
			customerService.modifyUserNumber(new Long(request

					.getParameter("customer")), request
					.getParameter("mobileNo"));
		     
		}
		else
		{
			
			return "adminerror.page";
		}
			
		return "adminsucess.page";
	}


	
	
	@RequestMapping("/admin/customerVehicleService")
	public String showCustomerOrders(HttpServletRequest request,Model model) {
		
		String status=request.getParameter("q");
		if(status==null || status.trim().equals(""))
		{
			status="Pending";
			
		}
		List<VehicleServiceDTO> orders=customerService.loadOrders(status);
		System.out.println(orders);
		request.setAttribute("orders", orders);
		return "customerService.page";
	}
	@RequestMapping("/admin/viewvehicleservice")
	public String showVehicleService(HttpServletRequest request,Model model) {
		
		String id=request.getParameter("i");
		Long requestId=new Long(id);
		
		if(requestId!=null)
		{
			
			
			List<VehicleServiceDTO> orderDetails=customerService.loadOrder(requestId);
			if(orderDetails!=null)
			{
				for(int i=0;i<orderDetails.size();i++)
				{
					String vName = orderDetails.get(i).getVehicleName();
					String vyear = orderDetails.get(i).getVehicleYear();
					request.setAttribute("vName",vName);
					request.setAttribute("vyear",vyear);
				}
				
				request.setAttribute("orderDetails",orderDetails);
			
			}
			 
			
			
		}
		return "adminviewvehicleservice.page";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/admin/viewvehicleservice")
	public String vehicleServiceStatus(VehicleServiceDTO vehicleServiceForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		UserRoleDTO userRoleDTO=(UserRoleDTO)request.getSession().getAttribute("userRole");
		String id=request.getParameter("i");
		Long requestId=new Long(id);
		System.out.println(request.getSession().getAttribute("userRole")+ "user role id");
		
		
		if(userRoleDTO!=null)
		{
			customerService.modifyOrder(requestId, vehicleServiceForm.getComment(),vehicleServiceForm.getVehicleName(),vehicleServiceForm.getVehicleYear(),vehicleServiceForm.getStatus(), userRoleDTO.getFullName(),vehicleServiceForm.getIssues());
		}
		
		return "redirect:customerVehicleService.htm?q="
		+ vehicleServiceForm.getStatus() + "&s=success";
	}
	
	
	@RequestMapping("/admin/customerRtoService")
	public String showCustomerRTORequest(HttpServletRequest request,Model model) {
		
		String status=request.getParameter("q");
		if(status==null || status.trim().equals(""))
		{
			status="Pending";
			
		}
		List<VehicleServiceDTO> orders=customerService.loadRtoOrders(status);
		System.out.println(orders);
		request.setAttribute("orders", orders);
		return "customerRTOService.page";
	}
	
	@RequestMapping("/admin/viewRTOvehicleservice")
	public String showRtoVehicleService(HttpServletRequest request,Model model) {
		
		String id=request.getParameter("i");
		Long requestId=new Long(id);
		
		if(requestId!=null)
		{
			
			
			List<VehicleServiceDTO> orderDetails=customerService.loadRTOOrder(requestId);
			if(orderDetails!=null)
			{
				for(int i=0;i<orderDetails.size();i++)
				{
					String vName = orderDetails.get(i).getVehicleName();
					String vyear = orderDetails.get(i).getVehicleYear();
					request.setAttribute("vName",vName);
					request.setAttribute("vyear",vyear);
				}
				
				request.setAttribute("orderDetails",orderDetails);
			
			}
			 
			
			
		}
		return "adminviewvehicleRTOservice.page";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/admin/viewRTOvehicleservice")
	public String vehicleRTOServiceStatus(VehicleServiceDTO vehicleServiceForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		UserRoleDTO userRoleDTO=(UserRoleDTO)request.getSession().getAttribute("userRole");
		String id=request.getParameter("i");
		Long requestId=new Long(id);
		
		
		
		if(userRoleDTO!=null)
		{
			customerService.modifyRTOStatus(requestId, vehicleServiceForm.getComment(),vehicleServiceForm.getVehicleName(),vehicleServiceForm.getVehicleYear(),vehicleServiceForm.getStatus(), userRoleDTO.getFullName(),vehicleServiceForm.getIssues());
		}
		
		return "redirect:customerRtoService.htm?q="
		+ vehicleServiceForm.getStatus() + "&s=success";
	}
	
	
	
}
