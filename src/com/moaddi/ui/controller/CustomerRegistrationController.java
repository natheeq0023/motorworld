package com.moaddi.ui.controller;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moaddi.service.CustomerService;
import com.moaddi.service.UserRoleService;
import com.moaddi.service.dto.CustomerDTO;
import com.moaddi.service.dto.UserRoleDTO;
import com.moaddi.ui.forms.AccountForm;
import com.moaddi.ui.forms.LoginForm;
import com.moaddi.utility.HttpUtility;
import com.moaddi.utility.OTPUtility;
import com.moaddi.utility.SendSmsUtility;


@Controller
public class CustomerRegistrationController  {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private UserRoleService userRoleService;
	@RequestMapping("/login")
	public String login() {
		
		
		return "login.page";
		
		
	}
	@RequestMapping("/changeserver")
	public String changeServer() {
		
		
		return "changeserver.page";
		
		
	}
	@RequestMapping(method = RequestMethod.POST, value = "/changeserver")
	public String changeServer(HttpServletRequest request) {
		String server=request.getParameter("serverUrl");
		request.getSession().getServletContext().setAttribute("serverUrl", server);
		return "redirect:changeserver.htm?msg=Sucessfully chnaged";
		
	}
	@RequestMapping("/otherlogin")
	public String otherLogin() {
		
		
		return "otherlogin.page";
		
		
	}
	@RequestMapping(method = RequestMethod.POST, value = "/otherlogin")
	public String createAccount(LoginForm loginForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		String result="redirect:otherlogin.htm";
		String errMsg="?errMsg=";
		if(loginForm!=null)
		{
			
			UserRoleDTO userRoleDTO=userRoleService.loadUser(loginForm.getUserId(), loginForm.getPassword());
			
			if(userRoleDTO!=null&& userRoleDTO.getCustomerId()!=null)
			{
				CustomerDTO customerDTO=customerService.loadCustomer(userRoleDTO.getCustomerId());
				System.out.println(customerDTO+"cus..");
				if(customerDTO!=null)
				{
					System.out.println(userRoleDTO.getUserRole()+"customerId in databasesss");
					HttpSession session=request.getSession();
					
					if(userRoleDTO.getUserRole()!=null && userRoleDTO.getUserRole().equalsIgnoreCase("MainManager") && loginForm.getAccountName().equalsIgnoreCase("MainManager"))
					{System.out.println("MainManager if");
						
						if(userRoleDTO.getStatus()!=null && userRoleDTO.getStatus().equalsIgnoreCase("Active"))
						{
							String email=customerDTO.getEmail();
							/*String subEmail=email.substring(0,email.indexOf('@'));*/
							String subEmail=email.replace("@gmail.com", "");
							customerDTO.setEmail(subEmail);
							
							session.setAttribute("authUser", customerDTO);
							session.setAttribute("userRole", userRoleDTO);
							result="redirect:mainmanager/createaccount.htm";
						}
						else
						{
							errMsg=errMsg+"Your account status is not Active. ..";
							result=result+errMsg;
						}
					}
				
					else  if(userRoleDTO.getUserRole()!=null && userRoleDTO.getUserRole().equalsIgnoreCase("Manager") && loginForm.getAccountName().equalsIgnoreCase("Manager"))
					{
						System.out.println("Manager if");
						
						if(userRoleDTO.getStatus()!=null && userRoleDTO.getStatus().equalsIgnoreCase("Active"))
						{
							String email=customerDTO.getEmail();
							String subEmail=email.replace("@gmail.com", "");
							customerDTO.setEmail(subEmail);
							session.setAttribute("authUser", customerDTO);
							session.setAttribute("userRole", userRoleDTO);
							result="redirect:manager/createaccount.htm";
						}
						else
						{
							errMsg=errMsg+"Your account status is not Active. ..";
							result=result+errMsg;
						}
					}
					else  if(userRoleDTO.getUserRole()!=null && userRoleDTO.getUserRole().equalsIgnoreCase("Administration") && loginForm.getAccountName().equalsIgnoreCase("Administration"))
					{
						System.out.println("Administration if");
						
						if(userRoleDTO.getStatus()!=null && userRoleDTO.getStatus().equalsIgnoreCase("Active"))
						{
							String email=customerDTO.getEmail();
							String subEmail=email.replace("@gmail.com", "");
							customerDTO.setEmail(subEmail);
							session.setAttribute("authUser", customerDTO);
							session.setAttribute("userRole", userRoleDTO);
							result="redirect:admin/adminhome.htm";
						}
						else
						{
							errMsg=errMsg+"Your account status is not Active. ..";
							result=result+errMsg;
						}
					}
					else  if(userRoleDTO.getUserRole()!=null && userRoleDTO.getUserRole().equalsIgnoreCase("Accounting") && loginForm.getAccountName().equalsIgnoreCase("Accounting"))
					{
						System.out.println("Accounting if");
						
						if(userRoleDTO.getStatus()!=null && userRoleDTO.getStatus().equalsIgnoreCase("Active"))
						{
							String email=customerDTO.getEmail();
							String subEmail=email.replace("@gmail.com", "");
							customerDTO.setEmail(subEmail);
							session.setAttribute("authUser", customerDTO);
							session.setAttribute("userRole", userRoleDTO);
							result="redirect:accounting/accountinghome.htm";
						}
						else
						{
							errMsg=errMsg+"Your account status is not Active. ..";
							result=result+errMsg;
						}
					}
					
					else  if(userRoleDTO.getUserRole()!=null && userRoleDTO.getUserRole().equalsIgnoreCase("Support") && loginForm.getAccountName().equalsIgnoreCase("Support"))
					{System.out.println("loginForm.getAccountName()");System.out.println("Support if");
						System.out.println("Support if");
						
						if(userRoleDTO.getStatus()!=null && userRoleDTO.getStatus().equalsIgnoreCase("Active"))
						{
							String email=customerDTO.getEmail();
							String subEmail=email.replace("@gmail.com", "");
							customerDTO.setEmail(subEmail);
							session.setAttribute("authUser", customerDTO);
							session.setAttribute("userRole", userRoleDTO);
							result="redirect:support/supporthome.htm";
						}
						else
						{
							errMsg=errMsg+"Your account status is not Active. ..";
							result=result+errMsg;
						}
					}
					else  if(userRoleDTO.getUserRole()!=null && userRoleDTO.getUserRole().equalsIgnoreCase("Calling Centre") && loginForm.getAccountName().equalsIgnoreCase("Calling Centre"))
					{System.out.println("loginForm.getAccountName()");System.out.println("Calling Centre if");
					System.out.println("Calling Centre if");
					
					if(userRoleDTO.getStatus()!=null && userRoleDTO.getStatus().equalsIgnoreCase("Active"))
					{
						String email=customerDTO.getEmail();
						String subEmail=email.replace("@gmail.com", "");
						customerDTO.setEmail(subEmail);
						session.setAttribute("authUser", customerDTO);
						session.setAttribute("userRole", userRoleDTO);
						result="redirect:callingcenter/callingcenterhome.htm";
					}
					else
					{
						errMsg=errMsg+"Your account status is not Active. ..";
						result=result+errMsg;
					}
				}
					else  if(userRoleDTO.getUserRole()!=null && userRoleDTO.getUserRole().equalsIgnoreCase("Accounting") && loginForm.getAccountName().equalsIgnoreCase("Accounting"))
					{System.out.println("loginForm.getAccountName()");System.out.println("Accounting if");
					System.out.println("Accounting if");
					
					if(userRoleDTO.getStatus()!=null && userRoleDTO.getStatus().equalsIgnoreCase("Active"))
					{
						String email=customerDTO.getEmail();
						String subEmail=email.replace("@gmail.com", "");
						customerDTO.setEmail(subEmail);
						session.setAttribute("authUser", customerDTO);
						session.setAttribute("userRole", userRoleDTO);
						result="redirect:accounting/accountinghome.htm";
					}
					else
					{
						errMsg=errMsg+"Your account status is not Active. ..";
						result=result+errMsg;
					}
				}
					else if(userRoleDTO.getUserRole()!=null && userRoleDTO.getUserRole().equalsIgnoreCase("Controller")&& loginForm.getAccountName().equalsIgnoreCase("Controller"))
					{
						System.out.println("In Controller ");
						if(userRoleDTO.getStatus()!=null && userRoleDTO.getStatus().equalsIgnoreCase("Active"))
						{
							session.setAttribute("authUser", customerDTO);
							session.setAttribute("userRole",userRoleDTO);
							result = "redirect:controller/createaccount.htm";
						}
						else
						{
							errMsg = errMsg + "Your Account Status is Not Active";
							result = result + errMsg;
						}
					}
					else if(userRoleDTO.getUserRole()!=null && userRoleDTO.getUserRole().equalsIgnoreCase("Warehouse") && loginForm.getAccountName().equalsIgnoreCase("Warehouse"))
					{System.out.println("Warehouse if");
						
						if(userRoleDTO.getStatus()!=null && userRoleDTO.getStatus().equalsIgnoreCase("Active"))
						{
							String email=customerDTO.getEmail();
							String subEmail=email.replace("@gmail.com", "");
							customerDTO.setEmail(subEmail);
							
							session.setAttribute("authUser", customerDTO);
							session.setAttribute("userRole", userRoleDTO);
							result="redirect:warehouse/warehousehome.htm";
						}
						else
						{
							errMsg=errMsg+"Your account status is not Active. ..";
							result=result+errMsg;
						}
					}
			/****************************otheraccounts start***********************************/
					else if(userRoleDTO.getUserRole()!=null && userRoleDTO.getUserRole().equalsIgnoreCase("Agency") && loginForm.getAccountName().equalsIgnoreCase("Agency"))
					{   System.out.println("Agency if");
						
						if(userRoleDTO.getStatus()!=null && userRoleDTO.getStatus().equalsIgnoreCase("Active"))
						{
							String email=customerDTO.getEmail();
							String subEmail=email.replace("@gmail.com", "");
							customerDTO.setEmail(subEmail);
							
							session.setAttribute("authUser", customerDTO);
							session.setAttribute("userRole", userRoleDTO);
							result="redirect:agency/agencyhome.htm";
						}
						else
						{
							errMsg=errMsg+"Your account status is not Active. ..";
							result=result+errMsg;
						}
					}
					else if(userRoleDTO.getUserRole()!=null && userRoleDTO.getUserRole().equalsIgnoreCase("SalesMan") && loginForm.getAccountName().equalsIgnoreCase("SalesMan"))
					{   System.out.println("SalesMan if");
						
						if(userRoleDTO.getStatus()!=null && userRoleDTO.getStatus().equalsIgnoreCase("Active"))
						{
							String email=customerDTO.getEmail();
							String subEmail=email.replace("@gmail.com", "");
							customerDTO.setEmail(subEmail);
							
							session.setAttribute("authUser", customerDTO);
							session.setAttribute("userRole", userRoleDTO);
							result="redirect:salesman/salesmanhome.htm";
						}
						else
						{
							errMsg=errMsg+"Your account status is not Active. ..";
							result=result+errMsg;
						}
					}
					else if(userRoleDTO.getUserRole()!=null && userRoleDTO.getUserRole().equalsIgnoreCase("Operator") && loginForm.getAccountName().equalsIgnoreCase("Operator"))
					{   System.out.println("Operator if");
						
						if(userRoleDTO.getStatus()!=null && userRoleDTO.getStatus().equalsIgnoreCase("Active"))
						{
							String email=customerDTO.getEmail();
							String subEmail=email.replace("@gmail.com", "");
							customerDTO.setEmail(subEmail);
							
							session.setAttribute("authUser", customerDTO);
							session.setAttribute("userRole", userRoleDTO);
							result="redirect:operator/operatorhome.htm";
						}
						else
						{
							errMsg=errMsg+"Your account status is not Active. ..";
							result=result+errMsg;
						}
					}
					else if(userRoleDTO.getUserRole()!=null && userRoleDTO.getUserRole().equalsIgnoreCase("Supplier") && loginForm.getAccountName().equalsIgnoreCase("Supplier"))
					{   System.out.println("Operator if");
						
						if(userRoleDTO.getStatus()!=null && userRoleDTO.getStatus().equalsIgnoreCase("Active"))
						{
							String email=customerDTO.getEmail();
							String subEmail=email.replace("@gmail.com", "");
							customerDTO.setEmail(subEmail);
							
							session.setAttribute("authUser", customerDTO);
							session.setAttribute("userRole", userRoleDTO);
							result="redirect:supplier/supplierhome.htm";
						}
						else
						{
							errMsg=errMsg+"Your account status is not Active. ..";
							result=result+errMsg;
						}
					}
					else if(userRoleDTO.getUserRole()!=null && userRoleDTO.getUserRole().equalsIgnoreCase("Partner") && loginForm.getAccountName().equalsIgnoreCase("Partner"))
					{   System.out.println("Partner if");
						
						if(userRoleDTO.getStatus()!=null && userRoleDTO.getStatus().equalsIgnoreCase("Active"))
						{
							String email=customerDTO.getEmail();
							String subEmail=email.replace("@gmail.com", "");
							customerDTO.setEmail(subEmail);
							
							session.setAttribute("authUser", customerDTO);
							session.setAttribute("userRole", userRoleDTO);
							result="redirect:partner/partnerhome.htm";
						}
						else
						{
							errMsg=errMsg+"Your account status is not Active. ..";
							result=result+errMsg;
						}
					}
					
					
					else
					{
						errMsg=errMsg+"Unauthorised User..";
						result=result+errMsg;
					}
				}
				
				else
				{
					errMsg=errMsg+"Unauthorised User..";
					result=result+errMsg;
				}
				
			}
			else
			{
				errMsg=errMsg+"In valid Username/Password..";
				result=result+errMsg;
			}
			
		}
		return result;
	}
	
	
	@RequestMapping("/showreg")
	public String showReg() {
		
		return "showreg.page";
		
		
	}
	

