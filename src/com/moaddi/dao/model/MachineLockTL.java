package com.moaddi.dao.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Machine_Lock_TL")
@org.hibernate.annotations.Entity(
		dynamicUpdate = true
)
public class MachineLockTL {
	@Id
	@GeneratedValue
	private Long machineLockId;
	private Long lockId;
	private Long machineId;
	private Long createdBy;
	private Long updatedBy;
	private String status;
	private Date createdOn;
	private Date updatedOn;
	public Long getMachineLockId() {
		return machineLockId;
	}
	public void setMachineLockId(Long machineLockId) {
		this.machineLockId = machineLockId;
	}
	public Long getLockId() {
		return lockId;
	}
	public void setLockId(Long lockId) {
		this.lockId = lockId;
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
