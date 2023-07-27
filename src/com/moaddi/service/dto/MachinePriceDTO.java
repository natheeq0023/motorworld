package com.moaddi.service.dto;

import java.util.Date;

public class MachinePriceDTO {
	
	private Long machinePriceId;
	private String machineKind;
	private String machineModel;
	private Double price;
	private Double discount;
	private Date fromDate;
	private Date toDate;
	private Date createdOn;
	private Date updatedOn;
	private Long createdBy;
	private Long updatedBy;
	public Long getMachinePriceId() {
		return machinePriceId;
	}
	public void setMachinePriceId(Long machinePriceId) {
		this.machinePriceId = machinePriceId;
	}
	
	public String getMachineKind() {
		return machineKind;
	}
	public void setMachineKind(String machineKind) {
		this.machineKind = machineKind;
	}
	public String getMachineModel() {
		return machineModel;
	}
	public void setMachineModel(String machineModel) {
		this.machineModel = machineModel;
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
	

}
