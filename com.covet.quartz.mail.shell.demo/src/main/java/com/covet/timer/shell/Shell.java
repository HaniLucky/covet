package com.covet.timer.shell;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Shell {
	private final static String beanConfig = "applicationContext.xml";
	private static final Log log = LogFactory.getLog(Shell.class);

	private static ClassPathXmlApplicationContext appContext = null;

	public static void main(String[] args) {
		try {
			long startTime = System.currentTimeMillis();
			appContext = new ClassPathXmlApplicationContext(beanConfig);
			appContext.registerShutdownHook();
			appContext.start();
			log.info("初始化context:" + beanConfig);
			log.info(" ** 自动发送邮件系统启动成功 ** 启动耗时: " + (System.currentTimeMillis() - startTime) + " ms. ");
		} catch (Exception e) {
			log.error("Shell 脚本启动异常！", e);
			appContext.destroy();
			appContext.close();
		}
	}

}
