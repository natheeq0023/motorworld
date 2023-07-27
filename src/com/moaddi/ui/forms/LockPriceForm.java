package com.moaddi.ui.forms;

public class LockPriceForm {
	
	private String lockKind;
	private String lockModel;
	private Double price;
	private Double discount;
	private String startDate;
	private String endDate;
	
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
