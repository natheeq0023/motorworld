package com.moaddi.dao.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moaddi.dao.LockDAO;
import com.moaddi.dao.model.AgencyLockSalesTL;
import com.moaddi.dao.model.LockPriceTL;
import com.moaddi.dao.model.LockSalesTL;
import com.moaddi.dao.model.LockTL;
import com.moaddi.dao.model.MachinePriceTL;
import com.moaddi.dao.model.MachineSalesTL;
import com.moaddi.dao.model.MachineTL;
import com.moaddi.dao.utility.CustomHibernateDaoSupport;

@Repository("lockDAO")
@Transactional
public class LockDAOImpl extends CustomHibernateDaoSupport implements LockDAO {

	public Long insertLock(LockTL lockTL) {
		Long lockId = 0L;
		lockId = (Long) getHibernateTemplate().save(lockTL);
		return lockId;
	}

	public Long getLockCount() {

		Long lockCount = 0L;
		String hql = "select count(lockId) from LockTL where lockId not in(select lockId from LockSalesTL)";

		List<Long> lockCounts = getHibernateTemplate().find(hql);
		if (lockCounts != null && lockCounts.size() > 0) {
			lockCount = lockCounts.get(0);
		}
		return lockCount;
	}

	public Long getLockCount(List<Long> warehouseIdsList) {
		Long lockCount = 0L;
		String hql = "select count(lockId) from LockTL where lockId not in(select lockId from LockSalesTL) and warehouseId in (:listParam)";

		String[] params = { "listParam" };
		Object[] values = { warehouseIdsList };
		List<Long> lockCounts = getHibernateTemplate().findByNamedParam(hql,
				params, values);
		if (lockCounts != null && lockCounts.size() > 0) {
			lockCount = lockCounts.get(0);
		}
		return lockCount;
	}

	public Long getLockCount(String lockModel) {

		Long lockCount = 0L;
		String hql = "select count(lockId) from LockTL where lockId not in(select lockId from LockSalesTL) and lockModel=?";

		List<Long> lockCounts = getHibernateTemplate().find(hql,
				new Object[] { lockModel });
		if (lockCounts != null && lockCounts.size() > 0) {
			lockCount = lockCounts.get(0);
		}
		return lockCount;
	}

	public Long getLockCount(List<Long> warehouseIdsList, String lockModel) {

		Long lockCount = 0L;
		String hql = "select count(lockId) from LockTL where lockId not in(select lockId from LockSalesTL) and lockModel=:lockModel and warehouseId in (:listParam)";

		String[] params = { "lockModel", "listParam" };
		Object[] values = { lockModel, warehouseIdsList };
		List<Long> lockCounts = getHibernateTemplate().findByNamedParam(hql,
				params, values);
		if (lockCounts != null && lockCounts.size() > 0) {
			lockCount = lockCounts.get(0);
		}
		return lockCount;
	}

	public LockTL getLock(Long lockId) {
		LockTL lockTL = null;
		lockTL = (LockTL) getHibernateTemplate().get(LockTL.class, lockId);
		return lockTL;
	}

	public Map<String, Object> getLock(String lockSNO) {
		Map<String, Object> lock = null;
		if (lockSNO != null && !lockSNO.trim().equals("")) {
			List locks = getHibernateTemplate()
					.find(
							"select lockId,status,lockKind,lockModel,warehouseId from LockTL where lockSno=?",
							new Object[] { lockSNO });
			if (locks != null && locks.size() > 0) {
				Object[] obj = (Object[]) locks.get(0);
				lock = new LinkedHashMap<String, Object>();
				lock.put("id", obj[0]);
				lock.put("status", obj[1]);
				lock.put("lockKind", obj[2]);
				lock.put("lockModel", obj[3]);

				lock.put("warehouseId", obj[4]);

			}

		}
		return lock;
	}

	public Long insertLockPrice(LockPriceTL lockPriceTL) {
		// TODO Auto-generated method stub
		Long lockPriceId = 0L;
		lockPriceId = (Long) getHibernateTemplate().save(lockPriceTL);
		return lockPriceId;
	}

