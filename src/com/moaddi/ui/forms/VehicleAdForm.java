package com.moaddi.ui.forms;

import org.springframework.web.multipart.MultipartFile;

public class VehicleAdForm {
	
	private String Vtype;
	private String title;
	private Double price;
	private MultipartFile vehiclePhoto;

	public String getVtype() {
		return Vtype;
	}

	public void setVtype(String vtype) {
		Vtype = vtype;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public MultipartFile getVehiclePhoto() {
		return vehiclePhoto;
	}

	public void setVehiclePhoto(MultipartFile vehiclePhoto) {
		this.vehiclePhoto = vehiclePhoto;
	}
}
