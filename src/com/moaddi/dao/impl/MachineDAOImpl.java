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

import com.moaddi.dao.MachineDAO;
import com.moaddi.dao.model.AgencyMachineSalesTL;
import com.moaddi.dao.model.LockTL;
import com.moaddi.dao.model.MachineLockTL;
import com.moaddi.dao.model.MachinePartnerTL;
import com.moaddi.dao.model.MachinePriceTL;
import com.moaddi.dao.model.MachineSalesTL;
import com.moaddi.dao.model.MachineSupplierTL;
import com.moaddi.dao.model.MachineTL;
import com.moaddi.dao.model.OperatorOrderDetailsTL;
import com.moaddi.dao.model.OperatorOrderTL;
import com.moaddi.dao.model.OrderDetailsTL;
import com.moaddi.dao.model.OrderTL;
import com.moaddi.dao.utility.CustomHibernateDaoSupport;

@Repository("machineDAO")
@Transactional
public class MachineDAOImpl extends CustomHibernateDaoSupport implements
		MachineDAO {

	public Long insertMachine(MachineTL machineTL) {
		Long machineId = 0L;
		machineId = (Long) getHibernateTemplate().save(machineTL);
		return machineId;
	}

	public Long getMachineCount() {
		Long machineCount = 0L;
		String hql = "select count(machineId) from MachineTL where machineId not in(select machineId from MachineSalesTL)";

		List<Long> machineCounts = getHibernateTemplate().find(hql);
		if (machineCounts != null && machineCounts.size() > 0) {
			machineCount = machineCounts.get(0);
		}
		return machineCount;
	}

	public Long getMachineCount(List<Long> warehouseIdsList) {
		Long machineCount = 0L;
		String hql = "select count(machineId) from MachineTL where warehouseId in (:listParam) and machineId not in(select machineId from MachineSalesTL)";

		String[] params = { "listParam" };
		Object[] values = { warehouseIdsList };
		List<Long> machineCounts = getHibernateTemplate().findByNamedParam(hql,
				params, values);
		if (machineCounts != null && machineCounts.size() > 0) {
			machineCount = machineCounts.get(0);
		}
		return machineCount;
	}

	public Long getMachineCount(String machineModel) {

		Long machineCount = 0L;
		String hql = "select count(machineId) from MachineTL where machineModel=? and machineId not in(select machineId from MachineSalesTL)";

		List<Long> machineCounts = getHibernateTemplate().find(hql,
				new Object[] { machineModel });
		if (machineCounts != null && machineCounts.size() > 0) {
			machineCount = machineCounts.get(0);
		}
		return machineCount;
	}

	public Long getMachineCount(List<Long> warehouseIdsList, String machineModel) {

		Long machineCount = 0L;
		String hql = "select count(machineId) from MachineTL where machineModel=:machineModel and warehouseId in (:listParam) and machineId not in(select machineId from MachineSalesTL)";

		String[] params = { "machineModel", "listParam" };
		Object[] values = { machineModel, warehouseIdsList };
		List<Long> machineCounts = getHibernateTemplate().findByNamedParam(hql,
				params, values);
		if (machineCounts != null && machineCounts.size() > 0) {
			machineCount = machineCounts.get(0);
		}
		return machineCount;
	}

	public Long insertMachinePrice(MachinePriceTL machinePriceTL) {
		Long machinePriceId = 0L;
		machinePriceId = (Long) getHibernateTemplate().save(machinePriceTL);
		return machinePriceId;
	}

	public Long getMachineId(String machineSno) {
		Long machineId = null;
		if (machineSno != null && !machineSno.trim().equals("")) {
			List<Long> list = getHibernateTemplate().find(
					"select machineId from MachineTL where machineSno=?",
					new Object[] { machineSno.trim() });
			if (list != null && list.size() > 0) {
				machineId = list.get(0);
			}
		}
		return machineId;
	}

	public MachineTL getMachine(Long machineId) {
		MachineTL machineTL = null;
		machineTL = (MachineTL) getHibernateTemplate().get(MachineTL.class,
				machineId);
		return machineTL;
	}

	public Map<String, Object> getMachine(String machineSNO) {
		Map<String, Object> machine = null;
		if (machineSNO != null && !machineSNO.trim().equals("")) {
			List machines = getHibernateTemplate()
					.find(
							"select machineId,machineKind,machineModel,status,warehouseId,machineSno,machineColour from MachineTL where machineSno=?",
							new Object[] { machineSNO });
			if (machines != null && machines.size() > 0) {
				Object[] obj = (Object[]) machines.get(0);
				machine = new LinkedHashMap<String, Object>();
				machine.put("id", obj[0]);
				machine.put("machineKind", obj[1]);
				machine.put("machineModel", obj[2]);

				machine.put("status", obj[3]);
				machine.put("warehouseId", obj[4]);
				machine.put("machineSno", obj[5]);
				machine.put("machineColour", obj[6]);

			}

		}
		return machine;
	}

	public List<MachinePriceTL> getMachinePrices(String machineKind,
			String machineModel) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find(
				"from MachinePriceTL where machineKind=? and machineModel=?",
				machineKind, machineModel);
	}

	public Integer updateMachineStatus(Long machineId, String status) {
		// TODO Auto-generated method stub
		Integer noOfRowsEffected = 0;

		MachineTL machineTL = (MachineTL) getHibernateTemplate().get(
				MachineTL.class, machineId);
		machineTL.setStatus(status);
		getHibernateTemplate().update(machineTL);
		return noOfRowsEffected;
	}

	public Map<String, Object> getMachines(String machineModel) {
		// TODO Auto-generated method stub
		Map<String, Object> machine = null;
		if (machineModel != null && !machineModel.trim().equals("")) {
			List machines = getHibernateTemplate()
					.find(
							"select machineId,machineKind,machineModel,status,warehouseId from MachineTL where machineModel=?",
							new Object[] { machineModel });
			if (machines != null && machines.size() > 0) {
				Object[] obj = (Object[]) machines.get(0);
				machine = new LinkedHashMap<String, Object>();
				machine.put("id", obj[0]);
				machine.put("machineKind", obj[1]);
				machine.put("machineModel", obj[2]);

				machine.put("status", obj[3]);
				machine.put("warehouseId", obj[4]);

			}

		}
		return machine;
	}

	public List<Map<String, Object>> getMachinelist(String machineModel) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> machines = null;
		List ags = getHibernateTemplate()
				.find(
						"select machineId,machineSno,machineKind,machineModel,status,warehouseId from MachineTL  where machineModel=?",
						new Object[] { machineModel });
		if (ags != null && ags.size() > 0) {
			machines = new ArrayList<Map<String, Object>>();
			ListIterator<Object[]> li = ags.listIterator();
			while (li.hasNext()) {
				Object[] ag = li.next();
				Map<String, Object> machine = new HashMap<String, Object>();
				machine.put("machineSno", ag[0]);
				machine.put("machineModel", ag[1]);
				machine.put("status", ag[2]);

				machines.add(machine);
			}

		}

		return machines;
	}

	public MachinePriceTL getMachinePrice(String machineKind,
			String machineModel) {
		MachinePriceTL machinePrice = null;

		List<MachinePriceTL> price = getHibernateTemplate()
				.find(
						"from MachinePriceTL where machinePriceId=(select max(machinePriceId) from MachinePriceTL where machineKind=? and machineModel=?)",
						new Object[] { machineKind, machineModel });
		if (price != null && price.size() > 0) {
			machinePrice = price.get(0);
		}

		return machinePrice;
	}

	public Long inserOrderDetails(OrderDetailsTL orderTL) {

		return (Long) getHibernateTemplate().save(orderTL);
	}

	public Long inserOrder(OrderTL orderTL) {
		return (Long) getHibernateTemplate().save(orderTL);
	}

	public List<OrderDetailsTL> getOrderDetails(Long orderId) {

		return getHibernateTemplate()
				.find("from OrderDetailsTL where orderId=?",
						new Object[] { orderId });
	}

	public List<OrderTL> getOrders(String status) {

		return getHibernateTemplate().find("from OrderTL where status=?",
				new Object[] { status });
	}

	public void updateOrder(Long orderId, String description, String status,
			Long updatedBy) {
		OrderTL orderTL = (OrderTL) getHibernateTemplate().get(OrderTL.class,
				orderId);
		if (orderTL != null) {
			orderTL.setUpdatedBy(updatedBy);
			orderTL.setUpdatedOn(new java.sql.Date(new java.util.Date()
					.getTime()));
			orderTL.setStatus(status);
			orderTL.setDescription(description);
			getHibernateTemplate().update(orderTL);

		}

	}

	public void updateOrder(Long orderId, String status, Long shiptedBy) {
		OrderTL orderTL = (OrderTL) getHibernateTemplate().get(OrderTL.class,
				orderId);
		if (orderTL != null) {
			orderTL.setShiptedBy(shiptedBy);
			orderTL.setShiptedOn(new java.sql.Date(new java.util.Date()
					.getTime()));
			orderTL.setStatus(status);
			getHibernateTemplate().update(orderTL);

		}

	}

	public OrderTL getOrder(Long orderId) {

		return (OrderTL) getHibernateTemplate().get(OrderTL.class, orderId);
	}

	public Long insertMachineSales(MachineSalesTL machineSalesTL) {

		return (Long) getHibernateTemplate().save(machineSalesTL);
	}

	public List<MachineTL> getMachineSales(Long orderId) {

		return getHibernateTemplate()
				.find(
						"from MachineTL where machineId in(select machineId from MachineSalesTL where orderId=?)",
						new Object[] { orderId });
	}

	public List<OrderTL> getOrders(Long createdBy) {

		return getHibernateTemplate().find(
				"from OrderTL where createdBy=? order by orderId desc",
				new Object[] { createdBy });
	}

	public List<MachineTL> getAgencyMachines(Long userRoleId, Long warehouseId) {
		return getHibernateTemplate()
				.find(
						"from MachineTL where machineId in(select machineId from MachineSalesTL where orderId in(select orderId from OrderTL where createdBy=? and warehouseId=? ))",
						new Object[] { userRoleId, warehouseId });

	}

	public Long getMachineSalesCount(Long orderCreatedBy) {
		String hql = "select count(machineId) from MachineTL where machineId in(select machineId from MachineSalesTL where orderId in(select orderId from OrderTL where createdBy=?))";
		List<Long> counts = getHibernateTemplate().find(hql,
				new Object[] { orderCreatedBy });
		if (counts != null && counts.size() > 0) {
			return counts.get(0);

		} else {
			return 0L;
		}

	}

	public Double getMachineSalesCost(Long orderCreatedBy) {
		double cost = 0;
		List<Long> machineIds = getHibernateTemplate()
				.find(
						"select machineId from MachineSalesTL where orderId in(select orderId from OrderTL where createdBy=?)",
						new Object[] { orderCreatedBy });
		if (machineIds != null && machineIds.size() > 0) {
			ListIterator<Long> li = machineIds.listIterator();
			while (li.hasNext()) {
				Long machineId = li.next();
				List<Object[]> machineCost = getHibernateTemplate()
						.find(
								"select mp.price,mp.discount from MachinePriceTL mp,MachineTL m  where mp.machineKind=m.machineKind and mp.machineModel=m.machineModel and m.machineId=? order by machinePriceId desc",
								new Object[] { machineId });
				if (machineCost != null && machineCost.size() > 0) {
					ListIterator<Object[]> mcostLi = machineCost.listIterator();
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

	public Long getMachineSalesCount() {
		List<Long> counts = getHibernateTemplate().find(
				"select count(MachineSalesId) from MachineSalesTL");
		if (counts != null && counts.size() > 0) {
			return counts.get(0);
		} else {
			return 0L;
		}

	}

	public Long getMachineSalesCount(List<Long> warehouseIdsList,
			String machineModel) {

		String[] params = { "listParam" };
		Object[] values = { warehouseIdsList };
		List<Long> counts = getHibernateTemplate()
				.findByNamedParam(
						"select count(MachineSalesId) from MachineSalesTL where  machineId in (select machineId from MachineTL where warehouseId in (:listParam) and machineModel='"
								+ machineModel + "')", params, values);
		if (counts != null && counts.size() > 0) {
			return counts.get(0);
		} else {
			return 0L;
		}

	}

	public Long getMachineSalesCount(List<Long> warehouseIdsList) {
		String[] params = { "listParam" };
		Object[] values = { warehouseIdsList };
		List<Long> counts = getHibernateTemplate()
				.findByNamedParam(
						"select count(MachineSalesId) from MachineSalesTL where machineId in (select machineId from MachineTL where warehouseId in (:listParam))",
						params, values);
		if (counts != null && counts.size() > 0) {
			return counts.get(0);
		} else {
			return 0L;
		}

	}
	public Long getMachineSalesCount(String machineModel) {
		List<Long> counts = getHibernateTemplate()
				.find(
						"select count(MachineSalesId) from MachineSalesTL where machineId in (select machineId from MachineTL where  machineModel=?)",
						new Object[] { machineModel });
		if (counts != null && counts.size() > 0) {
			return counts.get(0);
		} else {
			return 0L;
		}

	}
	public Double getMachineSalesCost() {
		double cost = 0;
		List<Long> machineIds = getHibernateTemplate().find(
				"select machineId from MachineSalesTL");
		if (machineIds != null && machineIds.size() > 0) {
			ListIterator<Long> li = machineIds.listIterator();
			while (li.hasNext()) {
				Long machineId = li.next();

				List<Object[]> machineCost = getHibernateTemplate()
						.find(
								"select mp.price,mp.discount from MachinePriceTL mp,MachineTL m  where mp.machineKind=m.machineKind and mp.machineModel=m.machineModel and m.machineId=? order by machinePriceId desc",
								new Object[] { machineId });
				if (machineCost != null && machineCost.size() > 0) {
					ListIterator<Object[]> mcostLi = machineCost.listIterator();
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
	public Double getMachineSalesCost(List<Long> warehouseIdsList,
			String machineModel) {
		double cost = 0;
		List<Long> machineIds = getHibernateTemplate().find(
				"select machineId from MachineSalesTL");
		if (machineIds != null && machineIds.size() > 0) {
			ListIterator<Long> li = machineIds.listIterator();
			while (li.hasNext()) {
				Long machineId = li.next();
				String[] params = { "listParam" };
				Object[] values = { warehouseIdsList };
				List<Object[]> machineCost = getHibernateTemplate()
						.findByNamedParam(
								"select mp.price,mp.discount from MachinePriceTL mp,MachineTL m  where where m.machineModel='"
										+ machineModel
										+ "' and m.warehouseId in(:listParam) and mp.machineKind=m.machineKind and mp.machineModel=m.machineModel and m.machineId=? order by machinePriceId desc",
								params, values);
				if (machineCost != null && machineCost.size() > 0) {
					ListIterator<Object[]> mcostLi = machineCost.listIterator();
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
	public Double getMachinesCost() {
		double cost = 0;
		List<Object[]> machines = getHibernateTemplate()
				.find(
						"select count(machineId),machineKind,machineModel from MachineTL where machineId not in(select machineId from MachineSalesTL) group by machineKind,machineModel");
		if (machines != null && machines.size() > 0) {
			ListIterator<Object[]> li = machines.listIterator();
			while (li.hasNext()) {
				Object[] obj = li.next();
				List<Double> machineCost = getHibernateTemplate()
						.find(
								"select price-(price*discount/100)  from MachinePriceTL where machinePriceId in(select max(machinePriceId) from MachinePriceTL where machineKind=? and machineModel=?)",
								new Object[] { obj[1], obj[2] });
				if (machineCost != null && machineCost.size() > 0) {
					cost = cost + ((Long) obj[0] * machineCost.get(0));
				}
			}
		}

		return cost;
	}
	public Double getMachinesCost(List<Long> warehouseIdsList) {
		double cost = 0;
		String[] params = { "listParam" };
		Object[] values = { warehouseIdsList };
		List<Object[]> machines = getHibernateTemplate()
				.findByNamedParam(
						"select count(machineId),machineKind,machineModel from MachineTL where warehouseId in(:listParam) and machineId not in(select machineId from MachineSalesTL) group by machineKind,machineModel",
						params, values);
		if (machines != null && machines.size() > 0) {
			ListIterator<Object[]> li = machines.listIterator();
			while (li.hasNext()) {
				Object[] obj = li.next();
				List<Double> machineCost = getHibernateTemplate()
						.find(
								"select price-(price*discount/100) from MachinePriceTL where machinePriceId in(select max(machinePriceId) from MachinePriceTL where machineKind=? and machineModel=?)",
								new Object[] { obj[1], obj[2] });
				if (machineCost != null && machineCost.size() > 0) {
					cost = cost + ((Long) obj[0] * machineCost.get(0));
				}
			}
		}

		return cost;
	}

	public Double getMachinesCost(String machineModel) {
		double cost = 0;
		List<Object[]> machines = getHibernateTemplate()
				.find(
						"select count(machineId),machineKind,machineModel from MachineTL  where machineModel='"
								+ machineModel
								+ "' and machineId not in(select machineId from MachineSalesTL) group by machineKind,machineModel");
		if (machines != null && machines.size() > 0) {
			ListIterator<Object[]> li = machines.listIterator();
			while (li.hasNext()) {
				Object[] obj = li.next();
				List<Double> machineCost = getHibernateTemplate()
						.find(
								"select price-(price*discount/100)  from MachinePriceTL where machinePriceId in(select max(machinePriceId) from MachinePriceTL where machineKind=? and machineModel=?)",
								new Object[] { obj[1], obj[2] });
				if (machineCost != null && machineCost.size() > 0) {
					cost = cost + ((Long) obj[0] * machineCost.get(0));
				}
			}
		}

		return cost;
	}

	public Double getMachinesCost(List<Long> warehouseIdsList,
			String machineModel) {
		double cost = 0;
		String[] params = { "listParam" };
		Object[] values = { warehouseIdsList };
		List<Object[]> machines = getHibernateTemplate()
				.findByNamedParam(
						"select count(machineId),machineKind,machineModel from MachineTL where machineModel='"
								+ machineModel
								+ "' and warehouseId in(:listParam) and machineId not in(select machineId from MachineSalesTL) group by machineKind,machineModel",
						params, values);
		if (machines != null && machines.size() > 0) {
			ListIterator<Object[]> li = machines.listIterator();
			while (li.hasNext()) {
				Object[] obj = li.next();
				List<Double> machineCost = getHibernateTemplate()
						.find(
								"select price-(price*discount/100)  from MachinePriceTL where machinePriceId in(select max(machinePriceId) from MachinePriceTL where machineKind=? and machineModel=?)",
								new Object[] { obj[1], obj[2] });
				if (machineCost != null && machineCost.size() > 0) {
					cost = cost + ((Long) obj[0] * machineCost.get(0));
				}
			}
		}

		return cost;
	}

	public Double getMachineSalesCost(List<Long> warehouseIdsList) {
		double cost = 0;
		List<Long> machineIds = getHibernateTemplate().find(
				"select machineId from MachineSalesTL");
		if (machineIds != null && machineIds.size() > 0) {
			ListIterator<Long> li = machineIds.listIterator();
			while (li.hasNext()) {
				Long machineId = li.next();
				String[] params = { "listParam" };
				Object[] values = { warehouseIdsList };
				List<Object[]> machineCost = getHibernateTemplate()
						.findByNamedParam(
								"select mp.price,mp.discount from MachinePriceTL mp,MachineTL m   where  m.warehouseId in(:listParam) and mp.machineKind=m.machineKind and mp.machineModel=m.machineModel and m.machineId="
										+ machineId
										+ " order by machinePriceId desc",
								params, values);
				if (machineCost != null && machineCost.size() > 0) {
					ListIterator<Object[]> mcostLi = machineCost.listIterator();
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

	public List<OrderDetailsTL> getOrders(String status, String orderFor,
			String model, String city, String country, Long createdBy) {
		String hql = null;
		if (model != null && !model.trim().equals("")
				&& !model.trim().equalsIgnoreCase("All")) {
			model = " model='" + model + "' and ";
		} else {
			model = "";
		}
		if (createdBy != null && createdBy > 0) {
			hql = "from OrderDetailsTL where "
					+ model
					+ " orderFor='"
					+ orderFor
					+ "' and orderId in(select orderId from OrderTL where status='"
					+ status + "' and createdBy=" + createdBy + ")";

		} else {

			if (country != null && !country.trim().equals("")
					&& !country.trim().equalsIgnoreCase("All")) {
				hql = "from OrderDetailsTL where "
						+ model
						+ " orderFor='"
						+ orderFor
						+ "' and orderId in(select orderId from OrderTL where status='"
						+ status
						+ "' and createdBy in(select userRoleId from UserRolesTL where country='"
						+ country + "')) ";
			} else {
				hql = "from OrderDetailsTL where "
						+ model
						+ " orderFor='"
						+ orderFor
						+ "' and orderId in(select orderId from OrderTL where status='"
						+ status + "')";
			}
			if (city != null && !city.trim().equals("")
					&& !city.trim().equalsIgnoreCase("All")) {
				hql = "from OrderDetailsTL where "
						+ model
						+ " orderFor='"
						+ orderFor
						+ "' and orderId in(select orderId from OrderTL where status='"
						+ status
						+ "' and createdBy in(select userRoleId from UserRolesTL where country='"
						+ country + "' and city='" + city + "')) ";
			}
		}
		return getHibernateTemplate().find(hql);
	}

	public List<OperatorOrderDetailsTL> getOperatorOrderDetails(Long orderId) {

		return getHibernateTemplate().find(
				"from OperatorOrderDetailsTL where orderId=" + orderId);
	}

	public List<OperatorOrderTL> getOperatorOrders(String status) {

		return getHibernateTemplate().find(
				"from OperatorOrderTL where status=?", new Object[] { status });
	}

	public List<OperatorOrderTL> getOperatorOrders(Long createdBy) {

		return getHibernateTemplate().find(
				"from OperatorOrderTL where createdBy=" + createdBy);
	}
	public Long inserOperatorOrder(OperatorOrderTL operatorOrderTL) {

		return (Long) getHibernateTemplate().save(operatorOrderTL);
	}
	public Long inserOperatorOrderDetails(
			OperatorOrderDetailsTL operatrOrderDetailsTL) {

		return (Long) getHibernateTemplate().save(operatrOrderDetailsTL);
	}
	public OperatorOrderTL getOperatorOrder(Long orderId) {

		return getHibernateTemplate().get(OperatorOrderTL.class, orderId);
	}
	public void updateOperatorOrder(Long orderId, String description,
			String status, Long updatedBy) {
		OperatorOrderTL orderTL = (OperatorOrderTL) getHibernateTemplate().get(
				OperatorOrderTL.class, orderId);
		if (orderTL != null) {
			orderTL.setUpdatedBy(updatedBy);
			orderTL.setUpdatedOn(new java.sql.Date(new java.util.Date()
					.getTime()));
			orderTL.setStatus(status);
			orderTL.setDescription(description);
			getHibernateTemplate().update(orderTL);

		}

	}
	public void updateOperatorOrder(Long orderId, String status, Long shiptedBy) {
		OperatorOrderTL orderTL = (OperatorOrderTL) getHibernateTemplate().get(
				OperatorOrderTL.class, orderId);
		if (orderTL != null) {
			orderTL.setShiptedBy(shiptedBy);
			orderTL.setShiptedOn(new java.sql.Date(new java.util.Date()
					.getTime()));
			orderTL.setStatus(status);
			getHibernateTemplate().update(orderTL);

		}

	}
	public boolean isMachineExist(String machineSno) {
  		boolean isExists = false;
		List machines = getHibernateTemplate().find(
				"from MachineTL where machineSno=?",
				new Object[] { machineSno });
		if (machines != null && machines.size() > 0) {
			isExists = true;
		}

		return isExists;
	}

	public boolean isMachineAvailable(String machineSno) {
		boolean isExists = false;
		List machines = getHibernateTemplate()
				.find(
						"from MachineTL where  machineSno=? and  machineId not in(select machineId from MachineSalesTL where machineId in(select machineId from MachineTL where machineSno=?))",
						new Object[] { machineSno, machineSno });
		if (machines != null && machines.size() > 0) {
			isExists = true;
		}

		return isExists;
	}

	public Long insertAgencyMachineSales(
			AgencyMachineSalesTL agencyMachineSalesTL) {

		return (Long) getHibernateTemplate().save(agencyMachineSalesTL);
	}

	public boolean isAgencyMachineAvailable(String machineSno, Long agencyId) {
		boolean isExists = false;
		List machines = getHibernateTemplate()
				.find(
						"select machineId from MachineSalesTL where machineId in(select machineId from MachineTL where machineSno=?) and   machineId not in(select machineId from AgencyMachineSalesTL where machineId in(select machineId from MachineTL where machineSno=?))  and orderId in(select orderId from OrderTL where createdBy=?)",
						new Object[] { machineSno, machineSno, agencyId });
		if (machines != null && machines.size() > 0) {
			isExists = true;
		}
		System.out.println(machineSno + " " + agencyId + " " + machines + " "
				+ isExists);
		return isExists;
	}

	public List<MachineTL> getAgencyMachineSales(Long orderId) {
		return getHibernateTemplate()
				.find(
						"from MachineTL where machineId in(select machineId from AgencyMachineSalesTL where orderId=?)",
						new Object[] { orderId });
	}

	public MachineSupplierTL getMachineSupplier(Long machineSupplierId) {

		return getHibernateTemplate().get(MachineSupplierTL.class,
				machineSupplierId);
	}

	public Long insertMachineSupplier(MachineSupplierTL machineSupplierTL) {

		return (Long) getHibernateTemplate().save(machineSupplierTL);
	}

	public void updateMachineSupplier(MachineSupplierTL machineSupplierTL) {
		getHibernateTemplate().update(machineSupplierTL);

	}

	public MachineLockTL getMachineLock(Long machineLockId) {
		return getHibernateTemplate().get(MachineLockTL.class,
				machineLockId);
	}

	public Long insertMachineLock(MachineLockTL machineLockTL) {
		return (Long) getHibernateTemplate().save(machineLockTL);
	}

	public void updateMachineLock(MachineLockTL machineLockTL) {
		getHibernateTemplate().update(machineLockTL);
		
	}
	public MachineTL operatorMachine(String machineSno,Long operatorId) {
		MachineTL machineTL = null;
		List<MachineTL> machines = getHibernateTemplate().find("from MachineTL where machineId in(select machineId from AgencyMachineSalesTL where orderId in (select orderId from OperatorOrderTL where createdBy=?)) and machineId in(select machineId from MachineTL where machineSno=?)",new Object[]{operatorId,machineSno});
		if (machines != null && machines.size() > 0) {
			machineTL=machines.get(0);
		}
		
		return machineTL;
	}
	public List<MachineTL> getOperatorMachines(Long operatorId) {
		List<MachineTL> machines = null;
		machines = getHibernateTemplate()
				.find(
						"from MachineTL where machineId in(select machineId from AgencyMachineSalesTL where orderId in(select orderId from OperatorOrderTL where createdBy=?))",
						new Object[] { operatorId });
		return machines;
	}

	public void updateMachineLock(String lockIds, Long machineId,Long updatedBy) {
		String cond=lockIds.equals("")?"":" and lockId not in("+lockIds+")";
		String hql="from MachineLockTL where  machineId="+machineId+" and status='Connected'"+cond;
		System.out.println(hql);
		List<MachineLockTL> machineLocks=getHibernateTemplate().find(hql);
		
		if(machineLocks!=null)
		{
			for (MachineLockTL machineLockTL : machineLocks) {
				machineLockTL.setStatus("DisConnected");
				machineLockTL.setUpdatedOn(new java.sql.Date(new java.util.Date().getTime()));
				machineLockTL.setUpdatedBy(updatedBy);
				getHibernateTemplate().update(machineLockTL);
				
			}
		}
		
	}

	public void updateMachineSuppplier(String supIds, Long machineId,
			Long updatedBy) {
		String cond=supIds.equals("")?"":" and supplierId not in("+supIds+")";
		String hql="from MachineSupplierTL where  machineId="+machineId+" and status='Connected'"+cond;
		System.out.println(hql);
		List<MachineSupplierTL> machineSuppliers=getHibernateTemplate().find(hql);
		if(machineSuppliers!=null)
		{
			for (MachineSupplierTL machineSupplierTL : machineSuppliers) {
				machineSupplierTL.setStatus("DisConnected");
				machineSupplierTL.setUpdatedOn(new java.sql.Date(new java.util.Date().getTime()));
				machineSupplierTL.setUpdatedBy(updatedBy);
				getHibernateTemplate().update(machineSupplierTL);
				
			}
		}
		
	}

	public Long insertMachinePartner(MachinePartnerTL machinePartnerTL) {
		
		return (Long)getHibernateTemplate().save(machinePartnerTL);
	}

	public MachinePartnerTL getMachinePartner(Long machineId, String status) {
		MachinePartnerTL machinePartnerTL=null;
		List<MachinePartnerTL> machinePartners=getHibernateTemplate().find("from MachinePartnerTL where machineId=? and status=?",new Object[]{machineId,status});
		
		if(machinePartners!=null && machinePartners.size()>0)
		{
			machinePartnerTL=machinePartners.get(0);
			
		}
		return machinePartnerTL;
	}

	public void updateMachinePartner(Long machineId, String status,Long updatedBy) {
		try {
			Session session=getHibernateTemplate().getSessionFactory().openSession();
			Transaction tx=session.beginTransaction();
			Query qry=session.createQuery("update MachinePartnerTL set status=?,updatedBy=?,updatedOn=? where machineId=?");
			qry.setString(0, status);
			qry.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
			qry.setLong(1, updatedBy);
			qry.setLong(3, machineId);
			qry.executeUpdate();
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<MachineTL> getMachines(Long supplierId, String status) {
		List<MachineTL> machines=null;
		machines=getHibernateTemplate().find("from MachineTL where machineId in(select machineId from MachineSupplierTL where supplierId=? and status=?)",new Object[]{supplierId,status});
		return machines;
	}

	public List<MachineTL> getLoactionMachines(Long locationId, String status) {
		List<MachineTL> machines=null;
		machines=getHibernateTemplate().find("from MachineTL where machineId in(select machineId from MachinePartnerTL where loactionId=? and status=?)",new Object[]{locationId,status});
		return machines;
	}

	@Override
	public List<MachineTL> getPartnerMachines(Long machineId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find(
				"from MachineTL where machineId=" + machineId);
	}
}
