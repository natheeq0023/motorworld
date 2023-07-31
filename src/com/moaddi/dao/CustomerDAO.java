package com.moaddi.dao;

import java.util.List;
import java.util.Map;


import com.moaddi.dao.model.CustomerTL;

import com.moaddi.dao.model.VehicleRtoServiceTL;
import com.moaddi.dao.model.VehicleServiceTL;
import com.moaddi.service.dto.CustomerDTO;

public interface CustomerDAO {
	public Long insertCustomer(CustomerTL customerTL);

	public Map<String, Object> getCustomer(String userId);

	public Long getAccountCount(String country, String city,
			String accountKind);
	public CustomerTL getCustomer(String userId,String password);
	public Integer updateUserPassword(Long customerId, String password);
	public CustomerTL getCustomer(Long customerId);
	
	public List<Map<String, Object>> getAgency(String status);
	
	
	/*********************************************/
	public Map<String, Object> getUser(Long customerId);
	
	/************based on requestform*************************/
	
	public Long insertServiceRequest(VehicleServiceTL vehicleServiceTL);
	public Long insertRtoServiceRequest(VehicleRtoServiceTL vehicleRtoServiceTL);
	
	public Integer updateUserNumber(Long customerId, String mobileNo);
	public Map<String, Object> getCustomerUserRole(Long userRoleId);
	public List<VehicleRtoServiceTL> getOrders(Long createdBy);
	

	public List<Map<String, Object>> getOperatorRequest(String status,Long agencyId);

	

	
	public boolean isCustomerExists(String userId);

	public List<Map<String, Object>> getOperatorPartner(String status);

	

	public Integer updateOperatorPartnerRequest(Long userRoleId, String status);
	
	
	
	public List<Map<String, Object>> getAllPartner(String status);

	public List<VehicleServiceTL> getOrders(String status);

	public List<Map<String, Object>> getAllPartners(Long customerId);

	public List<Map<String, Object>> getAllOperatorPartners(String userroleId);
	
	public List<Map<String, Object>> getPartnerAllMachines(Long userroleId);

	public List<VehicleServiceTL> serviceOrders(long customerId);

	public  List<VehicleServiceTL> getVehicleDetails(Long requestId);

	public void updateOrder(Long vehicleSeviceRequestId, String comment, String status, String string, String string2,
			String userRoleId, String issues);

	public List<VehicleRtoServiceTL> getRTOOrders(String status);

	public List<VehicleRtoServiceTL> getRTOVehicleDetails(Long requestId);

	void updateRTOServiceStatus(Long serviveRequestId, String comment, String vehicleName, String vehicleYear,
			String status, String userRoleId, String issues);





}
