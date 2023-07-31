package com.moaddi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moaddi.dao.CustomerDAO;

import com.moaddi.dao.model.CustomerTL;

import com.moaddi.dao.model.VehicleRtoServiceTL;
import com.moaddi.dao.model.VehicleServiceTL;
import com.moaddi.service.CustomerService;

import com.moaddi.service.dto.CustomerDTO;

import com.moaddi.service.dto.VehicleServiceDTO;
import com.moaddi.ui.forms.OperatorPartnerRequestForm;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO customerDAO;
	public Long saveCustomer(CustomerDTO customerDTO) {
		Long customerId=0l;
		if(customerDTO!=null)
		{
			CustomerTL customerTL = new CustomerTL();
			System.out.print(customerTL + "in seqrvizcqe");
			//customerTL.setAnswer(customerDTO.getAnswer());
			//customerTL.setCountry(customerDTO.getCountry());
			//customerTL.setCountryCode(customerDTO.getCountryCode());
			//customerTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			//customerTL.setDateOfBirth(new java.sql.Date(customerDTO.getDateOfBirth().getTime()));
			//customerTL.setDobType(customerDTO.getDobType());
			customerTL.setEmail(customerDTO.getEmail());
			customerTL.setFullName(customerDTO.getFullName());
			//customerTL.setGender(customerDTO.getGender());
	   //  	customerTL.setIdKind(customerDTO.getIdKind());
			//customerTL.setIdProofFileName(customerDTO.getIdProofFileName());
			customerTL.setMobileNo(customerDTO.getMobileNo());
			//customerTL.setNationality(customerDTO.getNationality());
			customerTL.setPassword(customerDTO.getPassword());
			//customerTL.setRegistrationType(customerDTO.getRegistrationType());
			//customerTL.setSecretQuestion(customerDTO.getSecretQuestion());
			customerTL.setUserId(customerDTO.getUserId());
			//customerTL.setCity(customerDTO.getCity());
			customerTL.setStatus(customerDTO.getStatus());
			customerId=customerDAO.insertCustomer(customerTL);
			
			
		}
		return customerId;
	}
	public Map<String, Object> loadCustomer(String userId) {
		
		return customerDAO.getCustomer(userId);
	}
	public Long loadAccountCount(String country, String city,
			String registrationType) {
		
		return customerDAO.getAccountCount(country, city, registrationType);
	}
	public CustomerDTO loadCustomer(String userId, String password) {
		System.out.println("customer service...");
		CustomerDTO customer=null;
		
		CustomerTL customerTL=customerDAO.getCustomer(userId, password);
		System.out.println("customer service...1");
		if(customerTL!=null)
		{
			System.out.println("customer service...2");
			customer=new CustomerDTO();
			//customer.setAnswer(customerTL.getAnswer());
			//customer.setCountry(customerTL.getCountry());
			//customer.setCountryCode(customerTL.getCountryCode());
			customer.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			//customer.setDateOfBirth(new java.sql.Date(customerTL.getDateOfBirth().getTime()));
			//customer.setDobType(customerTL.getDobType());
			customer.setEmail(customerTL.getEmail());
			customer.setFullName(customerTL.getFullName());
			//customer.setGender(customerTL.getGender());
			//customer.setIdKind(customerTL.getIdKind());
			//customer.setIdProofFileName(customerTL.getIdProofFileName());
			customer.setMobileNo(customerTL.getMobileNo());
			//customer.setNationality(customerTL.getNationality());
			customer.setPassword(customerTL.getPassword());
			customer.setRegistrationType(customerTL.getRegistrationType());
		//	customer.setSecretQuestion(customerTL.getSecretQuestion());
			customer.setUserId(customerTL.getUserId());
			//customer.setCity(customerTL.getCity());
			customer.setCustomerId(customerTL.getCustomerId());
			System.out.println(customerTL.getStatus()+"customer service");
			customer.setStatus(customerTL.getStatus());
		}
		return customer;
	}
	public CustomerDTO loadCustomer(Long customerId) {
		CustomerDTO customer=null;
		if(customerId!=null)
		{
			CustomerTL customerTL=customerDAO.getCustomer(customerId);
			if(customerTL!=null)
			{
				customer=new CustomerDTO();
				customer.setAnswer(customerTL.getAnswer());
				customer.setCountry(customerTL.getCountry());
				customer.setCountryCode(customerTL.getCountryCode());
				customer.setCreatedOn(customerTL.getCreatedOn());
				customer.setDateOfBirth(customerTL.getDateOfBirth());
				customer.setDobType(customerTL.getDobType());
				customer.setEmail(customerTL.getEmail());
				customer.setFullName(customerTL.getFullName());
				customer.setGender(customerTL.getGender());
				customer.setIdKind(customerTL.getIdKind());
				customer.setIdProofFileName(customerTL.getIdProofFileName());
				customer.setMobileNo(customerTL.getMobileNo());
				customer.setNationality(customerTL.getNationality());
				customer.setPassword(customerTL.getPassword());
				customer.setRegistrationType(customerTL.getRegistrationType());
				customer.setSecretQuestion(customerTL.getSecretQuestion());
				customer.setUserId(customerTL.getUserId());
				customer.setCity(customerTL.getCity());
				customer.setCustomerId(customerTL.getCustomerId());
			}
			
		}
		return customer;
	}
	
	public Map<String, Object> loadControlCustomer(Long customerId) {
		// TODO Auto-generated method stub
		return customerDAO.getUser(customerId);
	}
	
	
	
	public List<Map<String, Object>> loadAgency(String status) {
		// TODO Auto-generated method stub
		return customerDAO.getAgency(status);
	}
	

	
	
	
	
	public Long saveVehicleService(VehicleServiceDTO vehicleServiceDTO) {
		// TODO Auto-generated method stub
		Long requestId=0L;
		if(vehicleServiceDTO!=null)
		{
			VehicleServiceTL vehicleServiceTL = new VehicleServiceTL();
			vehicleServiceTL.setCustomerId(vehicleServiceDTO.getCustomerId());
			vehicleServiceTL.setVbrand(vehicleServiceDTO.getVbrand());
			vehicleServiceTL.setVtype(vehicleServiceDTO.getVtyqe());
			vehicleServiceTL.setArea(vehicleServiceDTO.getArea());
			vehicleServiceTL.setFullName(vehicleServiceDTO.getRequesterName());
			vehicleServiceTL.setMobileNo(vehicleServiceDTO.getMobileNo());
			vehicleServiceTL.setEmail(vehicleServiceDTO.getEmail());
			vehicleServiceTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			vehicleServiceTL.setStatus(vehicleServiceDTO.getStatus());
			requestId=customerDAO.insertServiceRequest(vehicleServiceTL);
			
		}
		return requestId;
	}
	
	public Long saveRtoService(VehicleServiceDTO vehicleServiceDTO) {
		// TODO Auto-generated method stub
		Long requestId=0L;
		if(vehicleServiceDTO!=null)
		{
			VehicleRtoServiceTL vehicleServiceTL = new VehicleRtoServiceTL();
			vehicleServiceTL.setCustomerId(vehicleServiceDTO.getCustomerId());
			vehicleServiceTL.setVbrand(vehicleServiceDTO.getVbrand());
			vehicleServiceTL.setVtype(vehicleServiceDTO.getVtyqe());
			vehicleServiceTL.setArea(vehicleServiceDTO.getArea());
			vehicleServiceTL.setFullName(vehicleServiceDTO.getRequesterName());
			vehicleServiceTL.setMobileNo(vehicleServiceDTO.getMobileNo());
			vehicleServiceTL.setEmail(vehicleServiceDTO.getEmail());
			vehicleServiceTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			vehicleServiceTL.setStatus(vehicleServiceDTO.getStatus());
			vehicleServiceTL.setRtoservicetype(vehicleServiceDTO.getRtoservicetype());
			vehicleServiceTL.setVehicleName(vehicleServiceDTO.getVehicleName());
			requestId=customerDAO.insertRtoServiceRequest(vehicleServiceTL);
			
		}
		return requestId;
	}
	
	public List<VehicleServiceDTO> loadOrders(Long createdBy) {
		List<VehicleServiceDTO> orders=null;
		List<VehicleRtoServiceTL> ord=customerDAO.getOrders(createdBy);
		if(ord!=null && ord.size()>0)
		{
			orders=new ArrayList<VehicleServiceDTO>();
			ListIterator<VehicleRtoServiceTL> li=ord.listIterator();
			while(li.hasNext())
			{
				VehicleRtoServiceTL vehicleRtoServiceTL=li.next();
				VehicleServiceDTO vehicleServiceDTO=new VehicleServiceDTO();
				vehicleServiceDTO.setRtoservicetype(vehicleRtoServiceTL.getRtoservicetype());
				vehicleServiceDTO.setArea(vehicleRtoServiceTL.getArea());
				vehicleServiceDTO.setCreatedOn(vehicleRtoServiceTL.getCreatedOn());
				vehicleServiceDTO.setStatus(vehicleRtoServiceTL.getStatus());
				vehicleServiceDTO.setVehicleName(vehicleRtoServiceTL.getVehicleName());
				vehicleServiceDTO.setVtyqe(vehicleRtoServiceTL.getVtype());
				vehicleServiceDTO.setVbrand(vehicleRtoServiceTL.getVbrand());
				vehicleServiceDTO.setComment(vehicleRtoServiceTL.getComment());
				vehicleServiceDTO.setIssues(vehicleRtoServiceTL.getIssues());
				vehicleServiceDTO.setUpdatedOn(vehicleRtoServiceTL.getUpdatedOn());
				vehicleServiceDTO.setVehicleYear(vehicleRtoServiceTL.getVehicleYear());
				orders.add(vehicleServiceDTO);
				
			}
		}
		
		return orders;
	}	
	
	
	
