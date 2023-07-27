package com.moaddi.dao.impl;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moaddi.dao.CustomerDAO;
import com.moaddi.dao.model.AccountsPercentageTL;
import com.moaddi.dao.model.AgencyRequestTL;
import com.moaddi.dao.model.AgencyRequestTLs;
import com.moaddi.dao.model.CustomerTL;
import com.moaddi.dao.model.OperatorPartnerRequestTL;
import com.moaddi.dao.model.OperatorRequestTL;
import com.moaddi.dao.model.OrderTL;
import com.moaddi.dao.model.UserRolesTL;
import com.moaddi.dao.model.VehicleRtoServiceTL;
import com.moaddi.dao.model.VehicleServiceTL;
import com.moaddi.dao.utility.CustomHibernateDaoSupport;
import com.moaddi.service.dto.CustomerDTO;
import com.moaddi.dao.model.OperatorPartnerRequestTL;

@Repository("customerDAO")
@Transactional
public class CustomerDAOImpl extends CustomHibernateDaoSupport implements CustomerDAO{

	
	public Long insertCustomer(CustomerTL customerTL) {
		Long customerId=0L;
		try {
			
			customerId=(Long)getHibernateTemplate().save(customerTL);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return customerId;
	}
         
	public Integer updateUserPassword(Long customerId, String password) {
		// TODO Auto-generated method stub
		Integer noOfRowsEffected = 0;
		CustomerTL customerTL = (CustomerTL) getHibernateTemplate().get(
				CustomerTL.class, customerId);
		customerTL.setPassword(password);
		getHibernateTemplate().update(customerTL);
		return noOfRowsEffected;
	}
	
	


	public Map<String, Object> getCustomer(String userId) {
		Map<String, Object> customer=null;
		
		List users=getHibernateTemplate().find("select customerId,fullName,country,registrationType,status,city,countryCode,email,userId from CustomerTL where userId=?",userId);
		if(users!=null && users.size()>0)
		{
			Object[] user=(Object[])users.get(0);
			customer=new LinkedHashMap<String, Object>();
			customer.put("customerId", user[0]);
			customer.put("fullName", user[1]);
			customer.put("country", user[2]);
			customer.put("registrationType", user[3]);
			customer.put("status", user[4]);
			customer.put("city", user[5]);
			customer.put("countryCode", user[6]);
			customer.put("email", user[7]);
			customer.put("userId", user[8]);
			
		}
		return customer;
	}



	public Long getAccountCount(String country, String city,
			String registrationType) {
		Long accountCount=0l;
		final String hql="select count(customerId) from CustomerTL";
		String counrtyCondition="";
		String cityCondition="";
		String registrationTypeCondition="";
		String where="";
		boolean isCondition=false;
		if(country!=null && !country.trim().equals("")&& !country.trim().equalsIgnoreCase("ALL"))
		{
			isCondition=true;
			counrtyCondition=" country='"+country.trim()+"'";
		}
		if(city!=null && !city.trim().equals("")&& !city.trim().equalsIgnoreCase("ALL"))
		{
			isCondition=true;
			cityCondition=" and city='"+city.trim()+"'";
		}
		if(registrationType!=null && !registrationType.trim().equals("")&& !registrationType.trim().equalsIgnoreCase("ALL"))
		{
			isCondition=true;
			registrationTypeCondition=" registrationTypeCondition='"+registrationType.trim()+"'";
		}
		if(isCondition)
		{
			where=" where";
		}
		
		List<Long> customersCount=getHibernateTemplate().find(hql+where+counrtyCondition+cityCondition+registrationTypeCondition);
		if(customersCount!=null && customersCount.size()>0)
		{
			
			accountCount=customersCount.get(0);
		}
		
		
		return accountCount;
	}



	public CustomerTL getCustomer(String userId, String password) {
		CustomerTL customerTL=null;
		if(userId!=null && password!=null)
		{
			System.out.println("customer dao");
			List<CustomerTL> customers=getHibernateTemplate().find("from CustomerTL where userId=? and password=?",new Object[]{userId,password});
			if(customers!=null && customers.size()>0)
			{
				customerTL=customers.get(0);
				
			}
		}
		System.out.println("customer dao return");
		return customerTL;
	}



	public CustomerTL getCustomer(Long customerId) {
		CustomerTL customerTL=null;
		customerTL=(CustomerTL)getHibernateTemplate().get(CustomerTL.class, customerId);
		return customerTL;
	}



	
	public Map<String, Object> getUser(Long customerId) {
		// TODO Auto-generated method stub
         Map<String, Object> customer=null;
		List users=getHibernateTemplate().find("select fullName from CustomerTL where customerId=?",customerId);
		if(users!=null && users.size()>0)
		{
			Object[] user=(Object[])users.get(0);
			customer=new LinkedHashMap<String, Object>();
			customer.put("fullName", user[0]);
			
			
		}
		return customer;
	}



	
	public Integer insertAgencyRequest(AgencyRequestTLs agencyRequestTL) {
		// TODO Auto-generated method stub
		Integer agencyRequestId=0;
		agencyRequestId=(Integer)getHibernateTemplate().save(agencyRequestTL);
		return agencyRequestId;
	}



	
	public List<Map<String, Object>> getAgency(String status) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> agencies=null;
		List ags=getHibernateTemplate().find("select ag.agencyRequestId,ag.createdOn,c.fullName,ag.status from AgencyRequestTL ag,CustomerTL c where ag.customerId=c.customerId and ag.status=?",new Object[]{status});
		if(ags!=null && ags.size()>0)
		{
			agencies=new ArrayList<Map<String,Object>>();
			ListIterator<Object[]> li=ags.listIterator();
			while(li.hasNext())
			{
				Object[] ag=li.next();
				Map<String, Object> agency=new HashMap<String,Object>();
				agency.put("agencyRequestId", ag[0]);
				agency.put("createdOn", ag[1]);
				agency.put("fullName", ag[2]);
				agency.put("status", ag[3]);
				
				agencies.add(agency);
			}
			
		}
		
		return agencies;
	}



