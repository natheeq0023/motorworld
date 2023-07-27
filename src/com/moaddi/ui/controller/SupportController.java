package com.moaddi.ui.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.moaddi.dao.ItemDAO;
import com.moaddi.service.CustomerService;
import com.moaddi.service.ItemService;
import com.moaddi.service.LockService;
import com.moaddi.service.MachineService;
import com.moaddi.service.UserRoleService;
import com.moaddi.service.WarehouseService;
import com.moaddi.service.dto.CustomerDTO;
import com.moaddi.service.dto.ItemDTO;
import com.moaddi.service.dto.LockDTO;
import com.moaddi.service.dto.MachineDTO;
import com.moaddi.service.dto.UserRoleDTO;
import com.moaddi.service.dto.WarehouseDTO;
import com.moaddi.ui.forms.AccountForm;
import com.moaddi.ui.forms.ItemForm;
import com.moaddi.ui.forms.LockForm;
import com.moaddi.ui.forms.MachineForm;
@Controller
public class SupportController {
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private ItemDAO itemDAO;
	
	@Autowired
	private WarehouseService warehouseService;
	
	@Autowired
	private MachineService machineService;
	
	@Autowired
	private LockService lockService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/support/checkitembarcode")
	public @ResponseBody String getCheckWarehouseInJSON(@RequestParam("itemBarcode")
			String itemBarcode) {

				
				
				
				String result = null;
				
				
				
				
				if (itemBarcode != null) {
					try {
						boolean isExists=itemService.isItemExist(itemBarcode.toUpperCase());
						
							
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
	@RequestMapping("/support/signout")
	public String showSignout(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			session.invalidate();
		}
		return "redirect:../otherlogin.htm?suMsg=Your successfully Signedout";
	}
	
	@RequestMapping("/support/supporthome")
	public String showCreateAccount(HttpServletRequest response) {

		if(response.getParameter("u")!=null)
		{
		 return "supporthome"+response.getParameter("u").toLowerCase()+".page";
		}
		else
		{
			return "supporthome.page";
		}

	}
	@RequestMapping("/support/createitem")
	public String showCreateItem() {
		
		return "supportcreateitem.page";
		
	}
	@RequestMapping("/support/edititem")
	public String showEditItem() {
		
		return "supportedititem.page";
		
	}
	@RequestMapping("/support/viewaccount")
	public String showViewAccount() {
		
		return "supportviewaccounts.page";
		
	}
	@RequestMapping("/support/viepage")
	public String showViewPage() {
		
		return "supportviewPages.page";
		
	}
	@RequestMapping("/support/vieitem")
	public String showViewItem() {
		
		return "supportviewitems.page";
		
	}
	@RequestMapping(method = RequestMethod.POST, value = "/support/createitem")
	public String submitLockForm(ItemForm itemForm,ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {

		if (itemForm != null) {
			
			
			ItemDTO itemDTO = new ItemDTO();
			UserRoleDTO userRoleDTO = (UserRoleDTO) request.getSession()
			.getAttribute("userRole");
			itemDTO.setItemBarcode(itemForm.getItemBarcode().toUpperCase());
			itemDTO.setItemGruop(itemForm.getItemGruop());
			itemDTO.setItemIngredients(itemForm.getItemIngredients());
			itemDTO.setItemName(itemForm.getItemName());
			itemDTO.setItemSize(itemForm.getItemSize());
			itemDTO.setCreatedBy(userRoleDTO.getUserRoleId());
			itemDTO.setStatus("Active");
			
			
			itemDTO.setItemPhotoName(itemForm.getItemPhoto()
					.getOriginalFilename());
			
		
			
			Long itemId=itemService.saveItem(itemDTO);
			if (itemId != null) {

				MultipartFile multiFile = itemForm.getItemPhoto();
				try {
					// just to show that we have actually received the file

					String fileName = multiFile.getOriginalFilename();

					String path = request.getSession().getServletContext()
							.getRealPath("/");
                    System.out.println(path+"path");
					// making directories for our required path.
					byte[] bytes = multiFile.getBytes();
					File directory = new File(path + "/uploads/item/"
							+ itemId);
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
		}
		return "redirect:createitem.htm?s=success";

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/support/checkitem")
	public @ResponseBody
	String getCheckItemInJSON(@RequestParam("itemBarcode")
	String itemBarcode) {

		Map<String, Object> itemAccount = null;
		
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		if (itemBarcode != null && !itemBarcode.trim().equals("")) {
			itemAccount = itemService.loadItems(itemBarcode.trim());
					if (itemAccount != null) {
						System.out.println(itemAccount);
						try {
							result = mapper.writeValueAsString(itemAccount);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						result = "fail";
					}
				
			
		
			

		}

		return result;

	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/support/updateaccountstatus")
	public String updtaeAccountStatus(HttpServletRequest request,
			HttpServletResponse response,ItemForm itemForm, ModelMap modelMap) {
     
    if(request.getParameter("accountStatus").equalsIgnoreCase("Block") || request.getParameter("accountStatus").equalsIgnoreCase("Active") || request.getParameter("accountStatus").equalsIgnoreCase("Stop") )
      {
    	  itemService.modifyItemStatus(new Long(request
  				.getParameter("itemId")), request
  				.getParameter("accountStatus")); 
    	  
      }
      else if(request.getParameter("accountStatus").equalsIgnoreCase("Update"))
      {
    	
    	  
	ItemDTO itemDTO=new ItemDTO();
	itemDTO.setItemId(new Long(request
  				.getParameter("itemId")));
	itemDTO.setItemBarcode(itemForm.getItemBarcode());
	itemDTO.setItemGruop(itemForm.getItemGruop());
	itemDTO.setItemIngredients(itemForm.getItemIngredients());
	itemDTO.setItemName(itemForm.getItemName());
	itemDTO.setItemSize(itemForm.getItemSize());
	itemDTO.setStatus(itemForm.getStatus());
	itemDTO.setItemPhotoName(itemForm.getItemPhoto()
			.getOriginalFilename());
	Integer  itemId=itemService.modifyItem(itemDTO);
	   itemId=new Integer(request.getParameter("itemId"));
	   if(itemId!=null){
		MultipartFile multiFile = itemForm.getItemPhoto();
		try {
			// just to show that we have actually received the file

			String fileName = multiFile.getOriginalFilename();

			String path = request.getSession().getServletContext()
					.getRealPath("/");
			
			// making directories for our required path.
			byte[] bytes = multiFile.getBytes();
			File directory = new File(path + "/uploads/item/"
					+ itemId);
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
      else if(request.getParameter("accountStatus").equalsIgnoreCase("Delete"))
      {
    	Long itemId= new Long(request.getParameter("itemId"));
    	  itemDAO.deleteItem(itemId);
      }
    	 
		

		return "redirect:edititem.htm?s="
				+ request.getParameter("accountStatus");
	}
	@RequestMapping(method = RequestMethod.GET, value = "/support/checkaccountstatus")
	public @ResponseBody
	String getCheckAccountStatusInJSON(@RequestParam("userId")
	String userId, @RequestParam("accountKind")
	String accountKind, @RequestParam("accountName")
	String accountName,HttpServletRequest request) {
		
        
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
	@RequestMapping(method = RequestMethod.GET, value = "/support/checkpagestatus")
	public @ResponseBody
	String getCheckPageStatusInJSON(@RequestParam("id")
	String id, @RequestParam("pageName")
	String pageName) {
		String result = null;
		if (pageName != null) {
			ObjectMapper mapper = new ObjectMapper();
			if (pageName.trim().equalsIgnoreCase("Warehouse Page")) {
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
			}
			
			if (pageName.trim().equalsIgnoreCase("Machine Page")) {
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
			}
			if (pageName.trim().equalsIgnoreCase("Lock Page")) {
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
			}
		}

		return result;
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/support/profile")
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
			return "supportprofile.page";
		}
	@RequestMapping("/support/changeprofile")
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
		return "supportchangeProfile.page";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/support/updatepassword")
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
			return "supporterror.page";
		}
			return "supportsucess.page";
		}

	@RequestMapping(method = RequestMethod.POST, value = "/support/updateNumber")
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
			
			return "supporterror.page";
		}
			
		return "supportsucess.page";
	}


}
