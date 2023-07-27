package com.moaddi.dao;

import java.util.List;
import java.util.Map;

import com.moaddi.dao.model.AgencyLockSalesTL;
import com.moaddi.dao.model.LockPriceTL;
import com.moaddi.dao.model.LockSalesTL;
import com.moaddi.dao.model.LockTL;
import com.moaddi.dao.model.MachinePriceTL;
import com.moaddi.dao.model.MachineSalesTL;
import com.moaddi.dao.model.MachineTL;

public interface LockDAO {
	public Long insertLock(LockTL lockTL);
	public Long getLockCount();
	public Long getLockCount(List<Long> warehouseIdsList);
	public Long getLockCount(List<Long> warehouseIdsList,String lockModel);
	public Long getLockCount(String lockModel);
	public LockTL getLock(Long lockId);
	public Map<String, Object> getLock(String lockSNO);
	public Long insertLockPrice(LockPriceTL lockPriceTL);
	public List<LockPriceTL> getLockPrices(String lockKind,String lockModel);
	public Long getLockId(String lockSno);
	public Integer updateLockStatus(Long lockid, String status);
	
	public LockPriceTL  getLockPrice(String lockKind,String lockModel);
	
	public Long insertLockSales(LockSalesTL lockSalesTL);
	public List<LockTL> getLockSales(Long orderId);
	public List<LockTL> getAgencyLocks(Long userRoleId,Long warehouseId);
	public Long getLockSalesCount(Long orderCreatedBy);
	public Double getLockSalesCost(Long orderCreatedBy);
	public Double getLockSalesCost();
	public Double getLocksCost();
	public Double getLocksCost(List<Long> warehouseIdsList);
	public Long getLockSalesCount();
	public Long getLockSalesCount(String lockModel);
	public Double getLocksCost(String lockModel);
	public Double getLocksCost(List<Long> warehouseIdsList,String lockModel);
	public Long getLockSalesCount(List<Long> warehouseIdsList,
			String lockModel);
	public Long getLockSalesCount(List<Long> warehouseIdsList);
	public Double getLockSalesCost(List<Long> warehouseIdsList);
	public boolean isLockExist(String lockSno);
	public boolean isLockAvailable(String lockSno);
	public Long insertAgencyLockSales(AgencyLockSalesTL agencyLockSalesTL);
	public boolean isAgencyLockAvailable(String lockSno,Long agencyId);
	public List<LockTL> getAgencyLockSales(Long orderId);
	public List<LockTL> getMachineLocks(Long machineId,String status);
	public List<LockTL> getOperatorLocks(Long operatorId);
	public List<LockTL> getOperatorLocks(Long operatorId,String status);
	public Map<String, Object> getLock(String lockSno,Long supplierid);
	public List<LockTL> getLocks(Long machineId,String status);
	/*Calling Center Code*/
	
	public Map<String, Object> getLockIdSales(Long lockId);
	public Map<String, Object> getLockWarehouse(Long orderid);
	public Map<String, Object> getOperatorLockWarehouse(Long orderid);
	
	
	
	
	
	
	

}
