package com.moaddi.service.dto;

import java.util.Date;


public class MachinePartnerDTO {
	
	private Long machinePartnerId;
	private Long partnerId;
	private Long loactionId;
	private Long machineId;
	private Long createdBy;
	private Long updatedBy;
	private String status;
	private Date createdOn;
	private Date updatedOn;
	public Long getMachinePartnerId() {
		return machinePartnerId;
	}
	public void setMachinePartnerId(Long machinePartnerId) {
		this.machinePartnerId = machinePartnerId;
	}
	public Long getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
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
	public Long getLoactionId() {
		return loactionId;
	}
	public void setLoactionId(Long loactionId) {
		this.loactionId = loactionId;
	}
	
	

}
