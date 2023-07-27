package com.moaddi.service;

import java.util.List;
import java.util.Map;

import com.moaddi.dao.model.MachineLockTL;
import com.moaddi.dao.model.MachinePartnerTL;
import com.moaddi.dao.model.MachineSalesTL;
import com.moaddi.dao.model.MachineSupplierTL;
import com.moaddi.dao.model.MachineTL;
import com.moaddi.dao.model.OrderDetailsTL;
import com.moaddi.dao.model.OrderTL;
import com.moaddi.service.dto.LockDTO;
import com.moaddi.service.dto.MachineDTO;
import com.moaddi.service.dto.MachineLockDTO;
import com.moaddi.service.dto.MachinePartnerDTO;
import com.moaddi.service.dto.MachinePriceDTO;
import com.moaddi.service.dto.MachineSalesDTO;
import com.moaddi.service.dto.MachineSupplierDTO;
import com.moaddi.service.dto.OperatorOrderDTO;
import com.moaddi.service.dto.OperatorOrderDetailsDTO;
import com.moaddi.service.dto.OrderDTO;

import com.moaddi.service.dto.OrderDetailsDTO;

public interface MachineService {
	public Long saveMachine(MachineDTO machineDTO);
	public Long loadMachineCount();
	public Long loadMachineCount(List<Long> warehouseIdsList);
	public Long loadMachineCount(List<Long> warehouseIdsList,String machineModel);
	public Long loadMachineCount(String machineModel);
	public Long saveMachinePrice(MachinePriceDTO machinePriceDTO);
	public Long loadMachineId(String machineSno);
	public MachineDTO loadMachine(Long machineId);
	public Map<String, Object> loadMachine(String machineSNO);
	public List<MachinePriceDTO> loadMachinePrices(String machineKind,String machineModel);
	public Integer modifyMachineStatus(Long machineId,String status);
	public MachinePriceDTO loadMachinePrice(String machineKind,String machineModel);
	
	/*******************************/
	
	public Map<String, Object> loadMachines(String machineModel);
	public List< Map<String, Object>> loadMachinelist(String machineModel);
	
	public Long saveOrderDetails(OrderDetailsDTO orderDTO);
	public Long saveOrder(OrderDTO orderDTO);
	public List<OrderDTO> loadOrders(String status);
	public List<OrderDetailsDTO> loadOrderDetails(Long orderId);
	public void modifyOrder(Long orderId,String description,String status,String string);
	public void modifyOrder(Long orderId,String status,Long shiptedBy);
	public OrderDTO loadOrder(Long orderId);
	public Long saveMachineSales(MachineSalesDTO machineSalesDTO);
	public List<MachineDTO> loadMachineSales(Long orderId);
	public List<OrderDTO> loadOrders(Long createdBy);
	public List<MachineDTO> loadAgencyMachines(Long userRoleId,Long warehouseId);
	public Long loadMachineSalesCount(Long orderCreatedBy);
	public Double loadMachineSalesCost(Long orderCreatedBy);
	public Long loadMachineSalesCount();
	public Double loadMachineSalesCost();
	public Double loadMachinesCost();
	public Double loadMachinesCost(List<Long> warehouseIdsList);
	public Double loadMachinesCost(String machineModel);
	public Double loadMachinesCost(List<Long> warehouseIdsList,String machineModel);
	public Double loadMachineSalesCost(List<Long> warehouseIdsList,String machineModel);
	public Long loadMachineSalesCount(List<Long> warehouseIdsList,String machineModel);
	public Long loadMachineSalesCount(String machineModel);
	public Long loadMachineSalesCount(List<Long> warehouseIdsList);
	public Double loadMachineSalesCost(List<Long> warehouseIdsList);
	public List<OrderDetailsDTO> loadOrders(String status,String orderFor,String model,String city,String country,Long createdBy);
	
	public Long saveOperatorOrderDetails(OperatorOrderDetailsDTO operatorOrderDetailsDTO);
	public Long saveOperatorOrder(OperatorOrderDTO operatorOrderDTO);
	public List<OperatorOrderDTO> loadOperatorOrders(String status);
	public List<OperatorOrderDetailsDTO> loadOperatorOrderDetails(Long orderId);
	public List<OperatorOrderDTO> loadOperatorOrders(Long createdBy);
	public OperatorOrderDTO loadOperatorOrder(Long orderId);
	public void modifyOperatorOrder(Long orderId,String description,String status,Long updatedBy);
	public void modifyOperatorOrder(Long orderId,String status,Long shiptedBy);
	public boolean isMachineExist(String machineSno);
	public boolean isMachineAvailable(String machineSno);
	public Long saveAgencyMachineSales(MachineSalesDTO machineSalesDTO);
	public boolean isAgencyMachineAvailable(String machineSno,Long agencyId);
	public List<MachineDTO> loadAgencyMachineSales(Long orderId);
	public Long saveMachineSupplier(MachineSupplierDTO machineSupplierDTO);
	public void modifyMachineSupplier(MachineSupplierDTO machineSupplierDTO);
	public MachineSupplierDTO loadMachineSupplier(Long machineSupplierId);
	
	public Long saveMachineLock(MachineLockDTO machineLockDTO);
	public void modifyMachineLock(MachineLockDTO machineLockDTO);
	public MachineLockDTO loadMachineLock(Long machineLockId);
	
	public MachineDTO operatorMachine(String machineSno,Long operatorId);
	public void modifyMachineLock(String lockIds, Long machineId,Long updatedBy);
	public void modifyMachineSuppplier(String supIds,Long machineId,Long updatedBy);
	public Long saveMachinePartner(MachinePartnerDTO machinePartnerDTO);
	public MachinePartnerDTO loadMachinePartner(Long machineId, String status);
	public void modifyMachinePartner(Long machineId, String status,Long updatedBy);
	public List<MachineDTO> loadMachines(Long supplierId, String status);
	public List<MachineDTO> loadLoactionMachines(Long locationId,String status);
	
	public List<MachineDTO> loadPartnerMachines(Long machineId);

}
