package com.moaddi.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moaddi.dao.UserRoleDAO;
import com.moaddi.dao.model.CustomerTL;
import com.moaddi.dao.model.OperatorPartnerRequestTL;
import com.moaddi.dao.model.UserRolesTL;
import com.moaddi.dao.utility.CustomHibernateDaoSupport;
import com.moaddi.service.dto.UserRoleDTO;

@Repository("userRoleDAO")
@Transactional
public class UserRoleDAOImpl extends CustomHibernateDaoSupport implements
		UserRoleDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Long insertUserRole(UserRolesTL userRolesTL) {
		Long userRoleId = 0l;
		if (userRolesTL != null) {
			userRoleId = (Long) getHibernateTemplate().save(userRolesTL);
		}

		return userRoleId;
	}

	public Map<String, Object> getUser(String userRole, String accountKind,
			Long customerId) {
		Map<String, Object> user = null;
		if (userRole != null && !userRole.trim().equals("")
				&& accountKind != null && !accountKind.trim().equals("")
				&& customerId != null) {
			List users = getHibernateTemplate()
					.find(
							"select userRoleId,city,status,country,userRole from UserRolesTL where userRole=? and accountKind=? and customerId=?",
							new Object[] { userRole, accountKind, customerId });
			if (users != null && users.size() > 0) {
				Object[] obj = (Object[]) users.get(0);
				user = new LinkedHashMap<String, Object>();
				user.put("userRoleId", obj[0]);
				user.put("city", obj[1]);
				user.put("status", obj[2]);
				user.put("country", obj[3]);
				user.put("userRole", obj[4]);

			}

		}
		return user;
	}

	public Integer updateUserStatus(Long userRoleId, String status) {
		Integer noOfRowsEffected = 0;
		UserRolesTL userRolesTL = (UserRolesTL) getHibernateTemplate().get(
				UserRolesTL.class, userRoleId);
		userRolesTL.setStatus(status);
		getHibernateTemplate().update(userRolesTL);

		return noOfRowsEffected;
	}

	public Long getAccountCount(String country, String city, String accountKind) {

		Long accountCount = 0l;
		final String hql = "select count(userRoleId) from UserRolesTL";
		String counrtyCondition = "";
		String cityCondition = "";
		String accountKindCondition = "";
		String where = "";

		boolean isCondition = false;
		if (country != null && !country.trim().equals("")
				&& !country.trim().equalsIgnoreCase("ALL")) {
			isCondition = true;
			counrtyCondition = " country='" + country.trim() + "'";
		}
		if (city != null && !city.trim().equals("")
				&& !city.trim().equalsIgnoreCase("ALL")) {
			isCondition = true;
			cityCondition = "  and  city='" + city.trim() + "'";
		}
		if (accountKind != null && !accountKind.trim().equals("")
				&& !accountKind.trim().equalsIgnoreCase("ALL")) {
			if (isCondition) {
				accountKindCondition = " and accountKind='"
						+ accountKind.trim() + "'";

			} else {
				accountKindCondition = " accountKind='" + accountKind.trim()
						+ "'";
			}

			isCondition = true;

		}
		if (isCondition) {
			where = " where";
		}

		List<Long> accountsCount = getHibernateTemplate().find(
				hql + where + counrtyCondition + cityCondition
						+ accountKindCondition);
		if (accountsCount != null && accountsCount.size() > 0) {

			accountCount = accountsCount.get(0);
		}

		return accountCount;
	}

	public UserRolesTL getUserRole(Long userRoleId) {
		UserRolesTL userRolesTL = null;
		userRolesTL = (UserRolesTL) getHibernateTemplate().get(
				UserRolesTL.class, userRoleId);
		return userRolesTL;
	}

	public UserRolesTL getUser(String userId, String password) {
		// TODO Auto-generated method stub
		UserRolesTL userRolesTL = null;
		if (userId != null && password != null) {
			List<UserRolesTL> users = getHibernateTemplate().find(
					"from UserRolesTL where userId=? and password=?",
					new Object[] { userId, password });
			if (users != null && users.size() > 0) {
				userRolesTL = users.get(0);

			}
		}
		return userRolesTL;
	}

	public Map<String, Object> getUser(String userId) {
		// TODO Auto-generated method stub
		Map<String, Object> customer = null;

		List users = getHibernateTemplate()
				.find(
						"select userRoleId,customerId,userRole,status,city,country,fullName from UserRolesTL where userId=?",
						userId);
		if (users != null && users.size() > 0) {
			Object[] user = (Object[]) users.get(0);
			customer = new LinkedHashMap<String, Object>();
			customer.put("userRoleId", user[0]);
			customer.put("customerId", user[1]);
			customer.put("userRole", user[2]);
			customer.put("status", user[3]);
			customer.put("city", user[4]);
			customer.put("country", user[5]);
			customer.put("fullName", user[6]);

		}
		return customer;
	}

	public Map<String, Object> getCustomer(String userId) {
		Map<String, Object> customer = null;

		List users = getHibernateTemplate()
				.find(
						"select customerId,country,status,city,userRoleId,fullName from UserRolesTL  where userId=?",
						userId);

		if (users != null && users.size() > 0) {

			Object[] user = (Object[]) users.get(0);
			customer = new LinkedHashMap<String, Object>();
			customer.put("customerId", user[0]);
			customer.put("country", user[1]);
			customer.put("status", user[2]);
			customer.put("city", user[3]);
			customer.put("userRoleId", user[4]);
			customer.put("fullName", user[5]);

		}
		return customer;
	}

	public Integer updateUserPassword(Long userRoleId, String password) {
		// TODO Auto-generated method stub
		Integer noOfRowsEffected = 0;
		UserRolesTL userRolesTL = (UserRolesTL) getHibernateTemplate().get(
				UserRolesTL.class, userRoleId);
		userRolesTL.setPassword(password);
		getHibernateTemplate().update(userRolesTL);
		return noOfRowsEffected;
	}

	public Map<String, Object> getUser(String userId, Long createdBy) {

		Map<String, Object> userRole = null;

		List users = getHibernateTemplate()
				.find(
						"select userRoleId,customerId,userRole,status,city,country,fullName from UserRolesTL where userId=? and createdBy=?",
						userId, createdBy);
		if (users != null && users.size() > 0) {
			Object[] user = (Object[]) users.get(0);
			userRole = new LinkedHashMap<String, Object>();
			userRole.put("userRoleId", user[0]);
			userRole.put("customerId", user[1]);
			userRole.put("userRole", user[2]);
			userRole.put("status", user[3]);
			userRole.put("city", user[4]);
			userRole.put("country", user[5]);
			userRole.put("fullName", user[6]);

		}
		return userRole;
	}

	public List<Map<String, Object>> getUsers(Long createdBy, String userRole) {
		List<Map<String, Object>> usrs = null;
		List users = getHibernateTemplate()
				.find(
						"select userRoleId,customerId,fullName,userId from UserRolesTL where userRole=? and createdBy=?",
						userRole, createdBy);
		if (users != null && users.size() > 0) {
			usrs = new ArrayList<Map<String, Object>>();
			ListIterator li = users.listIterator();
			while (li.hasNext()) {
				Object[] user = (Object[]) li.next();
				Map<String, Object> userRol = new LinkedHashMap<String, Object>();
				userRol.put("userRoleId", user[0]);
				userRol.put("customerId", user[1]);
				userRol.put("fullName", user[2]);
				userRol.put("userId", user[3]);
				usrs.add(userRol);
			}

		}

		return usrs;
	}

	public List<Map<String, Object>> getUsers(String userRole) {
		List<Map<String, Object>> usrs = null;
		List users = getHibernateTemplate()
				.find(
						"select userRoleId,customerId,fullName,userId from UserRolesTL where userRole=?",
						userRole);
		if (users != null && users.size() > 0) {
			usrs = new ArrayList<Map<String, Object>>();
			ListIterator li = users.listIterator();
			while (li.hasNext()) {
				Object[] user = (Object[]) li.next();
				Map<String, Object> userRol = new LinkedHashMap<String, Object>();
				userRol.put("userRoleId", user[0]);
				userRol.put("customerId", user[1]);
				userRol.put("fullName", user[2]);
				userRol.put("userId", user[3]);
				usrs.add(userRol);
			}

		}

		return usrs;
	}

	public List<Map<String, Object>> getUsers(String userRole, String country,
			String city) {
		List<Map<String, Object>> usrs = null;
		String hql = "select userRoleId,customerId,fullName,userId from UserRolesTL where userRole=?";
		if (country != null && !country.trim().equals("")
				&& !country.trim().equalsIgnoreCase("All")) {
			hql = hql + " and country='" + country + "'";
		}
		if (city != null && !city.trim().equals("")
				&& !city.trim().equalsIgnoreCase("All")) {
			hql = hql + " and city='" + city + "'";
		}
		List users = getHibernateTemplate().find(hql, userRole);
		if (users != null && users.size() > 0) {
			usrs = new ArrayList<Map<String, Object>>();
			ListIterator li = users.listIterator();
			while (li.hasNext()) {
				Object[] user = (Object[]) li.next();
				Map<String, Object> userRol = new LinkedHashMap<String, Object>();
				userRol.put("userRoleId", user[0]);
				userRol.put("customerId", user[1]);
				userRol.put("fullName", user[2]);
				userRol.put("userId", user[3]);
				usrs.add(userRol);
			}

		}

		return usrs;

	}

	public List<Map<String, Object>> getConnectedSuppliers(Long createdBy,
			Long machineId) {
		List<Map<String, Object>> usrs = null;
		String hql = "select userRoleId,customerId,fullName,userId from UserRolesTL where userRole='Supplier' and createdBy=? and  userRoleId  in(select supplierId from MachineSupplierTL where machineId=? and status='Connected')";
		List users = getHibernateTemplate().find(hql,
				new Object[] { createdBy, machineId });
		if (users != null && users.size() > 0) {
			usrs = new ArrayList<Map<String, Object>>();
			ListIterator li = users.listIterator();
			while (li.hasNext()) {
				Object[] user = (Object[]) li.next();
				Map<String, Object> userRol = new LinkedHashMap<String, Object>();
				userRol.put("userRoleId", user[0]);
				userRol.put("customerId", user[1]);
				userRol.put("fullName", user[2]);
				userRol.put("userId", user[3]);
				usrs.add(userRol);
			}

		}

		return usrs;
	}

	public List<Map<String, Object>> getNotConnectedSuppliers(Long createdBy,
			Long machineId) {
		List<Map<String, Object>> usrs = null;
		String hql = "select userRoleId,customerId,fullName,userId from UserRolesTL where userRole='Supplier' and createdBy=? and  userRoleId not in(select supplierId from MachineSupplierTL where machineId=? and status='Connected')";
		List users = getHibernateTemplate().find(hql,
				new Object[] { createdBy, machineId });
		if (users != null && users.size() > 0) {
			usrs = new ArrayList<Map<String, Object>>();
			ListIterator li = users.listIterator();
			while (li.hasNext()) {
				Object[] user = (Object[]) li.next();
				Map<String, Object> userRol = new LinkedHashMap<String, Object>();
				userRol.put("userRoleId", user[0]);
				userRol.put("customerId", user[1]);
				userRol.put("fullName", user[2]);
				userRol.put("userId", user[3]);
				usrs.add(userRol);
			}

		}

		return usrs;
	}
	
	public Map<String, Object> getUser(String userId, Long createdBy,String userRoles) {

		Map<String, Object> userRole = null;
		
		List users = getHibernateTemplate()
				.find(
						"select userRoleId,customerId,userRole,status,city,country,fullName from UserRolesTL where userId=? and createdBy=? and userRole=?",
						userId, createdBy,userRoles);
		if (users != null && users.size() > 0) {
			Object[] user = (Object[]) users.get(0);
			userRole = new LinkedHashMap<String, Object>();
			userRole.put("userRoleId", user[0]);
			userRole.put("customerId", user[1]);
			userRole.put("userRole", user[2]);
			userRole.put("status", user[3]);
			userRole.put("city", user[4]);
			userRole.put("country", user[5]);
			userRole.put("fullName", user[6]);

		}
		return userRole;
	}

	@Override
	public Long inserOperatorRequestPartnerDetails(
			OperatorPartnerRequestTL orderTL) {
		System.out.println("In Operator DAOIMPL");
		return (Long) getHibernateTemplate().save(orderTL);
	
	}

}
