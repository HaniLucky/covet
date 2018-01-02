package com.covet.spring.dubbo.provide;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SayHelloWorldTest {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		context.start();

		System.in.read();
		}
}