	public AgencyRequestTLs getAgencyRequest(Integer agencyRequestId) {
		// TODO Auto-generated method stub
		AgencyRequestTLs agencyRequestTL=null;
		agencyRequestTL=(AgencyRequestTLs)getHibernateTemplate().get(AgencyRequestTLs.class, agencyRequestId);
		return agencyRequestTL;
	}



	
	public void updateAgencyRequest(AgencyRequestTLs ageRequestTL) {
		// TODO Auto-generated method stub
		if(ageRequestTL!=null)
		{
			AgencyRequestTLs agencyRequestTL=getHibernateTemplate().get(AgencyRequestTLs.class,ageRequestTL.getAgencyRequestId());
			agencyRequestTL.setUpdatedOn(ageRequestTL.getUpdatedOn());
			agencyRequestTL.setStatus(ageRequestTL.getStatus());
			agencyRequestTL.setCustomerId(ageRequestTL.getCustomerId());
			agencyRequestTL.setComment(ageRequestTL.getComment());
			agencyRequestTL.setApprovedBy(ageRequestTL.getApprovedBy());
			
			getHibernateTemplate().merge(ageRequestTL);
		}
	}

	public Long insertAccountsPercentage(
			AccountsPercentageTL accountsPercentageTL) {
		// TODO Auto-generated method stub
		return (Long)getHibernateTemplate().save(accountsPercentageTL);
	}


	public Long insertAgencyRequests(AgencyRequestTL agencyRequestTL) {
		// TODO Auto-generated method stub
		Long agencyRequestId=0L;
		System.out.println(agencyRequestTL.getCustomerId()+"Agency Dao");
	    agencyRequestId=(Long)getHibernateTemplate().save(agencyRequestTL);
		return agencyRequestId;
	}

