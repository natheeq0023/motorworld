package com.moaddi.service.dto;

import java.util.Date;

public class VehicleServiceDTO {
	private Long vehicleSeviceRequestId;
	
	private Long customerId;
	private String status;
	private String comment;
	private Long approvedBy;
	private Date createdOn;
	private Date updatedOn;
	private String email; 
	private String vtyqe;
	private String updatedBy;
	private String vbrand;
	
	private String vehicleName;
	public String vehicleYear;
	private String requesterName;
	private String issues;
	public String getVehicleYear() {
		return vehicleYear;
	}
	public void setVehicleYear(String vehicleYear) {
		this.vehicleYear = vehicleYear;
	}
	private String area;
	private String mobileNo;
	private String checkValue;
	private String country;
	private String rtoservicetype;
	
	
	public String getRtoservicetype() {
		return rtoservicetype;
	}
	public void setRtoservicetype(String rtoservicetype) {
		this.rtoservicetype = rtoservicetype;
	}
	public String getRequesterName() {
		return requesterName;
	}
	public void setRequesterName(String requesterName) {
		this.requesterName = requesterName;
	}
	
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getCheckValue() {
		return checkValue;
	}
	public void setCheckValue(String checkValue) {
		this.checkValue = checkValue;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getVtyqe() {
		return vtyqe;
	}
	public void setVtyqe(String vtyqe) {
		this.vtyqe = vtyqe;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Long getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(Long approvedBy) {
		this.approvedBy = approvedBy;
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
	public String getVbrand() {
		return vbrand;
	}
	public void setVbrand(String vbrand) {
		this.vbrand = vbrand;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public Long getVehicleSeviceRequestId() {
		return vehicleSeviceRequestId;
	}
	public void setVehicleSeviceRequestId(Long vehicleSeviceRequestId) {
		this.vehicleSeviceRequestId = vehicleSeviceRequestId;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getIssues() {
		return issues;
	}
	public void setIssues(String issues) {
		this.issues = issues;
	}
	

}
