package com.moaddi.service.dto;

import java.util.Date;


public class MachineSalesDTO {
	
	private Long MachineSalesId;
	private Long orderId;
	private Date createdOn;
	private Long machineId;
	public Long getMachineSalesId() {
		return MachineSalesId;
	}
	public void setMachineSalesId(Long machineSalesId) {
		MachineSalesId = machineSalesId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Long getMachineId() {
		return machineId;
	}
	public void setMachineId(Long machineId) {
		this.machineId = machineId;
	}
	
	

}
