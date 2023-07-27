package com.moaddi.service.dto;
import java.util.Date;


public class ItemQuantityDTO {
	
	
	private Long itemQuantityId;
	private Long itemId;
	private Integer quantity;
	private Long warehouseId;
	private Long createdBy;
	private Date createdOn;
	public Long getItemQuantityId() {
		return itemQuantityId;
	}
	public void setItemQuantityId(Long itemQuantityId) {
		this.itemQuantityId = itemQuantityId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Long getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	

}