	@RequestMapping("/showgolden")
	public String showGolden() {
		
		return "showgolden.page";
		
		
	}
	@RequestMapping("/goldensuccess")
	public String showGoldenSuccess() {
		
		return "showgoldensuccess.page";
		
		
	}
	@RequestMapping("/basicsuccess")
	public String showNormalSuccess() {
		
		return "showbasicsuccess.page";
		
		
	}
	
	@RequestMapping(value = "/mobileverify", method = RequestMethod.GET)
	public @ResponseBody String processAJAXRequest(@RequestParam("cc") String cc,
				@RequestParam("mobileNo") String mobileNo,@RequestParam("otpCode") String otpCode,HttpServletRequest response,HttpServletRequest request) {
		String otp="";
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
    	
    	/*try {
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
        }*/
			
			return otp;
		}
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String login(LoginForm loginForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("controller in customer");
		String result="redirect:login.htm";
		String errMsg="?errMsg=";
		if(loginForm!=null)
		{
			CustomerDTO customerDTO=customerService.loadCustomer(loginForm.getUserId(), loginForm.getPassword());
			if(customerDTO!=null)
			{
				System.out.println("Status is"+customerDTO.getStatus());
				if(customerDTO.getStatus()!=null && customerDTO.getStatus().equalsIgnoreCase("Active"))
				{
					HttpSession session=request.getSession();
					session.setAttribute("authUser", customerDTO);
					
				/*	result="redirect:customer/agencyrequest.htm";*/
				result="redirect:customer/customerhome.htm";
				}
				else
				{
					errMsg=errMsg+"Your account status is not Active. ..";
					result=result+errMsg;
				}
				
			}
			else
			{
				errMsg=errMsg+"In valid Username/Password..";
				result=result+errMsg;
			}
			
		}
		return result;
	}
	
	public static void main(String[] args) {
		try {

			SendSmsUtility.init();
			SendSmsUtility.server = "http://192.168.16.1:8800/";
			SendSmsUtility.user = "hussain";
			SendSmsUtility.password = "hussain@7299";
			SendSmsUtility.phonenumber = "+919700273944";
			SendSmsUtility.text = "your otp is";
	    	System.out.println(SendSmsUtility.send());
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	@RequestMapping(value = "/checkuserid",method = RequestMethod.GET)
	public @ResponseBody String getCheckUserIdInJSON(@RequestParam("userId")
			String userId) {
			String result = null;
				if (userId != null) {
					try {
						boolean isExists=customerService.isCustomerExists(userId.toUpperCase());
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
						return "{\"msg\":\"fail\"}";
					}
				}
				
				return result;
			}
	
}

	


