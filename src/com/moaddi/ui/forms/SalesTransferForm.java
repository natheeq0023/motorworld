package com.moaddi.ui.forms;

public class SalesTransferForm {
	
	private String[] machineSno;
	private String[] lockSno;
	private Long orderId;
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String[] getMachineSno() {
		return machineSno;
	}
	public void setMachineSno(String[] machineSno) {
		this.machineSno = machineSno;
	}
	public String[] getLockSno() {
		return lockSno;
	}
	public void setLockSno(String[] lockSno) {
		this.lockSno = lockSno;
	}
	

}
