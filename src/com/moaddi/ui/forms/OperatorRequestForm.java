package com.moaddi.ui.forms;

import org.springframework.web.multipart.MultipartFile;

public class OperatorRequestForm {
	
	private String yearEstablished;
	public String getYearEstablished() {
		return yearEstablished;
	}

	public void setYearEstablished(String yearEstablished) {
		this.yearEstablished = yearEstablished;
	}
	
	
	
	
	
	
	

	private MultipartFile doc;
	private Long operatorRequestId;
	public MultipartFile getDoc() {
		return doc;
	}

	public Long getOperatorRequestId() {
		return operatorRequestId;
	}

	public void setOperatorRequestId(Long operatorRequestId) {
		this.operatorRequestId = operatorRequestId;
	}

	public void setDoc(MultipartFile doc) {
		this.doc = doc;
	}

	private String country;
	private String city;
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	private String organizationName;
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}



	public String getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

	public String getRequesterName() {
		return requesterName;
	}

	public void setRequesterName(String requesterName) {
		this.requesterName = requesterName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	private String organizationType;
	private String requesterName;
	private String street;
	private String mobileNo;
	private String checkValue;
	private String fullName;
	
	private Long customerId;
	private String salesManId;
	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	private String status;
	private String comment;
	private Long agencyRequestId;
	private String email;
	private String countryCode;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}



	public Long getAgencyRequestId() {
		return agencyRequestId;
	}

	public void setAgencyRequestId(Long agencyRequestId) {
		this.agencyRequestId = agencyRequestId;
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

	public String getSalesManId() {
		return salesManId;
	}

	public void setSalesManId(String salesManId) {
		this.salesManId = salesManId;
	}

	

	
	

}
