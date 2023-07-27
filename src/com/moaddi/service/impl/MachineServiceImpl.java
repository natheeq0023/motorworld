package com.moaddi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moaddi.dao.LockDAO;
import com.moaddi.dao.MachineDAO;
import com.moaddi.dao.model.AgencyMachineSalesTL;
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
import com.moaddi.service.LockService;
import com.moaddi.service.MachineService;
import com.moaddi.service.dto.LockPriceDTO;
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

@Service("machineService")
public class MachineServiceImpl implements MachineService {

	@Autowired
	private MachineDAO machineDAO;
	@Autowired
	private LockService lockService;
	public Long saveMachine(MachineDTO machineDTO) {
		Long machineId=0L;
		if(machineDTO!=null)
		{
			MachineTL machineTL=new MachineTL();
			machineTL.setCreatedBy(machineDTO.getCreatedBy());
			machineTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			machineTL.setMachineColour(machineDTO.getMachineColour());
			machineTL.setMachineDepth(machineDTO.getMachineDepth());
			machineTL.setMachineHeight(machineDTO.getMachineHeight());
			machineTL.setMachineKind(machineDTO.getMachineKind());
			machineTL.setMachineModel(machineDTO.getMachineModel());
			machineTL.setMachinePhotoName(machineDTO.getMachinePhotoName());
			machineTL.setMachineSno(machineDTO.getMachineSno());
			machineTL.setMachineWeight(machineDTO.getMachineWeight());
			machineTL.setMachineWidth(machineDTO.getMachineWidth());
			machineTL.setStatus(machineDTO.getStatus());
			machineTL.setWarehouseId(machineDTO.getWarehouseId());
			machineId=machineDAO.insertMachine(machineTL);
		}
		return machineId;
	}
	public Long loadMachineCount() {
		
		return machineDAO.getMachineCount();
	}
	public Long loadMachineCount(List<Long> warehouseIdsList) {
		
		return machineDAO.getMachineCount(warehouseIdsList);
	}
	
	public Long loadMachineCount(String machineModel) {
		
		return machineDAO.getMachineCount(machineModel);
	}
	public Long loadMachineCount(List<Long> warehouseIdsList,String machineModel)
	{
		return machineDAO.getMachineCount(warehouseIdsList, machineModel);
	}
	public Long saveMachinePrice(MachinePriceDTO machinePriceDTO) {
		Long machinePriceId=0L;
		if(machinePriceDTO!=null)
		{
			MachinePriceTL machinePriceTL=new MachinePriceTL();
			machinePriceTL.setCreatedBy(machinePriceDTO.getCreatedBy());
			machinePriceTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			machinePriceTL.setDiscount(machinePriceDTO.getDiscount());
			machinePriceTL.setFromDate(new java.sql.Date(machinePriceDTO.getFromDate().getTime()));
			machinePriceTL.setMachineKind(machinePriceDTO.getMachineKind());
			machinePriceTL.setMachineModel(machinePriceDTO.getMachineModel());
			machinePriceTL.setPrice(machinePriceDTO.getPrice());
			machinePriceTL.setToDate(new java.sql.Date(machinePriceDTO.getToDate().getTime()));
			machinePriceId=machineDAO.insertMachinePrice(machinePriceTL);
			
		}
		return machinePriceId;
	}
	public Long loadMachineId(String machineSno) {
		
		return machineDAO.getMachineId(machineSno);
	}
	public MachineDTO loadMachine(Long machineId) {
		MachineDTO machineDTO=null;
		MachineTL machine=machineDAO.getMachine(machineId);
		if(machine!=null)
		{
			
		}
		return machineDTO;
	}
	public Map<String, Object> loadMachine(String machineSNO) {
		
		return machineDAO.getMachine(machineSNO);
	}
	
	public List<MachinePriceDTO> loadMachinePrices(String machineKind,String machineModel) {
		// TODO Auto-generated method stub
		List<MachinePriceDTO> prices=null;
		if(machineModel!=null)
		{
			List<MachinePriceTL> mprices=machineDAO.getMachinePrices(machineKind, machineModel);
			if(mprices!=null && mprices.size()>0)
			{
				prices=new ArrayList<MachinePriceDTO>();
				ListIterator<MachinePriceTL> li=mprices.listIterator();
				while(li.hasNext())
				{
					MachinePriceTL machinePrice=li.next();
					MachinePriceDTO machinePriceDTO=new MachinePriceDTO();
					machinePriceDTO.setCreatedOn(machinePrice.getCreatedOn());
					machinePriceDTO.setDiscount(machinePrice.getDiscount());
					machinePriceDTO.setFromDate(machinePrice.getFromDate());
					machinePriceDTO.setMachineKind(machinePrice.getMachineKind());
					machinePriceDTO.setMachineModel(machinePrice.getMachineModel());
					machinePriceDTO.setPrice(machinePrice.getPrice());
					machinePriceDTO.setToDate(machinePrice.getToDate());
					machinePriceDTO.setMachinePriceId(machinePrice.getMachinePriceId());
					prices.add(machinePriceDTO);
					
				}
				
			}
			
		}
		return prices;
	}
	
	public Integer modifyMachineStatus(Long machineId, String status) {
		// TODO Auto-generated method stub
		return machineDAO.updateMachineStatus(machineId, status);
	}
	
	public Map<String, Object> loadMachines(String machineModel) {
		// TODO Auto-generated method stub
		return machineDAO.getMachines(machineModel);
	}
	
