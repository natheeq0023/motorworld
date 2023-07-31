package com.moaddi.service;

import java.util.List;
import java.util.Map;

import com.moaddi.dao.model.CustomerTL;

import com.moaddi.service.dto.CustomerDTO;

import com.moaddi.service.dto.VehicleServiceDTO;

public interface CustomerService {
	public Long saveCustomer(CustomerDTO customerDTO);
	public Map<String, Object> loadCustomer(String userId);
	public Long loadAccountCount(String country,String city,String registrationType);
	public CustomerDTO loadCustomer(String userId, String password);
	public CustomerDTO loadCustomer(Long customerId);
	
	public List<Map<String, Object>> loadAgency(String status);
	
	
	/**************************************************************/
	public Map<String, Object> loadControlCustomer(Long customerId);
	public Integer modifyUserPassord(Long customerId, String password);
	/**based on requestForm*****/
	
	public Long saveVehicleService(VehicleServiceDTO vehicleServiceDTO);
	public Long saveRtoService(VehicleServiceDTO vehicleServiceDTO);
	public List<VehicleServiceDTO> loadOrders(Long custId);
	public List<VehicleServiceDTO> loadOrders(String status);
	
	 /*Accounts of indiviusals */
	public Integer modifyUserNumber(Long customerId, String mobileNo);
	public Map<String, Object> loadCustomerUserRole(Long userRoleId);

	public List<Map<String, Object>> loadOperatorRequest(String status,Long agencyId);
	
	
	public boolean isCustomerExists(String userId);
	
	public List<Map<String, Object>> loadOpearatorPartner(String status);

	public Integer modifyoperatorpartnerRequests(Long userRoleid, String status);
	public List<Map<String, Object>> loadAllPartner(String status);
	public List<Map<String, Object>> loadAllPartners(Long customerid);
	public List<Map<String, Object>> loadAllOperatorPartners(String userroleId);
	
	public List<Map<String, Object>> loadPartnerAllMachines(Long userroleId);
	public List<VehicleServiceDTO> serviceOrders(long customerId);
	public List<VehicleServiceDTO> loadOrder(Long requestId);
	//public void modifyOrder(Long vehicleSeviceRequestId, String comment, String status, String string, String string2, String long1, String issues);
	public void modifyOrder(Long vehicleSeviceRequestId, String comment, String vehicleName, String vehicleYear,
			String status, String userRoleId, String issues);
	public List<VehicleServiceDTO> loadRtoOrders(String status);
	public List<VehicleServiceDTO> loadRTOOrder(Long requestId);
	void modifyRTOStatus(Long vehicleSeviceRequestId, String comment, String vehicleName, String vehicleYear,
			String status, String userRoleId, String issues);
}
