package com.moaddi.dao.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Machine_Sales_TL")
@org.hibernate.annotations.Entity(
		dynamicUpdate = true
)
public class MachineSalesTL {
	@Id
	@GeneratedValue
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
