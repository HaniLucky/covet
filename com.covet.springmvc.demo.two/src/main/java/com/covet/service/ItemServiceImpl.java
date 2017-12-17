package com.covet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covet.mapper.ItemsMapper;
import com.covet.po.Items;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<Items> getItemList() {
		List<Items> itemList = itemsMapper.getItemList();
		return itemList;
	}

	@Override
	public Items getItemById(Integer id) {
		Items item = itemsMapper.selectByPrimaryKey(id);
		return item;
	}

	@Override
	public void updateItem(Items item) {
		itemsMapper.updateByPrimaryKeySelective(item);
	}

}