	public List<LockPriceTL> getLockPrices(String lockKind, String lockModel) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find(
				"from LockPriceTL where lockKind=? and lockModel=? ", lockKind,
				lockModel);
	}

	public Long getLockId(String lockSno) {
		// TODO Auto-generated method stub
		Long lockId = null;
		if (lockSno != null && !lockSno.trim().equals("")) {
			List<Long> list = getHibernateTemplate().find(
					"select lockId from LockTL where lockSno=?",
					new Object[] { lockSno.trim() });
			if (list != null && list.size() > 0) {
				lockId = list.get(0);
			}
		}
		return lockId;
	}

	public Integer updateLockStatus(Long lockid, String status) {
		// TODO Auto-generated method stub
		Integer noOfRowsEffected = 0;

		LockTL lockTL = (LockTL) getHibernateTemplate().get(LockTL.class,
				lockid);
		lockTL.setStatus(status);
		getHibernateTemplate().update(lockTL);
		return noOfRowsEffected;
	}

	public LockPriceTL getLockPrice(String lockKind, String lockModel) {
		LockPriceTL lockPrice = null;

		List<LockPriceTL> price = getHibernateTemplate()
				.find(
						"from LockPriceTL where lockPriceId=(select max(lockPriceId) from LockPriceTL where lockKind=? and lockModel=?)",
						new Object[] { lockKind, lockModel });
		if (price != null && price.size() > 0) {
			lockPrice = price.get(0);
		}

		return lockPrice;
	}

	public Long insertLockSales(LockSalesTL lockSalesTL) {

		return (Long) getHibernateTemplate().save(lockSalesTL);
	}

	public List<LockTL> getLockSales(Long orderId) {

		return getHibernateTemplate()
				.find(
						"from LockTL where lockId in(select lockId from LockSalesTL where orderId=?)",
						new Object[] { orderId });
	}

	public List<LockTL> getAgencyLocks(Long userRoleId, Long warehouseId) {
		return getHibernateTemplate()
				.find(
						"from LockTL where lockId in(select lockId from LockSalesTL where orderId in(select orderId from OrderTL where createdBy=? and warehouseId=? ))",
						new Object[] { userRoleId, warehouseId });

	}

	public Long getLockSalesCount(Long orderCreatedBy) {
		String hql = "select count(lockId) from LockTL where lockId in(select lockId from LockSalesTL where orderId in(select orderId from OrderTL where createdBy=?))";
		List<Long> counts = getHibernateTemplate().find(hql,
				new Object[] { orderCreatedBy });
		if (counts != null && counts.size() > 0) {
			return counts.get(0);

		} else {
			return 0L;
		}

	}

	public Double getLockSalesCost(Long orderCreatedBy) {
		double cost = 0;
		List<Long> lockIds = getHibernateTemplate()
				.find(
						"select lockId from LockSalesTL where orderId in(select orderId from OrderTL where createdBy=?)",
						new Object[] { orderCreatedBy });
		if (lockIds != null && lockIds.size() > 0) {
			ListIterator<Long> li = lockIds.listIterator();
			while (li.hasNext()) {
				Long lockId = li.next();
				List<Object[]> lockCost = getHibernateTemplate()
						.find(
								"select lp.price,lp.discount from LockPriceTL lp,LockTL l  where lp.lockKind=l.lockKind and lp.lockModel=l.lockModel and l.lockId=? order by lp.lockPriceId desc",
								new Object[] { lockId });
				if (lockCost != null && lockCost.size() > 0) {
					ListIterator<Object[]> lcostLi = lockCost.listIterator();
					while (lcostLi.hasNext()) {
						Object[] lcost = lcostLi.next();
						Double price = (Double) lcost[0];
						Double discount = (Double) lcost[1];
						Double discountAmount = price * (discount / 100);
						Double finalPrice = price - discountAmount;
						cost = cost + finalPrice;

					}
				}
			}

		}
		return cost;
	}

	public Double getLocksCost() {
		double cost = 0;
		List<Object[]> locks = getHibernateTemplate()
				.find(
						"select count(lockId),lockKind,lockModel from LockTL where lockId not in(select lockId from LockSalesTL) group by lockKind,lockModel");
		if (locks != null && locks.size() > 0) {
			ListIterator<Object[]> li = locks.listIterator();
			while (li.hasNext()) {
				Object[] obj = li.next();
				List<Double> lockCost = getHibernateTemplate()
						.find(
								"select price-(price*discount/100)  from LockPriceTL where lockPriceId in(select max(lockPriceId) from LockPriceTL where lockKind=? and lockModel=?)",
								new Object[] { obj[1], obj[2] });
				if (lockCost != null && lockCost.size() > 0) {
					cost = cost + ((Long) obj[0] * lockCost.get(0));
				}
			}
		}

		return cost;
	}

	public Double getLocksCost(List<Long> warehouseIdsList) {
		double cost = 0;
		String[] params = { "listParam" };
		Object[] values = { warehouseIdsList };
		List<Object[]> locks = getHibernateTemplate()
				.findByNamedParam(
						"select count(lockId),lockKind,lockModel from LockTL where warehouseId in(:listParam) and lockId not in(select lockId from LockSalesTL) group by lockKind,lockModel",
						params, values);
		if (locks != null && locks.size() > 0) {
			ListIterator<Object[]> li = locks.listIterator();
			while (li.hasNext()) {
				Object[] obj = li.next();
				List<Double> lockCost = getHibernateTemplate()
						.find(
								"select price-(price*discount/100)  from LockPriceTL where lockPriceId in(select max(lockPriceId) from LockPriceTL where lockKind=? and lockModel=?)",
								new Object[] { obj[1], obj[2] });
				if (lockCost != null && lockCost.size() > 0) {
					cost = cost + ((Long) obj[0] * lockCost.get(0));
				}
			}
		}

		return cost;
	}

	public Long getLockSalesCount() {
		List<Long> counts = getHibernateTemplate().find(
				"select count(LockSalesId) from LockSalesTL");
		if (counts != null && counts.size() > 0) {
			return counts.get(0);
		} else {
			return 0L;
		}

	}

	public Long getLockSalesCount(String lockModel) {
		List<Long> counts = getHibernateTemplate()
				.find(
						"select count(LockSalesId) from LockSalesTL where lockId in (select lockId from LockTL where  lockModel=?)",
						new Object[] { lockModel });
		if (counts != null && counts.size() > 0) {
			return counts.get(0);
		} else {
			return 0L;
		}

	}

	public Double getLocksCost(String lockModel) {
		double cost = 0;
		List<Object[]> locks = getHibernateTemplate()
				.find(
						"select count(lockId),lockKind,lockModel from LockTL  where lockModel='"
								+ lockModel
								+ "' and lockId not in(select lockId from LockSalesTL) group by lockKind,lockModel");
		if (locks != null && locks.size() > 0) {
			ListIterator<Object[]> li = locks.listIterator();
			while (li.hasNext()) {
				Object[] obj = li.next();
				List<Double> lockCost = getHibernateTemplate()
						.find(
								"select price-(price*discount/100)  from LockPriceTL where lockPriceId in(select max(lockPriceId) from LockPriceTL where lockKind=? and lockModel=?)",
								new Object[] { obj[1], obj[2] });
				if (lockCost != null && lockCost.size() > 0) {
					cost = cost + ((Long) obj[0] * lockCost.get(0));
				}
			}
		}

		return cost;
	}

	public Double getLocksCost(List<Long> warehouseIdsList, String lockModel) {
		double cost = 0;
		String[] params = { "listParam" };
		Object[] values = { warehouseIdsList };
		List<Object[]> locks = getHibernateTemplate()
				.findByNamedParam(
						"select count(lockId),lockKind,lockModel from LockTL where lockModel='"
								+ lockModel
								+ "' and warehouseId in(:listParam) and lockId not in(select lockId from LockSalesTL) group by lockKind,lockModel",
						params, values);
		if (locks != null && locks.size() > 0) {
			ListIterator<Object[]> li = locks.listIterator();
			while (li.hasNext()) {
				Object[] obj = li.next();
				List<Double> lockCost = getHibernateTemplate()
						.find(
								"select price-(price*discount/100)  from LockPriceTL where lockPriceId in(select max(lockPriceId) from LockPriceTL where lockKind=? and lockModel=?)",
								new Object[] { obj[1], obj[2] });
				if (lockCost != null && lockCost.size() > 0) {
					cost = cost + ((Long) obj[0] * lockCost.get(0));
				}
			}
		}

		return cost;
	}

	public Long getLockSalesCount(List<Long> warehouseIdsList, String lockModel) {

		String[] params = { "listParam" };
		Object[] values = { warehouseIdsList };
		List<Long> counts = getHibernateTemplate()
				.findByNamedParam(
						"select count(LockSalesId) from LockSalesTL where  lockId in (select lockId from LockTL where warehouseId in (:listParam) and lockModel='"
								+ lockModel + "')", params, values);
		if (counts != null && counts.size() > 0) {
			return counts.get(0);
		} else {
			return 0L;
		}

	}

	public Long getLockSalesCount(List<Long> warehouseIdsList) {
		String[] params = { "listParam" };
		Object[] values = { warehouseIdsList };
		List<Long> counts = getHibernateTemplate()
				.findByNamedParam(
						"select count(LockSalesId) from LockSalesTL where lockId in (select lockId from LockTL where warehouseId in (:listParam))",
						params, values);
		if (counts != null && counts.size() > 0) {
			return counts.get(0);
		} else {
			return 0L;
		}

	}

	public Double getLockSalesCost() {
		double cost = 0;
		List<Long> lockIds = getHibernateTemplate()
				.find(
						"select lockId from LockSalesTL where orderId in(select orderId from OrderTL)");
		if (lockIds != null && lockIds.size() > 0) {
			ListIterator<Long> li = lockIds.listIterator();
			while (li.hasNext()) {
				Long lockId = li.next();
				List<Object[]> lockCost = getHibernateTemplate()
						.find(
								"select lp.price,lp.discount from LockPriceTL lp,LockTL l  where lp.lockKind=l.lockKind and lp.lockModel=l.lockModel and l.lockId=? order by lp.lockPriceId desc",
								new Object[] { lockId });
				if (lockCost != null && lockCost.size() > 0) {
					ListIterator<Object[]> lcostLi = lockCost.listIterator();
					while (lcostLi.hasNext()) {
						Object[] lcost = lcostLi.next();
						Double price = (Double) lcost[0];
						Double discount = (Double) lcost[1];
						Double discountAmount = price * (discount / 100);
						Double finalPrice = price - discountAmount;
						cost = cost + finalPrice;

					}
				}
			}

		}
		return cost;

	}

	public Double getLockSalesCost(List<Long> warehouseIdsList) {
		double cost = 0;
		List<Long> lockIds = getHibernateTemplate().find(
				"select lockId from LockSalesTL");
		if (lockIds != null && lockIds.size() > 0) {
			ListIterator<Long> li = lockIds.listIterator();
			while (li.hasNext()) {
				Long lockId = li.next();
				String[] params = { "listParam" };
				Object[] values = { warehouseIdsList };
				List<Object[]> lockCost = getHibernateTemplate()
						.findByNamedParam(
								"select mp.price,mp.discount from LockPriceTL mp,LockTL m  where  m.warehouseId in(:listParam) and mp.lockKind=m.lockKind and mp.lockModel=m.lockModel and m.lockId="
										+ lockId + " order by lockPriceId desc",
								params, values);
				if (lockCost != null && lockCost.size() > 0) {
					ListIterator<Object[]> mcostLi = lockCost.listIterator();
					while (mcostLi.hasNext()) {
						Object[] mcost = mcostLi.next();
						Double price = (Double) mcost[0];
						Double discount = (Double) mcost[1];
						Double discountAmount = price * (discount / 100);
						Double finalPrice = price - discountAmount;
						cost = cost + finalPrice;

					}
				}
			}

		}
		return cost;
	}

	public boolean isLockExist(String lockSno) {

		boolean isExists = false;
		List locks = getHibernateTemplate().find("from LockTL where lockSno=?",
				new Object[] { lockSno });
		if (locks != null && locks.size() > 0) {
			isExists = true;
		}

		return isExists;
	}

	public boolean isLockAvailable(String lockSno) {
		boolean isExists = false;
		List locks = getHibernateTemplate()
				.find(
						"from LockTL where  lockSno=? and  lockId not in(select lockId from LockSalesTL where lockId in(select lockId from LockTL where lockSno=?))",
						new Object[] { lockSno, lockSno });
		if (locks != null && locks.size() > 0) {
			isExists = true;
		}

		return isExists;
	}

	public Long insertAgencyLockSales(AgencyLockSalesTL agencyLockSalesTL) {

		return (Long) getHibernateTemplate().save(agencyLockSalesTL);
	}

	public boolean isAgencyLockAvailable(String lockSno, Long agencyId) {
		boolean isExists = false;
		List machines = getHibernateTemplate()
				.find(
						"select lockId from LockSalesTL where lockId in(select lockId from LockTL where lockSno=?) and   lockId not in(select lockId from AgencyLockSalesTL where lockId in(select lockId from LockTL where lockSno=?))  and orderId in(select orderId from OrderTL where createdBy=?)",
						new Object[] { lockSno, lockSno, agencyId });
		if (machines != null && machines.size() > 0) {
			isExists = true;
		}

		return isExists;
	}

	public List<LockTL> getAgencyLockSales(Long orderId) {

		return getHibernateTemplate()
				.find(
						"from LockTL where lockId in(select lockId from AgencyLockSalesTL where orderId=?)",
						new Object[] { orderId });
	}

	public List<LockTL> getMachineLocks(Long machineId, String status) {
		List<LockTL> locks = null;
		locks = getHibernateTemplate()
				.find(
						"from LockTL where lockId in(select lockId from MachineLockTL where machineId=? and status=?)",
						new Object[] { machineId, status });
		return locks;
	}

	public List<LockTL> getOperatorLocks(Long operatorId) {

		List<LockTL> locks = null;
		locks = getHibernateTemplate()
				.find(
						"from LockTL where lockId in(select lockId from AgencyLockSalesTL where orderId in(select orderId from OperatorOrderTL where createdBy=?))",
						new Object[] { operatorId });
		return locks;
	}

	public List<LockTL> getOperatorLocks(Long operatorId, String status) {
		List<LockTL> locks = null;
		locks = getHibernateTemplate()
				.find(
						"from LockTL where lockId in(select lockId from AgencyLockSalesTL where orderId in(select orderId from OperatorOrderTL where createdBy=?) and lockId not in(select  lockId from MachineLockTL where status=?))",
						new Object[] { operatorId ,status});
		return locks;
	}

	public Map<String, Object> getLock(String lockSno, Long supplierid) {
		Map<String, Object> lock = null;
		if (lockSno != null && !lockSno.trim().equals("")) {
			List locks = getHibernateTemplate()
					.find(
							"select lockId,lockKind,lockModel from LockTL where lockSno=? and lockId in (select lockId from MachineLockTL where status='Connected' and machineId in(select machineId from MachineSupplierTL where supplierId=?))",
							new Object[] { lockSno,supplierid });
			if (locks != null && locks.size() > 0) {
				Object[] obj = (Object[]) locks.get(0);
				lock = new LinkedHashMap<String, Object>();
				lock.put("lockId", obj[0]);
				lock.put("lockKind", obj[1]);
				lock.put("lockModel", obj[2]);
		}

		}
		return lock;
	}

	public List<LockTL> getLocks(Long machineId, String status) {
		List<LockTL> locks=null;
		locks=getHibernateTemplate().find("from LockTL where lockId in(select lockId from MachineLockTL where machineId=? and status=?)",new Object[]{machineId,status});
		return locks;
	}

	@Override
	public Map<String, Object> getLockIdSales(Long lockId) {
		Map<String, Object> lock = null;
		if (lockId != null ) {
			List locks = getHibernateTemplate()
					.find(
							"select lockSalesId,orderId from LockSalesTL where lockId=?",
							new Object[] { lockId });
			if (locks != null && locks.size() > 0) {
				Object[] obj = (Object[]) locks.get(0);
				lock = new LinkedHashMap<String, Object>();
				lock.put("lockSalesId", obj[0]);
				lock.put("orderId", obj[1]);
			
			}

		}
		return lock;
	}

	@Override
	public Map<String, Object> getLockWarehouse(Long orderid) {
		// TODO Auto-generated method stub
		Map<String, Object> lock = null;
		if (orderid != null ) {
			List locks = getHibernateTemplate()
					.find(
							"select status,warehouseId from OrderTL where orderId=?",
							new Object[] { orderid });
			if (locks != null && locks.size() > 0) {
				Object[] obj = (Object[]) locks.get(0);
				lock = new LinkedHashMap<String, Object>();
				lock.put("status", obj[0]);
				lock.put("warehouseId", obj[1]);
			
			}

		}
		return lock;
	}

	@Override
	public Map<String, Object> getOperatorLockWarehouse(Long orderid) {
		Map<String, Object> lock = null;
		if (orderid != null ) {
			List locks = getHibernateTemplate()
					.find(
							"select status,warehouseId from OperatorOrderTL where orderId=?",
							new Object[] { orderid });
			if (locks != null && locks.size() > 0) {
				Object[] obj = (Object[]) locks.get(0);
				lock = new LinkedHashMap<String, Object>();
				lock.put("status", obj[0]);
				lock.put("warehouseId", obj[1]);
			
			}

		}
		return lock;
	}

}
