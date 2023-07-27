package com.moaddi.ui.forms;

import org.springframework.web.multipart.MultipartFile;

public class VehicleServiceForm {
	private Long customerId;
	private String area;
	private String vtype;
	private String vbrand;
	private String mobileNo;
	public String vehicleYear;

	public String getVehicleYear() {
		return vehicleYear;
	}
	public void setVehicleYear(String vehicleYear) {
		this.vehicleYear = vehicleYear;
	}
	private String email;
	private String fullName;
	private String vehicleName;
	private String rtoservicetype;
	private String issues;
	public String getRtoservicetype() {
		return rtoservicetype;
	}
	public void setRtoservicetype(String rtoservicetype) {
		this.rtoservicetype = rtoservicetype;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getEmail() {
		return email;
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
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getIssues() {
		return issues;
	}
	public void setIssues(String issues) {
		this.issues = issues;
	}
}
