package com.moaddi.ui.forms;

public class MachinePartnerForm {
	
	private Integer machineId;
	private Integer userRoleId;
	private Integer locationId;
	private String connectedLocationId;
	public String getConnectedLocationId() {
		return connectedLocationId;
	}
	public void setConnectedLocationId(String connectedLocationId) {
		this.connectedLocationId = connectedLocationId;
	}
	public Integer getMachineId() {
		return machineId;
	}
	public void setMachineId(Integer machineId) {
		this.machineId = machineId;
	}
	public Integer getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	
	

}
