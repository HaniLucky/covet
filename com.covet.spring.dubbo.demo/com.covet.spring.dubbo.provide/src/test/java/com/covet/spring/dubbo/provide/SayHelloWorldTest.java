package com.covet.spring.dubbo.provide;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SayHelloWorldTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		context.start();

		while (true) {

		}
	}
}
