package com.moaddi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moaddi.dao.CustomerDAO;
import com.moaddi.dao.model.AccountsPercentageTL;
import com.moaddi.dao.model.AgencyRequestTL;
import com.moaddi.dao.model.AgencyRequestTLs;
import com.moaddi.dao.model.CustomerTL;
import com.moaddi.dao.model.OperatorPartnerRequestTL;
import com.moaddi.dao.model.OperatorRequestTL;
import com.moaddi.dao.model.OrderTL;
import com.moaddi.dao.model.VehicleRtoServiceTL;
import com.moaddi.dao.model.VehicleServiceTL;
import com.moaddi.service.CustomerService;
import com.moaddi.service.dto.AccountsPercentageDTO;
import com.moaddi.service.dto.AgencyRequestDTO;
import com.moaddi.service.dto.AgencyRequestDTOs;
import com.moaddi.service.dto.CustomerDTO;
import com.moaddi.service.dto.OperatorPartnerDetailsDTO;
import com.moaddi.service.dto.OperatorRequestDTO;
import com.moaddi.service.dto.OrderDTO;
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
	
	public Integer saveAgencyRequest(AgencyRequestDTOs agencyRequestDTO) {
		// TODO Auto-generated method stub
		Integer requestId=0;
		if(agencyRequestDTO!=null)
		{
			AgencyRequestTLs agencyRequestTL=new AgencyRequestTLs();
			agencyRequestTL.setDescription(agencyRequestDTO.getDescription());
			agencyRequestTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			agencyRequestTL.setStatus(agencyRequestDTO.getStatus());
			agencyRequestTL.setCustomerId(agencyRequestDTO.getCustomerId());
			requestId=customerDAO.insertAgencyRequest(agencyRequestTL);
		}
		return requestId;
	}
	
	public List<Map<String, Object>> loadAgency(String status) {
		// TODO Auto-generated method stub
		return customerDAO.getAgency(status);
	}
	
	public AgencyRequestDTOs loadAgencyRequest(Integer agencyRequestId) {
		// TODO Auto-generated method stub
		AgencyRequestDTOs agencyRequestDTO=null;
		AgencyRequestTLs agencyRequestTL=(AgencyRequestTLs)customerDAO.getAgencyRequest(agencyRequestId);
		if(agencyRequestTL!=null)
		{
			agencyRequestDTO=new AgencyRequestDTOs();
			agencyRequestDTO.setCreatedOn(agencyRequestTL.getCreatedOn());
			agencyRequestDTO.setStatus(agencyRequestTL.getStatus());
			agencyRequestDTO.setCustomerId(agencyRequestTL.getCustomerId());
			agencyRequestDTO.setAgencyRequestId(agencyRequestTL.getAgencyRequestId());
			agencyRequestDTO.setDescription(agencyRequestTL.getDescription());
			
			agencyRequestDTO.setUpdatedOn(agencyRequestTL.getUpdatedOn());
			agencyRequestDTO.setCustomerId(agencyRequestTL.getCustomerId());
			agencyRequestDTO.setComment(agencyRequestTL.getComment());
			agencyRequestDTO.setApprovedBy(agencyRequestTL.getApprovedBy());
			
		}
		return agencyRequestDTO;
	}
	
	public void modifyAgencyRequest(AgencyRequestDTOs agencyRequestDTO) {
		// TODO Auto-generated method stub
		if(agencyRequestDTO!=null)
		{
			AgencyRequestTLs agencyRequestTL=new AgencyRequestTLs();
			
			agencyRequestTL.setUpdatedOn(new java.sql.Date(new java.util.Date().getTime()));
			agencyRequestTL.setStatus(agencyRequestDTO.getStatus());
			agencyRequestTL.setCustomerId(agencyRequestDTO.getCustomerId());
			agencyRequestTL.setComment(agencyRequestDTO.getComment());
			agencyRequestTL.setApprovedBy(agencyRequestDTO.getApprovedBy());
			agencyRequestTL.setAgencyRequestId(agencyRequestDTO.getAgencyRequestId());
			customerDAO.updateAgencyRequest(agencyRequestTL);
			
			
		}
	}
	
	public Long saveAccountsPercentage(
			AccountsPercentageDTO accountsPercentageDTO) {
		// TODO Auto-generated method stub
		Long id=0L;
		if(accountsPercentageDTO!=null)
		{
			AccountsPercentageTL accountsPercentageTL=new AccountsPercentageTL();
			accountsPercentageTL.setAccountKind(accountsPercentageDTO.getAccountKind());
			accountsPercentageTL.setAccountPercentage(accountsPercentageDTO.getAccountPercentage());
			accountsPercentageTL.setCity(accountsPercentageDTO.getCity());
			accountsPercentageTL.setCountry(accountsPercentageDTO.getCountry());
			accountsPercentageTL.setCreatedBy(accountsPercentageDTO.getCreatedBy());
			accountsPercentageTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			accountsPercentageTL.setUserId(accountsPercentageDTO.getUserId());
			
			customerDAO.insertAccountsPercentage(accountsPercentageTL);
		}
		
		return id;
	}
	
	public Long saveAgencyRequests(AgencyRequestDTO agencyRequestDTO) {
		// TODO Auto-generated method stub
		Long requestId=0L;
		if(agencyRequestDTO!=null)
		{
			AgencyRequestTL agencyRequestTL=new AgencyRequestTL();
			agencyRequestTL.setCountry(agencyRequestDTO.getCountry());
			agencyRequestTL.setOrganizationName(agencyRequestDTO.getOrganizationName());
			agencyRequestTL.setDoc(agencyRequestDTO.getDoc());
			agencyRequestTL.setYearEstablished(new java.sql.Date(agencyRequestDTO.getYearEstablished().getTime()));
			agencyRequestTL.setOrganizationType(agencyRequestDTO.getOrganizationType());
			agencyRequestTL.setRequesterName(agencyRequestDTO.getRequesterName());
			agencyRequestTL.setStreet(agencyRequestDTO.getStreet());
			agencyRequestTL.setCity(agencyRequestDTO.getCity());
			agencyRequestTL.setEmail(agencyRequestDTO.getEmail());
			agencyRequestTL.setMobileNo(agencyRequestDTO.getMobileNo());
			agencyRequestTL.setCheckValue(agencyRequestDTO.getCheckValue());
			agencyRequestTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			agencyRequestTL.setStatus(agencyRequestDTO.getStatus());
			agencyRequestTL.setCustomerId(agencyRequestDTO.getCustomerId());
			System.out.println(agencyRequestDTO.getCustomerId()+"In Controller");
			requestId=customerDAO.insertAgencyRequests(agencyRequestTL);
		}
		return requestId;
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
				orders.add(vehicleServiceDTO);
				
			}
		}
		
		return orders;
	}	
	
	
	
