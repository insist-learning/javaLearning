package com.dj.observer;

public interface Observer {
	 /**
     * 实时更新的方法 
     * @param temp 温度
     * @param humidity 湿度
     * @param pressure 气压
     */
    public void update(float temp, float humidity,float pressure);
}
