package com.moaddi.dao;

import java.util.List;

import com.moaddi.dao.model.BranchSalesmanTL;
import com.moaddi.dao.model.BranchTL;
import com.moaddi.dao.model.CustomerTL;
import com.moaddi.dao.model.WarehouseTL;

public interface BranchDAO {

	public Long insertBranch(BranchTL branchTL);
	public List<BranchTL> getBranches(Long createdBy);
	public Long insertBranchSalesman(BranchSalesmanTL branchSalesmanTL);
}
