package com.moaddi.service;

import java.util.List;
import java.util.Map;


import com.moaddi.service.dto.VehicleAdDTO;

public interface VehicleAdService {
	public Long saveVehicleAd(VehicleAdDTO vehicleAdDTO);
	public VehicleAdDTO loadAd();

}
