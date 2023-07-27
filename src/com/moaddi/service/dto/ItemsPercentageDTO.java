package com.moaddi.service.dto;

import java.sql.Date;

public class ItemsPercentageDTO {
private Long itemsPercentageId;
	
	private String country;
	private String city;
	private String itemBarcode;
	private Double itemPercentage;
	private Date createdOn;
	private Long createdBy;
	public Long getItemsPercentageId() {
		return itemsPercentageId;
	}
	public void setItemsPercentageId(Long itemsPercentageId) {
		this.itemsPercentageId = itemsPercentageId;
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
	public String getItemBarcode() {
		return itemBarcode;
	}
	public void setItemBarcode(String itemBarcode) {
		this.itemBarcode = itemBarcode;
	}
	public Double getItemPercentage() {
		return itemPercentage;
	}
	public void setItemPercentage(Double itemPercentage) {
		this.itemPercentage = itemPercentage;
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
