package com.moaddi.dao;

import java.util.List;
import java.util.Map;

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


public interface MachineDAO {
	public Long insertMachine(MachineTL machineTL);
	public Long getMachineCount();
	public Long getMachineCount(List<Long> warehouseIdsList);
	public Long getMachineCount(List<Long> warehouseIdsList,String machineModel);
	public Long getMachineCount(String machineModel);
	public Long insertMachinePrice(MachinePriceTL machinePriceTL);
	public Long getMachineId(String machineSno);
	public MachineTL getMachine(Long machineId);
	public Map<String, Object> getMachine(String machineSNO);
	public List<MachinePriceTL> getMachinePrices(String machineKind,String machineModel);
	public Integer updateMachineStatus(Long machineId, String status);
	public MachinePriceTL  getMachinePrice(String machineKind,String machineModel);
	
	/*****************************************************/
	public Map<String, Object> getMachines(String machineModel);
	public List<Map<String, Object>> getMachinelist(String machineModel);
	
	public Long inserOrderDetails(OrderDetailsTL orderTL);
	public Long inserOrder(OrderTL orderTL);
	public List<OrderTL> getOrders(String status);
	public List<OrderTL> getOrders(Long createdBy);
	public List<OrderDetailsTL> getOrderDetails(Long orderId);
	
	public void updateOrder(Long orderId,String description,String status,Long updatedBy);
	public void updateOrder(Long orderId,String status,Long shiptedBy);
	public OrderTL getOrder(Long orderId);
	public Long insertMachineSales(MachineSalesTL machineSalesTL);
	public List<MachineTL> getMachineSales(Long orderId);
	
	public List<MachineTL> getAgencyMachines(Long userRoleId,Long warehouseId);
	public Long getMachineSalesCount(Long orderCreatedBy);
	public Double getMachineSalesCost(Long orderCreatedBy);
	public Long getMachineSalesCount();
	public Double getMachineSalesCost();
	public Double getMachinesCost();
	public Double getMachinesCost(String machineModel);
	public Double getMachinesCost(List<Long> warehouseIdsList);
	public Double getMachinesCost(List<Long> warehouseIdsList,String machineModel);
	public Double getMachineSalesCost(List<Long> warehouseIdsList,String machineModel);
	public Double getMachineSalesCost(List<Long> warehouseIdsList);
	public Long getMachineSalesCount(List<Long> warehouseIdsList,String machineModel);
	public Long getMachineSalesCount(String machineModel);
	public Long getMachineSalesCount(List<Long> warehouseIdsList);
	public List<OrderDetailsTL> getOrders(String status,String orderFor,String model,String city,String country,Long createdBy);
	
	public Long inserOperatorOrderDetails(OperatorOrderDetailsTL operatrOrderDetailsTL);
	public Long inserOperatorOrder(OperatorOrderTL operatorOrderTL);
	public List<OperatorOrderTL> getOperatorOrders(String status);
	public List<OperatorOrderTL> getOperatorOrders(Long createdBy);
	public List<OperatorOrderDetailsTL> getOperatorOrderDetails(Long orderId);
	public OperatorOrderTL getOperatorOrder(Long orderId);
	public void updateOperatorOrder(Long orderId,String description,String status,Long updatedBy);
	public void updateOperatorOrder(Long orderId,String status,Long shiptedBy);
	public boolean isMachineExist(String machineSno);
	public boolean isMachineAvailable(String machineSno);
	public Long insertAgencyMachineSales(AgencyMachineSalesTL agencyMachineSalesTL);
	public boolean isAgencyMachineAvailable(String machineSno,Long agencyId);
	public List<MachineTL> getAgencyMachineSales(Long orderId);
	public Long insertMachineSupplier(MachineSupplierTL machineSupplierTL);
	public void updateMachineSupplier(MachineSupplierTL machineSupplierTL);
	public MachineSupplierTL getMachineSupplier(Long machineSupplierId);
	public Long insertMachineLock(MachineLockTL machineLockTL);
	public void updateMachineLock(MachineLockTL machineLockTL);
	public MachineLockTL getMachineLock(Long machineLockId);
	public MachineTL operatorMachine(String machineSno,Long operatorId);
	public void updateMachineLock(String lockIds,Long machineId,Long updatedBy);
	public void updateMachineSuppplier(String supIds,Long machineId,Long updatedBy);
	public Long insertMachinePartner(MachinePartnerTL machinePartnerTL);
	public MachinePartnerTL getMachinePartner(Long machineId,String status);
	public void updateMachinePartner(Long machineId,String status,Long updatedBy);
	public List<MachineTL> getMachines(Long supplierId,String status);
	public List<MachineTL> getLoactionMachines(Long locationId,String status);
	
	
	
	
	
	
	public List<MachineTL> getPartnerMachines(Long machineId);
	

}
