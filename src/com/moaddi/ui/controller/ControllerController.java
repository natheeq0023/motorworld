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
public class ControllerController {

	/*code for mail*/
	@Autowired
	private JavaMailSender mailSender;
	/*code for mail*/
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
	@RequestMapping("/controller/signout")
	public String showSignout(HttpServletRequest response) {
		
		return "redirect:../otherlogin.htm?suMsg=Your successfully Signedout";
	}

	@RequestMapping("/controller/createaccount")
	public String showCreateAccount(HttpServletRequest response) {

		
		return "welcomecontroller.page";
	
	
	}
	@RequestMapping("/controller/controlaccount")
	public String showContollPage() {

		return "controllercontrolpage.page";
	
	}

	@RequestMapping(method = RequestMethod.GET, value = "/controller/checkaccountstatus")
	public @ResponseBody
	String getCheckAccountStatusInJSON(@RequestParam("userId")
	String userId, @RequestParam("accountKind")
	String accountKind, @RequestParam("accountName")
	String accountName) {

		Map<String, Object> userAccount = null;
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		if (userId != null && !userId.trim().equals("") && accountKind != null
				&& !accountKind.trim().equals("") && accountName != null
				&& !accountName.trim().equals("")) {
			userAccount = userRoleService.loadCustomer(userId.trim());

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
	
	@RequestMapping(method = RequestMethod.POST, value = "/controller/updateaccountstatus")
	public String updtaeAccountStatus(HttpServletRequest request,
			HttpServletResponse response) {

		userRoleService.modifyUserStatus(new Long(request
				.getParameter("userRoleId")), request
				.getParameter("accountStatus"));
      System.out.println("User Role ID" + request.getParameter("userRoleId")) ;
      System.out.println("Status " + request.getParameter("accountStatus"));
		return "redirect:controlaccount.htm?s="
				+ request.getParameter("accountStatus");
	}
	
	
	@RequestMapping("/controller/viewaccount")
	public String showViewAccount(HttpServletRequest request) {
       System.out.println("In View");
		String cid=request.getParameter("cid");
		String uid=request.getParameter("uid");
		if(cid!=null&&uid!=null && !cid.trim().equals("")&& !uid.trim().equals(""))
		{
			Long customerId=new Long(cid);
			Long userRoleId=new Long(uid);
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
		return "controllerviewpage.page";

	}
	@RequestMapping("/controller/machinecontrolpage")
	public String showMachineContollPage() {

		return "controllermachinepage.page";
	
	}
	@RequestMapping("/controller/lockcontrolpage")
	public String showLockContollPage() {

		return "controllerlockpage.page";
	
	}
	@RequestMapping(method = RequestMethod.GET, value = "/controller/checkpagestatus")
	public @ResponseBody
	String getCheckPageStatusInJSON(@RequestParam("id")
	String id) {
		String result = null;
		
			ObjectMapper mapper = new ObjectMapper();
						
				Map<String, Object> machine = machineService.loadMachine(id);
				if (machine != null) {
					try {
						Long warehouseId=(Long)machine.get("warehouseId");
						if(warehouseId!=null)
						{
							machine.putAll(warehouseService.loadWareHouse(warehouseId));
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
		
		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/controller/updatepagestatus")
	public String updtaePageStatus(HttpServletRequest request,
			HttpServletResponse response) {
		
			
				machineService.modifyMachineStatus(new Long(request
						.getParameter("id")), request
						.getParameter("pageStatus"));
		

		return "redirect:machinecontrolpage.htm?&s="
				+ request.getParameter("pageStatus");
	}
	@RequestMapping("/controller/viewmachinepage")
	public String showViewPage(HttpServletRequest request) {

		
		String pid=request.getParameter("id");
		if(pid!=null && !pid.trim().equals(""))
		{
			Long id=new Long(pid);
			
				MachineDTO machineDTO=machineService.loadMachine(id);
				Long wareHouseid = machineDTO.getWarehouseId();
				System.out.println(wareHouseid);
				WarehouseDTO warehouseDTO = (WarehouseDTO)warehouseService.loadWarehouse(wareHouseid);
				request.setAttribute("machine", machineDTO);
				request.setAttribute("warehouse", warehouseDTO);
				return "controllermachineviewpage.page";
				
		}
		return "redirect:machinecontrolpage.htm";

	}
	@RequestMapping(method = RequestMethod.GET, value = "/controller/checklockstatus")
	public @ResponseBody
	String getChecklockPageStatusInJSON(@RequestParam("id")
	String id) {
		String result = null;
		
			ObjectMapper mapper = new ObjectMapper();
						
				Map<String, Object> lock = lockService.loadLock(id);
				if (lock != null) {
					try {
						Long warehouseId=(Long)lock.get("warehouseId");
						if(warehouseId!=null)
						{
							lock.putAll(warehouseService.loadWareHouse(warehouseId));
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
		
		
		

		return result;
	}
	@RequestMapping(method = RequestMethod.POST, value = "/controller/updatelockstatus")
	public String updtaelockPageStatus(HttpServletRequest request,
			HttpServletResponse response) {
		
			
				lockService.modifyLockStatus(new Long(request
						.getParameter("id")), request
						.getParameter("pageStatus"));
		

		return "redirect:lockcontrolpage.htm?&s="
				+ request.getParameter("pageStatus");
	}
	
	@RequestMapping("/controller/viewlock")
	public String showlockViewPage(HttpServletRequest request) {
		

		
		String pid=request.getParameter("id");
		if(pid!=null && !pid.trim().equals(""))
		{
			Long id=new Long(pid);
			
				LockDTO lockDTO=lockService.loadLock(id);
				Long wareHouseid = lockDTO.getWarehouseId();
				System.out.println(wareHouseid);
				WarehouseDTO warehouseDTO = (WarehouseDTO)warehouseService.loadWarehouse(wareHouseid);
				System.out.println(warehouseDTO);
				
			
				request.setAttribute("warehouse", warehouseDTO);
				request.setAttribute("lock", lockDTO);
				return "controllerlockviewpage.page";
				
		}
		return "redirect:lockcontrolpage.htm";

	}
	
	@RequestMapping(method = RequestMethod.GET,value="/controller/profile")
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
			return "controllerprofile.page";
		}
	@RequestMapping("/controller/changeprofile")
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
		return "controllerchangeProfile.page";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/controller/updatepassword")
	public String updtaeAccountStatus1(HttpServletRequest request,
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
			return "controllererror.page";
		}
			return "controllersucess.page";
		}

	@RequestMapping(method = RequestMethod.POST, value = "/controller/updateNumber")
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
			
			return "controllererror.page";
		}
			
		return "controllersucess.page";
	}

	
	
	/*@RequestMapping(method = RequestMethod.GET, value = "/mainmanager/checkaccount")
	public @ResponseBody String getCheckAccountInJSON(@RequestParam("userId") String userId)
	{
		

		Map<String, Object> userAccount = null;
		Map <String, Object> checkAccount = null;
		ObjectMapper mapper = new ObjectMapper();
		ObjectMapper mapper1 = new ObjectMapper();
		String result = null;
		String result1 = null;
		
		
		if (userId != null && !userId.trim().equals("")) {
			userAccount = customerService.loadCustomer(userId.trim());
			Long cust = (Long) userAccount.get("customerId");
			checkAccount = userRoleService.checKaccount(cust);
             String userCase = "nathik";
             System.out.println(userCase.toUpperCase());
				if (userAccount != null ) {
					
					if(checkAccount == null)
					{
						System.out.println(userAccount);
						try {
							result = mapper.writeValueAsString(userAccount);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					else {
						System.out.println("alreadyexist");
						
						try {
						result = mapper1.writeValueAsString(checkAccount);
					} catch (Exception e) {
						e.printStackTrace();
					} }
					
				}
				else {
						result = "fail";
					}
										

		}

		return result;

	}
	@RequestMapping(method = RequestMethod.POST, value = "/mainmanager/createaccount")
	public String createAccount(AccountForm accountForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		
	
		if (accountForm != null ) {
			
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
                code to check the user Role
			
			
			*//**getting of countrycode and email code start heare ***************//*
			String countryCode=accountForm.getCountryCode();
			String email=accountForm.getEmail();
			String NewString = countryCode.replace("+", "");
		    String NewRole=accountForm.getUserRole().substring(0, 2).toUpperCase();
			
			System.out.println(NewString+"NewString");
			System.out.println(accountForm.getUserRole().substring(0, 2) + "User Role ID");
			*//***********generate random userId and password******************//*
			

				int n = 3;
				Random randGen = new Random();
				int startNum = (int) Math.pow(10, n-1);
				int range = (int) (Math.pow(10, n) - startNum + 1);
    			int randomuserId = randGen.nextInt(range) + startNum;
				String userId1 = NewString +NewRole+ randomuserId;
				int randomPassword = randGen.nextInt(range) + startNum;
				String password=NewString+randomPassword;
				 code start mail ################################
	    	 	SimpleMailMessage email1 = new SimpleMailMessage();
			 	email1.setTo(email);
			 	email1.setSubject("Your userName and Password");
			 	email1.setText("userIdNo:"+userId1+"password is:"+password);
				// sends the e-mail
					mailSender.send(email1);
			 	   //send userId password to user roles table
					System.out.println(userId1+"randomuserId");
					System.out.println(password+"randomPassword");
					userRoleDTO.setUserId(userId1);
					userRoleDTO.setPassword(password);
			 	  code end mail ################################
					*//**creation of userId and password code end heare ***************//*
			
			else if(NewRole.equals("Ad"))
			{
				int n = 3;
				Random randGen = new Random();
				int startNum = (int) Math.pow(10, n-1);
				int range = (int) (Math.pow(10, n) - startNum + 1);
    			int randomuserId = randGen.nextInt(range) + startNum;
				String userId1 = NewString + "AD" + randomuserId;
				int randomPassword = randGen.nextInt(range) + startNum;
				String password=NewString+randomPassword;
				 code start mail ################################
	    	 	SimpleMailMessage email1 = new SimpleMailMessage();
			 	email1.setTo(email);
			 	email1.setSubject("Your userName and Password");
			 	email1.setText("userIdNo:"+userId1+"password is:"+password);
				// sends the e-mail
					mailSender.send(email1);
			 	   //send userId password to user roles table
					System.out.println(userId1+"randomuserId");
					System.out.println(password+"randomPassword");
					userRoleDTO.setUserId(userId1);
					userRoleDTO.setPassword(password);
			 	  code end mail ################################
					*//**creation of userId and password code end heare ***************//*
			}
		
			else if(NewRole.equals("Ac"))
			{
				int n = 3;
				Random randGen = new Random();
				int startNum = (int) Math.pow(10, n-1);
				int range = (int) (Math.pow(10, n) - startNum + 1);
    			int randomuserId = randGen.nextInt(range) + startNum;
				String userId1 = NewString + "AC" + randomuserId;
				int randomPassword = randGen.nextInt(range) + startNum;
				String password=NewString+randomPassword;
				 code start mail ################################
	    	 	SimpleMailMessage email1 = new SimpleMailMessage();
			 	email1.setTo(email);
			 	email1.setSubject("Your userName and Password");
			 	email1.setText("userIdNo:"+userId+"password is:"+password);
				// sends the e-mail
					mailSender.send(email1);
			 	   //send userId password to user roles table
					System.out.println(userId1+"randomuserId");
					System.out.println(password+"randomPassword");
					userRoleDTO.setUserId(userId1);
					userRoleDTO.setPassword(password);
			 	  code end mail ################################
					*//**creation of userId and password code end heare ***************//*
			}
		
			
			
			
				Long userRoleId=userRoleService.saveUserRole(userRoleDTO);
				if(accountForm.getUserRole().equalsIgnoreCase("Warehouse"))
				{
					accountForm.setUserRole("UserWarehouse");
				}
				if(userRoleId!=null)
				{
					
					MultipartFile multiFile = accountForm.getDoc();
	                try {
	            // just to show that we have actually received the file
	           
	            String fileName=multiFile.getOriginalFilename();
	            
	            String path=request.getSession().getServletContext().getRealPath("/");
	                    
	            //making directories for our required path.
	            byte[] bytes = multiFile.getBytes();
	            File directory=    new File(path+ "/uploads/documents/"+userRoleId);
	            directory.mkdirs();
	            // saving the file
	            File file=new File(directory.getAbsolutePath()+System.getProperty("file.separator")+fileName);
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
		

			return "redirect:createaccount.htm?u="+accountForm.getUserRole().toLowerCase()+"&s=succ";
		}
	@RequestMapping(method = RequestMethod.POST, value = "/mainmanager/createaccount")
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
		
			Long userRoleId=userRoleService.saveUserRole(userRoleDTO);
			if(accountForm.getUserRole().equalsIgnoreCase("Warehouse"))
			{
				accountForm.setUserRole("UserWarehouse");
			}
			if(userRoleId!=null)
			{
				
				MultipartFile multiFile = accountForm.getDoc();
                try {
            // just to show that we have actually received the file
           
            String fileName=multiFile.getOriginalFilename();
            
            String path=request.getSession().getServletContext().getRealPath("/");
                    
            //making directories for our required path.
            byte[] bytes = multiFile.getBytes();
            File directory=    new File(path+ "/uploads/documents/"+userRoleId);
            directory.mkdirs();
            // saving the file
            File file=new File(directory.getAbsolutePath()+System.getProperty("file.separator")+fileName);
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

		return "redirect:createaccount.htm?u="+accountForm.getUserRole().toLowerCase()+"&s=succ";
	}

	@RequestMapping("/mainmanager/controlaccount")
	public String showContollAccount() {

		return "mainmanagercontrolaccount.page";

	}

	

	

	@RequestMapping("/mainmanager/createwarehouse")
	public String showCreateWarehouse() {

		return "mainmanagercreatewarehouse.page";

	}
	
	
	@RequestMapping("/mainmanager/viewpage")
	public String showViewPage(HttpServletRequest request) {

		String page=request.getParameter("page");
		String pid=request.getParameter("id");
		if(page!=null&&pid!=null && !page.trim().equals("")&& !pid.trim().equals(""))
		{
			Long id=new Long(pid);
			if(page.equalsIgnoreCase("Warehouse Page"))
			{
				WarehouseDTO warehouseDTO=warehouseService.loadWarehouse(id);
				request.setAttribute("warehouse", warehouseDTO);
				return "mainmanagerviewwarehouse.page";
			}
			if(page.equalsIgnoreCase("Machine Page"))
			{
				MachineDTO machineDTO=machineService.loadMachine(id);
				request.setAttribute("machine", machineDTO);
				return "mainmanagerviewmachine.page";
				
			}
			if(page.equalsIgnoreCase("Lock Page"))
			{
				LockDTO lockDTO=lockService.loadLock(id);
				request.setAttribute("lock",lockDTO);
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
			warehouseDTO.setWarehouseSno(warehouseForm.getWarehouseSNO());
			warehouseDTO.setCreatedBy(1L);
			warehouseService.saveWarehouse(warehouseDTO);

		}

		return "redirect:createwarehouse.htm?s=success";
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
			if (pageName.trim().equalsIgnoreCase("Machine Page")) {
				machineService.modifyMachineStatus(new Long(request
						.getParameter("id")), request
						.getParameter("pageStatus"));
			}
			if (pageName.trim().equalsIgnoreCase("Lock Page")) {
				lockService.modifyLockStatus(new Long(request
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
		String currency="SR";
		double totalcost=344454;
		if(country!=null)
		{
			     
			if(country.equalsIgnoreCase("Saudi Arabia"))
			{
				currency="SR";
				totalcost=1239;
			}else if(country.equalsIgnoreCase("Qatar"))
			{
				currency="QAR";
				totalcost=2277;
			}
			else if(country.equalsIgnoreCase("United Arab Emirates"))
			{
				currency="AED";
				totalcost=5676;
			}
			else if(country.equalsIgnoreCase("Kuwait"))
			{
				currency="KWD";
				totalcost=2239;
			}
			else if(country.equalsIgnoreCase("Bahrain"))
			{
				currency="BHD";
				totalcost=7899;
			}
			else if(country.equalsIgnoreCase("Oman"))
			{
				currency="OMR";
				totalcost=8999;
			}
			else if(country.equalsIgnoreCase("Egypt"))
			{
				currency="EGP";
				totalcost=6554;
			}
			else if(country.equalsIgnoreCase("India"))
			{
				currency="INR";
				totalcost=23454;
			}
		}
		result="{\"totalCost\":\" "+totalcost+" \",\"currency\":\""+currency+"\"}";

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
					+ userRoleService.loadAccountCount(country, city, accountKind);
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
		Long totalCost = 0L;
		Long agencyWarehouseCount = 0L;
		warehouseCount = warehouseService.loadWarehouseCount(country, city);
		if ((country == null || country.trim().equals("") || country.trim()
				.equalsIgnoreCase("ALL"))
				&& (city == null || city.trim().equals("") || city.trim()
						.equalsIgnoreCase("ALL"))) {
			machineCount = machineService.loadMachineCount();
			lockCount = lockService.loadLockCount();
		} else {
			List<Long> warehouseIdsList = warehouseService.loadWarehouseIdList(
					country, city);
			if (warehouseIdsList != null && warehouseIdsList.size() > 0) {
				machineCount = machineService
						.loadMachineCount(warehouseIdsList);
				lockCount = lockService.loadLockCount(warehouseIdsList);

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

		Long warehouseCount = 0L;
		Long lockCount = 0L;
		Long machineCount = 0L;
		Long totalCost = 0L;
		Long agencyWarehouseCount = 0L;

		return "{\"warehouseCount\":\"" + warehouseCount
				+ "\",\"lockCount\":\"" + lockCount + "\",\"machineCount\":\""
				+ machineCount + "\",\"totalCost\":\"" + totalCost
				+ "\",\"agencyWarehouseCount\":\"" + agencyWarehouseCount
				+ "\"}";
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
		Long totalCost = 0L;
		Long agencyMachineCount = 0L;

		if ((country == null || country.trim().equals("") || country.trim()
				.equalsIgnoreCase("ALL"))
				&& (city == null || city.trim().equals("") || city.trim()
						.equalsIgnoreCase("ALL"))
				&& (machineModel == null || machineModel.trim().equals("") || machineModel
						.equalsIgnoreCase("All"))) {
			machineCount = machineService.loadMachineCount();

		} else if ((country == null || country.trim().equals("") || country
				.trim().equalsIgnoreCase("ALL"))
				&& (city == null || city.trim().equals("") || city.trim()
						.equalsIgnoreCase("ALL"))
				&& (machineModel != null && !machineModel.trim()
						.equalsIgnoreCase("ALL"))) {
			machineCount = machineService.loadMachineCount(machineModel);

		}

		else {
			List<Long> warehouseIdsList = warehouseService.loadWarehouseIdList(
					country, city);
			if (warehouseIdsList != null && warehouseIdsList.size() > 0) {
				if (machineModel != null && !machineModel.trim().equals("")
						&& !machineModel.equalsIgnoreCase("All")) {
					machineCount = machineService.loadMachineCount(
							warehouseIdsList, machineModel);
				} else {
					machineCount = machineService
							.loadMachineCount(warehouseIdsList);
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
		Long totalCost = 0L;
		Long agencyLockCount = 0L;

		if ((country == null || country.trim().equals("") || country.trim()
				.equalsIgnoreCase("ALL"))
				&& (city == null || city.trim().equals("") || city.trim()
						.equalsIgnoreCase("ALL"))
				&& (lockModel == null || lockModel.trim().equals("") || lockModel
						.equalsIgnoreCase("All"))) {
			lockCount = lockService.loadLockCount();

		} else if ((country == null || country.trim().equals("") || country
				.trim().equalsIgnoreCase("ALL"))
				&& (city == null || city.trim().equals("") || city.trim()
						.equalsIgnoreCase("ALL"))
				&& (lockModel != null && !lockModel.trim().equalsIgnoreCase(
						"ALL"))) {
			lockCount = lockService.loadLockCount(lockModel);

		}

		else {
			List<Long> warehouseIdsList = warehouseService.loadWarehouseIdList(
					country, city);
			if (warehouseIdsList != null && warehouseIdsList.size() > 0) {
				if (lockModel != null && !lockModel.trim().equals("")
						&& !lockModel.equalsIgnoreCase("All")) {
					lockCount = lockService.loadLockCount(warehouseIdsList,
							lockModel);
				} else {
					lockCount = lockService.loadLockCount(warehouseIdsList);
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
		
		List machines = new ArrayList();

		return "{\"machineCount\":\"" + machineCount + "\",\"machines\":\""
				+ machines + "\"}";
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
		
		List locks = new ArrayList();

		return "{\"lockCount\":\"" + lockCount + "\",\"locks\":\""
				+ locks + "\"}";
	}
	
*/
}
