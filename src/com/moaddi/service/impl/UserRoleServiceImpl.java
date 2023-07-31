/**
 * 
 */
package com.moaddi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moaddi.dao.CustomerDAO;
import com.moaddi.dao.UserRoleDAO;

import com.moaddi.dao.model.CustomerTL;

import com.moaddi.dao.model.UserRolesTL;
import com.moaddi.service.UserRoleService;

import com.moaddi.service.dto.CustomerDTO;

import com.moaddi.service.dto.UserRoleDTO;
//import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;

/**
 * @author Hussain Basha
 *
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDAO userRoleDAO;
	/* (non-Javadoc)
	 * @see com.moaddi.service.UserRoleService#saveUserRole(com.moaddi.service.dto.UserRoleDTO)
	 */
	public Long saveUserRole(UserRoleDTO userRoleDTO) {
		Long userRoleId=0l;
		if(userRoleDTO!=null)
		{
			UserRolesTL userRolesTL=new UserRolesTL();
			userRolesTL.setAccountKind(userRoleDTO.getAccountKind());
			userRolesTL.setCity(userRoleDTO.getCity());
			userRolesTL.setCreatedBy(userRoleDTO.getCreatedBy());
			userRolesTL.setCustomerId(userRoleDTO.getCustomerId());
			userRolesTL.setFullName(userRoleDTO.getFullName());
			userRolesTL.setDocumentFileName(userRoleDTO.getDocumentFileName());
			userRolesTL.setStatus(userRoleDTO.getStatus());
			userRolesTL.setUserRole(userRoleDTO.getUserRole());
			userRolesTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			userRolesTL.setCountry(userRoleDTO.getCountry());
			userRolesTL.setUserId(userRoleDTO.getUserId());
			userRolesTL.setPassword(userRoleDTO.getPassword());
			userRoleId=userRoleDAO.insertUserRole(userRolesTL);
			
		}
		return userRoleId;
	}

	public Map<String, Object> loadUser(String userRole, String accountKind,
			Long customerId) {
		
		return userRoleDAO.getUser(userRole, accountKind, customerId);
	}

	public Integer modifyUserStatus(Long userRoleId, String status) {
		// TODO Auto-generated method stub
		return userRoleDAO.updateUserStatus(userRoleId, status);
	}

	public Long loadAccountCount(String country, String city, String accountKind) {
		
		return userRoleDAO.getAccountCount(country, city, accountKind);
	}

	public UserRoleDTO loadUserRole(Long userRoleId) {
		UserRoleDTO userRoleDTO=null;
		if(userRoleId!=null)
		{
			UserRolesTL userRoles=userRoleDAO.getUserRole(userRoleId);
			if(userRoles!=null)
			{
				userRoleDTO=new UserRoleDTO();
				
				userRoleDTO.setAccountKind(userRoles.getAccountKind());
				userRoleDTO.setCity(userRoles.getCity());
				userRoleDTO.setCreatedBy(userRoles.getCreatedBy());
				userRoleDTO.setCustomerId(userRoles.getCustomerId());
				userRoleDTO.setDocumentFileName(userRoles.getDocumentFileName());
				userRoleDTO.setStatus(userRoles.getStatus());
				userRoleDTO.setUserRole(userRoles.getUserRole());
				userRoleDTO.setUserId(userRoles.getUserId());
				userRoleDTO.setCreatedOn(userRoles.getCreatedOn());
				userRoleDTO.setCountry(userRoles.getCountry());
				userRoleDTO.setFullName(userRoles.getFullName());
				userRoleDTO.setUserRoleId(userRoles.getUserRoleId());
				userRoleDTO.setUpdatedBy(userRoles.getUpdatedBy());
				userRoleDTO.setUpdatedOn(userRoles.getUpdatedOn());
				userRoleDTO.setCreatedBy(userRoles.getCreatedBy());
				userRoleDTO.setPassword(userRoles.getPassword());
				
			}
		}
		return userRoleDTO;
	}

	
	public UserRoleDTO loadUser(String userId, String password) {
		
		UserRoleDTO userRoleDTO=null;
		UserRolesTL userRoles=userRoleDAO.getUser(userId, password);
		if(userRoles!=null)
		{
			userRoleDTO=new UserRoleDTO();
			userRoleDTO.setAccountKind(userRoles.getAccountKind());
			userRoleDTO.setCity(userRoles.getCity());
			userRoleDTO.setCreatedBy(userRoles.getCreatedBy());
			userRoleDTO.setCustomerId(userRoles.getCustomerId());
			userRoleDTO.setDocumentFileName(userRoles.getDocumentFileName());
			userRoleDTO.setStatus(userRoles.getStatus());
			userRoleDTO.setUserRole(userRoles.getUserRole());
			userRoleDTO.setCreatedOn(userRoles.getCreatedOn());
			userRoleDTO.setCountry(userRoles.getCountry());
			userRoleDTO.setFullName(userRoles.getFullName());
			userRoleDTO.setUserRoleId(userRoles.getUserRoleId());
			userRoleDTO.setUpdatedBy(userRoles.getUpdatedBy());
			userRoleDTO.setUpdatedOn(userRoles.getUpdatedOn());
			userRoleDTO.setCreatedBy(userRoles.getCreatedBy());
			userRoleDTO.setUserId(userRoles.getUserId());
			
			
		
		}
		return userRoleDTO;
	}

	
	public Map<String, Object> loadUser(String userId) {
		
		return userRoleDAO.getUser(userId);
	}

	
	public Map<String, Object> loadCustomer(String userId) {
		
		return userRoleDAO.getCustomer(userId);
	}

	
	public Integer modifyUserPassord(Long userRoleId, String password) {
		
		return userRoleDAO.updateUserPassword(userRoleId, password);
	}

	public Map<String, Object> loadUser(String userId, Long createdBy) {
		
		return userRoleDAO.getUser(userId, createdBy);
	}

	public List<Map<String, Object>> loadUsers(Long createdBy, String userRole) {
		
		return userRoleDAO.getUsers(createdBy, userRole);
	}

	public List<Map<String, Object>> loadUsers(String userRole) {
		
		return userRoleDAO.getUsers(userRole);
	}

	public List<Map<String, Object>> loadUsers(String userRole, String country,
			String city) {
		// TODO Auto-generated method stub
		return userRoleDAO.getUsers(userRole, country, city);
	}

	public List<Map<String, Object>> loadConnectedSuppliers(Long createdBy,
			Long machineId) {
		
		return userRoleDAO.getConnectedSuppliers(createdBy, machineId);
	}

	public List<Map<String, Object>> loadNotConnectedSuppliers(Long createdBy,
			Long machineId) {
		
		 return userRoleDAO.getNotConnectedSuppliers(createdBy, machineId);
	}

	public Map<String, Object> loadUser(String userId, Long createdBy,
			String userRole) {
		
		return userRoleDAO.getUser(userId, createdBy, userRole);
	}

	
	
	
}
