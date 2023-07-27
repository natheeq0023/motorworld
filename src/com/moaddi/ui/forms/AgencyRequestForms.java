package com.moaddi.ui.forms;

public class AgencyRequestForms {
	private String description;
	private String status;
	private String comment;
	private Integer agencyRequestId;
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

	public Integer getAgencyRequestId() {
		return agencyRequestId;
	}

	public void setAgencyRequestId(Integer agencyRequestId) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
