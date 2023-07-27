package com.moaddi.service.dto;

import java.util.Date;


public class LockSalesDTO {
	
	private Long lockSalesId;
	private Long orderId;
	private Date createdOn;
	private Long lockId;
	public Long getLockSalesId() {
		return lockSalesId;
	}
	public void setLockSalesId(Long lockSalesId) {
		this.lockSalesId = lockSalesId;
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
	public Long getLockId() {
		return lockId;
	}
	public void setLockId(Long lockId) {
		this.lockId = lockId;
	}
	
	

}
