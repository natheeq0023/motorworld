package com.moaddi.ui.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moaddi.dao.model.AgencyOrderRequestForm;
import com.moaddi.service.CustomerService;
import com.moaddi.service.LockService;
import com.moaddi.service.MachineService;
import com.moaddi.service.UserRoleService;
import com.moaddi.service.WarehouseService;
import com.moaddi.service.dto.CustomerDTO;
import com.moaddi.service.dto.LockPriceDTO;
import com.moaddi.service.dto.LockSalesDTO;
import com.moaddi.service.dto.MachinePriceDTO;
import com.moaddi.service.dto.MachineSalesDTO;
import com.moaddi.service.dto.OrderDTO;
import com.moaddi.service.dto.OrderDetailsDTO;
import com.moaddi.service.dto.UserRoleDTO;
import com.moaddi.service.dto.WarehouseDTO;
import com.moaddi.ui.forms.AgencyOrderForm;
import com.moaddi.ui.forms.SalesTransferForm;
import com.moaddi.ui.forms.WarehouseForm;
import com.moaddi.utility.HttpUtility;
import com.moaddi.utility.OTPUtility;

@Controller
public class WarehouseController {
	
	
	
	@Autowired
	private MachineService machineService;
	@Autowired
	private LockService lockService;
	
	@Autowired
	private WarehouseService warehouseService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private UserRoleService userRoleService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/warehouse/checklocksno")
	public @ResponseBody String getCheckLockInJSON(@RequestParam("lockSno")
			String lockSno) {

				
				
				
				String result = null;
				
				
				
				
				if (lockSno != null) {
					try {
						boolean isExists=lockService.isLockAvailable(lockSno.toUpperCase());
						
							
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
	@RequestMapping(method = RequestMethod.GET, value = "/warehouse/checkmachinesno")
	public @ResponseBody String getCheckMachineInJSON(@RequestParam("machineSno")
			String machineSno) {

				
				
				
				String result = null;
				
				
				
				
				if (machineSno != null) {
					try {
						boolean isExists=machineService.isMachineAvailable(machineSno.toUpperCase());
						
							
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
			
	@RequestMapping("/warehouse/signout")
	public String showSignout(HttpServletRequest response) {
		
		return "redirect:../otherlogin.htm?suMsg=Your successfully Signedout";
	}
	
	@RequestMapping("/warehouse/warehousehome")
	public String showCreateAccount(HttpServletRequest response) {

		if(response.getParameter("u")!=null)
		{
		 return "warehousehome"+response.getParameter("u").toLowerCase()+".page";
		}
		else
		{
			return "warehousehome.page";
		}

	}
	@RequestMapping("/warehouse/saleonline")
	public String showAgencyOrders(HttpServletRequest request,Model model) {
		
		String status=request.getParameter("q");
		if(status==null || status.trim().equals(""))
		{
			status="Accept";
			
		}
		List<OrderDTO> orders=machineService.loadOrders(status);
		System.out.println(orders);
		request.setAttribute("orders", orders);
		return "warehouseagencyorders.page";
	}
	@RequestMapping("/warehouse/viewagencyorder")
	public String showViewAgencyOrder(HttpServletRequest request,Model model) {
		
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
			Map<String, Object> agency=customerService.loadCustomerUserRole(order.getCreatedBy());
			System.out.println(agency+"...aggg");
			request.setAttribute("agency", agency);
			
		}
		return "warehouseviewagencyorder.page";
	}
	@RequestMapping(method = RequestMethod.POST, value = "/warehouse/viewagencyorder")
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
					machineService.saveMachineSales(machineSalesDTO);
					
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
					lockService.saveLockSales(lockSalesDTO);
					
				}
			}
			
			machineService.modifyOrder(salesTransferForm.getOrderId(), "Shifted", userRoleDTO.getUserRoleId());
			
		}
		
		return "redirect:saleonline.htm?s=success";
	}
	
	@RequestMapping("/warehouse/machinetransfer")
	public String showMachineTransfer(HttpServletRequest request,Model model) {
		
		
		return "warehousemachinetransfer.page";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/warehouse/checkmachineprice")
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
	@RequestMapping(method = RequestMethod.GET, value = "/warehouse/checkagencywarehouse")
	public @ResponseBody
	String getCheckWarehouseInJSON(@RequestParam("agencyId")
	String agencyId) {
		String result = null;
		Map<String, Object> agency=userRoleService.loadCustomer(agencyId);
		
		System.out.println(agencyId);
		System.out.println(agency);
		
		if (agency != null) {
			try {
				
					Long userRoleId=(Long)agency.get("userRoleId");
					if(userRoleId!=null)
					{
						ObjectMapper mapper = new ObjectMapper();

						List<WarehouseDTO> warehouses=warehouseService.getWarehouses(userRoleId, "Agency");
						System.out.println(warehouses+" waa");
						
						result="{\"agency\":"+mapper.writeValueAsString(agency)+",\"warehouses\":"+mapper.writeValueAsString(warehouses)+"}";
						
					}
					else
					{
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
	@RequestMapping(method = RequestMethod.POST, value = "/warehouse/machinetransfer")
	public String createOrder(AgencyOrderForm agencyOrderForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		Long orderId=null;
		if (userRoleDTO != null) {
			if(agencyOrderForm.getType()!=null)
			{
				if(agencyOrderForm.getType()!=null)
				{
					OrderDTO orderDTO=new OrderDTO();
					orderDTO.setStatus("Accept");
					orderDTO.setCreatedBy(agencyOrderForm.getUserRoleId());
					orderDTO.setWarehouseId(agencyOrderForm.getWarehouseId());
					orderDTO.setUpdatedBy(userRoleDTO.getUserRoleId());
					orderDTO.setUpdatedOn(new java.util.Date());
					orderDTO.setOrderType("offline");
					System.out.println(agencyOrderForm.getWarehouseId()+".......");
					 orderId=machineService.saveOrder(orderDTO);
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

		}

		return "redirect:viewagencyorder.htm?i="+orderId;
	}
	
	@RequestMapping("/warehouse/locktransfer")
	public String showLockTransfer(HttpServletRequest request,Model model) {
		
		
		return "warehouselocktransfer.page";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/warehouse/checklockprice")
	public @ResponseBody
	String getCheckLockPriceInJSON(@RequestParam("lockKind")
	String lockKind, @RequestParam("lockModel")
	String lockModel) {
		String result = null;

		ObjectMapper mapper = new ObjectMapper();

		LockPriceDTO lockPrice = lockService.loadLockPrice(
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
	@RequestMapping(method = RequestMethod.GET, value = "/warehouse/profile")
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
		return "warehouseprofile.page";
	}

	@RequestMapping("/warehouse/changeprofile")
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
		return "warehousechangeProfile.page";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/warehouse/updatepassword")
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
			return "warehouseerror.page";
		}
		return "warehousesucess.page";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/warehouse/updateNumber")
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

			return "warehouseerror.page";
		}

		return "warehousesucess.page";
	}
	@RequestMapping(value = "/mobileverifyWareHouse", method = RequestMethod.GET)
	public @ResponseBody String processAJAXRequest(@RequestParam("cc") String cc,
				@RequestParam("mobileNo") String mobileNo,@RequestParam("otpCode") String otpCode,HttpServletRequest response,HttpServletRequest request) {
		String otp="";
		System.out.println("Inside Mobile verify");
		if(otpCode!=null && !otpCode.trim().equals(""))
		{
			 otp=otpCode.trim();
		}
		else
		{
			otp=OTPUtility.generateOTP();
		}
			/*try {

				SendSmsUtility.init();
				String serverUrl=(String)request.getSession().getServletContext().getAttribute("serverUrl");
		    	SendSmsUtility.server = serverUrl;
		    	SendSmsUtility.user = "hussain";
		    	SendSmsUtility.password = "hussain@7299";
		    	SendSmsUtility.phonenumber = mobileNo;
		    	SendSmsUtility.text = "your Mobile verification code is "+otp;
		    	SendSmsUtility.send();
			} catch (Exception e) {
				return "fail";
			}
			*/
		String msg="your Mobile verification code is "+otp;
    	String country=cc.substring(1);
    	System.out.println(cc);
    	System.out.println(mobileNo);
    	String mobileNos=country+mobileNo;
    	String authkey="97520AuXWgP0jO56417ec4";
    	String sender="MOADDI";
    	String route="4";
    	
    	try {
    		String requestURL = "http://new.bestsmsdeal.com/app/smsapi/index.php?=&campaign=0&routeid=6&type=text&contacts="+mobileNos+"&senderid="+sender+"&msg="+URLEncoder.encode(msg, "UTF-8");
            if(!cc.equalsIgnoreCase("+91")) 
            {
            	requestURL="http://sms.bestsmsdeal.in/api/sendhttp.php?authkey="+authkey+"&mobiles="+mobileNos+"&message="+URLEncoder.encode(msg, "UTF-8")+"&sender="+sender+"&route="+route+"&country="+country;
            }
           
            HttpUtility.sendGetRequest(requestURL);
            String[] responseMsg = HttpUtility.readMultipleLinesRespone();
            
            for (String line : responseMsg) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (Exception e) {
			e.printStackTrace();
		}
        finally
        {
        	HttpUtility.disconnect();
        }
			
			return otp;
		}
}
