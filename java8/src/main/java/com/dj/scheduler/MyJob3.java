package com.dj.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob3 implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			System.out.println("每天准时触发的任务");
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
