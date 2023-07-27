package com.moaddi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moaddi.dao.BranchDAO;
import com.moaddi.dao.model.BranchSalesmanTL;
import com.moaddi.dao.model.BranchTL;
import com.moaddi.service.BranchService;
import com.moaddi.service.dto.BranchDTO;
import com.moaddi.service.dto.BranchSalesmanDTO;

@Service("branchService")
public class BranchServiceImpl implements BranchService {
	@Autowired
	private BranchDAO branchDAO;
	public List<BranchDTO> loadBranches(Long createdBy) {
		List<BranchDTO> branches=null;
		List<BranchTL> lbranches=branchDAO.getBranches(createdBy);
		if(lbranches!=null && lbranches.size()>0)
		{	branches=new ArrayList<BranchDTO>();
			ListIterator<BranchTL> li=lbranches.listIterator();
			while(li.hasNext())
			{
				BranchTL branchTL=li.next();
				BranchDTO branchDTO=new BranchDTO();
				branchDTO.setBranchName(branchTL.getBranchName());
				branchDTO.setContact(branchTL.getContact());
				branchDTO.setLocation(branchTL.getLocation());
				branchDTO.setCreatedOn(branchTL.getCreatedOn());
				branchDTO.setCreatedBy(branchTL.getBranchId());
				branchDTO.setBranchId(branchTL.getBranchId());
				
				branches.add(branchDTO);
				
			}
		}
		return branches;
	}

	public Long saveBranch(BranchDTO branchDTO) {
		Long branchId=null;
		if(branchDTO!=null)
		{
			BranchTL branchTL=new BranchTL();
			
			branchTL.setBranchName(branchDTO.getBranchName());
			branchTL.setContact(branchDTO.getContact());
			branchTL.setLocation(branchDTO.getLocation());
			branchTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			branchTL.setCreatedBy(branchDTO.getCreatedBy());
			branchTL.setBranchId(branchDTO.getBranchId());
			
			branchId=branchDAO.insertBranch(branchTL);
		}
		return branchId;
	}

	public Long saveBranchSalesman(BranchSalesmanDTO branchSalesmanDTO) {
		Long branchSalesmanId=null;
		if(branchSalesmanDTO!=null)
		{
			BranchSalesmanTL branchSalesmanTL=new BranchSalesmanTL();
			branchSalesmanTL.setBranchId(branchSalesmanDTO.getBranchId());
			branchSalesmanTL.setBranchSalesmanId(branchSalesmanDTO.getBranchSalesmanId());
			branchSalesmanTL.setSalesmanId(branchSalesmanDTO.getSalesmanId());
			branchSalesmanTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			branchSalesmanId=branchDAO.insertBranchSalesman(branchSalesmanTL);
			
		}
		return branchSalesmanId;
	}

}
