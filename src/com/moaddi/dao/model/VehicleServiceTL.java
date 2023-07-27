package com.moaddi.dao.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Vehicle_Service_Request_TL")
@org.hibernate.annotations.Entity(
		dynamicUpdate = true
) 
public class VehicleServiceTL {
	@Id
	@GeneratedValue
	private Long serviveRequestId;
	private String area;
	private String vtype;
	private String vbrand;
	private String issues;
	public String getVehicleYear() {
		return vehicleYear;
	}


	private String mobileNo;
	private String vehicleName;
	private String email;
	private String vehicleYear;
	public void setVehicleYear(String vehicleYear) {
		this.vehicleYear = vehicleYear;
	}


	private String fullName;
	private String updatedBy;
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String createdBy;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
	private Long customerId;
	private String status;
	private String comment;
	private Long approvedBy;
	private Date createdOn;
	private Date updatedOn;
	
	
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
	public Long getServiveRequestId() {
		return serviveRequestId;
	}
	public void setServiveRequestId(Long serviveRequestId) {
		this.serviveRequestId = serviveRequestId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getVtype() {
		return vtype;
	}
	public void setVtype(String vtype) {
		this.vtype = vtype;
	}
	public String getVbrand() {
		return vbrand;
	}
	public void setVbrand(String vbrand) {
		this.vbrand = vbrand;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
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