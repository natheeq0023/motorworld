package com.moaddi.service.dto;

import java.util.Date;

public class MachineDTO {
	private Long machineId;
	private String machineSno;
	private String machineKind;
	private String machineModel;
	private String machinePhotoName;
	private String machineColour;
	private String machineHeight;
	private String machineDepth;
	private String machineWidth;
	private String machineWeight;
	private Long warehouseId;
	private Date createdOn;
	private Date updatedOn;
	private Long createdBy;
	private Long updatedBy;
	private String status;
	public Long getMachineId() {
		return machineId;
	}
	public void setMachineId(Long machineId) {
		this.machineId = machineId;
	}
	public String getMachineSno() {
		return machineSno;
	}
	public void setMachineSno(String machineSno) {
		this.machineSno = machineSno;
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
	public String getMachinePhotoName() {
		return machinePhotoName;
	}
	public void setMachinePhotoName(String machinePhotoName) {
		this.machinePhotoName = machinePhotoName;
	}
	public String getMachineColour() {
		return machineColour;
	}
	public void setMachineColour(String machineColour) {
		this.machineColour = machineColour;
	}
	public String getMachineHeight() {
		return machineHeight;
	}
	public void setMachineHeight(String machineHeight) {
		this.machineHeight = machineHeight;
	}
	public String getMachineDepth() {
		return machineDepth;
	}
	public void setMachineDepth(String machineDepth) {
		this.machineDepth = machineDepth;
	}
	public String getMachineWidth() {
		return machineWidth;
	}
	public void setMachineWidth(String machineWidth) {
		this.machineWidth = machineWidth;
	}
	public String getMachineWeight() {
		return machineWeight;
	}
	public void setMachineWeight(String machineWeight) {
		this.machineWeight = machineWeight;
	}
	public Long getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
