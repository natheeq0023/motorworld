package com.moaddi.dao.model;
import java.util.Date;


public class ItemLockDTO {
	
	
	private Long itemlockId;
	private Long itemId;
	private Long lockId;
	private Integer quantity;
	private Long createdBy;
	private Date createdOn;
	private String status;
	public Long getItemlockId() {
		return itemlockId;
	}
	public void setItemlockId(Long itemlockId) {
		this.itemlockId = itemlockId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Long getLockId() {
		return lockId;
	}
	public void setLockId(Long lockId) {
		this.lockId = lockId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	

}