public Integer modifyUserPassord(Long customerId, String password) {
		
		return customerDAO.updateUserPassword(customerId, password);
	}
	
	
	
	
	public Integer modifyUserNumber(Long customerId, String mobileNo) {
		// TODO Auto-generated method stub
		return customerDAO.updateUserNumber(customerId, mobileNo);
	}
	public Map<String, Object> loadCustomerUserRole(Long userRoleId) {
		
		return customerDAO.getCustomerUserRole(userRoleId);
	}
	
	
	
	public List<Map<String, Object>> loadOperatorRequest(String status,Long agencyId) {
		// TODO Auto-generated method stub
		return customerDAO.getOperatorRequest(status,agencyId);
	}
	
	
	public boolean isCustomerExists(String userId) {
		
		return customerDAO.isCustomerExists(userId);
	}

	
	@Override
	public List<Map<String, Object>> loadOpearatorPartner(String status) {
		// TODO Auto-generated method stub
		return customerDAO.getOperatorPartner(status);
	}


	@Override
	public Integer modifyoperatorpartnerRequests(Long userRoleId,String status) {
		/*if(operatorPartnerDetailsDTO!=null)
		{
			OperatorPartnerRequestForm operatorPartnerRequestForm=new OperatorPartnerRequestForm();
			
			operatorPartnerRequestForm.setUpdatedOn(new java.sql.Date(new java.util.Date().getTime()));
			operatorPartnerRequestForm.setStatus(operatorPartnerDetailsDTO.getStatus());
			operatorPartnerRequestForm.setCustomerId(operatorPartnerDetailsDTO.getCustomerId());
			operatorPartnerRequestForm.setOperatorPartnerId(operatorPartnerDetailsDTO.getOperatorPartnerId());*/
			//agencyRequestTL.setComment(agencyRequestDTO.getComment());
		//	operatorPartnerRequestForm.setApprovedBy(operatorPartnerDetailsDTO.getCreatedBy());
			
			//customerDAO.updateOperatorPartnerRequest(operatorPartnerRequestForm);
		    System.out.println("In servive "+status);
			return customerDAO.updateOperatorPartnerRequest(userRoleId, status);
			
		
	
	
	}
	@Override
	public List<Map<String, Object>> loadAllPartner(String status) {
		// TODO Auto-generated method stub
		return customerDAO.getAllPartner(status);
	}
	@Override
	public List<Map<String, Object>> loadAllPartners(Long customerId) {
		// TODO Auto-generated method stub
		return customerDAO.getAllPartners(customerId);
	}
	@Override
	public List<Map<String, Object>> loadAllOperatorPartners(String userroleId) {
		// TODO Auto-generated method stub
		return customerDAO.getAllOperatorPartners(userroleId);
	}
	@Override
	public List<Map<String, Object>> loadPartnerAllMachines(Long userroleId) {
		// TODO Auto-generated method stub
		return customerDAO.getPartnerAllMachines(userroleId);
	}
	@Override
	public List<VehicleServiceDTO> serviceOrders(long customerId) {
		// TODO Auto-generated method stub
		List<VehicleServiceDTO> orders=null;
		List<VehicleServiceTL> ord=customerDAO.serviceOrders(customerId);
		if(ord!=null && ord.size()>0)
		{
			orders=new ArrayList<VehicleServiceDTO>();
			ListIterator<VehicleServiceTL> li=ord.listIterator();
			while(li.hasNext())
			{
				VehicleServiceTL vehicleRtoServiceTL=li.next();
				VehicleServiceDTO vehicleServiceDTO=new VehicleServiceDTO();
				vehicleServiceDTO.setComment(vehicleRtoServiceTL.getComment());
				vehicleServiceDTO.setArea(vehicleRtoServiceTL.getArea());
				vehicleServiceDTO.setCreatedOn(vehicleRtoServiceTL.getCreatedOn());
				vehicleServiceDTO.setStatus(vehicleRtoServiceTL.getStatus());
				vehicleServiceDTO.setVehicleName(vehicleRtoServiceTL.getVehicleName());
				vehicleServiceDTO.setVtyqe(vehicleRtoServiceTL.getVtype());
				vehicleServiceDTO.setIssues(vehicleRtoServiceTL.getIssues());
				vehicleServiceDTO.setVehicleYear(vehicleRtoServiceTL.getVehicleYear());
				vehicleServiceDTO.setVbrand(vehicleRtoServiceTL.getVbrand());
				orders.add(vehicleServiceDTO);
				
			}
		}
		
		return orders;
	}
	@Override
	public List<VehicleServiceDTO> loadOrders(String status) {
		// TODO Auto-generated method stub
		
			List<VehicleServiceDTO> orders=null;
			List<VehicleServiceTL> ord=customerDAO.getOrders(status);
			if(ord!=null && ord.size()>0)
			{
				orders=new ArrayList<VehicleServiceDTO>();
				ListIterator<VehicleServiceTL> li=ord.listIterator();
				while(li.hasNext())
				{
					VehicleServiceTL orderTL=li.next();
					VehicleServiceDTO orderDTO=new VehicleServiceDTO();
					
					orderDTO.setCreatedOn(orderTL.getCreatedOn());
					orderDTO.setStatus(orderTL.getStatus());
					orderDTO.setArea(orderTL.getArea());
					orderDTO.setRequesterName(orderTL.getFullName());
					orderDTO.setCustomerId(orderTL.getCustomerId());
					orderDTO.setEmail(orderTL.getEmail());
					orderDTO.setMobileNo(orderTL.getMobileNo());
					orderDTO.setVbrand(orderTL.getVbrand());
					orderDTO.setVtyqe(orderTL.getVtype());
					orderDTO.setVehicleSeviceRequestId(orderTL.getServiveRequestId());
					orderDTO.setUpdatedOn(orderTL.getUpdatedOn());
					
					orders.add(orderDTO);
					
				}
			
			}
			return orders;
		
	}
	
	@Override
	public List<VehicleServiceDTO> loadRtoOrders(String status) {
		// TODO Auto-generated method stub
		
			List<VehicleServiceDTO> orders=null;
			List<VehicleRtoServiceTL> ord=customerDAO.getRTOOrders(status);
			if(ord!=null && ord.size()>0)
			{
				orders=new ArrayList<VehicleServiceDTO>();
				ListIterator<VehicleRtoServiceTL> li=ord.listIterator();
				while(li.hasNext())
				{
					VehicleRtoServiceTL orderTL=li.next();
					VehicleServiceDTO orderDTO=new VehicleServiceDTO();
					
					orderDTO.setCreatedOn(orderTL.getCreatedOn());
					orderDTO.setStatus(orderTL.getStatus());
					orderDTO.setArea(orderTL.getArea());
					orderDTO.setRequesterName(orderTL.getFullName());
					orderDTO.setCustomerId(orderTL.getCustomerId());
					orderDTO.setEmail(orderTL.getEmail());
					orderDTO.setMobileNo(orderTL.getMobileNo());
					orderDTO.setVbrand(orderTL.getVbrand());
					orderDTO.setVtyqe(orderTL.getVtype());
					orderDTO.setRtoservicetype(orderTL.getRtoservicetype());
					orderDTO.setVehicleSeviceRequestId(orderTL.getServiceRequestId());
					orderDTO.setUpdatedOn(orderTL.getUpdatedOn());
					
					orders.add(orderDTO);
					
				}
			
			}
			return orders;
		
	}
	@Override
	public List<VehicleServiceDTO> loadOrder(Long requestId) {
	
		
		List<VehicleServiceDTO> orders=null;
		List<VehicleServiceTL> ord=customerDAO.getVehicleDetails(requestId);
		if(ord!=null && ord.size()>0)
		{
			orders=new ArrayList<VehicleServiceDTO>();
			ListIterator<VehicleServiceTL> li=ord.listIterator();
			while(li.hasNext())
			{
				VehicleServiceTL orderTL=li.next();
				VehicleServiceDTO orderDTO=new VehicleServiceDTO();
				
				orderDTO.setCreatedOn(orderTL.getCreatedOn());
				orderDTO.setStatus(orderTL.getStatus());
				orderDTO.setArea(orderTL.getArea());
				orderDTO.setRequesterName(orderTL.getFullName());
				orderDTO.setCustomerId(orderTL.getCustomerId());
				orderDTO.setEmail(orderTL.getEmail());
				orderDTO.setMobileNo(orderTL.getMobileNo());
				orderDTO.setVbrand(orderTL.getVbrand());
				orderDTO.setVtyqe(orderTL.getVtype());
				orderDTO.setVehicleSeviceRequestId(orderTL.getServiveRequestId());
				orderDTO.setUpdatedOn(orderTL.getUpdatedOn());
				orderDTO.setComment(orderTL.getComment());
				orderDTO.setIssues(orderTL.getIssues());
				orderDTO.setVehicleName(orderTL.getVehicleName());
				orderDTO.setVehicleYear(orderTL.getVehicleYear());
				
			
				
				orders.add(orderDTO);
				
			}
		
		}
		return orders;
	}
	
	@Override
	public List<VehicleServiceDTO> loadRTOOrder(Long requestId) {
	
		
		List<VehicleServiceDTO> orders=null;
		List<VehicleRtoServiceTL> ord=customerDAO.getRTOVehicleDetails(requestId);
		if(ord!=null && ord.size()>0)
		{
			orders=new ArrayList<VehicleServiceDTO>();
			ListIterator<VehicleRtoServiceTL> li=ord.listIterator();
			while(li.hasNext())
			{
				VehicleRtoServiceTL orderTL=li.next();
				VehicleServiceDTO orderDTO=new VehicleServiceDTO();
				
				orderDTO.setCreatedOn(orderTL.getCreatedOn());
				orderDTO.setStatus(orderTL.getStatus());
				orderDTO.setArea(orderTL.getArea());
				orderDTO.setRequesterName(orderTL.getFullName());
				orderDTO.setCustomerId(orderTL.getCustomerId());
				orderDTO.setEmail(orderTL.getEmail());
				orderDTO.setMobileNo(orderTL.getMobileNo());
				orderDTO.setVbrand(orderTL.getVbrand());
				orderDTO.setVtyqe(orderTL.getVtype());
				orderDTO.setVehicleSeviceRequestId(orderTL.getServiceRequestId());
				orderDTO.setUpdatedOn(orderTL.getUpdatedOn());
				orderDTO.setComment(orderTL.getComment());
				orderDTO.setRtoservicetype(orderTL.getRtoservicetype());
				orderDTO.setIssues(orderTL.getIssues());
				orderDTO.setVehicleName(orderTL.getVehicleName());
				orderDTO.setVehicleYear(orderTL.getVehicleYear());
				
				orders.add(orderDTO);
				
			}
		
		}
		return orders;
	}
	
			@Override
			public void modifyOrder(Long vehicleSeviceRequestId, String comment, String vehicleName,
			String vehicleYear,String status,String userRoleId,String issues) {
				customerDAO.updateOrder(vehicleSeviceRequestId, comment, vehicleName, vehicleYear,status,userRoleId,issues);
				
			}
	
			@Override
			public void modifyRTOStatus(Long vehicleSeviceRequestId, String comment, String vehicleName,
			String vehicleYear,String status,String userRoleId,String issues) {
				customerDAO.updateRTOServiceStatus(vehicleSeviceRequestId, comment, vehicleName, vehicleYear,status,userRoleId,issues);
				
			}
	
}
