package com.moaddi.ui.forms;

public class MachineLockForm {
	
	private Long[] lockId;
	private Long[] connectedLockId;
	private Long machineId;
	public Long[] getLockId() {
		return lockId;
	}
	public void setLockId(Long[] lockId) {
		this.lockId = lockId;
	}
	public Long[] getConnectedLockId() {
		return connectedLockId;
	}
	public void setConnectedLockId(Long[] connectedLockId) {
		this.connectedLockId = connectedLockId;
	}
	public Long getMachineId() {
		return machineId;
	}
	public void setMachineId(Long machineId) {
		this.machineId = machineId;
	}
	
	
	

}
