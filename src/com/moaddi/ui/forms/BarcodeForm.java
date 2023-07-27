package com.moaddi.ui.forms;

import org.springframework.web.multipart.MultipartFile;

public class BarcodeForm {
	
	
	private MultipartFile machinePhoto;

	public MultipartFile getMachinePhoto() {
		return machinePhoto;
	}

	public void setMachinePhoto(MultipartFile machinePhoto) {
		this.machinePhoto = machinePhoto;
	}
	

}