    public AgencyRequestTL getAgencyRequests(Long agencyRequestId) {
		// TODO Auto-generated method stub
		AgencyRequestTL agencyRequestTL=null;
		System.out.println(agencyRequestId+"in dao requestId");
		agencyRequestTL=(AgencyRequestTL)getHibernateTemplate().get(AgencyRequestTL.class, agencyRequestId);
		System.out.println(agencyRequestId+"in dao return");
		return agencyRequestTL;
	}
	public void updateAgencyRequests(AgencyRequestTL ageRequestTL) {
		// TODO Auto-generated method stub
		if(ageRequestTL!=null)
		{
			AgencyRequestTL agencyRequestTL=getHibernateTemplate().get(AgencyRequestTL.class,ageRequestTL.getAgencyRequestId());
			agencyRequestTL.setUpdatedOn(ageRequestTL.getUpdatedOn());
			agencyRequestTL.setStatus(ageRequestTL.getStatus());
			agencyRequestTL.setCustomerId(ageRequestTL.getCustomerId());
			agencyRequestTL.setComment(ageRequestTL.getComment());
			agencyRequestTL.setApprovedBy(ageRequestTL.getApprovedBy());
			
			getHibernateTemplate().merge(ageRequestTL);
		}
		
	}
	public Integer updateUserNumber(Long customerId, String mobileNo) {
		// TODO Auto-generated method stub
		Integer noOfRowsEffected = 0;
		CustomerTL customerTL = (CustomerTL) getHibernateTemplate().get(
				CustomerTL.class, customerId);
		customerTL.setMobileNo(mobileNo);
		getHibernateTemplate().update(customerTL);
		return noOfRowsEffected;
	}
	public Map<String, Object> getCustomerUserRole(Long userRoleId) {

		Map<String, Object> customer=null;
		List users=getHibernateTemplate().find("select customerId,fullName,country,mobileNo,city,countryCode,email from CustomerTL  where customerId=(select customerId from UserRolesTL where userRoleId=?)",userRoleId);
		if(users!=null && users.size()>0)
		{
			Object[] user=(Object[])users.get(0);
			customer=new LinkedHashMap<String, Object>();
			customer.put("customerId", user[0]);
			customer.put("fullName", user[1]);
			customer.put("country", user[2]);
			customer.put("mobileNo", user[3]);
			customer.put("city", user[4]);
			customer.put("countryCode", user[5]);
			customer.put("email", user[6]);
			
			
		}
		return customer;
	}
	public Long insertOperatorRequests(OperatorRequestTL operatorRequestTL) {
		// TODO Auto-generated method stub
		Long operatorRequestId=0L;
		operatorRequestId=(Long)getHibernateTemplate().save(operatorRequestTL);
		return operatorRequestId;
	}

	public List<Map<String, Object>> getOperatorRequest(String status,Long agencyId) {
		List<Map<String, Object>> operators=null;
		List ops=getHibernateTemplate().find("select op.operatorRequestId,op.createdOn,op.salesManId,c.fullName,op.status from OperatorRequestTL op,CustomerTL c where op.customerId=c.customerId and op.status=? and op.createdBy in(select userRoleId from UserRolesTL where createdBy=?) ",new Object[]{status,agencyId});
		if(ops!=null && ops.size()>0)
		{
			operators=new ArrayList<Map<String,Object>>();
			ListIterator<Object[]> li=ops.listIterator();
			while(li.hasNext())
			{
				Object[] ag=li.next();
				Map<String, Object> operator=new HashMap<String,Object>();
				operator.put("operatorRequestId", ag[0]);
				operator.put("createdOn", ag[1]);
				operator.put("fullName", ag[3]);
				operator.put("status", ag[4]);
				operator.put("salesManId", ag[2]);
				operators.add(operator);
			}
			
		}
		
		return operators;
	}

   public OperatorRequestTL getOperatorRequest(Long requestId) {
		OperatorRequestTL operatorRequestTL=null;
		System.out.println(requestId+"in dao requestId");
		operatorRequestTL=(OperatorRequestTL)getHibernateTemplate().get(OperatorRequestTL.class, requestId);
		System.out.println(requestId+"in dao return");
		return operatorRequestTL;
	}

