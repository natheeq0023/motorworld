package com.moaddi.dao.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Items_Percentage_TL")
@org.hibernate.annotations.Entity(
		dynamicUpdate = true
) 
public class ItemsPercentageTL {

	@Id
	@GeneratedValue
	private Long itemsPercentageId;
	
	private String country;
	private String city;
	private String itemBarcode;
	private Double itemPercentage;
	private Date createdOn;
	private Long createdBy;
	
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
	public Long getItemsPercentageId() {
		return itemsPercentageId;
	}
	public void setItemsPercentageId(Long itemsPercentageId) {
		this.itemsPercentageId = itemsPercentageId;
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
	
	
}
