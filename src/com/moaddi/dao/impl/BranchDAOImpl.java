package com.moaddi.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moaddi.dao.BranchDAO;
import com.moaddi.dao.model.BranchSalesmanTL;
import com.moaddi.dao.model.BranchTL;
import com.moaddi.dao.model.CustomerTL;
import com.moaddi.dao.model.WarehouseTL;
import com.moaddi.dao.utility.CustomHibernateDaoSupport;

@Repository("branchDAO")
@Transactional
public class BranchDAOImpl extends CustomHibernateDaoSupport implements BranchDAO {

	
	
	
	public Long insertBranch(BranchTL branchTL) {
		// TODO Auto-generated method stub
		Long branchId=0L;
		try {
			
			branchId=(Long)getHibernateTemplate().save(branchTL);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return branchId;
	}

	
	public List<BranchTL> getBranches(Long createdBy) {
		
		return getHibernateTemplate().find("from BranchTL where createdBy=?",new Object[]{createdBy});
	}


	public Long insertBranchSalesman(BranchSalesmanTL branchSalesmanTL) {
		
		return (Long)getHibernateTemplate().save(branchSalesmanTL);
	}

}
