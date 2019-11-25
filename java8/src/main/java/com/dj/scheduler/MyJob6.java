package com.dj.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob6 implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			System.out.println("测试CronTrigger");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
