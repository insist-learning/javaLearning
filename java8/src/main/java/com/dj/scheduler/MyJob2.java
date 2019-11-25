package com.dj.scheduler;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob2 implements Job{
	
	private boolean booleanValue; 
	private String StringValue; 
	private int intValue; 
	private Double DoubleValue;
	
	
	public boolean isBooleanValue() {
		return booleanValue;
	}


	public void setBooleanValue(boolean booleanValue) {
		this.booleanValue = booleanValue;
	}


	public String getStringValue() {
		return StringValue;
	}


	public void setStringValue(String stringValue) {
		StringValue = stringValue;
	}


	public int getIntValue() {
		return intValue;
	}


	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}


	public Double getDoubleValue() {
		return DoubleValue;
	}


	public void setDoubleValue(Double doubleValue) {
		DoubleValue = doubleValue;
	}


	@Override
	public void execute(JobExecutionContext context) {
		try {
			System.out.println("通过自动注入机制获取值");
			System.out.println("intValue:"+intValue);
			System.out.println("StringValue"+getStringValue());
			System.out.println("DoubleValue"+DoubleValue);
			System.out.println("booleanValue"+booleanValue);
			MyJob2 jobDetail = (MyJob2) context.getJobDetail();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
