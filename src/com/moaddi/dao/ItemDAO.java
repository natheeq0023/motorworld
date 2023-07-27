package com.moaddi.dao;

import java.util.List;
import java.util.Map;

import com.moaddi.dao.model.ItemLockTL;
import com.moaddi.dao.model.ItemPriceTL;
import com.moaddi.dao.model.ItemQuantityTL;
import com.moaddi.dao.model.ItemSupplierTL;
import com.moaddi.dao.model.ItemTL;
import com.moaddi.dao.model.ItemsPercentageTL;

public interface ItemDAO {
	public Long insertItem(ItemTL itemTL);
	public ItemTL getItem(String itemBarcode);
	public Integer updateItem(ItemTL itemTL);
	public Long insertItemsPercentage(ItemsPercentageTL itemsPercentageTL);
	/**************************************************/
	public Map<String, Object> getItems(String itemBarcode);
	public void deleteItem(Long itemId);
	public Integer updateItemStatus(Long itemId,String status);
	public ItemTL getItem(Long itemId);
	public boolean isItemExist(String itemBarcode);
	
	public Long insertItemPrice(ItemPriceTL itemPriceTL);
	public Long insertItemQuantity(ItemQuantityTL itemQuantityTL);
	public Long insertItemSupplier(ItemSupplierTL itemSupplierTL);
	public Long insertItemLock(ItemLockTL itemLockTL);
	public List<Map<String, Object>> getItems(Long supplierId);
}
