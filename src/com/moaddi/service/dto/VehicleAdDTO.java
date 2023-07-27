package com.moaddi.service.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class VehicleAdDTO {
	private Long adId;
	private String Vtype;
	private String title;
	private Double price;
	private String vehiclePhotoName;

	private Date createdOn;
	private Date updatedOn;
	private Long createdBy;
	private Long updatedBy;
	private String status;

	public Long getAdId() {
		return adId;
	}
	public void setAdId(Long adId) {
		this.adId = adId;
	}
	public String getVtype() {
		return Vtype;
	}
	public void setVtype(String vtype) {
		Vtype = vtype;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getVehiclePhotoName() {
		return vehiclePhotoName;
	}
	public void setVehiclePhotoName(String vehiclePhotoName) {
		this.vehiclePhotoName = vehiclePhotoName;
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
