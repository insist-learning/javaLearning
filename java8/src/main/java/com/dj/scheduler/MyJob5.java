package com.dj.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob5 implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			System.out.println("测试 SimpleTrigger");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
