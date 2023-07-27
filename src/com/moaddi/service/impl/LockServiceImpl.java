package com.moaddi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moaddi.dao.LockDAO;
import com.moaddi.dao.model.AgencyLockSalesTL;
import com.moaddi.dao.model.ItemLockDTO;
import com.moaddi.dao.model.LockPriceTL;
import com.moaddi.dao.model.LockSalesTL;
import com.moaddi.dao.model.LockTL;
import com.moaddi.dao.model.MachinePriceTL;
import com.moaddi.dao.model.MachineSalesTL;
import com.moaddi.dao.model.MachineTL;
import com.moaddi.service.LockService;
import com.moaddi.service.dto.LockDTO;
import com.moaddi.service.dto.LockPriceDTO;
import com.moaddi.service.dto.LockSalesDTO;
import com.moaddi.service.dto.MachineDTO;
import com.moaddi.service.dto.MachinePriceDTO;

@Service("lockService")
public class LockServiceImpl implements LockService {

	@Autowired
	private LockDAO lockDAO;

	public Long saveLock(LockDTO lockDTO) {
		Long lockId = 0L;
		if (lockDTO != null) {
			LockTL lockTL = new LockTL();
			lockTL.setCreatedBy(lockDTO.getCreatedBy());
			lockTL.setCreatedOn(new java.sql.Date(new java.util.Date()
					.getTime()));
			lockTL.setLockColour(lockDTO.getLockColour());
			lockTL.setLockDepth(lockDTO.getLockDepth());
			lockTL.setLockHeight(lockDTO.getLockHeight());
			lockTL.setLockKind(lockDTO.getLockKind());
			lockTL.setLockModel(lockDTO.getLockModel());
			lockTL.setLockPhotoName(lockDTO.getLockPhotoName());
			lockTL.setLockSno(lockDTO.getLockSno());
			lockTL.setLockWeight(lockDTO.getLockWeight());
			lockTL.setLockWidth(lockDTO.getLockWidth());
			lockTL.setStatus(lockDTO.getStatus());
			lockTL.setWarehouseId(lockDTO.getWarehouseId());
			lockId = lockDAO.insertLock(lockTL);
		}
		return lockId;
	}

	public Long loadLockCount() {

		return lockDAO.getLockCount();
	}

	public Long loadLockCount(List<Long> warehouseIdsList) {

		return lockDAO.getLockCount(warehouseIdsList);
	}

	public Long loadLockCount(List<Long> warehouseIdsList, String lockModel) {

		return lockDAO.getLockCount(warehouseIdsList, lockModel);
	}

	public Long loadLockCount(String lockModel) {

		return lockDAO.getLockCount(lockModel);
	}

	public LockDTO loadLock(Long lockId) {
		LockDTO lockDTO = null;
		LockTL lock = lockDAO.getLock(lockId);
		if (lock != null) {
			lockDTO = new LockDTO();
			lockDTO.setCreatedBy(lock.getCreatedBy());
			lockDTO.setCreatedOn(lock.getCreatedOn());
			lockDTO.setLockColour(lock.getLockColour());
			lockDTO.setLockDepth(lock.getLockDepth());
			lockDTO.setLockHeight(lock.getLockHeight());
			lockDTO.setLockKind(lock.getLockKind());
			lockDTO.setLockModel(lock.getLockModel());
			lockDTO.setLockPhotoName(lock.getLockPhotoName());
			lockDTO.setLockSno(lock.getLockSno());
			lockDTO.setLockWeight(lock.getLockWeight());
			lockDTO.setLockWidth(lock.getLockWidth());
			lockDTO.setStatus(lock.getStatus());
			lockDTO.setWarehouseId(lock.getWarehouseId());
			lockDTO.setLockId(lock.getLockId());
		}
		return lockDTO;
	}

	public Map<String, Object> loadLock(String lockSNO) {

		return lockDAO.getLock(lockSNO);
	}

