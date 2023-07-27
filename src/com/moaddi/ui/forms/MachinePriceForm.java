package com.moaddi.ui.forms;

public class MachinePriceForm {
	
	private String machineKind;
	private String machineModel;
	private Double price;
	private Double discount;
	private String startDate;
	private String endDate;
	
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
