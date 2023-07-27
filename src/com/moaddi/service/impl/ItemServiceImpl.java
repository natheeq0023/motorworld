package com.moaddi.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moaddi.dao.ItemDAO;
import com.moaddi.dao.model.ItemLockDTO;
import com.moaddi.dao.model.ItemLockTL;
import com.moaddi.dao.model.ItemPriceDTO;
import com.moaddi.dao.model.ItemPriceTL;
import com.moaddi.dao.model.ItemQuantityTL;
import com.moaddi.dao.model.ItemSupplierTL;
import com.moaddi.dao.model.ItemTL;
import com.moaddi.dao.model.ItemsPercentageTL;
import com.moaddi.dao.model.MachinePriceTL;
import com.moaddi.service.ItemService;
import com.moaddi.service.dto.ItemDTO;
import com.moaddi.service.dto.ItemQuantityDTO;
import com.moaddi.service.dto.ItemSupplierDTO;
import com.moaddi.service.dto.ItemsPercentageDTO;
@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDAO itemDAO;
	public ItemDTO loadItem(String itemBarcode) {
		ItemDTO  itemDTO=null;
		ItemTL itemTL=itemDAO.getItem(itemBarcode);
		if(itemTL!=null)
		{
			itemDTO=new ItemDTO();
			itemDTO.setCreatedBy(itemTL.getCreatedBy());
			itemDTO.setCreatedOn(itemTL.getCreatedOn());
			itemDTO.setItemBarcode(itemTL.getItemBarcode());
			itemDTO.setItemGruop(itemTL.getItemGruop());
			itemDTO.setItemId(itemTL.getItemId());
			itemDTO.setItemIngredients(itemTL.getItemIngredients());
			itemDTO.setItemName(itemTL.getItemName());
			itemDTO.setItemPhotoName(itemTL.getItemPhotoName());
			itemDTO.setItemSize(itemTL.getItemSize());
			itemDTO.setUpdatedBy(itemTL.getUpdatedBy());
			itemDTO.setUpdatedOn(itemTL.getUpdatedOn());
			itemDTO.setStatus(itemTL.getStatus());
		}
		return itemDTO;
	}

	public Integer modifyItem(ItemDTO itemDTO) {
		if(itemDTO!=null)
		{
			ItemTL item=new ItemTL();
			item.setCreatedBy(itemDTO.getCreatedBy());
			item.setItemBarcode(itemDTO.getItemBarcode());
			item.setItemGruop(itemDTO.getItemGruop());
			item.setItemId(itemDTO.getItemId());
			item.setItemIngredients(itemDTO.getItemIngredients());
			item.setItemName(itemDTO.getItemName());
			item.setItemPhotoName(itemDTO.getItemPhotoName());
			item.setItemSize(itemDTO.getItemSize());
			item.setStatus(itemDTO.getStatus());
			item.setUpdatedBy(itemDTO.getUpdatedBy());
			item.setUpdatedOn(new java.sql.Date(new java.util.Date().getTime()));
			itemDAO.updateItem(item);
			
		}
		return null;
	}

	public Long saveItem(ItemDTO itemDTO) {
		Long itemId=0L;
		if(itemDTO!=null)
		{
			ItemTL item=new ItemTL();
			item.setCreatedBy(itemDTO.getCreatedBy());
			item.setItemBarcode(itemDTO.getItemBarcode());
			item.setItemGruop(itemDTO.getItemGruop());
			item.setItemId(itemDTO.getItemId());
			item.setItemIngredients(itemDTO.getItemIngredients());
			item.setItemName(itemDTO.getItemName());
			item.setItemPhotoName(itemDTO.getItemPhotoName());
			item.setItemSize(itemDTO.getItemSize());
			item.setStatus(itemDTO.getStatus());
			item.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			itemId=itemDAO.insertItem(item);
			
		}
		return itemId;
	}

	
	public Map<String, Object> loadItems(String itemBarcode) {
		// TODO Auto-generated method stub
		return itemDAO.getItems(itemBarcode);
	}

	
	public Integer modifyItemStatus(Long itemId, String status) {
		// TODO Auto-generated method stub
		return itemDAO.updateItemStatus(itemId, status);
	}

	
	public Long saveItemsPercentage(ItemsPercentageDTO itemsPercentageDTO) {
		// TODO Auto-generated method stub
		Long id=0L;
		if(itemsPercentageDTO!=null)
		{
			ItemsPercentageTL itemsPercentageTL=new ItemsPercentageTL();
			itemsPercentageTL.setCity(itemsPercentageDTO.getCity());
			itemsPercentageTL.setCountry(itemsPercentageDTO.getCountry());
			itemsPercentageTL.setCreatedBy(itemsPercentageDTO.getCreatedBy());
			itemsPercentageTL.setItemBarcode(itemsPercentageDTO.getItemBarcode());
			itemsPercentageTL.setItemPercentage(itemsPercentageDTO.getItemPercentage());
			itemsPercentageTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			id=itemDAO.insertItemsPercentage(itemsPercentageTL);
		}
		return id;
	}

	public boolean isItemExist(String itemBarcode) {
		
		return itemDAO.isItemExist(itemBarcode);
	}

	public Long saveItemPrice(ItemPriceDTO itemPriceDTO) {
		Long itemPriceId=null;
		if(itemPriceDTO!=null)
		{
			ItemPriceTL itemPriceTL=new ItemPriceTL();
			itemPriceTL.setCreatedBy(itemPriceDTO.getCreatedBy());
			itemPriceTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			itemPriceTL.setDiscount(itemPriceDTO.getDiscount());
			itemPriceTL.setFromDate(new java.sql.Date(itemPriceDTO.getFromDate().getTime()));
			itemPriceTL.setItemId(itemPriceDTO.getItemId());
			itemPriceTL.setPrice(itemPriceDTO.getPrice());
			itemPriceTL.setToDate(new java.sql.Date(itemPriceDTO.getToDate().getTime()));
			itemPriceId=itemDAO.insertItemPrice(itemPriceTL);
		}
		return itemPriceId;
	}

	public Long saveItemQuantity(ItemQuantityDTO itemQuantityDTO) {
		Long itemQuantityId=null;
		if(itemQuantityDTO!=null)
		{
			ItemQuantityTL itemQuantityTL=new ItemQuantityTL();
			itemQuantityTL.setCreatedBy(itemQuantityDTO.getCreatedBy());
			itemQuantityTL.setItemId(itemQuantityDTO.getItemId());
			itemQuantityTL.setWarehouseId(itemQuantityDTO.getWarehouseId());
			itemQuantityTL.setQuantity(itemQuantityDTO.getQuantity());
			itemQuantityTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			itemQuantityId=itemDAO.insertItemQuantity(itemQuantityTL);
			
		}
		return itemQuantityId;
	}

	public Long saveItemSupplier(ItemSupplierDTO itemSupplierDTO) {
		Long itemSupplierId=null;
		if(itemSupplierDTO!=null)
		{
			ItemSupplierTL itemSupplierTL=new ItemSupplierTL();
			itemSupplierTL.setCreatedBy(itemSupplierDTO.getCreatedBy());
			itemSupplierTL.setItemId(itemSupplierDTO.getItemId());
			itemSupplierTL.setWarehouseId(itemSupplierDTO.getWarehouseId());
			itemSupplierTL.setSupplierId(itemSupplierDTO.getSupplierId());
			itemSupplierTL.setQuantity(itemSupplierDTO.getQuantity());
			itemSupplierTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			itemSupplierId=itemDAO.insertItemSupplier(itemSupplierTL);
			
		}
		return itemSupplierId;
	}

	public Long saveItemLock(ItemLockDTO itemLockDTO) {
		Long itemLockId=null;
		if(itemLockDTO!=null)
		{
			ItemLockTL itemLockTL=new ItemLockTL();
			itemLockTL.setCreatedBy(itemLockDTO.getCreatedBy());
			itemLockTL.setItemId(itemLockDTO.getItemId());
			itemLockTL.setStatus(itemLockDTO.getStatus());
			itemLockTL.setLockId(itemLockDTO.getLockId());
			itemLockTL.setQuantity(itemLockDTO.getQuantity());
			itemLockTL.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
			itemLockId=itemDAO.insertItemLock(itemLockTL);
			
		}
		return itemLockId;
	}

	public List<Map<String, Object>> loadItems(Long supplierId) {
		
		return itemDAO.getItems(supplierId);
	}

}
