package com.moaddi.ui.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.moaddi.dao.BranchDAO;
import com.moaddi.dao.model.BranchTL;
import com.moaddi.dao.model.ItemLockDTO;
import com.moaddi.dao.model.ItemPriceDTO;
import com.moaddi.dao.model.ItemQuantityTL;
import com.moaddi.dao.model.LockTL;
import com.moaddi.dao.model.MachinePartnerTL;
import com.moaddi.dao.model.MachineTL;
import com.moaddi.dao.model.UserRolesTL;
import com.moaddi.service.BranchService;
import com.moaddi.service.CustomerService;
import com.moaddi.service.ItemService;
import com.moaddi.service.LockService;
import com.moaddi.service.MachineService;
import com.moaddi.service.UserRoleService;
import com.moaddi.service.WarehouseService;
import com.moaddi.service.dto.AgencyRequestDTO;
import com.moaddi.service.dto.BranchDTO;
import com.moaddi.service.dto.BranchSalesmanDTO;
import com.moaddi.service.dto.CustomerDTO;
import com.moaddi.service.dto.ItemDTO;
import com.moaddi.service.dto.ItemQuantityDTO;
import com.moaddi.service.dto.ItemSupplierDTO;
import com.moaddi.service.dto.LocationDTO;
import com.moaddi.service.dto.LockDTO;
import com.moaddi.service.dto.LockPriceDTO;
import com.moaddi.service.dto.MachineDTO;
import com.moaddi.service.dto.MachineLockDTO;
import com.moaddi.service.dto.MachinePartnerDTO;
import com.moaddi.service.dto.MachinePriceDTO;
import com.moaddi.service.dto.MachineSupplierDTO;
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
import com.moaddi.ui.forms.ItemForm;
import com.moaddi.ui.forms.ItemLockForm;
import com.moaddi.ui.forms.ItemPriceForm;
import com.moaddi.ui.forms.ItemQuantityForm;
import com.moaddi.ui.forms.MachineLockForm;
import com.moaddi.ui.forms.MachinePartnerForm;
import com.moaddi.ui.forms.MachineSupForm;
import com.moaddi.ui.forms.OperatorRequestForm;
import com.moaddi.ui.forms.WarehouseForm;

@Controller
public class SupplierController {

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
	@Autowired
	private ItemService itemService;

	
	@RequestMapping("/supplier/signout")
	public String showSignout(HttpServletRequest response) {

		return "redirect:../otherlogin.htm?suMsg=Your successfully Signedout";
	}

	@RequestMapping("/supplier/supplierhome")
	public String showHome(HttpServletRequest response) {

		if (response.getParameter("u") != null) {
			return "supplierhome" + response.getParameter("u").toLowerCase()
					+ ".page";
		} else {
			return "supplierhome.page";
		}

	}
	@RequestMapping("/supplier/itemlock")
	public String showCreateItemSupplier(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
		.getAttribute("userRole");
		
		return "supplieritemlock.page";
		
	}
	@RequestMapping(method = RequestMethod.POST, value = "/supplier/itemlock")
	public String submitItemSupplierForm(ItemLockForm itemLockForm,ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
		.getAttribute("userRole");
		if(itemLockForm!=null && itemLockForm.getIquantity()!=null && itemLockForm.getIquantity().length>0)
		{
			ItemLockDTO itemLockDTO=new ItemLockDTO();
			
			for(int index=0;index<itemLockForm.getIquantity().length;index++)
			{
				itemLockDTO.setCreatedBy(userRoleDTO.getUserRoleId());
				long itId=itemLockForm.getItemId()[index];
				itemLockDTO.setItemId(itId);
				
				itemLockDTO.setStatus("Connected");
				itemLockDTO.setQuantity(itemLockForm.getIquantity()[index]);
				long lockId=itemLockForm.getLockId()[index];
				itemLockDTO.setLockId(lockId);
				itemService.saveItemLock(itemLockDTO);
			}
			
		}

		return "redirect:itemlock.htm?s=success";
	}
	

	@RequestMapping(method = RequestMethod.GET, value = "/supplier/checkitem")
	public @ResponseBody
	String getCheckItemInJSON(@RequestParam("itemBarcode")
	String itemBarcode) {

		Map<String, Object> item = null;
		
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		if (itemBarcode != null && !itemBarcode.trim().equals("")) {
			item = itemService.loadItems(itemBarcode.trim().toUpperCase());
					if (item != null) {
						
						try {
							result = mapper.writeValueAsString(item);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						
						result = "{\"msg\":\"fail\"}";
					}
				
			
		
			

		}
		System.out.println("result"+result);
		return result;

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/supplier/checklock")
	public @ResponseBody
	String getCheckLockInJSON(@RequestParam("lockSno")
	String lockSno,HttpServletRequest request) {

		Map<String, Object> lock = null;
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
		.getAttribute("userRole");
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		if (lockSno != null && !lockSno.trim().equals("")) {
			lock = lockService.loadLock(lockSno,userRoleDTO.getUserRoleId());
					if (lock != null) {
						
						try {
							result = mapper.writeValueAsString(lock);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						
						result = "{\"msg\":\"fail\"}";
					}
				
			
		
			

		}
		System.out.println("result"+result);
		return result;

	}
	@RequestMapping("/supplier/machines")
	public String showMachines(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
		.getAttribute("userRole");
		List<MachineDTO> machines=machineService.loadMachines(userRoleDTO.getUserRoleId(), "Connected");
		if(machines!=null)
		{
			request.setAttribute("machines", machines);
			
		}
		return "suppliermachines.page";
		
	}
	@RequestMapping("/supplier/locks")
	public String showLocks(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
		.getAttribute("userRole");
		try {
			String machineId=request.getParameter("machineId");
			List<LockDTO> locks=lockService.loadLocks(new Long(machineId), "Connected");
			if(locks!=null)
			{
				request.setAttribute("locks", locks);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "supplierlocks.page";
		
	}
	@RequestMapping("/supplier/items")
	public String showItems(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
		.getAttribute("userRole");
		
		List<Map<String, Object>> items=itemService.loadItems(userRoleDTO.getUserRoleId());
		if(items!=null)
		{
			request.setAttribute("items", items);
		}
		
		return "supplieritems.page";
		
	}
	@RequestMapping(method = RequestMethod.GET, value = "/supplier/profile")
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
		return "supplierprofile.page";
	}

	@RequestMapping("/supplier/changeprofile")
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
		return "supplierchangeProfile.page";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/supplier/updatepassword")
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
			return "suppliererror.page";
		}
		return "suppliersucess.page";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/supplier/updateNumber")
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

			return "suppliererror.page";
		}

		return "suppliersucess.page";
	}
	
	
}
