package com.moaddi.service;

import java.util.List;
import java.util.Map;

import com.moaddi.dao.model.CustomerTL;
import com.moaddi.service.dto.AccountsPercentageDTO;
import com.moaddi.service.dto.AgencyRequestDTO;
import com.moaddi.service.dto.AgencyRequestDTOs;
import com.moaddi.service.dto.CustomerDTO;
import com.moaddi.service.dto.OperatorPartnerDetailsDTO;
import com.moaddi.service.dto.OperatorRequestDTO;
import com.moaddi.service.dto.OrderDTO;
import com.moaddi.service.dto.VehicleServiceDTO;

public interface CustomerService {
	public Long saveCustomer(CustomerDTO customerDTO);
	public Map<String, Object> loadCustomer(String userId);
	public Long loadAccountCount(String country,String city,String registrationType);
	public CustomerDTO loadCustomer(String userId, String password);
	public CustomerDTO loadCustomer(Long customerId);
	public Integer saveAgencyRequest(AgencyRequestDTOs agencyRequestDTO);
	public List<Map<String, Object>> loadAgency(String status);
	public AgencyRequestDTOs loadAgencyRequest(Integer agencyRequestId);
	public void modifyAgencyRequest(AgencyRequestDTOs agencyRequestDTO);
	public Long saveAccountsPercentage(AccountsPercentageDTO accountsPercentageDTO);
	/**************************************************************/
	public Map<String, Object> loadControlCustomer(Long customerId);
	public Integer modifyUserPassord(Long customerId, String password);
	/**based on requestForm*****/
	public Long saveAgencyRequests(AgencyRequestDTO agencyRequestDTO);
	public Long saveVehicleService(VehicleServiceDTO vehicleServiceDTO);
	public Long saveRtoService(VehicleServiceDTO vehicleServiceDTO);
	public List<VehicleServiceDTO> loadOrders(Long custId);
	public List<VehicleServiceDTO> loadOrders(String status);
	public AgencyRequestDTO loadAgencyRequests(Long agencyRequestId);
	public void modifyAgencyRequests(AgencyRequestDTO agencyRequestDTO);
	 /*Accounts of indiviusals */
	public Integer modifyUserNumber(Long customerId, String mobileNo);
	public Map<String, Object> loadCustomerUserRole(Long userRoleId);
	public Long saveOperatorRequests(OperatorRequestDTO operatorRequestDTO);
	public List<Map<String, Object>> loadOperatorRequest(String status,Long agencyId);
	public OperatorRequestDTO loadoperatorRequests(Long requestId);
	public void modifyOperatorRequests(OperatorRequestDTO operatorRequestDTO);
	public boolean isCustomerExists(String userId);
	
	public List<Map<String, Object>> loadOpearatorPartner(String status);
	public OperatorPartnerDetailsDTO loadOperatorpartnerRequests(Long requestId);
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