	public List<Map<String, Object>> loadMachinelist(String machineModel) {
		// TODO Auto-generated method stub
		return machineDAO.getMachinelist(machineModel);
	}
	public MachinePriceDTO loadMachinePrice(String machineKind,
			String machineModel) {
		MachinePriceDTO machinePriceDTO=null;
		MachinePriceTL machinePrice=machineDAO.getMachinePrice(machineKind, machineModel);
		if(machinePrice!=null)
		{
			machinePriceDTO=new MachinePriceDTO();
			machinePriceDTO.setCreatedOn(machinePrice.getCreatedOn());
			machinePriceDTO.setDiscount(machinePrice.getDiscount());
			machinePriceDTO.setFromDate(machinePrice.getFromDate());
			machinePriceDTO.setMachineKind(machinePrice.getMachineKind());
			machinePriceDTO.setMachineModel(machinePrice.getMachineModel());
			machinePriceDTO.setPrice(machinePrice.getPrice());
			machinePriceDTO.setToDate(machinePrice.getToDate());
			machinePriceDTO.setMachinePriceId(machinePrice.getMachinePriceId());
		}
		return machinePriceDTO;
	}
	public Long saveOrderDetails(OrderDetailsDTO orderDTO) {
		Long orderId=null;
		if(orderDTO!=null)
		{
			OrderDetailsTL orderTL=new OrderDetailsTL();
			
			orderTL.setModel(orderDTO.getModel());
			orderTL.setOrderFor(orderDTO.getOrderFor());
			orderTL.setQuantity(orderDTO.getQuantity());
			orderTL.setType(orderDTO.getType());
			
			orderTL.setOrderId(orderDTO.getOrderId());
			orderId=machineDAO.inserOrderDetails(orderTL);
		}
		return orderId;
	}
	
