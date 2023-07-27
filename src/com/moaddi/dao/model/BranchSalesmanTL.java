package com.moaddi.dao.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Branch_Salesman_TL")
@org.hibernate.annotations.Entity(
		dynamicUpdate = true
) 
public class BranchSalesmanTL {
	@Id
	@GeneratedValue
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