	public Long saveLockPrice(LockPriceDTO lockPriceDTO) {
		// TODO Auto-generated method stub
		Long lockPriceId = 0L;
		if (lockPriceDTO != null) {
			LockPriceTL lockPriceTL = new LockPriceTL();
			lockPriceTL.setCreatedOn(new java.sql.Date(new java.util.Date()
					.getTime()));
			lockPriceTL.setDiscount(lockPriceDTO.getDiscount());
			lockPriceTL.setFromDate(new java.sql.Date(lockPriceDTO
					.getFromDate().getTime()));
			lockPriceTL.setLockKind(lockPriceDTO.getLockKind());
			lockPriceTL.setLockModel(lockPriceDTO.getLockModel());
			lockPriceTL.setPrice(lockPriceDTO.getPrice());
			lockPriceTL.setToDate(new java.sql.Date(lockPriceDTO.getToDate()
					.getTime()));
			lockPriceId = lockDAO.insertLockPrice(lockPriceTL);

		}
		return lockPriceId;
	}

	public Long loadLockId(String lockSno) {
		// TODO Auto-generated method stub
		return lockDAO.getLockId(lockSno);
	}

	public List<LockPriceDTO> loadLockPrices(String lockKind, String lockModel) {
		// TODO Auto-generated method stub
		List<LockPriceDTO> prices = null;
		if (lockModel != null) {
			List<LockPriceTL> mprices = lockDAO.getLockPrices(lockKind,
					lockModel);
			if (mprices != null && mprices.size() > 0) {
				prices = new ArrayList<LockPriceDTO>();
				ListIterator<LockPriceTL> li = mprices.listIterator();
				while (li.hasNext()) {
					LockPriceTL lockPrice = li.next();
					LockPriceDTO lockPriceDTO = new LockPriceDTO();
					lockPriceDTO.setCreatedOn(lockPrice.getCreatedOn());
					lockPriceDTO.setDiscount(lockPrice.getDiscount());
					lockPriceDTO.setFromDate(lockPrice.getFromDate());
					lockPriceDTO.setLockKind(lockPrice.getLockKind());
					lockPriceDTO.setLockModel(lockPrice.getLockModel());
					lockPriceDTO.setPrice(lockPrice.getPrice());
					lockPriceDTO.setToDate(lockPrice.getToDate());
					lockPriceDTO.setLockPriceId(lockPrice.getLockPriceId());
					prices.add(lockPriceDTO);

				}

			}

		}
		return prices;
	}

	public Integer modifyLockStatus(Long lockid, String status) {
		// TODO Auto-generated method stub
		return lockDAO.updateLockStatus(lockid, status);
	}

	public LockPriceDTO loadLockPrice(String lockKind, String lockModel) {
		LockPriceDTO lockPriceDTO = null;
		LockPriceTL lockPrice = lockDAO.getLockPrice(lockKind, lockModel);
		if (lockPrice != null) {
			lockPriceDTO = new LockPriceDTO();
			lockPriceDTO.setCreatedOn(lockPrice.getCreatedOn());
			lockPriceDTO.setDiscount(lockPrice.getDiscount());
			lockPriceDTO.setFromDate(lockPrice.getFromDate());
			lockPriceDTO.setLockKind(lockPrice.getLockKind());
			lockPriceDTO.setLockModel(lockPrice.getLockModel());
			lockPriceDTO.setPrice(lockPrice.getPrice());
			lockPriceDTO.setToDate(lockPrice.getToDate());
			lockPriceDTO.setLockPriceId(lockPrice.getLockPriceId());

		}
		return lockPriceDTO;
	}

	public List<LockDTO> loadLockSales(Long orderId) {

		List<LockDTO> locks = null;
		List<LockTL> llocks = lockDAO.getLockSales(orderId);
		if (llocks != null && llocks.size() > 0) {
			locks = new ArrayList<LockDTO>();
			ListIterator<LockTL> li = llocks.listIterator();
			while (li.hasNext()) {
				LockTL lock = li.next();
				LockDTO lockDTO = new LockDTO();
				lockDTO.setLockColour(lock.getLockColour());
				lockDTO.setCreatedBy(lock.getCreatedBy());
				lockDTO.setCreatedOn(lock.getCreatedOn());
				lockDTO.setLockColour(lock.getLockColour());
				lockDTO.setLockDepth(lock.getLockDepth());
				lockDTO.setLockHeight(lock.getLockHeight());
				lockDTO.setLockKind(lock.getLockKind());
				lockDTO.setLockModel(lock.getLockModel());
				lockDTO.setLockPhotoName(lock.getLockPhotoName());
				lockDTO.setLockSno(lock.getLockSno());
				lockDTO.setLockWeight(lock.getLockWeight());
				lockDTO.setLockWidth(lock.getLockWidth());
				lockDTO.setStatus(lock.getStatus());
				lockDTO.setWarehouseId(lock.getWarehouseId());
				lockDTO.setLockId(lock.getLockId());

				locks.add(lockDTO);

			}

		}
		return locks;
	}

