package com.moaddi.service;

import java.util.List;
import java.util.Map;

import com.moaddi.dao.model.MachineLockTL;
import com.moaddi.dao.model.MachinePartnerTL;
import com.moaddi.dao.model.MachineSalesTL;
import com.moaddi.dao.model.MachineSupplierTL;
import com.moaddi.dao.model.MachineTL;
import com.moaddi.dao.model.OrderDetailsTL;
import com.moaddi.dao.model.OrderTL;
import com.moaddi.service.dto.LockDTO;
import com.moaddi.service.dto.MachineDTO;
import com.moaddi.service.dto.MachineLockDTO;
import com.moaddi.service.dto.MachinePartnerDTO;
import com.moaddi.service.dto.MachinePriceDTO;
import com.moaddi.service.dto.MachineSalesDTO;
import com.moaddi.service.dto.MachineSupplierDTO;
import com.moaddi.service.dto.OperatorOrderDTO;
import com.moaddi.service.dto.OperatorOrderDetailsDTO;
import com.moaddi.service.dto.OrderDTO;

import com.moaddi.service.dto.OrderDetailsDTO;
import com.moaddi.service.dto.VehicleAdDTO;

public interface VehicleAdService {
	public Long saveVehicleAd(VehicleAdDTO vehicleAdDTO);
	public VehicleAdDTO loadAd();

}
