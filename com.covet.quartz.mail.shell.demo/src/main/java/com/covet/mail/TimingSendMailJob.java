package com.covet.mail;

import org.apache.log4j.Logger;

public class TimingSendMailJob {
	
	private Logger logger = Logger.getLogger(TimingSendMailJob.class);

	/**
	 * 自动统计微信端定存宝、活期宝的投资金额与人数信息。
	 */
	public void timingMailJob() {
		try {
			logger.info("开始发送邮件.....");
			String isValate = "true";// 邮件授权
			String to = "228321644@qq.com" ;// 收件人
			String subject = "测试主题";// 邮件主题
			// 调用发送邮件的方法
			SendEmailUtil.sendEmails(isValate, to, subject, "邮件发送成功了");
			logger.info("邮件发送完成.....");
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
//	public static void main(String[] args) {
//		timingMailJob();
//	}
}