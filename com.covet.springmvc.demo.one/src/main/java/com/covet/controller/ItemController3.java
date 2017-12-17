package com.covet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.covet.po.Items;

/**
 * <p>Describe:注解的实现方式</P>
 * @author Covet
 * 2017年12月11日 下午10:07:40
 */
@Controller
public class ItemController3 {
	@RequestMapping("/itemList2")
	public ModelAndView itemList() throws Exception {
		
		List<Items> itemList = new ArrayList<>();
		
		//商品列表
		Items items_1 = new Items();
		items_1.setName("联想笔记本_3");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
		
		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机！");
		
		itemList.add(items_1);
		itemList.add(items_2);
		//创建modelandView对象
		ModelAndView modelAndView = new ModelAndView();
		//添加model
		modelAndView.addObject("itemList", itemList);
		//添加视图
//		modelAndView.setViewName("/WEB-INF/jsp/itemList.jsp");
		modelAndView.setViewName("itemList");	
		return modelAndView;
	}

}