	public void updateOperatorRequests(OperatorRequestTL operatorRequestTL) {
		if(operatorRequestTL!=null)
		{
			OperatorRequestTL opRequestTL=getHibernateTemplate().get(OperatorRequestTL.class,operatorRequestTL.getOperatorRequestId());
			opRequestTL.setUpdatedOn(operatorRequestTL.getUpdatedOn());
			opRequestTL.setStatus(operatorRequestTL.getStatus());
			opRequestTL.setCustomerId(operatorRequestTL.getCustomerId());
			opRequestTL.setComment(operatorRequestTL.getComment());
			opRequestTL.setApprovedBy(operatorRequestTL.getApprovedBy());
			
			getHibernateTemplate().merge(operatorRequestTL);
		}
		
	}
	public boolean isCustomerExists(String userId) {
		boolean isExists=false;
		List customers=getHibernateTemplate().find("select userId from CustomerTL where userId=?",new Object[]{userId});
		if(customers!=null && customers.size()>0)
		{
			isExists=true;
		}
		return isExists;
	}
	@Override
	public List<Map<String, Object>> getOperatorPartner(String status) {
		List<Map<String, Object>> opeartors=null;
		List ags=getHibernateTemplate().find("select ag.operatorPartnerId,ag.createdOn,c.fullName,ag.status,ag.userId,ag.userRoleId,ag.percentage from OperatorPartnerRequestTL ag,CustomerTL c where ag.customerId=c.customerId and ag.status=?",new Object[]{status});
		if(ags!=null && ags.size()>0)
		{
			opeartors=new ArrayList<Map<String,Object>>();
			ListIterator<Object[]> li=ags.listIterator();
			while(li.hasNext())
			{
				Object[] ag=li.next();
				Map<String, Object> opeartor=new HashMap<String,Object>();
				opeartor.put("operatorPartnerId", ag[0]);
				opeartor.put("createdOn", ag[1]);
				opeartor.put("fullName", ag[2]);
				opeartor.put("status", ag[3]);
				opeartor.put("userId", ag[4]);
				opeartor.put("userRoleId", ag[5]);
				opeartor.put("percentage", ag[6]);
				opeartors.add(opeartor);
			}
			
		}
		
		return opeartors;
	}



	@Override
	public OperatorPartnerRequestTL getoperatorPartnerRequests(Long operatorPartnerId) {
		// TODO Auto-generated method stub
		OperatorPartnerRequestTL operatorPartnerForm=null;
		System.out.println(operatorPartnerId+"in dao requestId");
		operatorPartnerForm=(OperatorPartnerRequestTL)getHibernateTemplate().get(OperatorPartnerRequestTL.class, operatorPartnerId);
		System.out.println(operatorPartnerId+"in dao return");
		return operatorPartnerForm;
	}



	@Override
	public Integer updateOperatorPartnerRequest(Long customerId,String status) {
		// TODO Auto-generated method stub
	/*	if(OperatorPartnerRequestTL!=null)
		{
			System.out.println("IN DAO LAYER" +OperatorPartnerRequestTL.getOperatorPartnerId());
			OperatorPartnerRequestTL OperatorPartnerRequestTL2 =getHibernateTemplate().get(OperatorPartnerRequestTL.class,OperatorPartnerRequestTL.getOperatorPartnerId());
		//	OperatorPartnerRequestTL2.setUpdatedOn(OperatorPartnerRequestTL.getUpdatedOn());
		//	OperatorPartnerRequestTL2.setStatus(OperatorPartnerRequestTL.getStatus());
			OperatorPartnerRequestTL2.setCustomerId(OperatorPartnerRequestTL.getCustomerId());
			
			getHibernateTemplate().merge(OperatorPartnerRequestTL);
		}
	}
		*/
		Integer noOfRowsEffected = 0;
		System.out.println(customerId);
		System.out.println(status+"In dao Impl");
		OperatorPartnerRequestTL OperatorPartnerRequestTL = new OperatorPartnerRequestTL();
		//List customers=getHibernateTemplate().find("select customerId from OperatorPartnerRequestTL where customerId=?",new Object[]{customerId});
	
			OperatorPartnerRequestTL.setStatus(status);
			getHibernateTemplate().bulkUpdate("update OperatorPartnerRequestTL set status =? where customerId=?",new Object[]{status,customerId});
	
	//	OperatorPartnerRequestTL OperatorPartnerRequestTL = (OperatorPartnerRequestTL) getHibernateTemplate().get(OperatorPartnerRequestTL.class, customerId);
		
		System.out.println(noOfRowsEffected+"Rows affaected");

		return noOfRowsEffected;
	}




