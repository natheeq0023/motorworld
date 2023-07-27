package com.moaddi.ui.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import com.moaddi.service.CustomerService;
import com.moaddi.service.ItemService;
import com.moaddi.service.LockService;
import com.moaddi.service.MachineService;
import com.moaddi.service.UserRoleService;
import com.moaddi.service.dto.AccountsPercentageDTO;
import com.moaddi.service.dto.CustomerDTO;
import com.moaddi.service.dto.ItemsPercentageDTO;
import com.moaddi.service.dto.LockPriceDTO;
import com.moaddi.service.dto.MachinePriceDTO;
import com.moaddi.service.dto.OperatorPartnerDetailsDTO;
import com.moaddi.service.dto.OrderDetailsDTO;
import com.moaddi.service.dto.UserRoleDTO;
import com.moaddi.ui.forms.AccountsPercentageForm;
import com.moaddi.ui.forms.ItemsPercentageForm;
import com.moaddi.ui.forms.LockPriceForm;
import com.moaddi.ui.forms.MachinePriceForm;
import com.moaddi.ui.forms.OperatorPartnerForm;

@Controller
public class AccountingController {
	@Autowired
	private MachineService machineService;
	@Autowired
	private LockService lockService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping("/accounting/accountinghome")
	public String showCreateAccount(HttpServletRequest response) {

		if(response.getParameter("u")!=null)
		{
		 return "accountinghome"+response.getParameter("u").toLowerCase()+".page";
		}
		else
		{
			return "accountinghome.page";
		}

	}
	
	
	@RequestMapping("/accounting/createmachineprice")
	public String showCreateMachinePrice() {

		return "accountingcreatemachineprice.page";

	}
	/*
	@RequestMapping(method = RequestMethod.GET, value = "/accounting/checkmachineprice")
	public @ResponseBody
	String getCheckMachineInJSON(@RequestParam("machineSno")
	String machineSno) {

		
		String result = "";
		if(machineSno!=null && !machineSno.trim().equalsIgnoreCase(""))
		{
			Long machineId=machineService.loadMachineId(machineSno);
			if(machineId!=null && machineId>0L)
			{
				
				List<MachinePriceDTO> prices=machineService.loadMachinePrices(machineId);
				if(prices!=null && prices.size()>0)
				{
				  try {
					String pricesAsString=new ObjectMapper().writeValueAsString(prices);
					result="{\"machineId\":\""+machineId+"\",\"prices\":"+pricesAsString+"}";
				} catch (JsonGenerationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				  
				}
				else
				{
					result="{\"machineId\":\""+machineId+"\"}";
				}
			}
		}
		System.out.println(result);
		
		return result;

	}
	*/
	