	public Long saveLockSales(LockSalesDTO lockSalesDTO) {
		Long lockSalesId = null;
		if (lockSalesDTO != null) {
			LockSalesTL lockSalesTL = new LockSalesTL();
			lockSalesTL.setCreatedOn(new java.sql.Date(new java.util.Date()
					.getTime()));
			lockSalesTL.setLockId(lockSalesDTO.getLockId());
			lockSalesTL.setOrderId(lockSalesDTO.getOrderId());
			lockSalesId = lockDAO.insertLockSales(lockSalesTL);
		}
		return lockSalesId;
	}

	public List<LockDTO> loadAgencyLocks(Long userRoleId, Long warehouseId) {
		List<LockDTO> locks = null;
		List<LockTL> llocks = lockDAO.getAgencyLocks(userRoleId, warehouseId);
		if (llocks != null && llocks.size() > 0) {
			locks = new ArrayList<LockDTO>();
			ListIterator<LockTL> li = llocks.listIterator();
			while (li.hasNext()) {
				LockTL lock = li.next();
				LockDTO lockDTO = new LockDTO();
				lockDTO.setLockColour(lock.getLockColour());
				lockDTO.setCreatedBy(lock.getCreatedBy());
				lockDTO.setCreatedOn(lock.getCreatedOn());
				lockDTO.setLockColour(lock.getLockColour());
				lockDTO.setLockDepth(lock.getLockDepth());
				lockDTO.setLockHeight(lock.getLockHeight());
				lockDTO.setLockKind(lock.getLockKind());
				lockDTO.setLockModel(lock.getLockModel());
				lockDTO.setLockPhotoName(lock.getLockPhotoName());
				lockDTO.setLockSno(lock.getLockSno());
				lockDTO.setLockWeight(lock.getLockWeight());
				lockDTO.setLockWidth(lock.getLockWidth());
				lockDTO.setStatus(lock.getStatus());
				lockDTO.setWarehouseId(lock.getWarehouseId());
				lockDTO.setLockId(lock.getLockId());

				locks.add(lockDTO);

			}

		}
		return locks;
	}

	public Long loadLockSalesCount(Long orderCreatedBy) {
		return lockDAO.getLockSalesCount(orderCreatedBy);
	}

	public Double loadLockSalesCost(Long orderCreatedBy) {

		return lockDAO.getLockSalesCost(orderCreatedBy);
	}

	public Double loadLocksCost() {
		return lockDAO.getLocksCost();
	}

	public Double loadLocksCost(List<Long> warehouseIdsList) {

		return lockDAO.getLocksCost(warehouseIdsList);
	}

	public Long loadLockSalesCount() {

		return lockDAO.getLockSalesCount();
	}

	public Long loadLockSalesCount(String lockModel) {

		return lockDAO.getLockSalesCount(lockModel);
	}

	public Double loadLocksCost(String lockModel) {

		return lockDAO.getLocksCost(lockModel);
	}

	public Double loadLocksCost(List<Long> warehouseIdsList, String lockModel) {
		return lockDAO.getLocksCost(warehouseIdsList, lockModel);
	}

	public Long loadLockSalesCount(List<Long> warehouseIdsList, String lockModel) {

		return lockDAO.getLockSalesCount(warehouseIdsList, lockModel);
	}

	public Long loadLockSalesCount(List<Long> warehouseIdsList) {

		return lockDAO.getLockSalesCount(warehouseIdsList);
	}

	public Double loadLockSalesCost() {

		return lockDAO.getLockSalesCost();
	}

	public Double loadLockSalesCost(List<Long> warehouseIdsList) {

		return lockDAO.getLockSalesCost(warehouseIdsList);
	}

	public boolean isLockExist(String lockSno) {
		return lockDAO.isLockExist(lockSno);
	}

	public boolean isLockAvailable(String lockSno) {

		return lockDAO.isLockAvailable(lockSno);
	}

