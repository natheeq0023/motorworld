package com.moaddi.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moaddi.dao.WarehouseDAO;
import com.moaddi.dao.model.LocationTL;
import com.moaddi.dao.model.WarehouseSalesmanTL;
import com.moaddi.dao.model.WarehouseTL;
import com.moaddi.dao.utility.CustomHibernateDaoSupport;

@Repository("warehouseDAO")
@Transactional
public class WarehouseDAOImpl extends CustomHibernateDaoSupport implements
		WarehouseDAO {

	public Long insertWarehouse(WarehouseTL warehouseTL) {
		Long warehouseId=0L;
		warehouseId=(Long)getHibernateTemplate().save(warehouseTL);
		return warehouseId;
	}

	public Integer updateWarehouseStatus(Long warehouseId, String status) {
		Integer noOfRowsEffected=0;
		WarehouseTL warehouseTL=(WarehouseTL)getHibernateTemplate().get(WarehouseTL.class, warehouseId);
		warehouseTL.setStatus(status);
		getHibernateTemplate().update(warehouseTL);
		return noOfRowsEffected;
	}

	public Map<String, Object> getWareHouse(String warehouseSNO) {
		Map<String, Object> warehouse = null;
		if (warehouseSNO != null && !warehouseSNO.trim().equals("")) {
			List warehouses = getHibernateTemplate()
					.find(
							"select warehouseId,city,status,country from WarehouseTL where warehouseSno=?",
							new Object[] { warehouseSNO });
			if (warehouses != null && warehouses.size() > 0) {
				Object[] obj = (Object[]) warehouses.get(0);
				warehouse = new LinkedHashMap<String, Object>();
				warehouse.put("id", obj[0]);
				warehouse.put("city", obj[1]);
				warehouse.put("status", obj[2]);
				warehouse.put("country", obj[3]);
				

			}

		}
		return warehouse;
	}

	public Long getWarehouseCount(String country, String city) {
		Long count=0L;
		
		/*
		 * final String hql="select count(warehouseId) from WarehouseTL";
		String counrtyCondition="";
		String cityCondition="";
		
		String where="";
		boolean isCondition=false;
		String and="";
		boolean isAnd=false;
		if(country!=null && !country.trim().equals("")&& !country.trim().equalsIgnoreCase("ALL"))
		{
			isCondition=true;
			
			counrtyCondition=" country='"+country.trim()+"'";
		}
		if(city!=null && !city.trim().equals("")&& !city.trim().equalsIgnoreCase("ALL"))
		{
			isCondition=true;
			cityCondition=" city='"+city.trim()+"'";
		}
		
		if(country!=null && !country.trim().equals("")&& !country.trim().equalsIgnoreCase("ALL")&& city!=null && !city.trim().equals("")&& !city.trim().equalsIgnoreCase("ALL"))
		{
			isAnd=true;
		}
		if(isCondition)
		{
			where=" where";
		}
		if(isAnd)
		{
			and=" and";
		}
		
		List<Long> warehouseCount=getHibernateTemplate().find(hql+where+counrtyCondition+and+cityCondition);
		if(warehouseCount!=null && warehouseCount.size()>0)
		{
			
			count=warehouseCount.get(0);
		}
		 */
		final String hql="select count(warehouseId) from WarehouseTL where warehouseType is null ";
		String counrtyCondition="";
		String cityCondition="";
		if(country!=null && !country.trim().equals("")&& !country.trim().equalsIgnoreCase("ALL"))
		{
			counrtyCondition=" and country='"+country.trim()+"'";
		}
		if(city!=null && !city.trim().equals("")&& !city.trim().equalsIgnoreCase("ALL"))
		{
			
			cityCondition=" and city='"+city.trim()+"'";
		}
		List<Long> warehouseCount=getHibernateTemplate().find(hql+counrtyCondition+cityCondition);
		if(warehouseCount!=null && warehouseCount.size()>0)
		{
			count=warehouseCount.get(0);
		}
		return count;
	}

	public List<Long> getWarehouseIdList(String country, String city) {
		List<Long> warehouseIds=null;
		final String hql="select warehouseId from WarehouseTL where warehouseType is null ";
		String counrtyCondition="";
		String cityCondition="";
		if(country!=null && !country.trim().equals("")&& !country.trim().equalsIgnoreCase("ALL"))
		{
		   counrtyCondition=" and country='"+country.trim()+"'";
		}
		if(city!=null && !city.trim().equals("")&& !city.trim().equalsIgnoreCase("ALL"))
		{
		   cityCondition="and  city='"+city.trim()+"'";
		}
		warehouseIds=getHibernateTemplate().find(hql+counrtyCondition+cityCondition);
		return warehouseIds;
	}

	public List<WarehouseTL> getWarehouseIdsSnos() {
		List<WarehouseTL> warehouseIdsSnos=null;
		final String hql="select warehouseId,warehouseSno from WarehouseTL where warehouseType is null";
		List<Object[]> warehouses=getHibernateTemplate().find(hql);
		if(warehouses!=null && warehouses.size()>0)
		{
			ListIterator<Object[]> li=warehouses.listIterator();
			warehouseIdsSnos=new ArrayList<WarehouseTL>();
			while(li.hasNext())
			{
				Object[] objs=li.next();
				WarehouseTL warehouse=new WarehouseTL();
				warehouse.setWarehouseId((Long)objs[0]);
				warehouse.setWarehouseSno((String)objs[1]);
				warehouseIdsSnos.add(warehouse);
				
			}
		}
		return warehouseIdsSnos;
	}

	public WarehouseTL getWarehouse(Long warehouseId) {
		WarehouseTL warehouseTL=null;
		warehouseTL=(WarehouseTL)getHibernateTemplate().get(WarehouseTL.class, warehouseId);
		return warehouseTL;
	}

	public Map<String, Object> getWareHouse(Long warehouseId) {
		Map<String, Object> warehouse = null;
		if (warehouseId != null ) {
			List warehouses = getHibernateTemplate()
					.find(
							"select warehouseId,city,country,warehouseSno,warehouseType from WarehouseTL where warehouseId=?",
							new Object[] { warehouseId });
			if (warehouses != null && warehouses.size() > 0) {
				Object[] obj = (Object[]) warehouses.get(0);
				warehouse = new LinkedHashMap<String, Object>();
				warehouse.put("warehouseId", obj[0]);
				warehouse.put("city", obj[1]);
				warehouse.put("country", obj[2]);
				warehouse.put("warehouseSno", obj[3]);
				warehouse.put("warehouseType", obj[4]);
			}

		}
		return warehouse;
	}

	public List<WarehouseTL> getWarehouses(Long createdBy, String warehouseType) {
		
		return getHibernateTemplate().find("from WarehouseTL where createdBy=? and warehouseType=?",new Object[]{createdBy,warehouseType});
	}

	public Long insertWarehouseSalesman(WarehouseSalesmanTL warehouseSalesmanTL) {
		
		return (Long)getHibernateTemplate().save(warehouseSalesmanTL);
	}

	public Long getWarehouseCount(Long createdBy, String warehouseType) {
		Long count=0l;
		final String hql="select count(warehouseId) from WarehouseTL where createdBy=? and warehouseType=? ";
		List<Long> warehouseCount=getHibernateTemplate().find(hql,new Object[]{createdBy,warehouseType});
		if(warehouseCount!=null && warehouseCount.size()>0)
		{
			
			count=warehouseCount.get(0);
		}
		return count;
	}

	public Long getWarehouseCount(String country, String city,
			String warehouseType) {
		long  count=0;
		final String hql="select count(warehouseId) from WarehouseTL where warehouseType='"+warehouseType+"'";
		String counrtyCondition="";
		String cityCondition="";
		if(country!=null && !country.trim().equals("")&& !country.trim().equalsIgnoreCase("ALL"))
		{
			counrtyCondition=" and country='"+country.trim()+"'";
		}
		if(city!=null && !city.trim().equals("")&& !city.trim().equalsIgnoreCase("ALL"))
		{
			cityCondition=" and city='"+city.trim()+"'";
		}
		List<Long> warehouseCount=getHibernateTemplate().find(hql+counrtyCondition+cityCondition);
		if(warehouseCount!=null && warehouseCount.size()>0)
		{
			count=warehouseCount.get(0);
		}
		return count;
	}
	public List<Long> getWarehouseIdList(String country, String city,String warehouseType) {
		List<Long> warehouseIds=null;
		final String hql="select warehouseId from WarehouseTL where warehouseType='"+warehouseType+"'";
		String counrtyCondition="";
		String cityCondition="";
		if(country!=null && !country.trim().equals("")&& !country.trim().equalsIgnoreCase("ALL"))
		{
			counrtyCondition=" and country='"+country.trim()+"'";
		}
		if(city!=null && !city.trim().equals("")&& !city.trim().equalsIgnoreCase("ALL"))
		{
			
			cityCondition="and  city='"+city.trim()+"'";
		}
		warehouseIds=getHibernateTemplate().find(hql+counrtyCondition+cityCondition);
		return warehouseIds;
	}

	public List<WarehouseTL> getSalesmanWarehouses(Long salesManId) {
		
		List<WarehouseTL> warehouses=null;
		final String hql=" from WarehouseTL where warehouseId in(select warehouseId from WarehouseSalesmanTL where salesmanId="+salesManId+")";
		warehouses=getHibernateTemplate().find(hql);
		
		return warehouses;
	}

	public boolean isWarehouseExist(String warehouseSno)
	{
		boolean isExists=false;
		List warehouses=getHibernateTemplate().find("from WarehouseTL where warehouseSno=?",new Object[]{warehouseSno});
		if(warehouses!=null && warehouses.size()>0)
		{
			isExists=true;
		}
		
		return isExists;
		
	}

	public Long insertLocation(LocationTL locationTL) {
		
		return (Long)getHibernateTemplate().save(locationTL);
	}

	public List<LocationTL> getLocations(Long createdBy) {
		
		return getHibernateTemplate().find("from LocationTL where createdBy="+createdBy);
	}

	public LocationTL getLocation(Long loactionId) {
		
		return (LocationTL)getHibernateTemplate().get(LocationTL.class,loactionId);
	}
}