	@RequestMapping(method = RequestMethod.POST, value = "/accounting/createmachineprice")
	public String createMachinePrice(MachinePriceForm machinePriceForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		if(machinePriceForm!=null)
		{
			MachinePriceDTO machinePriceDTO=new MachinePriceDTO();
			machinePriceDTO.setDiscount(machinePriceForm.getDiscount());
			machinePriceDTO.setMachineKind(machinePriceForm.getMachineKind());
			machinePriceDTO.setMachineModel(machinePriceForm.getMachineModel());
			machinePriceDTO.setPrice(machinePriceForm.getPrice());
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			
			try {
				
				machinePriceDTO.setFromDate(sdf.parse(machinePriceForm.getStartDate()));
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			try {
				machinePriceDTO.setToDate(sdf.parse(machinePriceForm.getEndDate()));
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			machineService.saveMachinePrice(machinePriceDTO);
			
		}
		return "redirect:createmachineprice.htm?s=success";
		
	}
	@RequestMapping("/accounting/createlockprice")
	public String showCreateLockPrice() {
		

		return "accountingcreatelockprice.page";

	}
	/*
	@RequestMapping(method = RequestMethod.GET, value = "/accounting/checklockprice")
	public @ResponseBody
	String getCheckLockInJSON(@RequestParam("lockSno")
	String lockSno) {

		
		String result = "";
		if(lockSno!=null && !lockSno.trim().equalsIgnoreCase(""))
		{
			Long lockId=lockService.loadLockId(lockSno);
			
			if(lockId!=null && lockId>0L)
			{
				
				List<LockPriceDTO> prices=lockService.loadLockPrices(lockId);
				if(prices!=null && prices.size()>0)
				{
				  try {
					String pricesAsString=new ObjectMapper().writeValueAsString(prices);
					result="{\"lockId\":\""+lockId+"\",\"prices\":"+pricesAsString+"}";
				} catch (JsonGenerationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				  
				}
				else
				{
					result="{\"lockId\":\""+lockId+"\"}";
				}
			}
		}
		System.out.println(result);
		
		return result;

	}
	*/
	@RequestMapping(method = RequestMethod.POST, value = "/accounting/createlockprice")
	public String createLockPrice(LockPriceForm lockPriceForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		if(lockPriceForm!=null)
		{
			LockPriceDTO lockPriceDTO=new LockPriceDTO();
			lockPriceDTO.setDiscount(lockPriceForm.getDiscount());
			lockPriceDTO.setLockKind(lockPriceForm.getLockKind());
			lockPriceDTO.setLockModel(lockPriceForm.getLockModel());
			lockPriceDTO.setPrice(lockPriceForm.getPrice());
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			try {
				lockPriceDTO.setFromDate(sdf.parse(lockPriceForm.getStartDate()));
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			try {
				lockPriceDTO.setToDate(sdf.parse(lockPriceForm.getEndDate()));
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			lockService.saveLockPrice(lockPriceDTO);
			
		}
		return "redirect:createlockprice.htm?s=success";
		
	}
	@RequestMapping("/accounting/accountspercentage")
	public String showAccountsPercentage() {

		return "accountingaccountspercentage.page";

	}
	@RequestMapping(method = RequestMethod.POST, value = "/accounting/accountspercentage")
	public String accountsPercentage(AccountsPercentageForm accountsPercentageForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		if(accountsPercentageForm!=null)
		{
			AccountsPercentageDTO accountsPercentageDTO=new AccountsPercentageDTO();
			accountsPercentageDTO.setAccountKind(accountsPercentageForm.getAccountKind());
			accountsPercentageDTO.setAccountPercentage(accountsPercentageForm.getAccountPercentage());
			accountsPercentageDTO.setCity(accountsPercentageForm.getCity());
			accountsPercentageDTO.setCountry(accountsPercentageForm.getCountry());
			accountsPercentageDTO.setCreatedBy(accountsPercentageForm.getCreatedBy());
			
			accountsPercentageDTO.setUserId(accountsPercentageForm.getUserId());
			customerService.saveAccountsPercentage(accountsPercentageDTO);
			
			
		}
		return "redirect:accountspercentage.htm?s=success";
	}
		
	@RequestMapping("/accounting/itemspercentage")
	public String showItemsPercentage() {

		return "accountingitemspercentage.page";

	}
	@RequestMapping(method = RequestMethod.POST, value = "/accounting/itemspercentage")
	public String itemsPercentage(ItemsPercentageForm itemsPercentageForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		if(itemsPercentageForm!=null)
		{
			
			ItemsPercentageDTO itemsPercentageDTO=new ItemsPercentageDTO();
			itemsPercentageDTO.setCity(itemsPercentageForm.getCity());
			itemsPercentageDTO.setCountry(itemsPercentageForm.getCountry());
			//itemsPercentageDTO.setCreatedBy(itemsPercentageForm.getCreatedBy());
			itemsPercentageDTO.setItemBarcode(itemsPercentageForm.getItemBarcode());
			itemsPercentageDTO.setItemPercentage(itemsPercentageForm.getItemPercentage());
			itemService.saveItemsPercentage(itemsPercentageDTO);
			
			
		}
		return "redirect:itemspercentage.htm?s=success";
	}
		
	

	@RequestMapping("/accounting/useraccounts")
	public String showUserAccounts() {

		return "accountinguseraccounts.page";

	}
	
	@RequestMapping("/accounting/machinessaleshistory")
	public String showMachinesSalesHistory(HttpServletRequest request) {

		 
		return "accountingmachinessaleshistory.page";

	}
	@RequestMapping("/accounting/lockssaleshistory")
	public String showLocksSalesHistory() {

		return "accountinglockssaleshistory.page";

	}
	@RequestMapping("/accounting/itemssaleshistory")
	public String showItemsSalesHistory() {

		return "accountingitemssaleshistory.page";

	}
	@RequestMapping("/accounting/signout")
	public String showSignout(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			session.invalidate();
		}
		return "redirect:../otherlogin.htm?suMsg=Your successfully Signedout";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/accounting/checkaccountstatus")
	public @ResponseBody
	String getCheckAccountStatusInJSON(@RequestParam("userId")
	String userId, @RequestParam("accountKind")
	String accountKind, @RequestParam("accountName")
	String accountName,HttpServletRequest request) {
		System.out.println("controller in accounting chech account");
        
		Map<String, Object> userAccount = null;
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		Long customerId=0L;
		if (userId != null && !userId.trim().equals("") && accountKind != null
				&& !accountKind.trim().equals("") && accountName != null
				&& !accountName.trim().equals("")) {
			/*userAccount = customerService.loadCustomer(userId.trim());*/
			userAccount = userRoleService.loadUser(userId.trim());
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
	@RequestMapping(method = RequestMethod.GET,value="/accounting/profile")
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
			return "accountingprofile.page";
		}
	@RequestMapping("/accounting/changeprofile")
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
		return "accountchangeProfile.page";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/accounting/updatepassword")
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
			return "accounterror.page";
		}
			return "accountsucess.page";
		}

	@RequestMapping(method = RequestMethod.POST, value = "/accounting/updateNumber")
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
			
			return "accounterror.page";
		}
			
		return "accountsucess.page";
	}


	@RequestMapping(method = RequestMethod.GET, value = "/accounting/checkagencydetails")
	public @ResponseBody
	String getCheckAgencyDetailsJSON(@RequestParam("country")
	String country, @RequestParam("city")
	String city) {
		String result = null;
		System.out.println("ajjj");

		ObjectMapper mapper = new ObjectMapper();

		List<Map<String,Object>> users = userRoleService.loadUsers("Agency", country, city);
		System.out.println(users);
		if (users != null) {
			try {

				result = mapper.writeValueAsString(users);
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

	@RequestMapping(method = RequestMethod.GET, value = "/accounting/checksaleshostory")
	public @ResponseBody
	String getCheckSalesDetails(@RequestParam("country")
	String country, @RequestParam("city")
	String city,@RequestParam("userRoleId") String userRoleId,@RequestParam("model") String model,@RequestParam("orderFor")
	String orderFor) {
		String result = null;
		Long uid=null;
		
		if(userRoleId!=null && !userRoleId.trim().equals("") && !userRoleId.trim().equalsIgnoreCase("All"))
		{
			try {
				uid=new Long(userRoleId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ObjectMapper mapper = new ObjectMapper();

		List<OrderDetailsDTO> sales = machineService.loadOrders("Shifted", orderFor, model, city, country, uid);
		if (sales != null) {
			try {

				result = mapper.writeValueAsString(sales);
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

  /*Code For Operator*/
	@RequestMapping("/accounting/partnerpercentage")
	public String showViewPartnerPercentage(HttpServletRequest request) {
				System.out.println("Inside Operator Partner");
			String status=null;
			if(status==null || status.trim().equals(""))
			{
				status="Pending";
				
			}
		//	List<Map<String, Object>> agencies=customerService.loadAgency(status);
			List<Map<String, Object>> operator=customerService.loadOpearatorPartner(status);
			System.out.println(operator);
			request.setAttribute("agreements", operator);
			

		return "accountingpartnerpercentage.page";

	}
	@RequestMapping("/accounting/viewagreement")
	public String showViewAgency(HttpServletRequest request,Model model) {
		
		String id=request.getParameter("i");
		Long requestId=new Long(id);
		
		if(requestId!=null)
		{
			OperatorPartnerDetailsDTO operatorPartnerDetailsDTO=customerService.loadOperatorpartnerRequests(requestId);
			
			if(operatorPartnerDetailsDTO!=null)
			{
				CustomerDTO customerDTO=customerService.loadCustomer(operatorPartnerDetailsDTO.getCustomerId());
				request.setAttribute("customer", customerDTO);
				request.setAttribute("operator", operatorPartnerDetailsDTO);
				
				
			}
			
		}
		return "accountingviewagreement.page";
	}
	@RequestMapping(method = RequestMethod.POST, value = "/accounting/viewagreement")
	public String agencyStatus(OperatorPartnerForm operatorPartnerForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		OperatorPartnerDetailsDTO operatorPartnerDetailsDTO=new OperatorPartnerDetailsDTO();
		String customerid1 = operatorPartnerForm.getCustomerId();
		Long customerid2 = new Long(customerid1);
		operatorPartnerDetailsDTO.setCustomerId(customerid2);
		System.out.println(operatorPartnerDetailsDTO.getCustomerId());
		CustomerDTO customerDTO=customerService.loadCustomer(operatorPartnerDetailsDTO.getCustomerId());
		System.out.println(customerDTO);
	//	agencyRequestDTO.setComment(agencyRequestForm.getComment());
		operatorPartnerDetailsDTO.setContractId(operatorPartnerForm.getContractId());
		UserRoleDTO userRoleDTO=new UserRoleDTO();
		userRoleDTO.setAccountKind("Other Account");
		userRoleDTO.setStatus("Active");
		userRoleDTO.setCreatedBy(1L);
	    
	    userRoleDTO.setCity(customerDTO.getCity());
		userRoleDTO.setCountry(customerDTO.getCountry());
		userRoleDTO.setFullName(customerDTO.getFullName());
		String customerId = operatorPartnerForm.getCustomerId();
		long cust = new Long(customerId);
		userRoleDTO.setCustomerId(cust);
		userRoleDTO.setUserRole("Partner");
		/**agency Id creation *************************/
		/**getting of countrycode and email code start heare ***************/
		String countryCode=customerDTO.getCountryCode();
	    String NewString = countryCode.replace("+", "");
		String NewRole="PA";
		/***********generate random userId and password******************/
		if(operatorPartnerForm.getStatus().equals("Agree"))
		{
		int n = 3;
		Random randGen = new Random();
		int startNum = (int) Math.pow(10, n-1);
		int range = (int) (Math.pow(10, n) - startNum + 1);
		int randomuserId = randGen.nextInt(range) + startNum;
		String userId=NewString+NewRole+randomuserId;
		int randomPassword = randGen.nextInt(range) + startNum;
		String password=NewString+randomPassword;
		
		 /*code start mail ################################*/
		String email=customerDTO.getEmail();
		SimpleMailMessage email1 = new SimpleMailMessage();
	 	email1.setTo(email);
	 	email1.setSubject("YouruserName and Password");
	 	email1.setText("userIdNo:"+userId+"   "+"password is:"+password);
		// sends the e-mail
		mailSender.send(email1);
	 	   //send userId password to user roles table
			/*  code end mail ################################*/
		userRoleDTO.setUserId(userId);
		userRoleDTO.setPassword(password);
		Long userRoleId = userRoleService.saveUserRole(userRoleDTO);
	    }
		else if(operatorPartnerForm.getStatus().equals("Cancel"))
		{
			 /*code start mail ################################*/
			String email=customerDTO.getEmail();
			SimpleMailMessage email1 = new SimpleMailMessage();
		 	email1.setTo(email);
		 	email1.setSubject("Your Partner Request IS Rejected");
		 	email1.setText("BecauseOfThisReason: Not proper Documents");
			// sends the e-mail
			mailSender.send(email1);
			/*  code end mail ################################*/
		}
	 	
		
		 
		/**creation of userId and password code end heare ***************/
		
		/**agency Id end *************************/
		operatorPartnerDetailsDTO.setStatus(operatorPartnerForm.getStatus());
		String status = operatorPartnerForm.getStatus();
		System.out.println(status);
		String userroleid=request.getParameter("customerId");
		//String userroleid= operatorPartnerForm.getUserRoleId();
		System.out.println(userroleid);
		/*int len = userroleid.length();
		String str1=userroleid.substring(0,len);
	    System.out.println(str1);
	    */
		System.out.println(userroleid);
		Long userRoleid = new Long(userroleid);
		System.out.println(userRoleid);
		operatorPartnerDetailsDTO.setOperatorPartnerId(operatorPartnerForm.getOperatorPartnerId());
		customerService.modifyoperatorpartnerRequests(userRoleid,status);
		
		return "redirect:partnerpercentage.htm?st="
		+ operatorPartnerDetailsDTO.getStatus() + "&s=success";
			
		}
	
}
