package com.moaddi.service;

import java.util.List;
import java.util.Map;

import com.moaddi.dao.model.LocationTL;
import com.moaddi.dao.model.WarehouseSalesmanTL;
import com.moaddi.dao.model.WarehouseTL;
import com.moaddi.service.dto.LocationDTO;
import com.moaddi.service.dto.WarehouseDTO;
import com.moaddi.service.dto.WarehouseSalesmanDTO;

public interface WarehouseService {
	public Long saveWarehouse(WarehouseDTO warehouseDTO);
	public Map<String, Object> loadWareHouse(String warehouseSNO);
	public Integer modifyWarehouseStatus(Long warehouseId,String status);
	public Long loadWarehouseCount(String country, String city);
	public List<Long> loadWarehouseIdList(String country, String city);
	public List<WarehouseDTO> loadWarehouseIdsSnos();
	public WarehouseDTO loadWarehouse(Long warehouseId);
	public Map<String, Object> loadWareHouse(Long warehouseId);
	public List<WarehouseDTO> getWarehouses(Long createdBy,String warehouseType);
	public Long saveWarehouseSalesman(WarehouseSalesmanDTO warehouseSalesmanDTO);
	public Long loadWarehouseCount(Long createdBy, String warehouseType);
	public List<Long> loadWarehouseIdList(String country, String city,String warehouseType);
	public Long loadWarehouseCount(String country, String city,String warehouseType);
	public List<WarehouseDTO> loadSalesmanWarehouses(Long salesManId);
	public boolean isWarehouseExist(String warehouseSno);
	public Long saveLocation(LocationDTO locationDTO);
	public List<LocationDTO> loadLocations(Long createdBy);
	public LocationDTO loadLocation(Long loactionId);
	

}
