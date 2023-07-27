package com.moaddi.ui.forms;

import org.springframework.web.multipart.MultipartFile;

public class ItemForm {

	
	private String itemBarcode;
	private String itemName;
	private String itemSize;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String itemIngredients;
	private String itemGruop;

	public String getItemGruop() {
		return itemGruop;
	}
	public void setItemGruop(String itemGruop) {
		this.itemGruop = itemGruop;
	}
	private MultipartFile itemPhoto;
	
	public String getItemBarcode() {
		return itemBarcode;
	}
	public void setItemBarcode(String itemBarcode) {
		this.itemBarcode = itemBarcode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
	public MultipartFile getItemPhoto() {
		return itemPhoto;
	}
	public void setItemPhoto(MultipartFile itemPhoto) {
		this.itemPhoto = itemPhoto;
	}
	
}
