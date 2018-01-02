package com.covet.test;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.covet.service.SayHelloWorld;

public class SayHelloWorldTest {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		context.start();
		SayHelloWorld bean = context.getBean(SayHelloWorld.class);
		String sayHelloWorld = bean.sayHelloWorld();
		System.err.println("ok"+sayHelloWorld);
		System.in.read();
	}
}
