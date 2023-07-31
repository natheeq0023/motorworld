package com.moaddi.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.moaddi.dao.VehicleAdDAO;

import com.moaddi.dao.model.VehicleAdTL;
import com.moaddi.dao.utility.CustomHibernateDaoSupport;

@Repository("vehicleAdDAO")
@Transactional
public class VehicleAdDAOImpl extends CustomHibernateDaoSupport implements
		VehicleAdDAO {

	public Long insertVehicleAd(VehicleAdTL vehicleAdTL) {
		Long adId = 0L;
		adId = (Long) getHibernateTemplate().save(vehicleAdTL);
		return adId;
	}

}
