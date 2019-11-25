package com.dj.scheduler;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map.Entry;
import java.util.Set;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;

public class MyJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// 通过 JobExecutionContext 可以获得各种信息
		JobDetail job = context.getJobDetail();
		System.out.println("job:name->"+job.getKey().getName()+",group:"+job.getKey().getGroup());
		Trigger trigger = context.getTrigger();
		System.out.println("trigger:name->"+trigger.getKey().getName()+",group:"+trigger.getKey().getGroup()+"-jobKey:"+trigger.getJobKey());
		JobDataMap map = job.getJobDataMap();
		for (Entry<String, Object> entry : map.entrySet()) {
			System.out.println("map:key->"+entry.getKey()+"value->"+entry.getValue());
		}
	}

//	@Override
//	public void execute(JobExecutionContext context) throws JobExecutionException {
//		LocalDateTime time = LocalDateTime.now();
//		System.out.println("每3秒打印一次，当前时间："+time.getHour()+":"+time.getMinute()+":"+time.getSecond());
//		
//	}
	
	

}
