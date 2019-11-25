package com.dj.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob4 implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			System.out.println("每天准时触发的任务2");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
