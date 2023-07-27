package com.moaddi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moaddi.dao.VehicleAdDAO;
import com.moaddi.dao.model.VehicleAdTL;
import com.moaddi.service.VehicleAdService;
import com.moaddi.service.dto.VehicleAdDTO;

@Service("vehicleAdService")
public class VehicleAdServiceImpl implements VehicleAdService {

	@Autowired
	private VehicleAdDAO vehicleAdDAO;
	
	public Long saveVehicleAd(VehicleAdDTO vehicleAdDTO) {
		Long adId=0L;
		if(vehicleAdDTO!=null)
		{
			VehicleAdTL vehicleAdTL = new VehicleAdTL();
			vehicleAdTL.setCreatedBy(vehicleAdDTO.getCreatedBy());
			vehicleAdTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			vehicleAdTL.setPrice(vehicleAdDTO.getPrice());
			vehicleAdTL.setTitle(vehicleAdDTO.getTitle());
			vehicleAdTL.setStatus(vehicleAdDTO.getStatus());
			vehicleAdTL.setVehiclePhoto(vehicleAdDTO.getVehiclePhotoName());
			vehicleAdTL.setVtype(vehicleAdDTO.getVtype());
			
			
		
			adId=vehicleAdDAO.insertVehicleAd(vehicleAdTL);
		}
		return adId;
	}

	@Override
	public VehicleAdDTO loadAd() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