public Integer modifyUserPassord(Long customerId, String password) {
		
		return customerDAO.updateUserPassword(customerId, password);
	}
	
	
	public AgencyRequestDTO loadAgencyRequests(Long agencyRequestId) {
		// TODO Auto-generated method stub
		AgencyRequestDTO agencyRequestDTO=null;
		System.out.println(customerDAO.getAgencyRequests(agencyRequestId)+"in service requestId");
		AgencyRequestTL agencyRequestTL=(AgencyRequestTL)customerDAO.getAgencyRequests(agencyRequestId);
		if(agencyRequestTL!=null)
		{
			agencyRequestDTO=new AgencyRequestDTO();
			agencyRequestDTO.setStatus(agencyRequestTL.getStatus());
			agencyRequestDTO.setAgencyRequestId(agencyRequestTL.getAgencyRequestId());
			agencyRequestDTO.setCountry(agencyRequestTL.getCountry());
			agencyRequestDTO.setOrganizationName(agencyRequestTL.getOrganizationName());
			agencyRequestDTO.setDoc(agencyRequestTL.getDoc());
			agencyRequestDTO.setYearEstablished(new java.sql.Date(agencyRequestTL.getYearEstablished().getTime()));
			agencyRequestDTO.setOrganizationType(agencyRequestTL.getOrganizationType());
			agencyRequestDTO.setRequesterName(agencyRequestTL.getRequesterName());
			agencyRequestDTO.setStreet(agencyRequestTL.getStreet());
			agencyRequestDTO.setCity(agencyRequestTL.getCity());
			agencyRequestDTO.setEmail(agencyRequestTL.getEmail());
			agencyRequestDTO.setMobileNo(agencyRequestTL.getMobileNo());
			agencyRequestDTO.setCheckValue(agencyRequestTL.getCheckValue());
			agencyRequestDTO.setUpdatedOn(agencyRequestTL.getUpdatedOn());
			agencyRequestDTO.setCustomerId(agencyRequestTL.getCustomerId());
			agencyRequestDTO.setComment(agencyRequestTL.getComment());
			agencyRequestDTO.setApprovedBy(agencyRequestTL.getApprovedBy());
			
		}
		return agencyRequestDTO;
	}
	
	public void modifyAgencyRequests(AgencyRequestDTO agencyRequestDTO) {
		// TODO Auto-generated method stub
		if(agencyRequestDTO!=null)
		{
			AgencyRequestTL agencyRequestTL=new AgencyRequestTL();
			
			agencyRequestTL.setUpdatedOn(new java.sql.Date(new java.util.Date().getTime()));
			agencyRequestTL.setStatus(agencyRequestDTO.getStatus());
			agencyRequestTL.setCustomerId(agencyRequestDTO.getCustomerId());
			agencyRequestTL.setComment(agencyRequestDTO.getComment());
			agencyRequestTL.setApprovedBy(agencyRequestDTO.getApprovedBy());
			agencyRequestTL.setAgencyRequestId(agencyRequestDTO.getAgencyRequestId());
			
			customerDAO.updateAgencyRequests(agencyRequestTL);
			
			
		}
	}
	public Integer modifyUserNumber(Long customerId, String mobileNo) {
		// TODO Auto-generated method stub
		return customerDAO.updateUserNumber(customerId, mobileNo);
	}
	public Map<String, Object> loadCustomerUserRole(Long userRoleId) {
		
		return customerDAO.getCustomerUserRole(userRoleId);
	}
	
	public Long saveOperatorRequests(OperatorRequestDTO operatorRequestDTO) {
		// TODO Auto-generated method stub
		Long requestId=0L;
		if(operatorRequestDTO!=null)
		{
			OperatorRequestTL operatorRequestTL=new OperatorRequestTL();
			operatorRequestTL.setCountry(operatorRequestDTO.getCountry());
			operatorRequestTL.setOrganizationName(operatorRequestDTO.getOrganizationName());
			operatorRequestTL.setDoc(operatorRequestDTO.getDoc());
			operatorRequestTL.setYearEstablished(new java.sql.Date(operatorRequestDTO.getYearEstablished().getTime()));
			operatorRequestTL.setOrganizationType(operatorRequestDTO.getOrganizationType());
			operatorRequestTL.setRequesterName(operatorRequestDTO.getRequesterName());
			operatorRequestTL.setStreet(operatorRequestDTO.getStreet());
			operatorRequestTL.setSalesManId(operatorRequestDTO.getSalesManId());
			operatorRequestTL.setCity(operatorRequestDTO.getCity());
			operatorRequestTL.setEmail(operatorRequestDTO.getEmail());
			operatorRequestTL.setMobileNo(operatorRequestDTO.getMobileNo());
			operatorRequestTL.setCheckValue(operatorRequestDTO.getCheckValue());
			operatorRequestTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			operatorRequestTL.setStatus(operatorRequestDTO.getStatus());
			operatorRequestTL.setCustomerId(operatorRequestDTO.getCustomerId());
			operatorRequestTL.setCreatedBy(operatorRequestDTO.getCreatedBy());
			requestId=customerDAO.insertOperatorRequests(operatorRequestTL);
		}
		return requestId;
	}
	
	public List<Map<String, Object>> loadOperatorRequest(String status,Long agencyId) {
		// TODO Auto-generated method stub
		return customerDAO.getOperatorRequest(status,agencyId);
	}
	
	public OperatorRequestDTO loadoperatorRequests(Long requestId) {
		OperatorRequestDTO operatorRequestDTO=null;
		OperatorRequestTL operatorRequestTL=(OperatorRequestTL)customerDAO.getOperatorRequest(requestId);
		if(operatorRequestTL!=null)
		{
			operatorRequestDTO=new OperatorRequestDTO();
			operatorRequestDTO.setCreatedOn(operatorRequestTL.getCreatedOn());
			operatorRequestDTO.setStatus(operatorRequestTL.getStatus());
			operatorRequestDTO.setCustomerId(operatorRequestTL.getCustomerId());
			operatorRequestDTO.setOperatorRequestId(operatorRequestTL.getOperatorRequestId());
			operatorRequestDTO.setComment(operatorRequestTL.getComment());
			operatorRequestDTO.setCountry(operatorRequestTL.getCountry());
			operatorRequestDTO.setRequesterName(operatorRequestTL.getRequesterName());
			operatorRequestDTO.setOrganizationName(operatorRequestTL.getOrganizationName());
			operatorRequestDTO.setOrganizationType(operatorRequestTL.getOrganizationType());
			operatorRequestDTO.setCity(operatorRequestTL.getCity());
			operatorRequestDTO.setStreet(operatorRequestTL.getStreet());
			operatorRequestDTO.setYearEstablished(new java.sql.Date(operatorRequestTL.getYearEstablished().getTime()));
			operatorRequestDTO.setEmail(operatorRequestTL.getEmail());
			operatorRequestDTO.setMobileNo(operatorRequestTL.getMobileNo());
			operatorRequestDTO.setUpdatedOn(operatorRequestTL.getUpdatedOn());
			operatorRequestDTO.setCustomerId(operatorRequestTL.getCustomerId());
			operatorRequestDTO.setComment(operatorRequestTL.getComment());
			operatorRequestDTO.setApprovedBy(operatorRequestTL.getApprovedBy());
			operatorRequestDTO.setCreatedBy(operatorRequestTL.getCreatedBy());
			
		}
		return operatorRequestDTO;
	}
	
	public void modifyOperatorRequests(OperatorRequestDTO operatorRequestDTO) {
		if(operatorRequestDTO!=null)
		{
			OperatorRequestTL operatorRequestTL=new OperatorRequestTL();
			
			operatorRequestTL.setUpdatedOn(new java.sql.Date(new java.util.Date().getTime()));
			operatorRequestTL.setStatus(operatorRequestDTO.getStatus());
			operatorRequestTL.setCustomerId(operatorRequestDTO.getCustomerId());
			operatorRequestTL.setComment(operatorRequestDTO.getComment());
			operatorRequestTL.setApprovedBy(operatorRequestDTO.getApprovedBy());
			operatorRequestTL.setOperatorRequestId(operatorRequestDTO.getOperatorRequestId());
			
			customerDAO.updateOperatorRequests(operatorRequestTL);
			
			
		}
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
	public OperatorPartnerDetailsDTO loadOperatorpartnerRequests(Long operatorPartnerId) {
		OperatorPartnerDetailsDTO operatorPartnerDetailsDTO=null;
		OperatorPartnerRequestTL operatorPartnerForm=(OperatorPartnerRequestTL)customerDAO.getoperatorPartnerRequests(operatorPartnerId);
		if(operatorPartnerForm!=null)
		{
			operatorPartnerDetailsDTO=new OperatorPartnerDetailsDTO();
			operatorPartnerDetailsDTO.setStatus(operatorPartnerForm.getStatus());
			operatorPartnerDetailsDTO.setContractId(operatorPartnerForm.getContractId());
			operatorPartnerDetailsDTO.setOperatorPartnerId(operatorPartnerForm.getOperatorPartnerId());
			operatorPartnerDetailsDTO.setCreatedBy(operatorPartnerForm.getCreatedBy());
			operatorPartnerDetailsDTO.setCreatedOn(operatorPartnerForm.getCreatedOn());
			Long customer = operatorPartnerForm.getCustomerId();
			long cust = new Long(customer);
			operatorPartnerDetailsDTO.setCustomerId(cust);
			operatorPartnerDetailsDTO.setUserRoleId(operatorPartnerForm.getUserRoleId());
			operatorPartnerDetailsDTO.setEnddate(operatorPartnerForm.getEnddate());
			operatorPartnerDetailsDTO.setStartDate(operatorPartnerForm.getStartDate());
			operatorPartnerDetailsDTO.setUserId(operatorPartnerForm.getUserId());
			operatorPartnerDetailsDTO.setPercentage(operatorPartnerForm.getPercentage());
			
			
			
			
		}
		return operatorPartnerDetailsDTO;
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
