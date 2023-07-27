package com.moaddi.ui.forms;

import org.springframework.web.multipart.MultipartFile;

public class OperatorPartnerRequestForm {
	
	public Long getOperatorPartnerId() {
		return operatorPartnerId;
	}
	public void setOperatorPartnerId(Long operatorPartnerId) {
		this.operatorPartnerId = operatorPartnerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Long userRoleId) {
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
	private Long operatorPartnerId;
	private String status;	
	private Long userRoleId;
	private String startDate;
	private String enddate;
	private String model;
	private String contractId;
	private String month;
	private String fullName;
	private Long userId;
}
