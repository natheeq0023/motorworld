package com.moaddi.service.dto;

import java.util.Date;
import java.util.List;

public class LockDTO {
	private Long lockId;
	private String lockSno;
	private String lockKind;
	private String lockModel;
	private String lockPhotoName;
	private String lockColour;
	private String lockHeight;
	private String lockDepth;
	private String lockWidth;
	private String lockWeight;
	private Long warehouseId;
	private Date createdOn;
	private Date updatedOn;
	private Long createdBy;
	private Long updatedBy;
	private String status;
	private List<String> photos;
	public Long getLockId() {
		return lockId;
	}
	public void setLockId(Long lockId) {
		this.lockId = lockId;
	}
	public String getLockSno() {
		return lockSno;
	}
	public void setLockSno(String lockSno) {
		this.lockSno = lockSno;
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
	public String getLockPhotoName() {
		return lockPhotoName;
	}
	public void setLockPhotoName(String lockPhotoName) {
		this.lockPhotoName = lockPhotoName;
	}
	public String getLockColour() {
		return lockColour;
	}
	public void setLockColour(String lockColour) {
		this.lockColour = lockColour;
	}
	public String getLockHeight() {
		return lockHeight;
	}
	public void setLockHeight(String lockHeight) {
		this.lockHeight = lockHeight;
	}
	public String getLockDepth() {
		return lockDepth;
	}
	public void setLockDepth(String lockDepth) {
		this.lockDepth = lockDepth;
	}
	public String getLockWidth() {
		return lockWidth;
	}
	public void setLockWidth(String lockWidth) {
		this.lockWidth = lockWidth;
	}
	public String getLockWeight() {
		return lockWeight;
	}
	public void setLockWeight(String lockWeight) {
		this.lockWeight = lockWeight;
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
	public List<String> getPhotos() {
		return photos;
	}
	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}

	

}
