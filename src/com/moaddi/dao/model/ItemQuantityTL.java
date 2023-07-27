package com.moaddi.dao.model;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Item_Quantity_TL")
@org.hibernate.annotations.Entity(
		dynamicUpdate = true
)
public class ItemQuantityTL {
	
	@Id
	@GeneratedValue
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
