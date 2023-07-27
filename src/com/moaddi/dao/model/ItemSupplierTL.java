package com.moaddi.dao.model;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Item_Supplier_TL")
@org.hibernate.annotations.Entity(
		dynamicUpdate = true
)
public class ItemSupplierTL {
	
	@Id
	@GeneratedValue
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
