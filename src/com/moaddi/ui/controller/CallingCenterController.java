package com.moaddi.ui.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moaddi.service.CustomerService;
import com.moaddi.service.LockService;
import com.moaddi.service.MachineService;
import com.moaddi.service.UserRoleService;
import com.moaddi.service.WarehouseService;
import com.moaddi.service.dto.CustomerDTO;
import com.moaddi.service.dto.MachineDTO;
import com.moaddi.service.dto.UserRoleDTO;


@Controller
public class CallingCenterController {
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private WarehouseService warehouseService;
	
	@Autowired
	private MachineService machineService;
	
	@Autowired
	private LockService lockService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/callingcenter/signout")
	public String showSignout(HttpServletRequest response) {
		
		return "redirect:../otherlogin.htm?suMsg=Your successfully Signedout";
	}

	@RequestMapping("/callingcenter/callingcenterhome")
	public String showCreateAccount(HttpServletRequest response) {

		if(response.getParameter("u")!=null)
		{
		 return "callingcenterhome"+response.getParameter("u").toLowerCase()+".page";
		}
		else
		{
			return "callingcenterhome.page";
		}

	}
	
	
	@RequestMapping("/callingcenter/viewaccount")
	public String showViewAccount() {
		
		return "callingcenterviewaccounts.page";
		
	}
	@RequestMapping("/callingcenter/viewmachine")
	public String showViewMachine() {
		
		return "callingcenterviewmachine.page";
		
	}
	@RequestMapping("/callingcenter/viewlock")
	public String showViewLock() {
		
		return "callingcenterviewlock.page";
		
	}
	@RequestMapping("/callingcenter/viewwarehouse")
	public String showViewWarehouse() {
		
		return "callingcenterviewwarehouse.page";
		
	}
	
	
	
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/callingcenter/checkaccountstatus")
	public @ResponseBody
	String getCheckAccountStatusInJSON(@RequestParam("userId")
	String userId, @RequestParam("accountKind")
	String accountKind, @RequestParam("accountName")
	String accountName,HttpServletRequest request) {
		System.out.println("controller in support chech account");
        
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
	
	@RequestMapping(method = RequestMethod.GET, value = "/callingcenter/checkmachine")
	public @ResponseBody
	String getCheckMachineInJSON(@RequestParam("id")
	String id) {
		String result = null;
		
			ObjectMapper mapper = new ObjectMapper();
			
				Map<String, Object> machine = machineService.loadMachine(id);
				if (machine != null) {
					try {
						Long warehouseId=(Long)machine.get("warehouseId");
						if(warehouseId!=null)
						{  System.out.println("in calling center control machine");
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

	/*@RequestMapping(method = RequestMethod.GET, value = "/callingcenter/checklock")
	public @ResponseBody
	String getCheckLockInJSON(@RequestParam("id")
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
	}*/
	

	@RequestMapping(method = RequestMethod.GET, value = "/callingcenter/checklock")
	public @ResponseBody
	String getCheckLockInJSON(@RequestParam("id")
	String id) {
		String result = null;
		
			ObjectMapper mapper = new ObjectMapper();
			
			Map<String, Object> lock = lockService.loadLock(id);
			
			Long lockId = (Long)lock.get("id");
			Long warehouseId=(Long)lock.get("warehouseId");
			
			
			Map<String, Object> locksales  = lockService.loadLockIdSales(lockId);
			if(locksales !=null)
			{
				Long orderid = (Long)locksales.get("orderId");
                
			
				
				
				Map<String, Object> lockWarehouse  = lockService.loadLockIdWarehouse(orderid);
				System.out.println(lockWarehouse+"Lock lockWarehouse");
				  String lockstatus = (String)lockWarehouse.get("status");
				
				  System.out.println(lockstatus);
					try {
						Long warehouseId1=(Long)lockWarehouse.get("warehouseId");
						if(warehouseId1!=null)
						{
							lock.putAll(warehouseService.loadWareHouse(warehouseId1));
							
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
				}
			
			else {
				try {
					
					/*Long warehouseId1=(Long)lock.get("warehouseId");*/
					if(warehouseId!=null)
					{
						lock.putAll(warehouseService.loadWareHouse(warehouseId));
						System.out.println(lock);
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
		}
			
			

		return result;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/callingcenter/checkwarehouse")
	public @ResponseBody
	String getCheckWarehouseInJSON(@RequestParam("id")
	String id) {
		String result = null;
		
			ObjectMapper mapper = new ObjectMapper();
			
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
		return result;
	}
	@RequestMapping(method = RequestMethod.GET,value="/callingcenter/profile")
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
			return "callcenterprofile.page";
		}
	@RequestMapping("/callingcenter/changeprofile")
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
		return "callcenterchangeProfile.page";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/callingcenter/updatepassword")
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
			return "callcentererror.page";
		}
			return "callcentersucess.page";
		}

	@RequestMapping(method = RequestMethod.POST, value = "/callingcenter/updateNumber")
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
			
			return "callcentererror.page";
		}
			
		return "callcentersucess.page";
	}

	
}
