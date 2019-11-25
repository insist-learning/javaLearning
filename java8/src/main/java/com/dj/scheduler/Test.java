package com.dj.scheduler;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.DateBuilder.*;
import static org.quartz.CronScheduleBuilder.*;
public class Test {
	public static void main(String[] args) throws Exception {
		
		
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();
		JobDetail job = JobBuilder.newJob(MyJob6.class).withIdentity("myJob").build();
		
		// 1.使用 cron 表达式,此处表示每天某个时刻触发
//		CronTrigger trigger = newTrigger()
//			    .withIdentity("trigger3", "group1")
//			    .withSchedule(cronSchedule("0 56 9 * * ?"))
//			    .forJob("myJob")
//			    .build();
		
		
		// 2.使用 CronSchedulerBuilder 辅助类
		// ①. dailyAtHourAndMinute() 每天某个时刻触发
//		CronTrigger trigger = newTrigger()
//			    .withIdentity("trigger3", "group1")
//			    .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(9, 54))
//			    .forJob("myJob")
//			    .build();
		
		CronTrigger trigger = newTrigger()
			    .withIdentity("trigger3", "group1")
			    .withSchedule(CronScheduleBuilder.weeklyOnDayAndHourAndMinute(DateBuilder.JANUARY, 10, 06))
			    .forJob("myJob")
			    .build();
		
		scheduler.scheduleJob(job,trigger);
		
		
		
//****************
//		以下内容测试了 SimpleTrigger,以及对应的 SimpleScheduler 的使用，以及使用 DateBuilder 灵活构建时间
//****************	
		
//		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//		scheduler.start();
//		JobDetail job = JobBuilder.newJob(MyJob5.class).withIdentity("myJob").build();
		// 立即触发，不重复,不指定 startAt 默认为立即触发,默认不重复
//	    SimpleTrigger trigger = (SimpleTrigger) newTrigger() 
//	            .withIdentity("trigger1")
//	            .startAt(new Date())                     
//	            .forJob("myJob")              
//	            .build();
		
		
		// $指定时间触发，每隔10秒执行一次，重复10次$
//		long start = System.currentTimeMillis();
//		Date startDate = new Date(start);
//		long end = start+10*1000;
//		Date endDate = new Date(end);
//		// 关于重复次数，0 表示执行一次，1 表示执行两次，SimpleTrigger.REPEAT_INDEFINITELY，表示在指定的时间内，根据间隔自动设置执行
//		// 开始时间默认为当前时间,结束时间不设置则执行完就结束,此时如果使用 SimpleTrigger.REPEAT_INDEFINITELY 就会无限循环
//		SimpleTrigger trigger =  (SimpleTrigger) newTrigger()
//		        .withIdentity("trigger3")
//		        .withSchedule(simpleSchedule()
//		            .withIntervalInSeconds(2)
//		            .withRepeatCount(1))
////		            .withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY)) 
//		        .startAt(startDate)
//		        .endAt(endDate)
//		        .forJob("myJob") // identify job with handle to its JobDetail itself                   
//		        .build();
//		
//		
		// 通过 DateBuilder 可以很灵活的操作开始时间和结束时间，内部的方法是通过 Calendar 的调节后返回 Date 完成的
		
		// 表示5秒后开始 futureDate
//		SimpleTrigger trigger = (SimpleTrigger) newTrigger() 
//		        .withIdentity("trigger5", "group1")
//		        .startAt(futureDate(5, IntervalUnit.SECOND)) // use DateBuilder to create a date in the future
//		        .forJob("myJob") // identify job with its JobKey
//		        .build();
		
		// 何时结束,dateOf
//		SimpleTrigger trigger = (SimpleTrigger) newTrigger() 
//		        .withIdentity("trigger5", "group1")
//		        .withSchedule(simpleSchedule().withIntervalInSeconds(5).repeatForever())
//		        .endAt(dateOf(11, 44, 00))
//		        .forJob("myJob") 
//		        .build();
//		
		
		//  整点触发 evenHourDate
//		SimpleTrigger trigger = newTrigger()
//			        .withIdentity("trigger8") // because group is not specified, "trigger8" will be in the default group
//			        .startAt(evenHourDate(null)) // get the next even-hour (minutes and seconds zero ("00:00"))
//			        .withSchedule(simpleSchedule()
//			            .withIntervalInHours(2)
//			            .repeatForever())
//			        .build();
//
//		scheduler.scheduleJob(job, trigger);
		
		
		
//****************
//		以下内容测试了 HolidayCalendar 用于排除日期的功能，trigger 的 forJob 参数为与 trigger 绑定的 Job 对象的 name,
//****************		
		// 如果未绑定，则会出错，可以用来确保对应关系
//		JobDetail job = JobBuilder.newJob(MyJob3.class).withIdentity("myJob").build();
//		JobDetail job2 = JobBuilder.newJob(MyJob4.class).withIdentity("myJob2").build();
//		Scheduler schedulerNoToday = getSchedulerNoToday();
//		schedulerNoToday.start();
//		Scheduler schedulerNoTomorrow = getSchedulerNoTomorrow();
//		schedulerNoTomorrow.start();
//		
//		Trigger trigger = TriggerBuilder.newTrigger().
//				withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(10, 32))
//				.modifiedByCalendar("myHolidays")
//				.build();
//		
//		Trigger trigger2 = TriggerBuilder.newTrigger().
//				withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(10, 32)).forJob("myJob2")
//				.modifiedByCalendar("myHolidays2")
//				.build();
//		schedulerNoToday.scheduleJob(job, trigger);
//		schedulerNoTomorrow.scheduleJob(job2,trigger2);
		
		
		// 以下内容测试了 Job 属性的自动注入机制
//		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
//		Scheduler sched = schedFact.getScheduler();
//		sched.start();
//		JobDetail job = JobBuilder.newJob(MyJob2.class).withIdentity("myJob", "group1")
//				.usingJobData("booleanValue", true)
//				.usingJobData("StringValue","string")
//				.usingJobData("intValue",12)
//				.usingJobData("DoubleValue",1.2)
//				.build();
//		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").startNow()
//				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(60).repeatForever()).build();
//		sched.scheduleJob(job, trigger);
		
		
		// 以下内容测试了基本的使用和从 JobExecutionContext 获取各种信息
//		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
//		Scheduler sched = schedFact.getScheduler();
//		sched.start();
//		JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("myJob", "group1")
//				.usingJobData("booleanValue", true)
//				.usingJobData("StringValue","string")
//				.usingJobData("intValue",12)
//				.usingJobData("DoubleValue",1.2)
//				.build();
//		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").startNow()
//				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatMinutelyForever()).build();
//		sched.scheduleJob(job, trigger);
		
	}
//	public static Scheduler getSchedulerNoToday() throws Exception {
//		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//		HolidayCalendar cal  = new HolidayCalendar();
//		cal.addExcludedDate(new Date());
//		scheduler.addCalendar("myHolidays",cal , false, true);
//		return scheduler;
//	}
//	private static Scheduler getSchedulerNoTomorrow() throws Exception {
//		Date date = new Date();
//		date.setDate(20);
//		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//		HolidayCalendar cal  = new HolidayCalendar();
//		cal.addExcludedDate(date);
//		scheduler.addCalendar("myHolidays2",cal , false, true);
//		return scheduler;
//	}
}
