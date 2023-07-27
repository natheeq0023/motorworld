package com.moaddi.service;

import java.util.List;
import java.util.Map;

import com.moaddi.dao.model.ItemLockDTO;
import com.moaddi.dao.model.ItemLockTL;
import com.moaddi.dao.model.LockTL;
import com.moaddi.service.dto.LockDTO;
import com.moaddi.service.dto.LockPriceDTO;
import com.moaddi.service.dto.LockSalesDTO;
import com.moaddi.service.dto.MachineDTO;
import com.moaddi.service.dto.MachinePriceDTO;
import com.moaddi.service.dto.MachineSalesDTO;

public interface LockService {
	public Long saveLock(LockDTO lockDTO);
	public Long loadLockCount();
	public Long loadLockCount(List<Long> warehouseIdsList);
	public Long loadLockCount(List<Long> warehouseIdsList,String lockModel);
	public Long loadLockCount(String lockModel);
	public LockDTO loadLock(Long lockId);
	public Map<String, Object> loadLock(String lockSNO);
	
	
	public Long saveLockPrice(LockPriceDTO lockPriceDTO);
	public Long loadLockId(String lockSno);
	public List<LockPriceDTO> loadLockPrices(String lockKind,String lockModel);
	public Integer modifyLockStatus(Long lockid, String status);
	public LockPriceDTO loadLockPrice(String lockKind,String lockModel);
	public Long saveLockSales(LockSalesDTO lockSalesDTO);
	public List<LockDTO> loadLockSales(Long orderId);
	public List<LockDTO> loadAgencyLocks(Long userRoleId, Long warehouseId);
	public Long loadLockSalesCount(Long orderCreatedBy);
	public Double loadLockSalesCost(Long orderCreatedBy);
	public Double loadLockSalesCost();
	public Double loadLocksCost();
	public Double loadLocksCost(List<Long> warehouseIdsList);
	public Long loadLockSalesCount();
	public Long loadLockSalesCount(String lockModel);
	public Double loadLocksCost(String lockModel);
	public Double loadLocksCost(List<Long> warehouseIdsList,String lockModel);
	public Long loadLockSalesCount(List<Long> warehouseIdsList,
			String lockModel);
	public Long loadLockSalesCount(List<Long> warehouseIdsList);
	public Double loadLockSalesCost(List<Long> warehouseIdsList);
	public boolean isLockExist(String lockSno);
	public boolean isLockAvailable(String lockSno);
	public Long saveAgencyLockSales(LockSalesDTO lockSalesDTO);
	public boolean isAgencyLockAvailable(String lockSno,Long agencyId);
	public List<LockDTO> loadAgencyLockSales(Long orderId);
	public List<LockDTO> loadMachineLocks(Long machineId,String status);
	public List<LockDTO> loadOperatorLocks(Long operatorId);
	public List<LockDTO> loadOperatorLocks(Long operatorId, String status);
	public Map<String, Object> loadLock(String lockSno, Long supplierid);
	public List<LockDTO> loadLocks(Long machineId, String status);
	/*Calling Center Code*/
	public Map<String, Object> loadLockIdSales(Long lockId);
	public Map<String, Object> loadLockIdWarehouse(Long orderid);
	public Map<String, Object> LoadInOperatorLockIdWarehouse(Long orderid); 
}
