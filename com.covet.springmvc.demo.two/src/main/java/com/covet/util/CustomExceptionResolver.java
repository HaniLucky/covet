package com.covet.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义异常转化器
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		ex.printStackTrace();
		CustomException customException = null;

		if (ex instanceof CustomException) {
			// 如果抛出的是系统自定义异常则直接转换
			customException = (CustomException) ex;
		} else {
			// 如果抛出的不是系统自定义异常则重新构造一个系统错误异常。
			customException = new CustomException("系统错误,请与管理员联系!");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", customException.getMessage());
		modelAndView.setViewName("error");
		
		return modelAndView;
	}

}
