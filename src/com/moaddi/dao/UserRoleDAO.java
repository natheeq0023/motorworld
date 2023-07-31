package com.moaddi.dao;

import java.util.List;
import java.util.Map;





import com.moaddi.dao.model.UserRolesTL;

public interface UserRoleDAO {
	public Long insertUserRole(UserRolesTL userRolesTL);
	public Map<String, Object> getUser(String userRole,String accountKind,Long customerId);
	public Integer updateUserStatus(Long userRoleId,String status);
	public Long getAccountCount(String country, String city,
			String accountKind);
	public UserRolesTL getUserRole(Long userRoleId);
	public UserRolesTL getUser(String userId,String password);
	
	/**************************************************************/
	public Map<String, Object> getUser(String userId);
	public Map<String, Object> getCustomer(String userId);
	public Integer updateUserPassword(Long userRoleId, String password);
	public Map<String, Object> getUser(String userId,Long createdBy);
	public Map<String, Object> getUser(String userId,Long createdBy,String userRole);
	public List<Map<String, Object>> getUsers(Long createdBy,String userRole);
	public List<Map<String, Object>> getUsers(String userRole);
	public List<Map<String, Object>> getUsers(String userRole,String country,String city);
	public List<Map<String, Object>> getNotConnectedSuppliers(Long createdBy,Long machineId);
	public List<Map<String, Object>> getConnectedSuppliers(Long createdBy,Long machineId);
	
	
}
