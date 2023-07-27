package com.moaddi.dao;

import java.util.List;
import java.util.Map;

import com.moaddi.dao.model.LocationTL;
import com.moaddi.dao.model.WarehouseSalesmanTL;
import com.moaddi.dao.model.WarehouseTL;

public interface WarehouseDAO {
	public Long insertWarehouse(WarehouseTL warehouseTL);

	public Integer updateWarehouseStatus(Long warehouseId, String status);

	public Map<String, Object> getWareHouse(String warehouseSNO);

	public Long getWarehouseCount(String country, String city);
	public List<Long> getWarehouseIdList(String country, String city);
	public List<WarehouseTL> getWarehouseIdsSnos();
	public WarehouseTL getWarehouse(Long warehouseId);
	public Map<String, Object> getWareHouse(Long warehouseId);
	public List<WarehouseTL> getWarehouses(Long createdBy,String warehouseType);
	public Long insertWarehouseSalesman(WarehouseSalesmanTL warehouseSalesmanTL);
	public Long getWarehouseCount(Long createdBy,String warehouseType);
	public Long getWarehouseCount(String country, String city,String warehouseType);
	public List<Long> getWarehouseIdList(String country, String city,String warehouseType);
	public List<WarehouseTL> getSalesmanWarehouses(Long salesManId);
	public boolean isWarehouseExist(String warehouseSno);
	public Long insertLocation(LocationTL locationTL);
	public List<LocationTL> getLocations(Long createdBy);
	public LocationTL  getLocation(Long loactionId);
	

}