	public Long saveAgencyLockSales(LockSalesDTO lockSalesDTO) {
		Long lockSalesId = null;
		if (lockSalesDTO != null) {
			AgencyLockSalesTL lockSalesTL = new AgencyLockSalesTL();
			lockSalesTL.setCreatedOn(new java.sql.Date(new java.util.Date()
					.getTime()));
			lockSalesTL.setLockId(lockSalesDTO.getLockId());
			lockSalesTL.setOrderId(lockSalesDTO.getOrderId());
			lockSalesId = lockDAO.insertAgencyLockSales(lockSalesTL);
		}
		return lockSalesId;
	}

	public boolean isAgencyLockAvailable(String lockSno, Long agencyId) {
		return lockDAO.isAgencyLockAvailable(lockSno, agencyId);
	}

	public List<LockDTO> loadAgencyLockSales(Long orderId) {

		List<LockDTO> locks = null;
		List<LockTL> llocks = lockDAO.getAgencyLockSales(orderId);
		if (llocks != null && llocks.size() > 0) {
			locks = new ArrayList<LockDTO>();
			ListIterator<LockTL> li = llocks.listIterator();
			while (li.hasNext()) {
				LockTL lock = li.next();
				LockDTO lockDTO = new LockDTO();
				lockDTO.setLockColour(lock.getLockColour());
				lockDTO.setCreatedBy(lock.getCreatedBy());
				lockDTO.setCreatedOn(lock.getCreatedOn());
				lockDTO.setLockColour(lock.getLockColour());
				lockDTO.setLockDepth(lock.getLockDepth());
				lockDTO.setLockHeight(lock.getLockHeight());
				lockDTO.setLockKind(lock.getLockKind());
				lockDTO.setLockModel(lock.getLockModel());
				lockDTO.setLockPhotoName(lock.getLockPhotoName());
				lockDTO.setLockSno(lock.getLockSno());
				lockDTO.setLockWeight(lock.getLockWeight());
				lockDTO.setLockWidth(lock.getLockWidth());
				lockDTO.setStatus(lock.getStatus());
				lockDTO.setWarehouseId(lock.getWarehouseId());
				lockDTO.setLockId(lock.getLockId());

				locks.add(lockDTO);

			}

		}
		return locks;
	}

	public List<LockDTO> loadMachineLocks(Long machineId, String status) {
		List<LockDTO> locks = null;
		List<LockTL> llocks = lockDAO.getMachineLocks(machineId, status);
		if (llocks != null && llocks.size() > 0) {
			locks = new ArrayList<LockDTO>();
			ListIterator<LockTL> li = llocks.listIterator();
			while (li.hasNext()) {
				LockTL lock = li.next();
				LockDTO lockDTO = new LockDTO();
				lockDTO.setLockColour(lock.getLockColour());
				lockDTO.setCreatedBy(lock.getCreatedBy());
				lockDTO.setCreatedOn(lock.getCreatedOn());
				lockDTO.setLockColour(lock.getLockColour());
				lockDTO.setLockDepth(lock.getLockDepth());
				lockDTO.setLockHeight(lock.getLockHeight());
				lockDTO.setLockKind(lock.getLockKind());
				lockDTO.setLockModel(lock.getLockModel());
				lockDTO.setLockPhotoName(lock.getLockPhotoName());
				lockDTO.setLockSno(lock.getLockSno());
				lockDTO.setLockWeight(lock.getLockWeight());
				lockDTO.setLockWidth(lock.getLockWidth());
				lockDTO.setStatus(lock.getStatus());
				lockDTO.setWarehouseId(lock.getWarehouseId());
				lockDTO.setLockId(lock.getLockId());

				locks.add(lockDTO);

			}

		}
		return locks;
	}

	public List<LockDTO> loadOperatorLocks(Long operatorId) {
		List<LockDTO> locks = null;
		List<LockTL> llocks = lockDAO.getOperatorLocks(operatorId);
		if (llocks != null && llocks.size() > 0) {
			locks = new ArrayList<LockDTO>();
			ListIterator<LockTL> li = llocks.listIterator();
			while (li.hasNext()) {
				LockTL lock = li.next();
				LockDTO lockDTO = new LockDTO();
				lockDTO.setLockColour(lock.getLockColour());
				lockDTO.setCreatedBy(lock.getCreatedBy());
				lockDTO.setCreatedOn(lock.getCreatedOn());
				lockDTO.setLockColour(lock.getLockColour());
				lockDTO.setLockDepth(lock.getLockDepth());
				lockDTO.setLockHeight(lock.getLockHeight());
				lockDTO.setLockKind(lock.getLockKind());
				lockDTO.setLockModel(lock.getLockModel());
				lockDTO.setLockPhotoName(lock.getLockPhotoName());
				lockDTO.setLockSno(lock.getLockSno());
				lockDTO.setLockWeight(lock.getLockWeight());
				lockDTO.setLockWidth(lock.getLockWidth());
				lockDTO.setStatus(lock.getStatus());
				lockDTO.setWarehouseId(lock.getWarehouseId());
				lockDTO.setLockId(lock.getLockId());

				locks.add(lockDTO);

			}

		}
		return locks;
	}

