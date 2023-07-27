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
import java.util.Iterator;
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
import com.moaddi.dao.model.ItemPriceDTO;
import com.moaddi.dao.model.ItemQuantityTL;
import com.moaddi.dao.model.LockTL;
import com.moaddi.dao.model.MachineTL;
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
import com.moaddi.service.dto.MachinePriceDTO;
import com.moaddi.service.dto.MachineSupplierDTO;
import com.moaddi.service.dto.OperatorOrderDTO;
import com.moaddi.service.dto.OperatorOrderDetailsDTO;
import com.moaddi.service.dto.OperatorPartnerDetailsDTO;
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
import com.moaddi.ui.forms.ItemPriceForm;
import com.moaddi.ui.forms.ItemQuantityForm;
import com.moaddi.ui.forms.LocationForm;
import com.moaddi.ui.forms.MachineLockForm;
import com.moaddi.ui.forms.MachineSupForm;
import com.moaddi.ui.forms.OperatorPartnerForm;
import com.moaddi.ui.forms.OperatorRequestForm;
import com.moaddi.ui.forms.WarehouseForm;

@Controller
public class PartnerController {

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

	
	@RequestMapping("/partner/signout")
	public String showSignout(HttpServletRequest response) {

		return "redirect:../otherlogin.htm?suMsg=Your successfully Signedout";
	}

	@RequestMapping("/partner/partnerhome")
	public String showHome(HttpServletRequest response) {

		if (response.getParameter("u") != null) {
			return "partnerhome" + response.getParameter("u").toLowerCase()
					+ ".page";
		} else {
			return "partnerhome.page";
		}

	}

	@RequestMapping("/partner/createlocation")
	public String showCreateWarehouse() {

		return "partnercreatelocation.page";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/partner/createlocation")
	public String createWarehouse(LocationForm locationForm,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) {

		if (locationForm != null) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setAddress(locationForm.getAddress());
			locationDTO.setCity(locationForm.getCity());
			locationDTO.setCountry(locationForm.getCountry());
			locationDTO.setStatus("Active");
			locationDTO.setLocationName(locationForm.getLocationName()
					.toUpperCase());
			locationDTO.setLocationType(locationForm.getLocationType());
			UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
					.getAttribute("userRole");
			if (userRoleDTO != null) {
				locationDTO.setCreatedBy(userRoleDTO.getUserRoleId());

			}
			warehouseService.saveLocation(locationDTO);

		}

		return "redirect:createlocation.htm?s=success";
	}

	@RequestMapping("/partner/locations")
	public String locations(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
				.getAttribute("userRole");
		if (userRoleDTO != null) {
			List<LocationDTO> locations = warehouseService.loadLocations(
					userRoleDTO.getUserRoleId());
			request.setAttribute("locations", locations);
		}

		return "partnerlocations.page";

	}

	@RequestMapping("/partner/machines")
	public String showMachines(HttpServletRequest request) {
		UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
		.getAttribute("userRole");
		try {
			List<MachineDTO> machines=machineService.loadLoactionMachines(new Long(request.getParameter("locationId")), "Connected");
			if(machines!=null)
			{
				request.setAttribute("machines", machines);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "partnermachines.page";
		
	}
	
	
	
	
	
	/******************************************************integrated code*********************************/
	
	
	
	
	
	
	
	@RequestMapping("/partner/allpartnerContract")
	public String allcontract(HttpServletRequest request) {
		String customerId = request.getParameter("cid");
		System.out.println(customerId);
		Long customerid= new Long(customerId);
		List<Map<String, Object>> partner=customerService.loadAllPartners(customerid);
		System.out.println("Partner" + partner);
		request.setAttribute("partner", partner);
		return "allcontract.page";
	}
	
	@RequestMapping("/partner/viewPartner")
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
		return "partnerview.page";
	}
	@RequestMapping(method = RequestMethod.POST, value = "/partner/viewPartner")
	public String agencyStatus(OperatorPartnerForm operatorPartnerForm, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		String status = request.getParameter("status");
		String userroleid = request.getParameter("customerId");
		System.out.println(userroleid);
		Long userRoleid = new Long(userroleid);
		System.out.println(userRoleid);
		
		customerService.modifyoperatorpartnerRequests(userRoleid,status);
		
		return "redirect:allpartnerContract.htm?cid="+userroleid;
			
		}
	

	@RequestMapping("/partner/machineView")
	public String machineView(HttpServletRequest request) {
		String uid = request.getParameter("cid");
		System.out.println(uid);
		Long userRoleId= new Long(uid);
		
		List<Map<String, Object>> machine=customerService.loadPartnerAllMachines(userRoleId);
		
	   
		List<MachineDTO> lm=null;
		for (Map<String, Object> map : machine) {
			Long mid= (Long) map.get("machineId");
			System.out.println(mid+"machineId is:");
			lm=machineService.loadPartnerMachines(mid);
			
			
		}
		request.setAttribute("machine", lm);
		return "allmachine.page";
	}
	
	

	
	@RequestMapping("/partner/viewMachine")
    public String showViewMachine(HttpServletRequest request,Model model) {
		
		String machineSNO=request.getParameter("i");
		System.out.println(machineSNO+"machineSno");
			  if (machineSNO != null) {
				  try {
					  Map<String, Object> machines=machineService.loadMachine(machineSNO);
						if(machines!=null)
						{
							request.setAttribute("machines", machines);
							
						}
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
			}
	
			  return "machineview.page";
       }
	
	@RequestMapping(method = RequestMethod.GET, value = "/partner/profile")
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
		return "partnerprofile.page";
	}

	@RequestMapping("/partner/changeprofile")
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
		return "partnerchangeProfile.page";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/partner/updatepassword")
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
			return "partnererror.page";
		}
		return "partnersucess.page";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/partner/updateNumber")
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

			return "partnererror.page";
		}

		return "partnersucess.page";
	}
	
}