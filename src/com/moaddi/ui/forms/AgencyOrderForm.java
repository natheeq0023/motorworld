package com.moaddi.ui.forms;

public class AgencyOrderForm {
	
	private String[] orderFor;
	private String[] type;
	private String[] model;
	private Integer[] quantity;
	private Long warehouseId;
	private Long userRoleId;
	
	
	public Long getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}
	public Long getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String[] getOrderFor() {
		return orderFor;
	}
	public void setOrderFor(String[] orderFor) {
		this.orderFor = orderFor;
	}
	public String[] getType() {
		return type;
	}
	public void setType(String[] type) {
		this.type = type;
	}
	public String[] getModel() {
		return model;
	}
	public void setModel(String[] model) {
		this.model = model;
	}
	public Integer[] getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer[] quantity) {
		this.quantity = quantity;
	}
	

}
