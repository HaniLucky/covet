package com.covet.controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.covet.po.Items;
import com.covet.po.QueryVo;
import com.covet.service.ItemService;
import com.covet.util.CustomException;

@Controller
public class ItemController {

	private final Logger logger = Logger.getLogger(ItemController.class);
	@Autowired
	private ItemService itemService;

	/** 获取所有条目 */ /** 多个路径映射同一个方法 */
	@RequestMapping(value = {"/itemList","/itemlist","item"})
	public ModelAndView getItemList() {
		List<Items> list = itemService.getItemList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList", list);
		modelAndView.setViewName("itemList");
		return modelAndView;

	}

	/** 根据id获取记录(使用HttpServletRequest的方式) */
	// @RequestMapping("itemEdit")
	public ModelAndView getItemById(HttpServletRequest request) {
		logger.info("%%%调用查询方法开始%%%");
		// 使用request获取传递的参数
		String strId = request.getParameter("id");
		Integer id = null;
		if (strId != null && strId != "") {
			id = Integer.parseInt(strId);
		} else {
			logger.error("参数有误,请核实!!!");
		}
		Items item = itemService.getItemById(id);
		// 创建ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 向jsp传递数据
		modelAndView.addObject("item", item);
		// 设置跳转的jsp页面
		modelAndView.setViewName("editItem");
		logger.info("%%%调用查询方法结束%%%");
		return modelAndView;
	}

	/** 使用model对象进行改造 */
	/**
	 * 如果使用Model则可以不使用ModelAndView对象，Model对象可以向页面传递数据
	 * ，View对象则可以使用String返回值替代。不管是Model还是ModelAndView ，其本质都是使用Request对象向jsp传递数据。
	 */
	// @RequestMapping("itemEdit")
	public String getItemById(HttpServletRequest request, Model model) {
		logger.info("调用model");
		// 使用request获取传递的参数
		String strId = request.getParameter("id");
		Integer id = null;
		if (strId != null && strId != "") {
			id = Integer.parseInt(strId);
		} else {

		}
		Items items = itemService.getItemById(id);
		// 向jsp传递数据
		model.addAttribute("item", items);
		// 设置跳转的jsp页面
		return "editItem";
	}

	/**
	 * =====================================简单类型数据绑定============================
	 * @throws CustomException 
	 */
	// @RequestMapping("itemEdit")
	public String getItemById(Integer id, Model model) throws CustomException {
		logger.info("简单类型数据绑定");
		Items item = itemService.getItemById(id);
		
		model.addAttribute("item", item);
		return "editItem";
	}

	/**
	 * 使用@RequestParam绑定参数 value请求带过来的入参id required 属性必传
	 * @throws CustomException 
	 */
	@RequestMapping("itemEdit")
	public String getItemById2(@RequestParam(value = "id", required = true) Integer item_id, Model modle) throws CustomException {
		// 使用@RequestParam绑定参数
		logger.info("使用@RequestParam绑定参数");
		Items item = itemService.getItemById(item_id);
		
		if (item == null) {
			throw new CustomException("商品信息不存在");
		}
		modle.addAttribute("item", item);
		return "editItem";
	}

	/**
	 * =========================================================================
	 */
	
	/** 根据主键选择性更新数据 */
	@RequestMapping("updateitem")
	public String updateItem(Items item) {
		itemService.updateItem(item);
		return "success";
	}
	
}
