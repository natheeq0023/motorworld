package com.moaddi.service.dto;

import java.util.Date;

public class AccountsPercentageDTO {
	private String accountKind;
	private String country;
	private String city;
	private String userId;
	private Double accountPercentage;
	private Date createdOn;
	private Long createdBy;
	public String getAccountKind() {
		return accountKind;
	}
	public void setAccountKind(String accountKind) {
		this.accountKind = accountKind;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Double getAccountPercentage() {
		return accountPercentage;
	}
	public void setAccountPercentage(Double accountPercentage) {
		this.accountPercentage = accountPercentage;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

}
