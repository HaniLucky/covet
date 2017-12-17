package com.covet.quartz.test;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

	private static Logger logger = Logger.getLogger(AppTest.class);

	public static void main(String[] args) {
		logger.info("ok");
		new ClassPathXmlApplicationContext("applicationContext.xml");
	}
}
