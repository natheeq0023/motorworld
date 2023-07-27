package com.moaddi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moaddi.dao.WarehouseDAO;
import com.moaddi.dao.model.LocationTL;
import com.moaddi.dao.model.WarehouseSalesmanTL;
import com.moaddi.dao.model.WarehouseTL;
import com.moaddi.service.WarehouseService;
import com.moaddi.service.dto.LocationDTO;
import com.moaddi.service.dto.WarehouseDTO;
import com.moaddi.service.dto.WarehouseSalesmanDTO;
@Service("warehouseService")
public class WarehouseServiceImpl implements WarehouseService{

	@Autowired
	private WarehouseDAO warehouseDAO;
	public Long saveWarehouse(WarehouseDTO warehouseDTO) {
		Long warehouseId=0L;
		if(warehouseDTO!=null)
		{
			WarehouseTL warehouseTL=new WarehouseTL();
			warehouseTL.setAddress(warehouseDTO.getAddress());
			warehouseTL.setCity(warehouseDTO.getCity());
			warehouseTL.setCountry(warehouseDTO.getCountry());
			warehouseTL.setCreatedBy(warehouseDTO.getCreatedBy());
			warehouseTL.setStatus(warehouseDTO.getStatus());
			warehouseTL.setWarehouseSno(warehouseDTO.getWarehouseSno());
			warehouseTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			warehouseTL.setWarehouseType(warehouseDTO.getWarehouseType());
			warehouseDAO.insertWarehouse(warehouseTL);
		}
		
		return warehouseId;
	}
	public Map<String, Object> loadWareHouse(String warehouseSNO) {
		
		return warehouseDAO.getWareHouse(warehouseSNO);
	}
	public Integer modifyWarehouseStatus(Long warehouseId, String status) {
		
		return warehouseDAO.updateWarehouseStatus(warehouseId, status);
	}
	public Long loadWarehouseCount(String country, String city) {
		
		return warehouseDAO.getWarehouseCount(country, city);
	}
	public List<Long> loadWarehouseIdList(String country, String city) {
		
		return warehouseDAO.getWarehouseIdList(country, city);
	}
	public List<WarehouseDTO> loadWarehouseIdsSnos() {
		List<WarehouseDTO> warehouseIdsSnos=null;
		List<WarehouseTL> widsSnos=warehouseDAO.getWarehouseIdsSnos();
		if(widsSnos!=null)
		{
			warehouseIdsSnos=new ArrayList<WarehouseDTO>();
			ListIterator<WarehouseTL> li=widsSnos.listIterator();
			while(li.hasNext())
			{
				WarehouseTL warehouseTL=li.next();
				WarehouseDTO warehouseDTO=new WarehouseDTO();
				warehouseDTO.setWarehouseId(warehouseTL.getWarehouseId());
				warehouseDTO.setWarehouseSno(warehouseTL.getWarehouseSno());
				warehouseDTO.setWarehouseType(warehouseTL.getWarehouseType());
				warehouseIdsSnos.add(warehouseDTO);
				
			}
		}
		
		return warehouseIdsSnos;
	}
	public WarehouseDTO loadWarehouse(Long warehouseId) {
		
		WarehouseDTO warehouseDTO=null;
		WarehouseTL warehouseTL=warehouseDAO.getWarehouse(warehouseId);
		if(warehouseTL!=null)
		{
			warehouseDTO=new WarehouseDTO();
			warehouseDTO.setAddress(warehouseTL.getAddress());
			warehouseDTO.setCity(warehouseTL.getCity());
			warehouseDTO.setCountry(warehouseTL.getCountry());
			warehouseDTO.setCreatedBy(warehouseTL.getCreatedBy());
			warehouseDTO.setStatus(warehouseTL.getStatus());
			warehouseDTO.setWarehouseSno(warehouseTL.getWarehouseSno());
			System.out.println("control in warhouse sevice"+warehouseTL.getWarehouseSno());
			warehouseDTO.setWarehouseType(warehouseTL.getWarehouseType());
			warehouseDTO.setCreatedOn(warehouseTL.getCreatedOn());
		}
		return warehouseDTO;
	}
	public Map<String, Object> loadWareHouse(Long warehouseId) {
		System.out.println("control in warhouse sevice");
		return warehouseDAO.getWareHouse(warehouseId);
	}
	public List<WarehouseDTO> getWarehouses(Long createdBy, String warehouseType) {
		List<WarehouseDTO> warehouses=null;
		List<WarehouseTL> warehouseList=warehouseDAO.getWarehouses(createdBy, warehouseType);
		if(warehouseList!=null && warehouseList.size()>0)
		{
			warehouses=new ArrayList<WarehouseDTO>();
			ListIterator<WarehouseTL> li=warehouseList.listIterator();
			while(li.hasNext())
			{
				
				WarehouseTL warehouseTL=li.next();
				WarehouseDTO warehouseDTO=new WarehouseDTO();
				warehouseDTO.setAddress(warehouseTL.getAddress());
				warehouseDTO.setCity(warehouseTL.getCity());
				warehouseDTO.setCountry(warehouseTL.getCountry());
				warehouseDTO.setCreatedBy(warehouseTL.getCreatedBy());
				warehouseDTO.setStatus(warehouseTL.getStatus());
				warehouseDTO.setWarehouseSno(warehouseTL.getWarehouseSno());
				
				warehouseDTO.setWarehouseType(warehouseTL.getWarehouseType());
				warehouseDTO.setCreatedOn(warehouseTL.getCreatedOn());
				warehouseDTO.setWarehouseId(warehouseTL.getWarehouseId());
				
				warehouses.add(warehouseDTO);
			}
		}
		return warehouses;
	}
	public Long saveWarehouseSalesman(WarehouseSalesmanDTO warehouseSalesmanDTO) {
		Long warehouseSalesmanId=null;
		if(warehouseSalesmanDTO!=null)
		{
			WarehouseSalesmanTL warehouseSalesmanTL=new WarehouseSalesmanTL();
			warehouseSalesmanTL.setWarehouseId(warehouseSalesmanDTO.getWarehouseId());
			warehouseSalesmanTL.setSalesmanId(warehouseSalesmanDTO.getSalesmanId());
			warehouseSalesmanTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			warehouseSalesmanId=warehouseDAO.insertWarehouseSalesman(warehouseSalesmanTL);
		}
		return warehouseSalesmanId;
	}
	public Long loadWarehouseCount(Long createdBy, String warehouseType)
	{
		return warehouseDAO.getWarehouseCount(createdBy, warehouseType);
	}
	public Long loadWarehouseCount(String country, String city,
			String warehouseType) {
		
		return warehouseDAO.getWarehouseCount(country, city, warehouseType);
	}
	public List<Long> loadWarehouseIdList(String country, String city,
			String warehouseType) {
		
		return warehouseDAO.getWarehouseIdList(country, city, warehouseType);
	}
	public List<WarehouseDTO> loadSalesmanWarehouses(Long salesManId) {
		List<WarehouseDTO> warehouses=null;
		List<WarehouseTL> warehouseList=warehouseDAO.getSalesmanWarehouses(salesManId);
		if(warehouseList!=null && warehouseList.size()>0)
		{
			warehouses=new ArrayList<WarehouseDTO>();
			ListIterator<WarehouseTL> li=warehouseList.listIterator();
			while(li.hasNext())
			{
				
				WarehouseTL warehouseTL=li.next();
				WarehouseDTO warehouseDTO=new WarehouseDTO();
				warehouseDTO.setAddress(warehouseTL.getAddress());
				warehouseDTO.setCity(warehouseTL.getCity());
				warehouseDTO.setCountry(warehouseTL.getCountry());
				warehouseDTO.setCreatedBy(warehouseTL.getCreatedBy());
				warehouseDTO.setStatus(warehouseTL.getStatus());
				warehouseDTO.setWarehouseSno(warehouseTL.getWarehouseSno());
				
				warehouseDTO.setWarehouseType(warehouseTL.getWarehouseType());
				warehouseDTO.setCreatedOn(warehouseTL.getCreatedOn());
				warehouseDTO.setWarehouseId(warehouseTL.getWarehouseId());
				
				warehouses.add(warehouseDTO);
			}
		}
		return warehouses;
	}
	public boolean isWarehouseExist(String warehouseSno) {
		
		return warehouseDAO.isWarehouseExist(warehouseSno);
	}
	public Long saveLocation(LocationDTO locationDTO) {
		Long locationId=0L;
		if(locationDTO!=null)
		{
			LocationTL locationTL=new LocationTL();
			locationTL.setAddress(locationDTO.getAddress());
			locationTL.setCity(locationDTO.getCity());
			locationTL.setCountry(locationDTO.getCountry());
			locationTL.setCreatedBy(locationDTO.getCreatedBy());
			locationTL.setStatus(locationDTO.getStatus());
			locationTL.setLocationName(locationDTO.getLocationName());
			locationTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			locationTL.setLocationType(locationDTO.getLocationType());
			warehouseDAO.insertLocation(locationTL);
		}
		
		return locationId;
	}
	public List<LocationDTO> loadLocations(Long createdBy) {
		List<LocationDTO> locations=null;
		List<LocationTL> locationList=warehouseDAO.getLocations(createdBy);
		if(locationList!=null && locationList.size()>0)
		{
			locations=new ArrayList<LocationDTO>();
			ListIterator<LocationTL> li=locationList.listIterator();
			while(li.hasNext())
			{
				
				LocationTL locationTL=li.next();
				LocationDTO locationDTO=new LocationDTO();
				locationDTO.setAddress(locationTL.getAddress());
				locationDTO.setCity(locationTL.getCity());
				locationDTO.setCountry(locationTL.getCountry());
				locationDTO.setCreatedBy(locationTL.getCreatedBy());
				locationDTO.setStatus(locationTL.getStatus());
				locationDTO.setLocationName(locationTL.getLocationName());
				
				locationDTO.setLocationType(locationTL.getLocationType());
				locationDTO.setCreatedOn(locationTL.getCreatedOn());
				locationDTO.setLocationId(locationTL.getLocationId());
				
				locations.add(locationDTO);
			}
		}
		return locations;
	}
	public LocationDTO loadLocation(Long loactionId) {
		LocationTL locationTL=warehouseDAO.getLocation(loactionId);
		LocationDTO locationDTO=null;
		
		if(locationTL!=null)
		{
			locationDTO=new LocationDTO();
			locationDTO.setAddress(locationTL.getAddress());
			locationDTO.setCity(locationTL.getCity());
			locationDTO.setCountry(locationTL.getCountry());
			locationDTO.setCreatedBy(locationTL.getCreatedBy());
			locationDTO.setStatus(locationTL.getStatus());
			locationDTO.setLocationName(locationTL.getLocationName());
			locationDTO.setLocationId(locationTL.getLocationId());
			locationDTO.setLocationType(locationTL.getLocationType());
			locationDTO.setCreatedOn(locationTL.getCreatedOn());
			locationDTO.setLocationId(locationTL.getLocationId());
			
		}
		
		return locationDTO;
		
		
	}

}
