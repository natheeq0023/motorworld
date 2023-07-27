package com.moaddi.service.dto;

import java.util.Date;

public class LockPriceDTO {
	private Long lockPriceId;
	private String lockKind;
	private String lockModel;
	private Double price;
	private Double discount;
	private Date fromDate;
	private Date toDate;
	private Date createdOn;
	private Date updatedOn;
	private Long createdBy;
	private Long updatedBy;
	public Long getLockPriceId() {
		return lockPriceId;
	}
	public void setLockPriceId(Long lockPriceId) {
		this.lockPriceId = lockPriceId;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
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
	public String getLockKind() {
		return lockKind;
	}
	public void setLockKind(String lockKind) {
		this.lockKind = lockKind;
	}
	public String getLockModel() {
		return lockModel;
	}
	public void setLockModel(String lockModel) {
		this.lockModel = lockModel;
	}
	
	

}
