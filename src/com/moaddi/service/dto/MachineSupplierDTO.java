package com.moaddi.service.dto;

import java.util.Date;

public class MachineSupplierDTO {
	private Long machineSupplierId;
	private Long supplierId;
	private Long machineId;
	private Long createdBy;
	private Long updatedBy;
	private String status;
	private Date createdOn;
	private Date updatedOn;
	public Long getMachineSupplierId() {
		return machineSupplierId;
	}
	public void setMachineSupplierId(Long machineSupplierId) {
		this.machineSupplierId = machineSupplierId;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public Long getMachineId() {
		return machineId;
	}
	public void setMachineId(Long machineId) {
		this.machineId = machineId;
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
	

}
