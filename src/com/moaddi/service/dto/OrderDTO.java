package com.moaddi.service.dto;

import java.util.Date;

public class OrderDTO {
	
	private Long orderId;
	private String status;
	private Date createdOn;
	private Long createdBy;
	private Long updatedBy;
	private Long warehouseId;
	private String description;
	private Date updatedOn;
	private Date shiptedOn;
	private Long shiptedBy;
	private String orderType;
	
	

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Date getShiptedOn() {
		return shiptedOn;
	}

	public void setShiptedOn(Date shiptedOn) {
		this.shiptedOn = shiptedOn;
	}

	public Long getShiptedBy() {
		return shiptedBy;
	}

	public void setShiptedBy(Long shiptedBy) {
		this.shiptedBy = shiptedBy;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

}
