package com.moaddi.ui.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.moaddi.service.dto.CustomerDTO;
import com.moaddi.service.dto.UserRoleDTO;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String path = request.getServletPath();

		if (path != null) {
			if (path.startsWith("/mainmanager")) {
				System.out.println("controller in mainmanager");
				HttpSession session=request.getSession(false);
				if(session!=null)
				{
					CustomerDTO authUser=(CustomerDTO)session.getAttribute("authUser");
					if(authUser!=null)
					{
						UserRoleDTO userRole=(UserRoleDTO)session.getAttribute("userRole");
						
						if(userRole!=null && userRole.getUserRole()!=null && userRole.getUserRole().equalsIgnoreCase("MainManager") )
						{
							return true;
						}
						else
						{
							response.sendRedirect("../otherlogin.htm?errMsg=Unauthorised User..");
							return false;
						}
						
					}
					else
					{
						response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
						return false;
					}
					
				}
				else
				{
					response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
					return false;
				}

			}
        //manager
			if (path.startsWith("/manager")) {
				System.out.println("controller in manager");
				HttpSession session=request.getSession(false);
				if(session!=null)
				{
					CustomerDTO authUser=(CustomerDTO)session.getAttribute("authUser");
					if(authUser!=null)
					{
						UserRoleDTO userRole=(UserRoleDTO)session.getAttribute("userRole");
						System.out.println("userRole"+userRole);
						
						if(userRole!=null && userRole.getUserRole()!=null && userRole.getUserRole().equalsIgnoreCase("Manager"))
						{
							return true;
						}
						else
						{
							response.sendRedirect("../otherlogin.htm?errMsg=Unauthorised User..");
							return false;
						}
						
					}
					else
					{
						response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
						return false;
					}
					
				}
				else
				{
					response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
					return false;
				}

			}
			 //admin
			if (path.startsWith("/admin")) {
				System.out.println("controller in Administration");
				HttpSession session=request.getSession(false);
				if(session!=null)
				{
					CustomerDTO authUser=(CustomerDTO)session.getAttribute("authUser");
					if(authUser!=null)
					{
						UserRoleDTO userRole=(UserRoleDTO)session.getAttribute("userRole");
						System.out.println("userRole"+userRole);
						
						if(userRole!=null && userRole.getUserRole()!=null && userRole.getUserRole().equalsIgnoreCase("Administration"))
						{
							return true;
						}
						else
						{
							response.sendRedirect("../otherlogin.htm?errMsg=Unauthorised User..");
							return false;
						}
						
					}
					else
					{
						response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
						return false;
					}
					
				}
				else
				{
					response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
					return false;
				}

			}
			 //support
			if (path.startsWith("/support")) {
				System.out.println("controller in support");
				HttpSession session=request.getSession(false);
				if(session!=null)
				{
					CustomerDTO authUser=(CustomerDTO)session.getAttribute("authUser");
					if(authUser!=null)
					{
						UserRoleDTO userRole=(UserRoleDTO)session.getAttribute("userRole");
						System.out.println("userRole"+userRole);
						
						if(userRole!=null && userRole.getUserRole()!=null && userRole.getUserRole().equalsIgnoreCase("Support"))
						{
							return true;
						}
						else
						{
							response.sendRedirect("../otherlogin.htm?errMsg=Unauthorised User..");
							return false;
						}
						
					}
					else
					{
						response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
						return false;
					}
					
				}
				else
				{
					response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
					return false;
				}

			}
			 //callingcenter
			if (path.startsWith("/callingcenter")) {
				System.out.println("controller in callingcenter");
				HttpSession session=request.getSession(false);
				if(session!=null)
				{
					CustomerDTO authUser=(CustomerDTO)session.getAttribute("authUser");
					if(authUser!=null)
					{
						UserRoleDTO userRole=(UserRoleDTO)session.getAttribute("userRole");
						System.out.println("userRole"+userRole);
						
						if(userRole!=null && userRole.getUserRole()!=null && userRole.getUserRole().equalsIgnoreCase("Calling Centre"))
						{
							return true;
						}
						else
						{
							response.sendRedirect("../otherlogin.htm?errMsg=Unauthorised User..");
							return false;
						}
						
					}
					else
					{
						response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
						return false;
					}
					
				}
				else
				{
					response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
					return false;
				}

			}
			 //accounting
				if (path.startsWith("/accounting")) {
					System.out.println("controller in accounting");
					HttpSession session=request.getSession(false);
					if(session!=null)
					{
						CustomerDTO authUser=(CustomerDTO)session.getAttribute("authUser");
						if(authUser!=null)
						{
							UserRoleDTO userRole=(UserRoleDTO)session.getAttribute("userRole");
							System.out.println("userRole"+userRole);
							
							if(userRole!=null && userRole.getUserRole()!=null && userRole.getUserRole().equalsIgnoreCase("Accounting"))
							{
								return true;
							}
							else
							{
								response.sendRedirect("../otherlogin.htm?errMsg=Unauthorised User..");
								return false;
							}
							
						}
						else
						{
							response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
							return false;
						}
						
					}
					else
					{
						response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
						return false;
					}

				}
				 //warehouse
				if (path.startsWith("/warehouse")) {
					System.out.println("controller in warehouse");
					HttpSession session=request.getSession(false);
					if(session!=null)
					{
						CustomerDTO authUser=(CustomerDTO)session.getAttribute("authUser");
						if(authUser!=null)
						{
							UserRoleDTO userRole=(UserRoleDTO)session.getAttribute("userRole");
							System.out.println("userRole"+userRole);
							
							if(userRole!=null && userRole.getUserRole()!=null && userRole.getUserRole().equalsIgnoreCase("Warehouse"))
							{
								return true;
							}
							else
							{
								response.sendRedirect("../otherlogin.htm?errMsg=Unauthorised User..");
								return false;
							}
							
						}
						else
						{
							response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
							return false;
						}
						
					}
					else
					{
						response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
						return false;
					}

				}
				/*******************************otheraccount star********************************************/
				 //Agency
				if (path.startsWith("/agency")) {
					System.out.println("controller in agency");
					HttpSession session=request.getSession(false);
					if(session!=null)
					{
						CustomerDTO authUser=(CustomerDTO)session.getAttribute("authUser");
						if(authUser!=null)
						{
							UserRoleDTO userRole=(UserRoleDTO)session.getAttribute("userRole");
							System.out.println("userRole"+userRole);
							
							if(userRole!=null && userRole.getUserRole()!=null && userRole.getUserRole().equalsIgnoreCase("Agency"))
							{
								return true;
							}
							else
							{
								response.sendRedirect("../otherlogin.htm?errMsg=Unauthorised User..");
								return false;
							}
							
						}
						else
						{
							response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
							return false;
						}
						
					}
					else
					{
						response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
						return false;
					}

				}
				if (path.startsWith("/salesman")) {
					System.out.println("controller in salesman");
					HttpSession session=request.getSession(false);
					if(session!=null)
					{
						CustomerDTO authUser=(CustomerDTO)session.getAttribute("authUser");
						if(authUser!=null)
						{
							UserRoleDTO userRole=(UserRoleDTO)session.getAttribute("userRole");
							System.out.println("userRole"+userRole);
							
							if(userRole!=null && userRole.getUserRole()!=null && userRole.getUserRole().equalsIgnoreCase("SalesMan"))
							{
								return true;
							}
							else
							{
								response.sendRedirect("../otherlogin.htm?errMsg=Unauthorised User..");
								return false;
							}
							
						}
						else
						{
							response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
							return false;
						}
						
					}
					else
					{
						response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
						return false;
					}

				}
				if (path.startsWith("/operator")) {
					System.out.println("controller in operator");
					HttpSession session=request.getSession(false);
					if(session!=null)
					{
						CustomerDTO authUser=(CustomerDTO)session.getAttribute("authUser");
						if(authUser!=null)
						{
							UserRoleDTO userRole=(UserRoleDTO)session.getAttribute("userRole");
							System.out.println("userRole"+userRole);
							
							if(userRole!=null && userRole.getUserRole()!=null && userRole.getUserRole().equalsIgnoreCase("Operator"))
							{
								return true;
							}
							else
							{
								response.sendRedirect("../otherlogin.htm?errMsg=Unauthorised User..");
								return false;
							}
							
						}
						else
						{
							response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
							return false;
						}
						
					}
					else
					{
						response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
						return false;
					}

				}
				if (path.startsWith("/supplier")) {
					System.out.println("controller in supplier");
					HttpSession session=request.getSession(false);
					if(session!=null)
					{
						CustomerDTO authUser=(CustomerDTO)session.getAttribute("authUser");
						if(authUser!=null)
						{
							UserRoleDTO userRole=(UserRoleDTO)session.getAttribute("userRole");
							System.out.println("userRole"+userRole);
							
							if(userRole!=null && userRole.getUserRole()!=null && userRole.getUserRole().equalsIgnoreCase("Supplier"))
							{
								return true;
							}
							else
							{
								response.sendRedirect("../otherlogin.htm?errMsg=Unauthorised User..");
								return false;
							}
							
						}
						else
						{
							response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
							return false;
						}
						
					}
					else
					{
						response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
						return false;
					}

				}
				if (path.startsWith("/partner")) {
					System.out.println("controller in partner");
					HttpSession session=request.getSession(false);
					if(session!=null)
					{
						CustomerDTO authUser=(CustomerDTO)session.getAttribute("authUser");
						if(authUser!=null)
						{
							UserRoleDTO userRole=(UserRoleDTO)session.getAttribute("userRole");
							System.out.println("userRole"+userRole);
							
							if(userRole!=null && userRole.getUserRole()!=null && userRole.getUserRole().equalsIgnoreCase("Partner"))
							{
								return true;
							}
							else
							{
								response.sendRedirect("../otherlogin.htm?errMsg=Unauthorised User..");
								return false;
							}
							
						}
						else
						{
							response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
							return false;
						}
						
					}
					else
					{
						response.sendRedirect("../otherlogin.htm?errMsg=Invalid User..");
						return false;
					}

				}
		}
		return true;
	}
}