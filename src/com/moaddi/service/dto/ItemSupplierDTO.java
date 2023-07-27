package com.moaddi.service.dto;
import java.util.Date;



public class ItemSupplierDTO {
	
	
	private Long itemSupplierId;
	private Long itemId;
	private Long supplierId;
	private Integer quantity;
	private Long warehouseId;
	private Long createdBy;
	private Date createdOn;
	
	public Long getItemSupplierId() {
		return itemSupplierId;
	}
	public void setItemSupplierId(Long itemSupplierId) {
		this.itemSupplierId = itemSupplierId;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
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