	public Long saveOrder(OrderDTO orderDTO) {
		Long orderId=null;
		if(orderDTO!=null)
		{
			OrderTL orderTL=new OrderTL();
			orderTL.setCreatedBy(orderDTO.getCreatedBy());
			orderTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			orderTL.setStatus(orderDTO.getStatus());
			orderTL.setWarehouseId(orderDTO.getWarehouseId());
			orderTL.setUpdatedBy(orderDTO.getUpdatedBy());
			if(orderDTO.getUpdatedOn()!=null)
			{
				orderTL.setUpdatedOn(new java.sql.Date(orderDTO.getUpdatedOn().getTime()));
			}
			orderTL.setOrderType(orderDTO.getOrderType());
			
			orderId=machineDAO.inserOrder(orderTL);
		}
		return orderId;
	}
	public List<OrderDetailsDTO> loadOrderDetails(Long orderId) {
		 List<OrderDetailsDTO> orderDetails=null;
		 List<OrderDetailsTL> ords=machineDAO.getOrderDetails(orderId);
		 if(ords!=null && ords.size()>0)
		 {
			 orderDetails=new ArrayList<OrderDetailsDTO>();
			 ListIterator<OrderDetailsTL> li=ords.listIterator();
			 while(li.hasNext())
			 {
				 OrderDetailsTL orderDetailsTL=li.next();
				 OrderDetailsDTO orderDetailsDTO=new OrderDetailsDTO();
				 orderDetailsDTO.setModel(orderDetailsTL.getModel());
				 orderDetailsDTO.setOrderFor(orderDetailsTL.getOrderFor());
				 orderDetailsDTO.setQuantity(orderDetailsTL.getQuantity());
				 orderDetailsDTO.setType(orderDetailsTL.getType());
				 orderDetailsDTO.setOrderDetailsId(orderDetailsTL.getOrderDetailsId());
				 orderDetailsDTO.setOrderId(orderDetailsTL.getOrderId());
				 try {
					 
					if(orderDetailsTL.getOrderFor()!=null) 
					{
					
						if(orderDetailsTL.getOrderFor().equalsIgnoreCase("machine"))
						{
							MachinePriceDTO machinePriceDTO=loadMachinePrice(orderDetailsTL.getType(), orderDetailsTL.getModel());
							orderDetailsDTO.setPrice(machinePriceDTO.getPrice());
							orderDetailsDTO.setDiscount(machinePriceDTO.getDiscount());
							Double discoutAmount=machinePriceDTO.getPrice()*machinePriceDTO.getDiscount()/100;
							Double finalAmount=machinePriceDTO.getPrice()-discoutAmount;
							Double totalCost=orderDetailsTL.getQuantity()*finalAmount;
							orderDetailsDTO.setFinalPrice(finalAmount);
							orderDetailsDTO.setTotalCost(totalCost);
						}
						else if(orderDetailsTL.getOrderFor().equalsIgnoreCase("lock"))
						{
							LockPriceDTO lockPriceDTO=lockService.loadLockPrice(orderDetailsTL.getType(), orderDetailsTL.getModel());
							orderDetailsDTO.setPrice(lockPriceDTO.getPrice());
							orderDetailsDTO.setDiscount(lockPriceDTO.getDiscount());
							Double discoutAmount=lockPriceDTO.getPrice()*lockPriceDTO.getDiscount()/100;
							Double finalAmount=lockPriceDTO.getPrice()-discoutAmount;
							Double totalCost=orderDetailsTL.getQuantity()*finalAmount;
							orderDetailsDTO.setFinalPrice(finalAmount);
							orderDetailsDTO.setTotalCost(totalCost);
						}
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				 
				 orderDetails.add(orderDetailsDTO);
				 
				
				 
			 }
		 }
		
		return orderDetails;
	}
	public List<OrderDTO> loadOrders(String status) {
		List<OrderDTO> orders=null;
		List<OrderTL> ord=machineDAO.getOrders(status);
		if(ord!=null && ord.size()>0)
		{
			orders=new ArrayList<OrderDTO>();
			ListIterator<OrderTL> li=ord.listIterator();
			while(li.hasNext())
			{
				OrderTL orderTL=li.next();
				OrderDTO orderDTO=new OrderDTO();
				orderDTO.setCreatedBy(orderTL.getCreatedBy());
				orderDTO.setCreatedOn(orderTL.getCreatedOn());
				orderDTO.setStatus(orderTL.getStatus());
				orderDTO.setWarehouseId(orderTL.getWarehouseId());
				orderDTO.setOrderId(orderTL.getOrderId());
				orderDTO.setUpdatedBy(orderTL.getUpdatedBy());
				orderDTO.setUpdatedOn(orderTL.getUpdatedOn());
				orderDTO.setShiptedBy(orderTL.getShiptedBy());
				orderDTO.setDescription(orderTL.getDescription());
				orderDTO.setShiptedOn(orderTL.getShiptedOn());
				orderDTO.setOrderType(orderTL.getOrderType());
				orders.add(orderDTO);
				
			}
		}
		
		return orders;
	}
	public void modifyOrder(Long orderId, String description, String status,
			Long updatedBy) {
		machineDAO.updateOrder(orderId, description, status, updatedBy);
		
	}
	public void modifyOrder(Long orderId, String status, Long shiptedBy) {
		machineDAO.updateOrder(orderId,  status, shiptedBy);
		
	}
	public OrderDTO loadOrder(Long orderId) {
		OrderDTO orderDTO=null;
		OrderTL orderTL=machineDAO.getOrder(orderId);
		if(orderTL!=null)
		{
			 	orderDTO=new OrderDTO();
				orderDTO.setCreatedBy(orderTL.getCreatedBy());
				orderDTO.setCreatedOn(orderTL.getCreatedOn());
				orderDTO.setStatus(orderTL.getStatus());
				orderDTO.setWarehouseId(orderTL.getWarehouseId());
				orderDTO.setOrderId(orderTL.getOrderId());
				orderDTO.setUpdatedBy(orderTL.getUpdatedBy());
				orderDTO.setUpdatedOn(orderTL.getUpdatedOn());
				orderDTO.setShiptedBy(orderTL.getShiptedBy());
				orderDTO.setDescription(orderTL.getDescription());
				orderDTO.setShiptedOn(orderTL.getShiptedOn());
				orderDTO.setOrderType(orderTL.getOrderType());
		}
		return orderDTO;
	}
	public Long saveMachineSales(MachineSalesDTO machineSalesDTO) {
		Long machineSalesId=null;
		if(machineSalesDTO!=null)
		{
			MachineSalesTL machineSalesTL=new MachineSalesTL();
			machineSalesTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			machineSalesTL.setMachineId(machineSalesDTO.getMachineId());
			machineSalesTL.setOrderId(machineSalesDTO.getOrderId());
			machineSalesId=machineDAO.insertMachineSales(machineSalesTL);
		}
		return machineSalesId;
	}
	public List<MachineDTO> loadMachineSales(Long orderId) {
		List<MachineDTO> machines=null;
		List<MachineTL> lmachines=machineDAO.getMachineSales(orderId);
		if(lmachines!=null && lmachines.size()>0)
		{
			machines=new ArrayList<MachineDTO>();
			ListIterator<MachineTL> li=lmachines.listIterator();
			while(li.hasNext())
			{
					MachineTL machine=li.next();
					MachineDTO machineDTO=new MachineDTO();
					machineDTO.setMachineColour(machine.getMachineColour());
					machineDTO.setCreatedBy(machine.getCreatedBy());
					machineDTO.setCreatedOn(machine.getCreatedOn());
					machineDTO.setMachineColour(machine.getMachineColour());
					machineDTO.setMachineDepth(machine.getMachineDepth());
					machineDTO.setMachineHeight(machine.getMachineHeight());
					machineDTO.setMachineKind(machine.getMachineKind());
					machineDTO.setMachineModel(machine.getMachineModel());
					machineDTO.setMachinePhotoName(machine.getMachinePhotoName());
					machineDTO.setMachineSno(machine.getMachineSno());
					machineDTO.setMachineWeight(machine.getMachineWeight());
					machineDTO.setMachineWidth(machine.getMachineWidth());
					machineDTO.setStatus(machine.getStatus());
					machineDTO.setWarehouseId(machine.getWarehouseId());
					machineDTO.setMachineId(machine.getMachineId());
					
					machines.add(machineDTO);
					
			}
			
			
		}
		return machines;
	}
	public List<OrderDTO> loadOrders(Long createdBy) {
		List<OrderDTO> orders=null;
		List<OrderTL> ord=machineDAO.getOrders(createdBy);
		if(ord!=null && ord.size()>0)
		{
			orders=new ArrayList<OrderDTO>();
			ListIterator<OrderTL> li=ord.listIterator();
			while(li.hasNext())
			{
				OrderTL orderTL=li.next();
				OrderDTO orderDTO=new OrderDTO();
				orderDTO.setCreatedBy(orderTL.getCreatedBy());
				orderDTO.setCreatedOn(orderTL.getCreatedOn());
				orderDTO.setStatus(orderTL.getStatus());
				orderDTO.setWarehouseId(orderTL.getWarehouseId());
				orderDTO.setOrderId(orderTL.getOrderId());
				orderDTO.setUpdatedBy(orderTL.getUpdatedBy());
				orderDTO.setUpdatedOn(orderTL.getUpdatedOn());
				orderDTO.setShiptedBy(orderTL.getShiptedBy());
				orderDTO.setDescription(orderTL.getDescription());
				orderDTO.setShiptedOn(orderTL.getShiptedOn());
				orderDTO.setOrderType(orderTL.getOrderType());
				
				orders.add(orderDTO);
				
			}
		}
		
		return orders;
	}
	public List<MachineDTO> loadAgencyMachines(Long userRoleId, Long warehouseId) {
		List<MachineDTO> machines=null;
		List<MachineTL> lmachines=machineDAO.getAgencyMachines(userRoleId, warehouseId);
		if(lmachines!=null && lmachines.size()>0)
		{
			machines=new ArrayList<MachineDTO>();
			ListIterator<MachineTL> li=lmachines.listIterator();
			while(li.hasNext())
			{
					MachineTL machine=li.next();
					MachineDTO machineDTO=new MachineDTO();
					machineDTO.setMachineColour(machine.getMachineColour());
					machineDTO.setCreatedBy(machine.getCreatedBy());
					machineDTO.setCreatedOn(machine.getCreatedOn());
					machineDTO.setMachineColour(machine.getMachineColour());
					machineDTO.setMachineDepth(machine.getMachineDepth());
					machineDTO.setMachineHeight(machine.getMachineHeight());
					machineDTO.setMachineKind(machine.getMachineKind());
					machineDTO.setMachineModel(machine.getMachineModel());
					machineDTO.setMachinePhotoName(machine.getMachinePhotoName());
					machineDTO.setMachineSno(machine.getMachineSno());
					machineDTO.setMachineWeight(machine.getMachineWeight());
					machineDTO.setMachineWidth(machine.getMachineWidth());
					machineDTO.setStatus(machine.getStatus());
					machineDTO.setWarehouseId(machine.getWarehouseId());
					machineDTO.setMachineId(machine.getMachineId());
					
					machines.add(machineDTO);
					
			}
			
			
		}
		return machines;
	}
	public Long loadMachineSalesCount(Long orderCreatedBy) {
		
		return machineDAO.getMachineSalesCount(orderCreatedBy);
	}
	public Double loadMachineSalesCost(Long orderCreatedBy)
	{
		return machineDAO.getMachineSalesCost(orderCreatedBy);
	}
	public Long loadMachineSalesCount() {
		
		return machineDAO.getMachineSalesCount();
	}
	public Double loadMachineSalesCost()
	{
		return machineDAO.getMachineSalesCost();
	}
	public Double loadMachinesCost() {
		
		return machineDAO.getMachinesCost();
	}
	public Double loadMachinesCost(List<Long> warehouseIdsList) {
		
		return machineDAO.getMachinesCost(warehouseIdsList);
	}
	public Double loadMachinesCost(String machineModel) {
		
		return machineDAO.getMachinesCost(machineModel);
	}
	public Double loadMachinesCost(List<Long> warehouseIdsList,
			String machineModel) {
		
		return machineDAO.getMachinesCost(warehouseIdsList,machineModel);
	}
	public Double loadMachineSalesCost(List<Long> warehouseIdsList,
			String machineModel) {
		
		return machineDAO.getMachineSalesCost(warehouseIdsList, machineModel);
	}
	public Long loadMachineSalesCount(List<Long> warehouseIdsList,
			String machineModel) {
		
		return machineDAO.getMachineSalesCount(warehouseIdsList, machineModel);
	}
	public Long loadMachineSalesCount(List<Long> warehouseIdsList
			) {
		
		return machineDAO.getMachineSalesCount(warehouseIdsList);
	}
	public Long loadMachineSalesCount(String machineModel) {
		
		return machineDAO.getMachineSalesCount(machineModel);
	}
	public Double loadMachineSalesCost(List<Long> warehouseIdsList) {
		
		return machineDAO.getMachineSalesCost(warehouseIdsList);
	}
	public List<OrderDetailsDTO> loadOrders(String status, String orderFor,
			String model, String city, String country, Long createdBy) {
		List<OrderDetailsDTO> orderDetails=null;
		 List<OrderDetailsTL> ords=machineDAO.getOrders(status, orderFor, model, city, country, createdBy);
		 if(ords!=null && ords.size()>0)
		 {
			 orderDetails=new ArrayList<OrderDetailsDTO>();
			 ListIterator<OrderDetailsTL> li=ords.listIterator();
			 while(li.hasNext())
			 {
				 OrderDetailsTL orderDetailsTL=li.next();
				 OrderDetailsDTO orderDetailsDTO=new OrderDetailsDTO();
				 orderDetailsDTO.setModel(orderDetailsTL.getModel());
				 orderDetailsDTO.setOrderFor(orderDetailsTL.getOrderFor());
				 orderDetailsDTO.setQuantity(orderDetailsTL.getQuantity());
				 orderDetailsDTO.setType(orderDetailsTL.getType());
				 
				 orderDetails.add(orderDetailsDTO);
					
				} 
				 
				 
				
				 
			 }
		 
		
		return orderDetails;
	}
	public List<OperatorOrderDetailsDTO> loadOperatorOrderDetails(Long orderId) {
		
		 List<OperatorOrderDetailsDTO> orderDetails=null;
		 List<OperatorOrderDetailsTL> ords=machineDAO.getOperatorOrderDetails(orderId);
		 if(ords!=null && ords.size()>0)
		 {
			 orderDetails=new ArrayList<OperatorOrderDetailsDTO>();
			 ListIterator<OperatorOrderDetailsTL> li=ords.listIterator();
			 while(li.hasNext())
			 {
				 OperatorOrderDetailsTL orderDetailsTL=li.next();
				 OperatorOrderDetailsDTO orderDetailsDTO=new OperatorOrderDetailsDTO();
				 orderDetailsDTO.setModel(orderDetailsTL.getModel());
				 orderDetailsDTO.setOrderFor(orderDetailsTL.getOrderFor());
				 orderDetailsDTO.setQuantity(orderDetailsTL.getQuantity());
				 orderDetailsDTO.setType(orderDetailsTL.getType());
				 orderDetailsDTO.setOrderDetailsId(orderDetailsTL.getOrderDetailsId());
				 orderDetailsDTO.setOrderId(orderDetailsTL.getOrderId());
				 try {
					 
					if(orderDetailsTL.getOrderFor()!=null) 
					{
					
						if(orderDetailsTL.getOrderFor().equalsIgnoreCase("machine"))
						{
							MachinePriceDTO machinePriceDTO=loadMachinePrice(orderDetailsTL.getType(), orderDetailsTL.getModel());
							orderDetailsDTO.setPrice(machinePriceDTO.getPrice());
							orderDetailsDTO.setDiscount(machinePriceDTO.getDiscount());
							Double discoutAmount=machinePriceDTO.getPrice()*machinePriceDTO.getDiscount()/100;
							Double finalAmount=machinePriceDTO.getPrice()-discoutAmount;
							Double totalCost=orderDetailsTL.getQuantity()*finalAmount;
							orderDetailsDTO.setFinalPrice(finalAmount);
							orderDetailsDTO.setTotalCost(totalCost);
						}
						else if(orderDetailsTL.getOrderFor().equalsIgnoreCase("lock"))
						{
							LockPriceDTO lockPriceDTO=lockService.loadLockPrice(orderDetailsTL.getType(), orderDetailsTL.getModel());
							orderDetailsDTO.setPrice(lockPriceDTO.getPrice());
							orderDetailsDTO.setDiscount(lockPriceDTO.getDiscount());
							Double discoutAmount=lockPriceDTO.getPrice()*lockPriceDTO.getDiscount()/100;
							Double finalAmount=lockPriceDTO.getPrice()-discoutAmount;
							Double totalCost=orderDetailsTL.getQuantity()*finalAmount;
							orderDetailsDTO.setFinalPrice(finalAmount);
							orderDetailsDTO.setTotalCost(totalCost);
						}
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				 
				 orderDetails.add(orderDetailsDTO);
				 
				
				 
			 }
		 }
		
		return orderDetails;
	}
	public List<OperatorOrderDTO> loadOperatorOrders(String status) {
		List<OperatorOrderDTO> orders=null;
		List<OperatorOrderTL> ord=machineDAO.getOperatorOrders(status);
		if(ord!=null && ord.size()>0)
		{
			orders=new ArrayList<OperatorOrderDTO>();
			ListIterator<OperatorOrderTL> li=ord.listIterator();
			while(li.hasNext())
			{
				OperatorOrderTL orderTL=li.next();
				OperatorOrderDTO orderDTO=new OperatorOrderDTO();
				orderDTO.setCreatedBy(orderTL.getCreatedBy());
				orderDTO.setCreatedOn(orderTL.getCreatedOn());
				orderDTO.setStatus(orderTL.getStatus());
				orderDTO.setWarehouseId(orderTL.getWarehouseId());
				orderDTO.setOrderId(orderTL.getOrderId());
				orderDTO.setUpdatedBy(orderTL.getUpdatedBy());
				orderDTO.setUpdatedOn(orderTL.getUpdatedOn());
				orderDTO.setShiptedBy(orderTL.getShiptedBy());
				orderDTO.setDescription(orderTL.getDescription());
				orderDTO.setShiptedOn(orderTL.getShiptedOn());
				orderDTO.setOrderType(orderTL.getOrderType());
				
				orders.add(orderDTO);
				
			}
		}
		
		return orders;
	}
	public List<OperatorOrderDTO> loadOperatorOrders(Long createdBy) {
		List<OperatorOrderDTO> orders=null;
		List<OperatorOrderTL> ord=machineDAO.getOperatorOrders(createdBy);
		if(ord!=null && ord.size()>0)
		{
			orders=new ArrayList<OperatorOrderDTO>();
			ListIterator<OperatorOrderTL> li=ord.listIterator();
			while(li.hasNext())
			{
				OperatorOrderTL orderTL=li.next();
				OperatorOrderDTO orderDTO=new OperatorOrderDTO();
				orderDTO.setCreatedBy(orderTL.getCreatedBy());
				orderDTO.setCreatedOn(orderTL.getCreatedOn());
				orderDTO.setStatus(orderTL.getStatus());
				orderDTO.setWarehouseId(orderTL.getWarehouseId());
				orderDTO.setOrderId(orderTL.getOrderId());
				orderDTO.setUpdatedBy(orderTL.getUpdatedBy());
				orderDTO.setUpdatedOn(orderTL.getUpdatedOn());
				orderDTO.setShiptedBy(orderTL.getShiptedBy());
				orderDTO.setDescription(orderTL.getDescription());
				orderDTO.setShiptedOn(orderTL.getShiptedOn());
				orderDTO.setOrderType(orderTL.getOrderType());
				
				orders.add(orderDTO);
				
			}
		}
		
		return orders;
	}
	public Long saveOperatorOrder(OperatorOrderDTO operatorOrderDTO) {
		Long orderId=null;
		if(operatorOrderDTO!=null)
		{
			OperatorOrderTL orderTL=new OperatorOrderTL();
			orderTL.setCreatedBy(operatorOrderDTO.getCreatedBy());
			orderTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			orderTL.setStatus(operatorOrderDTO.getStatus());
			orderTL.setWarehouseId(operatorOrderDTO.getWarehouseId());
			orderTL.setUpdatedBy(operatorOrderDTO.getUpdatedBy());
			if(operatorOrderDTO.getUpdatedOn()!=null)
			{
				orderTL.setUpdatedOn(new java.sql.Date(operatorOrderDTO.getUpdatedOn().getTime()));
			}
			orderTL.setOrderType(operatorOrderDTO.getOrderType());
			
			orderId=machineDAO.inserOperatorOrder(orderTL);
		}
		return orderId;
		
	}
	public Long saveOperatorOrderDetails(OperatorOrderDetailsDTO operatorOrderDetailsDTO) {
		Long orderId=null;
		if(operatorOrderDetailsDTO!=null)
		{
			OperatorOrderDetailsTL orderTL=new OperatorOrderDetailsTL();
			
			orderTL.setModel(operatorOrderDetailsDTO.getModel());
			orderTL.setOrderFor(operatorOrderDetailsDTO.getOrderFor());
			orderTL.setQuantity(operatorOrderDetailsDTO.getQuantity());
			orderTL.setType(operatorOrderDetailsDTO.getType());
			
			orderTL.setOrderId(operatorOrderDetailsDTO.getOrderId());
			orderId=machineDAO.inserOperatorOrderDetails(orderTL);
		}
		return orderId;
	}
	public OperatorOrderDTO loadOperatorOrder(Long orderId) {
		OperatorOrderDTO orderDTO=null;
		OperatorOrderTL orderTL=machineDAO.getOperatorOrder(orderId);
		if(orderTL!=null)
		{
			 	orderDTO=new OperatorOrderDTO();
				orderDTO.setCreatedBy(orderTL.getCreatedBy());
				orderDTO.setCreatedOn(orderTL.getCreatedOn());
				orderDTO.setStatus(orderTL.getStatus());
				orderDTO.setWarehouseId(orderTL.getWarehouseId());
				orderDTO.setOrderId(orderTL.getOrderId());
				orderDTO.setUpdatedBy(orderTL.getUpdatedBy());
				orderDTO.setUpdatedOn(orderTL.getUpdatedOn());
				orderDTO.setShiptedBy(orderTL.getShiptedBy());
				orderDTO.setDescription(orderTL.getDescription());
				orderDTO.setShiptedOn(orderTL.getShiptedOn());
				orderDTO.setOrderType(orderTL.getOrderType());
		}
		return orderDTO;
	}
	
	public void modifyOperatorOrder(Long orderId, String description, String status,
			Long updatedBy) {
		machineDAO.updateOperatorOrder(orderId, description, status, updatedBy);
		
	}
	public void modifyOperatorOrder(Long orderId, String status, Long shiptedBy) {
		machineDAO.updateOperatorOrder(orderId,  status, shiptedBy);
		
	}
	public boolean isMachineExist(String machineSno) {
		
		return machineDAO.isMachineExist(machineSno);
	}
	public boolean isMachineAvailable(String machineSno) {
		return machineDAO.isMachineAvailable(machineSno);
	}
	public Long saveAgencyMachineSales(MachineSalesDTO machineSalesDTO) {
		Long machineSalesId=null;
		if(machineSalesDTO!=null)
		{
			AgencyMachineSalesTL machineSalesTL=new AgencyMachineSalesTL();
			machineSalesTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			machineSalesTL.setMachineId(machineSalesDTO.getMachineId());
			machineSalesTL.setOrderId(machineSalesDTO.getOrderId());
			machineSalesId=machineDAO.insertAgencyMachineSales(machineSalesTL);
		}
		return machineSalesId;
	}
	public boolean isAgencyMachineAvailable(String machineSno,Long agencyId)
	{
		return machineDAO.isAgencyMachineAvailable(machineSno, agencyId);
	}
	public List<MachineDTO> loadAgencyMachineSales(Long orderId) {
		List<MachineDTO> machines=null;
		List<MachineTL> lmachines=machineDAO.getAgencyMachineSales(orderId);
		if(lmachines!=null && lmachines.size()>0)
		{
			machines=new ArrayList<MachineDTO>();
			ListIterator<MachineTL> li=lmachines.listIterator();
			while(li.hasNext())
			{
					MachineTL machine=li.next();
					MachineDTO machineDTO=new MachineDTO();
					machineDTO.setMachineColour(machine.getMachineColour());
					machineDTO.setCreatedBy(machine.getCreatedBy());
					machineDTO.setCreatedOn(machine.getCreatedOn());
					machineDTO.setMachineColour(machine.getMachineColour());
					machineDTO.setMachineDepth(machine.getMachineDepth());
					machineDTO.setMachineHeight(machine.getMachineHeight());
					machineDTO.setMachineKind(machine.getMachineKind());
					machineDTO.setMachineModel(machine.getMachineModel());
					machineDTO.setMachinePhotoName(machine.getMachinePhotoName());
					machineDTO.setMachineSno(machine.getMachineSno());
					machineDTO.setMachineWeight(machine.getMachineWeight());
					machineDTO.setMachineWidth(machine.getMachineWidth());
					machineDTO.setStatus(machine.getStatus());
					machineDTO.setWarehouseId(machine.getWarehouseId());
					machineDTO.setMachineId(machine.getMachineId());
					
					machines.add(machineDTO);
					
			}
			
			
		}
		return machines;
	}
	public MachineSupplierDTO loadMachineSupplier(Long machineSupplierId) {
		MachineSupplierDTO machineSupplierDTO=null;
		MachineSupplierTL machineSupplierTL=machineDAO.getMachineSupplier(machineSupplierId);
		if(machineSupplierTL!=null)
		{
			machineSupplierDTO.setCreatedBy(machineSupplierTL.getCreatedBy());
			machineSupplierDTO.setCreatedOn(machineSupplierTL.getCreatedOn());
			machineSupplierDTO.setMachineId(machineSupplierTL.getMachineId());
			machineSupplierDTO.setStatus(machineSupplierTL.getStatus());
			machineSupplierDTO.setSupplierId(machineSupplierTL.getSupplierId());
			machineSupplierDTO.setUpdatedBy(machineSupplierTL.getUpdatedBy());
			machineSupplierDTO.setUpdatedOn(machineSupplierTL.getUpdatedOn());
			machineSupplierDTO.setMachineSupplierId(machineSupplierTL.getMachineSupplierId());
		}
		
		return machineSupplierDTO;
	}
	public void modifyMachineSupplier(MachineSupplierDTO machineSupplierDTO) {
		if(machineSupplierDTO!=null)
		{
			MachineSupplierTL machineSupplierTL=new MachineSupplierTL();
			machineSupplierTL.setCreatedBy(machineSupplierDTO.getCreatedBy());
			machineSupplierTL.setCreatedOn(new java.sql.Date(machineSupplierDTO.getCreatedOn().getTime()));
			machineSupplierTL.setMachineId(machineSupplierDTO.getMachineId());
			machineSupplierTL.setStatus(machineSupplierDTO.getStatus());
			machineSupplierTL.setSupplierId(machineSupplierDTO.getSupplierId());
			machineSupplierTL.setUpdatedBy(machineSupplierDTO.getUpdatedBy());
			machineSupplierTL.setUpdatedOn(new java.sql.Date(new java.util.Date().getTime()));
			machineSupplierTL.setMachineSupplierId(machineSupplierDTO.getMachineSupplierId());
			machineDAO.updateMachineSupplier(machineSupplierTL);
			
		}
		
	}
	public Long saveMachineSupplier(MachineSupplierDTO machineSupplierDTO) {
		Long machineSupplierId=null;
		if(machineSupplierDTO!=null)
		{
			MachineSupplierTL machineSupplierTL=new MachineSupplierTL();
			machineSupplierTL.setCreatedBy(machineSupplierDTO.getCreatedBy());
			machineSupplierTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			machineSupplierTL.setMachineId(machineSupplierDTO.getMachineId());
			machineSupplierTL.setStatus(machineSupplierDTO.getStatus());
			machineSupplierTL.setSupplierId(machineSupplierDTO.getSupplierId());
			//machineSupplierTL.setUpdatedBy(machineSupplierDTO.getUpdatedBy());
			//machineSupplierTL.setUpdatedOn(new java.sql.Date(new java.util.Date().getTime()));
			//machineSupplierTL.setMachineSupplierId(machineSupplierDTO.getMachineSupplierId());
			machineSupplierId=machineDAO.insertMachineSupplier(machineSupplierTL);
			
		}
		return machineSupplierId;
	}
	public MachineLockDTO loadMachineLock(Long machineLockId) {
		MachineLockDTO machineLockDTO=null;
		MachineLockTL machineLockTL=machineDAO.getMachineLock(machineLockId);
		if(machineLockTL!=null)
		{
			machineLockDTO.setCreatedBy(machineLockTL.getCreatedBy());
			machineLockDTO.setCreatedOn(machineLockTL.getCreatedOn());
			machineLockDTO.setMachineId(machineLockTL.getMachineId());
			machineLockDTO.setStatus(machineLockTL.getStatus());
			machineLockDTO.setLockId(machineLockTL.getLockId());
			machineLockDTO.setUpdatedBy(machineLockTL.getUpdatedBy());
			machineLockDTO.setUpdatedOn(machineLockTL.getUpdatedOn());
			machineLockDTO.setMachineLockId(machineLockTL.getMachineLockId());
		}
		
		return machineLockDTO;
	}
	public void modifyMachineLock(MachineLockDTO machineLockDTO) {
		if(machineLockDTO!=null)
		{
			MachineLockTL machineLockTL=new MachineLockTL();
			machineLockTL.setCreatedBy(machineLockDTO.getCreatedBy());
			machineLockTL.setCreatedOn(new java.sql.Date(machineLockDTO.getCreatedOn().getTime()));
			machineLockTL.setMachineId(machineLockDTO.getMachineId());
			machineLockTL.setStatus(machineLockDTO.getStatus());
			machineLockTL.setLockId(machineLockDTO.getLockId());
			machineLockTL.setUpdatedBy(machineLockDTO.getUpdatedBy());
			machineLockTL.setUpdatedOn(new java.sql.Date(new java.util.Date().getTime()));
			machineLockTL.setMachineLockId(machineLockDTO.getMachineLockId());
			machineDAO.updateMachineLock(machineLockTL);
			
		}
		
	}
	public Long saveMachineLock(MachineLockDTO machineLockDTO) {
		Long id=null;
		if(machineLockDTO!=null)
		{
			MachineLockTL machineLockTL=new MachineLockTL();
			machineLockTL.setCreatedBy(machineLockDTO.getCreatedBy());
			machineLockTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			machineLockTL.setMachineId(machineLockDTO.getMachineId());
			machineLockTL.setStatus(machineLockDTO.getStatus());
			machineLockTL.setLockId(machineLockDTO.getLockId());
			;
			id=machineDAO.insertMachineLock(machineLockTL);
			
		}
		return id;
	}
	public MachineDTO operatorMachine(String machineSno, Long operatorId) {
		MachineDTO machineDTO=null;
		MachineTL machine=machineDAO.operatorMachine(machineSno, operatorId);
		if(machine!=null)
		{
			machineDTO=new MachineDTO();
			machineDTO.setMachineColour(machine.getMachineColour());
			machineDTO.setCreatedBy(machine.getCreatedBy());
			machineDTO.setCreatedOn(machine.getCreatedOn());
			machineDTO.setMachineColour(machine.getMachineColour());
			machineDTO.setMachineDepth(machine.getMachineDepth());
			machineDTO.setMachineHeight(machine.getMachineHeight());
			machineDTO.setMachineKind(machine.getMachineKind());
			machineDTO.setMachineModel(machine.getMachineModel());
			machineDTO.setMachinePhotoName(machine.getMachinePhotoName());
			machineDTO.setMachineSno(machine.getMachineSno());
			machineDTO.setMachineWeight(machine.getMachineWeight());
			machineDTO.setMachineWidth(machine.getMachineWidth());
			machineDTO.setStatus(machine.getStatus());
			machineDTO.setWarehouseId(machine.getWarehouseId());
			machineDTO.setMachineId(machine.getMachineId());
		}
		return machineDTO;
	}
	public void modifyMachineLock(String lockIds, Long machineId,Long updatedBy) {
		machineDAO.updateMachineLock(lockIds, machineId,updatedBy);
		
	}
	public void modifyMachineSuppplier(String supIds, Long machineId,
			Long updatedBy) {
		machineDAO.updateMachineSuppplier(supIds, machineId, updatedBy);
		
	}
	public Long saveMachinePartner(MachinePartnerDTO machinePartnerDTO) {
		Long machinePartnerId=null;
		if(machinePartnerDTO!=null)
		{
			MachinePartnerTL machinePartnerTL=new MachinePartnerTL();
			machinePartnerTL.setCreatedBy(machinePartnerDTO.getCreatedBy());
			machinePartnerTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			machinePartnerTL.setMachineId(machinePartnerDTO.getMachineId());
			machinePartnerTL.setPartnerId(machinePartnerDTO.getPartnerId());
			machinePartnerTL.setLoactionId(machinePartnerDTO.getLoactionId());
			machinePartnerTL.setStatus(machinePartnerDTO.getStatus());
			machinePartnerTL.setPartnerId(machinePartnerDTO.getPartnerId());
			
			machinePartnerId=machineDAO.insertMachinePartner(machinePartnerTL);
			
		}
		return machinePartnerId;
	}
	public MachinePartnerDTO loadMachinePartner(Long machineId, String status) {
		MachinePartnerDTO machinePartner=null;
		MachinePartnerTL machinePartnerTL=machineDAO.getMachinePartner(machineId, status);
		if(machinePartnerTL!=null)
		{	machinePartner=new MachinePartnerDTO();
			machinePartner.setCreatedBy(machinePartnerTL.getCreatedBy());
			machinePartner.setCreatedOn(machinePartnerTL.getCreatedOn());
			machinePartner.setMachineId(machinePartnerTL.getMachineId());
			machinePartner.setPartnerId(machinePartnerTL.getPartnerId());
			machinePartner.setLoactionId(machinePartnerTL.getLoactionId());
			machinePartner.setStatus(machinePartnerTL.getStatus());
			machinePartner.setPartnerId(machinePartnerTL.getPartnerId());
		}
		
		return machinePartner;
	}
	public void modifyMachinePartner(Long machineId, String status,Long updatedBy) {
		machineDAO.updateMachinePartner(machineId, status,updatedBy);
		
	}
	public List<MachineDTO> loadMachines(Long supplierId, String status) {
		List<MachineDTO> machines=null;
		List<MachineTL> machs=machineDAO.getMachines(supplierId, status);
		if(machs!=null && machs.size()>0)
		{
			machines=new ArrayList<MachineDTO>();
			ListIterator<MachineTL> li=machs.listIterator();
			while(li.hasNext())
			{
				MachineTL machine=li.next();
				MachineDTO machineDTO=new MachineDTO();
				machineDTO.setMachineColour(machine.getMachineColour());
				machineDTO.setCreatedBy(machine.getCreatedBy());
				machineDTO.setCreatedOn(machine.getCreatedOn());
				machineDTO.setMachineColour(machine.getMachineColour());
				machineDTO.setMachineDepth(machine.getMachineDepth());
				machineDTO.setMachineHeight(machine.getMachineHeight());
				machineDTO.setMachineKind(machine.getMachineKind());
				machineDTO.setMachineModel(machine.getMachineModel());
				machineDTO.setMachinePhotoName(machine.getMachinePhotoName());
				machineDTO.setMachineSno(machine.getMachineSno());
				machineDTO.setMachineWeight(machine.getMachineWeight());
				machineDTO.setMachineWidth(machine.getMachineWidth());
				machineDTO.setStatus(machine.getStatus());
				machineDTO.setWarehouseId(machine.getWarehouseId());
				machineDTO.setMachineId(machine.getMachineId());
				
				machines.add(machineDTO);
			}
		}
		return machines;
		
	}
	public List<MachineDTO> loadLoactionMachines(Long locationId, String status) {
		List<MachineDTO> machines=null;
		List<MachineTL> machs=machineDAO.getLoactionMachines(locationId, status);
		if(machs!=null && machs.size()>0)
		{
			machines=new ArrayList<MachineDTO>();
			ListIterator<MachineTL> li=machs.listIterator();
			while(li.hasNext())
			{
				MachineTL machine=li.next();
				MachineDTO machineDTO=new MachineDTO();
				machineDTO.setMachineColour(machine.getMachineColour());
				machineDTO.setCreatedBy(machine.getCreatedBy());
				machineDTO.setCreatedOn(machine.getCreatedOn());
				machineDTO.setMachineColour(machine.getMachineColour());
				machineDTO.setMachineDepth(machine.getMachineDepth());
				machineDTO.setMachineHeight(machine.getMachineHeight());
				machineDTO.setMachineKind(machine.getMachineKind());
				machineDTO.setMachineModel(machine.getMachineModel());
				machineDTO.setMachinePhotoName(machine.getMachinePhotoName());
				machineDTO.setMachineSno(machine.getMachineSno());
				machineDTO.setMachineWeight(machine.getMachineWeight());
				machineDTO.setMachineWidth(machine.getMachineWidth());
				machineDTO.setStatus(machine.getStatus());
				machineDTO.setWarehouseId(machine.getWarehouseId());
				machineDTO.setMachineId(machine.getMachineId());
				
				machines.add(machineDTO);
			}
		}
		return machines;
		
	}
	@Override
	public List<MachineDTO> loadPartnerMachines(Long machineId) {
		// TODO Auto-generated method stub
		List<MachineDTO> machines=null;
		List<MachineTL> machs=machineDAO.getPartnerMachines(machineId);
		if(machs!=null && machs.size()>0)
		{
			machines=new ArrayList<MachineDTO>();
			ListIterator<MachineTL> li=machs.listIterator();
			while(li.hasNext())
			{
				MachineTL machine=li.next();
				MachineDTO machineDTO=new MachineDTO();
				machineDTO.setMachineColour(machine.getMachineColour());
				machineDTO.setCreatedBy(machine.getCreatedBy());
				machineDTO.setCreatedOn(machine.getCreatedOn());
				machineDTO.setMachineColour(machine.getMachineColour());
				machineDTO.setMachineDepth(machine.getMachineDepth());
				machineDTO.setMachineHeight(machine.getMachineHeight());
				machineDTO.setMachineKind(machine.getMachineKind());
				machineDTO.setMachineModel(machine.getMachineModel());
				machineDTO.setMachinePhotoName(machine.getMachinePhotoName());
				machineDTO.setMachineSno(machine.getMachineSno());
				machineDTO.setMachineWeight(machine.getMachineWeight());
				machineDTO.setMachineWidth(machine.getMachineWidth());
				machineDTO.setStatus(machine.getStatus());
				machineDTO.setWarehouseId(machine.getWarehouseId());
				machineDTO.setMachineId(machine.getMachineId());
				
				machines.add(machineDTO);
			}
		}
		return machines;
	}

}
