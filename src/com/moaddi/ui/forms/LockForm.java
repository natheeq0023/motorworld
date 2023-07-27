package com.moaddi.ui.forms;

import org.springframework.web.multipart.MultipartFile;

public class LockForm {
	
	private String lockSerialNo;
	private String lockKind;
	private String lockModel;
	private Double lockPrice;
	private String lockColor;
	private String depth;
	private String height;
	private String width;
	private String weight;
	private Long warehouseId; 
	private MultipartFile lockPhoto;
	public String getLockSerialNo() {
		return lockSerialNo;
	}
	public void setLockSerialNo(String lockSerialNo) {
		this.lockSerialNo = lockSerialNo;
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
	public Double getLockPrice() {
		return lockPrice;
	}
	public void setLockPrice(Double lockPrice) {
		this.lockPrice = lockPrice;
	}
	public String getLockColor() {
		return lockColor;
	}
	public void setLockColor(String lockColor) {
		this.lockColor = lockColor;
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
	public MultipartFile getLockPhoto() {
		return lockPhoto;
	}
	public void setLockPhoto(MultipartFile lockPhoto) {
		this.lockPhoto = lockPhoto;
	}
	

}