	public List<LockDTO> loadOperatorLocks(Long operatorId, String status) {
		List<LockDTO> locks = null;
		List<LockTL> llocks = lockDAO.getOperatorLocks(operatorId,status);
		if (llocks != null && llocks.size() > 0) {
			locks = new ArrayList<LockDTO>();
			ListIterator<LockTL> li = llocks.listIterator();
			while (li.hasNext()) {
				LockTL lock = li.next();
				LockDTO lockDTO = new LockDTO();
				lockDTO.setLockColour(lock.getLockColour());
				lockDTO.setCreatedBy(lock.getCreatedBy());
				lockDTO.setCreatedOn(lock.getCreatedOn());
				lockDTO.setLockColour(lock.getLockColour());
				lockDTO.setLockDepth(lock.getLockDepth());
				lockDTO.setLockHeight(lock.getLockHeight());
				lockDTO.setLockKind(lock.getLockKind());
				lockDTO.setLockModel(lock.getLockModel());
				lockDTO.setLockPhotoName(lock.getLockPhotoName());
				lockDTO.setLockSno(lock.getLockSno());
				lockDTO.setLockWeight(lock.getLockWeight());
				lockDTO.setLockWidth(lock.getLockWidth());
				lockDTO.setStatus(lock.getStatus());
				lockDTO.setWarehouseId(lock.getWarehouseId());
				lockDTO.setLockId(lock.getLockId());

				locks.add(lockDTO);

			}

		}
		return locks;
	}

	public Map<String, Object> loadLock(String lockSno, Long supplierid) {
		
		return lockDAO.getLock(lockSno, supplierid);
	}

	public List<LockDTO> loadLocks(Long machineId, String status) {
		List<LockDTO> locks=null;
		List<LockTL> lcks=lockDAO.getLocks(machineId, status);
		if(lcks!=null && lcks.size()>0)
		{
			locks=new ArrayList<LockDTO>();
			ListIterator<LockTL> li = lcks.listIterator();
			while (li.hasNext()) {
				LockTL lock = li.next();
				LockDTO lockDTO = new LockDTO();
				lockDTO.setLockColour(lock.getLockColour());
				lockDTO.setCreatedBy(lock.getCreatedBy());
				lockDTO.setCreatedOn(lock.getCreatedOn());
				lockDTO.setLockColour(lock.getLockColour());
				lockDTO.setLockDepth(lock.getLockDepth());
				lockDTO.setLockHeight(lock.getLockHeight());
				lockDTO.setLockKind(lock.getLockKind());
				lockDTO.setLockModel(lock.getLockModel());
				lockDTO.setLockPhotoName(lock.getLockPhotoName());
				lockDTO.setLockSno(lock.getLockSno());
				lockDTO.setLockWeight(lock.getLockWeight());
				lockDTO.setLockWidth(lock.getLockWidth());
				lockDTO.setStatus(lock.getStatus());
				lockDTO.setWarehouseId(lock.getWarehouseId());
				lockDTO.setLockId(lock.getLockId());

				locks.add(lockDTO);
			}
		}
		return locks;
	}

	@Override
	public Map<String, Object> loadLockIdSales(Long lockId) {
		// TODO Auto-generated method stub
		 return lockDAO.getLockIdSales(lockId);
	}

	@Override
	public Map<String, Object> loadLockIdWarehouse(Long orderid) {
		// TODO Auto-generated method stub
		return lockDAO.getLockWarehouse(orderid);
	}

	@Override
	public Map<String, Object> LoadInOperatorLockIdWarehouse(Long orderid) {
		// TODO Auto-generated method stub
		return lockDAO.getOperatorLockWarehouse(orderid);
	}

	

}
