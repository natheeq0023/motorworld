package com.moaddi.ui.forms;

import org.springframework.web.multipart.MultipartFile;

public class MachineForm {
	
	private String machineSerialNo;
	private String machineKind;
	private String machineModel;
	private Double machinePrice;
	private String machineColor;
	private String depth;
	private String height;
	private String width;
	private String weight;
	private Long warehouseId; 
	private MultipartFile machinePhoto;
	public String getMachineSerialNo() {
		return machineSerialNo;
	}
	public void setMachineSerialNo(String machineSerialNo) {
		this.machineSerialNo = machineSerialNo;
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
	public Double getMachinePrice() {
		return machinePrice;
	}
	public void setMachinePrice(Double machinePrice) {
		this.machinePrice = machinePrice;
	}
	public String getMachineColor() {
		return machineColor;
	}
	public void setMachineColor(String machineColor) {
		this.machineColor = machineColor;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public Long getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
	public MultipartFile getMachinePhoto() {
		return machinePhoto;
	}
	public void setMachinePhoto(MultipartFile machinePhoto) {
		this.machinePhoto = machinePhoto;
	}
	

}
