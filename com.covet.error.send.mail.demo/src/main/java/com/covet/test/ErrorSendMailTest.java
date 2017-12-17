package com.covet.test;

import java.util.List;

import org.apache.log4j.Logger;

public class ErrorSendMailTest {
	private static Logger logger = Logger.getLogger(ErrorSendMailTest.class);

	public static void main(String[] args) {

		try {
			List<Object> a = null;
			System.out.println(a.size());
		} catch (Exception e) {
			e.printStackTrace();
			
			// 异常时自动发邮件
			logger.error("run err", e);
		}
	}
}
