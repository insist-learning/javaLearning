package com.dj.observer.impl;

import com.dj.observer.DisplayElement;
import com.dj.observer.Observer;
import com.dj.observer.Subject;

public class CurrentPressureDisplay implements DisplayElement, Observer {

	private float pressure;
	private Subject weatherDate;

	/**
	 * 需要一个主题用来注册
	 * 
	 * @param weatherDate
	 */
	public CurrentPressureDisplay(Subject weatherDate) {
		this.weatherDate = weatherDate;
		weatherDate.registerObserver(this);
	}

	/**
	 * 实时发布信息
	 */
	@Override
	public void display() {
		System.out.print("三号布告板：");
		System.out.println("pressure:" + pressure);
	}

	/**
	 * 布告板更新
	 * 
	 * @param temp
	 *            温度
	 * @param humidity
	 *            湿度
	 * @param pressure
	 *            气压
	 */
	@Override
	public void update(float temp, float humidity, float pressure) {
		this.pressure = pressure;
		display();
	}

}
