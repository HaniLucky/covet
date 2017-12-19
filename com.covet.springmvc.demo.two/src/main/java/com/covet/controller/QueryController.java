package com.covet.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.covet.po.QueryVo;

@Controller
@RequestMapping("/item")/* 窄化请求 */
public class QueryController {

	/** 获取数组数据 *//** 限定请求方式为post方法 */
	@RequestMapping(value = "/queryitem",method = RequestMethod.POST ) /*/item/queryitem */
	public String queryItem(QueryVo queryVo,String [] ids){
		// System.err.println(queryVo.getItem().getName());
		// System.err.println(queryVo.getItem().getPrice());
		System.err.println(Arrays.toString(ids));
		return null ;
	}
}
