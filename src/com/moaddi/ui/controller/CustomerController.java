package com.moaddi.ui.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.moaddi.service.CustomerService;
import com.moaddi.service.LockService;
import com.moaddi.service.MachineService;
import com.moaddi.service.UserRoleService;
import com.moaddi.service.VehicleAdService;
import com.moaddi.service.WarehouseService;
import com.moaddi.service.dto.AgencyRequestDTO;
import com.moaddi.service.dto.AgencyRequestDTOs;
import com.moaddi.service.dto.CustomerDTO;
import com.moaddi.service.dto.LockDTO;
import com.moaddi.service.dto.MachineDTO;
import com.moaddi.service.dto.OrderDTO;
import com.moaddi.service.dto.UserRoleDTO;
import com.moaddi.service.dto.VehicleAdDTO;
import com.moaddi.service.dto.VehicleServiceDTO;
import com.moaddi.service.dto.WarehouseDTO;
import com.moaddi.ui.forms.AgencyRequestForm;
import com.moaddi.ui.forms.AgencyRequestForms;
import com.moaddi.ui.forms.VehicleServiceForm;

@Controller
public class CustomerController {
	
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
	private VehicleAdService vehicleAdService;	
	
	@Autowired
	private UserRoleService userRoleService;
	
	@RequestMapping("/customer/signout")
	public String showSignout(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			session.invalidate();
		}
		return "redirect:../login.htm?suMsg=Your successfully Signedout";
	}


	@RequestMapping("/customer/customerhome")
	public String customerHome(HttpServletRequest request) {
		
		
		VehicleAdDTO vehicleAdDTO = vehicleAdService.loadAd(); 
		  return "customerhome.page";
	} 
	
	@RequestMapping("/customer/agencyrequest")
	public String showAgencyRequest(HttpServletRequest request) {
		
		return "customeragencyrequest.page";

	}
	
	@RequestMapping("/customer/vehicleservice")
	public String showvVehicleServiceRequest(HttpServletRequest request) {
		
		return "vehiclerequest.page";

	}
	
	
	@RequestMapping("/customer/contactUs")
	public String contactUs(HttpServletRequest request) {
		
		return "contactUs.page";

	}
	
	@RequestMapping("/contactUsHomePage")
	public String contactUsHomePage(HttpServletRequest request) {
		
		return "contactUsHome.page";

	}
	
	@RequestMapping("/customer/aboutUs")
	public String aboutUs(HttpServletRequest request) {
		
		return "aboutUs.page";

	}
	
	
	@RequestMapping("/forgotpassword")
	public String forgotPassword(HttpServletRequest request) {
		
		return "forgotpassword.page";

	}
	
	@RequestMapping("/customer/rtoService")
	public String rtoServiceRequest(HttpServletRequest request) {
		
		return "rtoService.page";

	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/customer/vehicleservice")
	public String vehicleServiceRequest(VehicleServiceForm vehicleServiceForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("hello");
		VehicleServiceDTO vehicleServiceDTO  =  new VehicleServiceDTO();
		vehicleServiceDTO.setVbrand(vehicleServiceForm.getVbrand());
		vehicleServiceDTO.setVtyqe(vehicleServiceForm.getVtype());
		vehicleServiceDTO.setCustomerId(vehicleServiceForm.getCustomerId());
		vehicleServiceDTO.setArea(vehicleServiceForm.getArea());
		vehicleServiceDTO.setRequesterName(vehicleServiceForm.getFullName());
		vehicleServiceDTO.setMobileNo(vehicleServiceForm.getMobileNo());
		vehicleServiceDTO.setStatus("Pending");
		
		String mob = vehicleServiceForm.getMobileNo();
		String fullname = vehicleServiceForm.getFullName();
		
		
		 /*code start mail ################################*/
	 	  
	 	  SimpleMailMessage email1 = new SimpleMailMessage();
	 	 email1.setTo("nathiq2020@gmail.com");
	 	email1.setSubject("Notification for vehicle Service");
	 	email1.setText("We have received your request form for vehicle servie "
	 			+ "Mobile No :" +mob+ 
	 			  "Name :" +fullname);
			
			// sends the e-mail
			mailSender.send(email1);
	 	   //send userId password to user roles table
			
		
		System.out.println(vehicleServiceForm.getCustomerId()+"In Controller");
		Long agencyRequestId=customerService.saveVehicleService(vehicleServiceDTO);
		
	     return "adminsucess.page";
		//return "redirect:agencyrequest.htm?s=success";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/customer/rtoService")
	public String rtoServiceRequest(VehicleServiceForm vehicleServiceForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("hello");
		VehicleServiceDTO vehicleServiceDTO  =  new VehicleServiceDTO();
		vehicleServiceDTO.setVbrand(vehicleServiceForm.getVbrand());
		vehicleServiceDTO.setVtyqe(vehicleServiceForm.getVtype());
		vehicleServiceDTO.setCustomerId(vehicleServiceForm.getCustomerId());
		vehicleServiceDTO.setArea(vehicleServiceForm.getArea());
		vehicleServiceDTO.setRequesterName(vehicleServiceForm.getFullName());
		vehicleServiceDTO.setMobileNo(vehicleServiceForm.getMobileNo());
		vehicleServiceDTO.setStatus("Pending");
		vehicleServiceDTO.setRtoservicetype(vehicleServiceForm.getRtoservicetype());
		vehicleServiceDTO.setVehicleName(vehicleServiceForm.getVehicleName());
		String mob = vehicleServiceForm.getMobileNo();
		String fullname = vehicleServiceForm.getFullName();
		String serviceType = vehicleServiceForm.getRtoservicetype();
		System.out.println("Mobile No"+mob+ "fullname"+fullname);
		 /*code start mail ################################*/
	 	  
	 	  SimpleMailMessage email1 = new SimpleMailMessage();
	 	 email1.setTo("nathiq2020@gmail.com");
	 	email1.setSubject("Notification for vehicle Service");
	 	email1.setText("We have received your rto request form for vehicle servie "
	 			+ "Mobile No :" +mob+ 
	 			  "Name :" +fullname+
	 			  "servce Type"+serviceType);
			
			// sends the e-mail
			mailSender.send(email1);
	 	   //send userId password to user roles table
			
		
		System.out.println(vehicleServiceForm.getCustomerId()+"In Controller");
		Long rtoRequestId=customerService.saveRtoService(vehicleServiceDTO);
		
	     return "adminsucess.page";
		//return "redirect:agencyrequest.htm?s=success";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/customer/agencyrequest")
	public String agencyRequest(AgencyRequestForm agencyRequestForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("hello");
		AgencyRequestDTO agencyRequestDTO=new AgencyRequestDTO();
		agencyRequestDTO.setCountry(agencyRequestForm.getCountry());
		agencyRequestDTO.setOrganizationName(agencyRequestForm.getOrganizationName());
		agencyRequestDTO.setOrganizationType(agencyRequestForm.getOrganizationType());
		agencyRequestDTO.setRequesterName(agencyRequestForm.getRequesterName());
		agencyRequestDTO.setStreet(agencyRequestForm.getStreet());
		agencyRequestDTO.setCity(agencyRequestForm.getCity());
		agencyRequestDTO.setEmail(agencyRequestForm.getEmail());
		agencyRequestDTO.setMobileNo(agencyRequestForm.getMobileNo());
		agencyRequestDTO.setCustomerId(agencyRequestForm.getCustomerId());
		agencyRequestDTO.setStatus("Pending");
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		try {
			agencyRequestDTO.setYearEstablished(sdf.parse(agencyRequestForm.getYearEstablished()));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		 /*code start mail ################################*/
	 	  
	 	  SimpleMailMessage email1 = new SimpleMailMessage();
	 	 email1.setTo(agencyRequestForm.getEmail());
	 	email1.setSubject("NotificationFromMoaddi");
	 	email1.setText("We have received your request form for Agency.We are Proccesing your request Form it is taken 4 to 5 days");
			
			// sends the e-mail
			mailSender.send(email1);
	 	   //send userId password to user roles table
			
		agencyRequestDTO.setDoc(agencyRequestForm.getDoc().getOriginalFilename());
		System.out.println(agencyRequestForm.getCustomerId()+"In Controller");
		Long agencyRequestId=customerService.saveAgencyRequests(agencyRequestDTO);
		if (agencyRequestId != null) {

			MultipartFile multiFile = agencyRequestForm.getDoc();
			try {
				// just to show that we have actually received the file

				String fileName = multiFile.getOriginalFilename();

				String path = request.getSession().getServletContext()
						.getRealPath("/");
                System.out.println(path+"path");
				// making directories for our required path.
				byte[] bytes = multiFile.getBytes();
				File directory = new File(path + "/uploads/agencyrequest/"
						+ agencyRequestId);
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
	
		return "redirect:agencyrequest.htm?s=success";
	}
	
@RequestMapping(method = RequestMethod.POST, value = "/customer/buy")
/*date 29 dec 2015*/
	public String agencyRequest(CustomerDTO customerDTO, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
	CustomerDTO customerDTO1=new CustomerDTO();
	customerDTO.setCustomerId(customerDTO.getCustomerId());
	customerDTO.setCustomerId(4l);
	customerDTO.setStatus("Pending");
	
	try {
		MultipartFile multiFile = null;
	String fileName = multiFile.getOriginalFilename();

	String path = request.getSession().getServletContext()
			.getRealPath("/");
    System.out.println(path+"path");
	// making directories for our required path.
	byte[] bytes = multiFile.getBytes();
	File directory = new File(path + "/uploads/customer/"
			);
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
	    customerService.saveCustomer(customerDTO);
		return "redirect:saveCustomer.htm?s=success";
	}

@RequestMapping(method = RequestMethod.GET,value="/customer/profile")
public String AdminProfile(HttpServletRequest request) {
	System.out.println("hi");
	String cid=request.getParameter("cid");
	String uid=request.getParameter("uid");
	System.out.println(cid+"cid");
	System.out.println(uid+"uid");
	
	if(cid!=null&&uid!=null && !cid.trim().equals("")&& !uid.trim().equals(""))
	{
		Long customerId=new Long(cid);
	//	String userRoleId=new String(uid);
		System.out.println(customerId+"customerId");
		//System.out.println(userRoleId+"userRoleId");
		CustomerDTO customerDTO=customerService.loadCustomer(customerId);
		//UserRoleDTO userRoleDTO=userRoleService.loadUserRole(userRoleId);
		if(customerDTO!=null)
		{
			request.setAttribute("customer", customerDTO);
		}
		
	}
		return "customerprofile.page";
	}
@RequestMapping("/customer/changeprofile")
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
	return "customerchangeProfile.page";

}

@RequestMapping(method = RequestMethod.POST, value = "/customer/updatepassword")
public String updtaeAccountStatus1(HttpServletRequest request,
		HttpServletResponse response) {
	String cid=request.getParameter("customerId");
	
	String usrpassord = request.getParameter("oldpassword");
	System.out.println("Password from form"+usrpassord);
	System.out.println(cid +"usser");
	System.out.println("password" +request.getParameter("confirmpassword"));
	ObjectMapper mapper = new ObjectMapper();
	String result = null;
	
	Long customerId=new Long(cid);
	CustomerDTO customerDTO = customerService.loadCustomer(customerId);
	
	
	String olddatabsepassword = customerDTO.getPassword();
	System.out.println("Oldpass"+olddatabsepassword);
	if(olddatabsepassword.equalsIgnoreCase(usrpassord))
	{
		customerService.modifyUserPassord(new Long(request
				.getParameter("customerId")), request
			.getParameter("confirmpassword"));
	    }
	else
	{
		return "controllererror.page";
	}
		return "controllersucess.page";
	}

@RequestMapping(method = RequestMethod.POST, value = "/customer/updateNumber")
public String updtaeN(HttpServletRequest request,
		HttpServletResponse response) {
	String cid=request.getParameter("customer");
	//String uid=request.getParameter("userRole");
    String oldmobileNo =request.getParameter("oldmobileNo");
    Long customerId=new Long(cid);
	//Long userRoleId=new Long(uid);
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
		
		return "controllererror.page";
	}
		
	return "controllersucess.page";
}

@RequestMapping(method = RequestMethod.POST, value = "/updatePassword")
public String updtaePassword(HttpServletRequest request,
		HttpServletResponse response) {
	
	String cid=request.getParameter("userId");
	String usrpassord = request.getParameter("newpassword");
	Map<String,Object> map = customerService.loadCustomer(cid);
	long customerID = (long) map.get("customerId");
	  customerService.modifyUserPassord(customerID, request
	  .getParameter("newpassword"));
	  
	 return "customersucess.page";
	
      }


@RequestMapping(method = RequestMethod.GET,value="/customer/myorders")
public String myOrders(HttpServletRequest request) {
	String cid=request.getParameter("cid");
	 long customerId = Long.parseLong(cid);
	 System.out.println("Customer id"+customerId);
	if (cid != null) {
		
		List<VehicleServiceDTO> orders=customerService.loadOrders(customerId);
		System.out.println("cutsomer details"+orders);
		request.setAttribute("orders", orders);
		
		List<VehicleServiceDTO> serviceorders=customerService.serviceOrders(customerId);
		System.out.println("cutsomer details"+serviceorders);
		request.setAttribute("serviceorders", serviceorders);
		
	}

	return "myorders.page";

}


}



