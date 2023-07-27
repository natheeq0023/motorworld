package com.moaddi.dao.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Item_TL")
@org.hibernate.annotations.Entity(
		dynamicUpdate = true
)
public class ItemTL {
	@Id
	@GeneratedValue
	private Long itemId;
	private String itemBarcode;
	private String itemPhotoName;
	private String itemName;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String itemGruop;
	private String itemSize;
	private String itemIngredients;
	private Date createdOn;
	private Date updatedOn;
	private Long createdBy;
	private Long updatedBy;
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemBarcode() {
		return itemBarcode;
	}
	public void setItemBarcode(String itemBarcode) {
		this.itemBarcode = itemBarcode;
	}
	public String getItemPhotoName() {
		return itemPhotoName;
	}
	public void setItemPhotoName(String itemPhotoName) {
		this.itemPhotoName = itemPhotoName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemGruop() {
		return itemGruop;
	}
	public void setItemGruop(String itemGruop) {
		this.itemGruop = itemGruop;
	}
	public String getItemSize() {
		return itemSize;
	}
	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}
	public String getItemIngredients() {
		return itemIngredients;
	}
	public void setItemIngredients(String itemIngredients) {
		this.itemIngredients = itemIngredients;
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
	

}
