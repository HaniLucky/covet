package com.covet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.covet.po.Items;

/**
 * <p>
 * Describe:实现Controller的方式
 * </P>
 * 
 * @author Covet 2017年12月11日 下午9:55:25
 */
public class ItemController2 implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Items> itemList = new ArrayList<>();

		// 商品列表
		Items items_1 = new Items();
		items_1.setName("联想笔记本_3");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad T450 联想笔记本电脑！");

		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机！");

		itemList.add(items_1);
		itemList.add(items_2);

		// 创建monldAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 添加返回对象
		modelAndView.addObject("itemList", itemList);
		// 设置视图
//		modelAndView.setViewName("/WEB-INF/jsp/itemList.jsp");
		modelAndView.setViewName("itemList");
		System.err.println("controller方式调用了");
		return modelAndView;
	}

}