	@Override
	public List<Map<String, Object>> getAllPartner(String status) {
		List<Map<String, Object>> partners=null;
		List part=getHibernateTemplate().find("select op.operatorPartnerId,op.contractId,op.userRoleId,op.status,op.model from OperatorPartnerRequestTL op where op.status=?",new Object[]{status});
		if(part!=null && part.size()>0)
		{
			partners=new ArrayList<Map<String,Object>>();
			ListIterator<Object[]> li=part.listIterator();
			while(li.hasNext())
			{
				Object[] ag=li.next();
				Map<String, Object> partner=new HashMap<String,Object>();
				partner.put("operatorPartnerId", ag[0]);
				partner.put("contractId", ag[1]);
				partner.put("userRoleId", ag[2]);
				partner.put("status", ag[3]);
				partner.put("model", ag[4]);
			    partners.add(partner);
			}
			
		}
		
		return partners;
	}


	@Override
	public List<Map<String, Object>> getAllPartners(Long customerId) {
		List<Map<String, Object>> partners=null;
		List part=getHibernateTemplate().find("select op.operatorPartnerId,op.contractId,op.userRoleId,op.status,op.model from OperatorPartnerRequestTL op where op.customerId=?",new Object[]{customerId});
		if(part!=null && part.size()>0)
		{
			partners=new ArrayList<Map<String,Object>>();
			ListIterator<Object[]> li=part.listIterator();
			while(li.hasNext())
			{
				Object[] ag=li.next();
				Map<String, Object> partner=new HashMap<String,Object>();
				partner.put("operatorPartnerId", ag[0]);
				partner.put("contractId", ag[1]);
				partner.put("userRoleId", ag[2]);
				partner.put("status", ag[3]);
				partner.put("model", ag[4]);
			    partners.add(partner);
			}
			
		}
		
		return partners;
	}



	@Override
	public List<Map<String, Object>> getAllOperatorPartners(String userroleId) {
		List<Map<String, Object>> partners=null;
		List part=getHibernateTemplate().find("select op.operatorPartnerId,op.contractId,op.fullName,op.enddate,op.status from OperatorPartnerRequestTL op where op.userRoleId=?",new Object[]{userroleId});
		if(part!=null && part.size()>0)
		{
			partners=new ArrayList<Map<String,Object>>();
			ListIterator<Object[]> li=part.listIterator();
			while(li.hasNext())
			{
				Object[] ag=li.next();
				Map<String, Object> partner=new HashMap<String,Object>();
				partner.put("operatorPartnerId", ag[0]);
				partner.put("contractId", ag[1]);
				partner.put("fullName", ag[2]);
				partner.put("enddate", ag[3]);
				partner.put("status", ag[4]);
			    partners.add(partner);
			}
			
		}
		
		return partners;
	}



	@Override
	public List<Map<String, Object>> getPartnerAllMachines(Long userroleId) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> partners=null;
		List part=getHibernateTemplate().find("select op.loactionId,op.machineId,op.status from MachinePartnerTL op where op.partnerId=?",new Object[]{userroleId});
		if(part!=null && part.size()>0)
		{
			partners=new ArrayList<Map<String,Object>>();
			ListIterator<Object[]> li=part.listIterator();
			while(li.hasNext())
			{
				Object[] ag=li.next();
				Map<String, Object> partner=new HashMap<String,Object>();
				partner.put("locationId", ag[0]);
				partner.put("machineId", ag[1]);
				partner.put("status", ag[2]);
			    partners.add(partner);
			}
			
		}
		
