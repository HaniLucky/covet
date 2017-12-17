package com.covet.quartz.job;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * quarzt工作的类
 */
public class QuartzJob {

	/*
	 * 定时方法
	 */
	public void work() {
		System.out.println("Quartz的任务调度！！！" + (new Date()).toString());
	}

}
