package com.moaddi.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;




import com.moaddi.dao.ItemDAO;
import com.moaddi.dao.model.ItemLockTL;
import com.moaddi.dao.model.ItemPriceTL;
import com.moaddi.dao.model.ItemQuantityTL;
import com.moaddi.dao.model.ItemSupplierTL;
import com.moaddi.dao.model.ItemTL;
import com.moaddi.dao.model.ItemsPercentageTL;
import com.moaddi.dao.model.UserRolesTL;
import com.moaddi.dao.utility.CustomHibernateDaoSupport;
@Repository("itemDAO")
@Transactional
public class ItemDAOImpl extends CustomHibernateDaoSupport implements ItemDAO {

	public ItemTL getItem(String itemBarcode) {
		ItemTL itemTL=null;
		if(itemBarcode!=null && !itemBarcode.trim().equals(""))
		{
			List<ItemTL> items=getHibernateTemplate().find("from ItemTL where itemBarcode=?",new Object[]{itemBarcode});
			if(items!=null && items.size()>0)
			{
				itemTL=items.get(0);
			}
			
			
			
		}
		return itemTL;
	}

	public Long insertItem(ItemTL itemTL) {
		Long itemId=0L;
		itemId=(Long)getHibernateTemplate().save(itemTL);
		return itemId;
	}

	public Integer updateItem(ItemTL itemTL) {
		getHibernateTemplate().update(itemTL);
		return null;
	}

	
	public Map<String, Object> getItems(String itemBarcode) {
		// TODO Auto-generated method stub
        Map<String, Object> item=null;
		System.out.println("check item in dao impl");
		List users=getHibernateTemplate().find("select itemId,itemName,itemGruop,itemSize,itemIngredients,itemPhotoName,itemBarcode,status from ItemTL where itemBarcode=?",itemBarcode);
		if(users!=null && users.size()>0)
		{
			Object[] user=(Object[])users.get(0);
			item=new LinkedHashMap<String, Object>();
			item.put("itemId", user[0]);
			item.put("itemName", user[1]);
			item.put("itemGruop", user[2]);
			item.put("itemSize", user[3]);
			item.put("itemIngredients", user[4]);
			item.put("itemPhotoName", user[5]);
			item.put("itemBarcode", user[6]);
			item.put("status", user[7]);
			
			
			System.out.println("check item in dao impl return");
		}
		return item;
	}

	
	public void deleteItem(Long itemId) {
		// TODO Auto-generated method stub
		System.out.println(itemId+"itemId");
		getHibernateTemplate().delete(getItem(itemId));
	}

	
	public Integer updateItemStatus(Long itemId, String status) {
		// TODO Auto-generated method stub
		Integer noOfRowsEffected = 0;
		ItemTL itemTL = (ItemTL) getHibernateTemplate().get(
				ItemTL.class, itemId);
		itemTL.setStatus(status);
		getHibernateTemplate().update(itemTL);

		return noOfRowsEffected;
	}

	
	public ItemTL getItem(Long itemId) {
		// TODO Auto-generated method stub
		return (ItemTL)getHibernateTemplate().get(ItemTL.class, itemId);
	}

	
	public Long insertItemsPercentage(ItemsPercentageTL itemsPercentageTL) {
		// TODO Auto-generated method stub
		return (Long)getHibernateTemplate().save(itemsPercentageTL);
	}

public boolean isItemExist(String itemBarcode) {
		
		boolean isExists=false;
		List items=getHibernateTemplate().find("from ItemTL where itemBarcode=?",new Object[]{itemBarcode});
		if(items!=null && items.size()>0)
		{
			isExists=true;
		}
		
		return isExists;
	}

public Long insertItemPrice(ItemPriceTL itemPriceTL) {
	return (Long)getHibernateTemplate().save(itemPriceTL);
}

public Long insertItemQuantity(ItemQuantityTL itemQuantityTL) {
	return (Long)getHibernateTemplate().save(itemQuantityTL);
}

public Long insertItemSupplier(ItemSupplierTL itemSupplierTL) {
	return (Long)getHibernateTemplate().save(itemSupplierTL);
}

public Long insertItemLock(ItemLockTL itemLockTL) {
	
	return (Long)getHibernateTemplate().save(itemLockTL);
}

public List<Map<String, Object>> getItems(Long supplierId) {
	List<Map<String, Object>> items=null;
	String hql="select isp.itemId ,itl.itemBarcode, isp.quantity from ItemSupplierTL isp, ItemTL itl  where isp.itemId=itl.itemId and isp.supplierId=?";
	List<Object[]> itemList=getHibernateTemplate().find(hql,new Object[]{supplierId});
	if(itemList!=null && itemList.size()>0)
	{
		items=new ArrayList<Map<String,Object>>();
		ListIterator<Object[]> li=itemList.listIterator();
		while(li.hasNext())
		{
			Object[] obj=li.next();
			Map<String, Object> item=new HashMap<String, Object>();
			item.put("itemId", obj[0]);
			item.put("itemBarcode", obj[1]);
			item.put("quantity", obj[2]);
			items.add(item);
		}
	}
	return items;
}
}
