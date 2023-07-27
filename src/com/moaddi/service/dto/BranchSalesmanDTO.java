package com.moaddi.service.dto;

import java.sql.Date;

public class BranchSalesmanDTO {
	
	private Long branchSalesmanId;
	private Long branchId;
	private Long salesmanId;
	private Date createdOn;
	public Long getBranchSalesmanId() {
		return branchSalesmanId;
	}
	public void setBranchSalesmanId(Long branchSalesmanId) {
		this.branchSalesmanId = branchSalesmanId;
	}
	public Long getBranchId() {
		return branchId;
	}
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
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
