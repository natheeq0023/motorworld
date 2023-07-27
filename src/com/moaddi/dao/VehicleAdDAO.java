package com.moaddi.dao;

import java.util.List;
import java.util.Map;

import com.moaddi.dao.model.AgencyMachineSalesTL;
import com.moaddi.dao.model.LockTL;
import com.moaddi.dao.model.MachineLockTL;
import com.moaddi.dao.model.MachinePartnerTL;
import com.moaddi.dao.model.MachinePriceTL;
import com.moaddi.dao.model.MachineSalesTL;
import com.moaddi.dao.model.MachineSupplierTL;
import com.moaddi.dao.model.MachineTL;
import com.moaddi.dao.model.OperatorOrderDetailsTL;
import com.moaddi.dao.model.OperatorOrderTL;
import com.moaddi.dao.model.OrderDetailsTL;
import com.moaddi.dao.model.OrderTL;
import com.moaddi.dao.model.VehicleAdTL;


public interface VehicleAdDAO {
	public Long insertVehicleAd(VehicleAdTL vehicleAdTL);
}
