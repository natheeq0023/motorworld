package com.moaddi.service.dto;

import java.util.Date;



public class WarehouseSalesmanDTO {
	
	private Long warehouseSalesmanId;
	private Long warehouseId;
	private Long salesmanId;
	private Date createdOn;
	public Long getWarehouseSalesmanId() {
		return warehouseSalesmanId;
	}
	public void setWarehouseSalesmanId(Long warehouseSalesmanId) {
		this.warehouseSalesmanId = warehouseSalesmanId;
	}
	public Long getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
	public Long getSalesmanId() {
		return salesmanId;
	}
	public void setSalesmanId(Long salesmanId) {
		this.salesmanId = salesmanId;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	
	

}
