package com.moaddi.dao.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Operator_Partner_Request_TL")
@org.hibernate.annotations.Entity(
		dynamicUpdate = true
)
public class OperatorPartnerRequestTL {
	
	@Id
	@GeneratedValue
	private Long operatorPartnerId;
	private String status;	
	private String userRoleId;
	private String startDate;
	private String enddate;
	private String model;
	private String contractId;
	private String month;
	private String fullName;
	private Date createdOn;
	private Long createdBy;
	private Long updatedBy;
	private Long customerId;
	private String percentage;
	private String percentagemonth;
	private String amountnow;
	private String amountmonth;
	public String getPercentagemonth() {
		return percentagemonth;
	}
	public void setPercentagemonth(String percentagemonth) {
		this.percentagemonth = percentagemonth;
	}
	public String getAmountnow() {
		return amountnow;
	}
	public void setAmountnow(String amountnow) {
		this.amountnow = amountnow;
	}
	public String getAmountmonth() {
		return amountmonth;
	}
	public void setAmountmonth(String amountmonth) {
		this.amountmonth = amountmonth;
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
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	private Date updatedOn;
	
	private Long userId;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getOperatorPartnerId() {
		return operatorPartnerId;
	}
	public void setOperatorPartnerId(Long operatorPartnerId) {
		this.operatorPartnerId = operatorPartnerId;
	}
	public String getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
}
