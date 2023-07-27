package com.moaddi.service;

import java.util.List;
import java.util.Map;

import com.moaddi.dao.model.ItemLockDTO;
import com.moaddi.dao.model.ItemPriceDTO;
import com.moaddi.service.dto.ItemDTO;
import com.moaddi.service.dto.ItemQuantityDTO;
import com.moaddi.service.dto.ItemSupplierDTO;
import com.moaddi.service.dto.ItemsPercentageDTO;

public interface ItemService {
	public Long saveItem(ItemDTO itemDTO);
	public ItemDTO loadItem(String itemBarcode);
	public Integer modifyItem(ItemDTO itemDTO);
	public Long saveItemsPercentage(ItemsPercentageDTO itemsPercentageDTO);
	/*********************************************************/
	public Map<String, Object> loadItems(String itemBarcode);
	public Integer modifyItemStatus(Long itemId, String status);
	public boolean isItemExist(String itemBarcode);
	public Long saveItemPrice(ItemPriceDTO itemPriceDTO);
	public Long saveItemQuantity(ItemQuantityDTO itemQuantityDTO);
	public Long saveItemSupplier(ItemSupplierDTO itemSupplierDTO);
	public Long saveItemLock(ItemLockDTO itemLockDTO);
	List<Map<String, Object>> loadItems(Long supplierId);
	
}
