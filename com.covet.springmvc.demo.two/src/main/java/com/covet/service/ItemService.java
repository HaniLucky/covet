package com.covet.service;

import java.util.List;

import com.covet.po.Items;

public interface ItemService {
	
	/** 获取所有记录  */
	List<Items> getItemList();
	
	/** 根据ID查询记录 */
	Items getItemById(Integer id);
	
	/** 根据ID进行更新数据库操作*/
	void updateItem(Items item);
}