		return partners;
	}



	@Override
	public Long insertServiceRequest(VehicleServiceTL vehicleServiceTL) {
		Long serviceRequestId=0L;
		System.out.println(vehicleServiceTL.getCustomerId()+"Agency Dao");
	    serviceRequestId=(Long)getHibernateTemplate().save(vehicleServiceTL);
		return serviceRequestId;
	}
	@Override
	public Long insertRtoServiceRequest(VehicleRtoServiceTL vehicleServiceTL) {
		Long serviceRequestId=0L;
		System.out.println(vehicleServiceTL.getCustomerId()+"Agency Dao");
	    serviceRequestId=(Long)getHibernateTemplate().save(vehicleServiceTL);
		return serviceRequestId;
	}
	
	public List<VehicleRtoServiceTL> getOrders(Long createdBy) {

		return getHibernateTemplate().find(
				"from VehicleRtoServiceTL where customerId=? order by serviceRequestId  desc",
				new Object[] { createdBy });
	}

	@Override
	public List<VehicleServiceTL> serviceOrders(long customerId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find(
				"from VehicleServiceTL where customerId=? order by serviveRequestId desc",
				new Object[] { customerId });
	}
	
	public List<VehicleServiceTL> getOrders(String status) {

		return getHibernateTemplate().find("from VehicleServiceTL where status=? order by serviveRequestId desc",
				new Object[] { status });
	}

	public OrderTL getOrder(Long orderId) {

		return (OrderTL) getHibernateTemplate().get(OrderTL.class, orderId);
	}

	@Override
	public List<VehicleServiceTL> getVehicleDetails(Long requestId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from VehicleServiceTL where serviveRequestId=? order by serviveRequestId desc",
				new Object[] { requestId });
	}
     
	@Override
	public List<VehicleRtoServiceTL> getRTOVehicleDetails(Long requestId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from VehicleRtoServiceTL where serviveRequestId=? order by serviveRequestId desc",
				new Object[] { requestId });
	}

	
	@Override
	public void updateOrder(Long serviveRequestId, String comment, String vehicleName, String vehicleYear,
			String status, String userRoleId, String issues) {
		VehicleServiceTL orderTL = (VehicleServiceTL) getHibernateTemplate().get(VehicleServiceTL.class,
				serviveRequestId);
		if (orderTL != null) {
			orderTL.setUpdatedBy(userRoleId);
			orderTL.setUpdatedOn(new java.sql.Date(new java.util.Date()
					.getTime()));
			orderTL.setStatus(status);
			orderTL.setComment(comment);
			orderTL.setVehicleName(vehicleName);
			orderTL.setVehicleYear(vehicleYear);
			orderTL.setIssues(issues);
			
			getHibernateTemplate().update(orderTL);

		}
		
	}
   
	@Override
	public void updateRTOServiceStatus(Long serviveRequestId, String comment, String vehicleName, String vehicleYear,
			String status, String userRoleId, String issues) {
		VehicleRtoServiceTL orderTL = (VehicleRtoServiceTL) getHibernateTemplate().get(VehicleRtoServiceTL.class,
				serviveRequestId);
		if (orderTL != null) {
			orderTL.setUpdatedBy(userRoleId);
			orderTL.setUpdatedOn(new java.sql.Date(new java.util.Date()
					.getTime()));
			orderTL.setStatus(status);
			orderTL.setComment(comment);
			orderTL.setVehicleName(vehicleName);
			orderTL.setVehicleYear(vehicleYear);
			orderTL.setIssues(issues);
			
			getHibernateTemplate().update(orderTL);

		}
		
	}
	
	
	@Override
	public List<VehicleRtoServiceTL> getRTOOrders(String status) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from VehicleRtoServiceTL where status=? order by serviceRequestId desc",
				new Object[] { status });
	}
}
