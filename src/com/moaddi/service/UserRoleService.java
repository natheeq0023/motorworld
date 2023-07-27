/**
 * 
 */
package com.moaddi.service;

import java.util.List;
import java.util.Map;

import com.moaddi.dao.model.UserRolesTL;
import com.moaddi.service.dto.CustomerDTO;
import com.moaddi.service.dto.OperatorPartnerDetailsDTO;
import com.moaddi.service.dto.UserRoleDTO;

/**
 * @author Hussain Basha S
 * 
 * 
 *
 */
public interface UserRoleService {
	public Long saveUserRole(UserRoleDTO userRoleDTO);
	public Map<String, Object> loadUser(String userRole,String accountKind,Long customerId);
	public Integer modifyUserStatus(Long userRoleId, String status);
	public Long loadAccountCount(String country, String city,
			String accountKind);
	public UserRoleDTO loadUserRole(Long userRoleId);
	public UserRoleDTO loadUser(String userId, String password);
	
	
	/********************************************************/
	public Map<String, Object> loadUser(String userId);
	public Map<String, Object> loadCustomer(String userId);
	public Integer modifyUserPassord(Long userRoleId, String password);
	public Map<String, Object> loadUser(String userId, Long createdBy);
	public Map<String, Object> loadUser(String userId, Long createdBy,String userRole);
	public List<Map<String, Object>> loadUsers(Long createdBy, String userRole);
	public List<Map<String, Object>> loadUsers(String userRole);
	public List<Map<String, Object>> loadUsers(String userRole, String country,
			String city);
	public List<Map<String, Object>> loadNotConnectedSuppliers(Long createdBy,Long machineId);
	public List<Map<String, Object>> loadConnectedSuppliers(Long createdBy,Long machineId);
	public Long saveOperatorDetails(
			OperatorPartnerDetailsDTO operatorPartnerDetailsDTO);
	

}
