package com.moaddi.service;

import java.util.List;

import com.moaddi.dao.model.BranchSalesmanTL;
import com.moaddi.service.dto.BranchDTO;
import com.moaddi.service.dto.BranchSalesmanDTO;




public interface BranchService {

	public Long saveBranch(BranchDTO branchDTO);
	public List<BranchDTO> loadBranches(Long createdBy);
	public Long saveBranchSalesman(BranchSalesmanDTO branchSalesmanDTO);
}
