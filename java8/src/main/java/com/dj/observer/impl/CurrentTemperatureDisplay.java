package com.dj.observer.impl;

import com.dj.observer.DisplayElement;
import com.dj.observer.Observer;
import com.dj.observer.Subject;

public class CurrentTemperatureDisplay implements Observer, DisplayElement {

	private float temperature;
	private Subject weatherDate;

	/**
	 * 需要一个主题用来注册
	 * 
	 * @param weatherDate
	 */
	public CurrentTemperatureDisplay(Subject weatherDate) {
		this.weatherDate = weatherDate;
		weatherDate.registerObserver(this);
	}

	/**
	 * 实时发布信息
	 */
	@Override
	public void display() {
		System.out.print("一号布告板：");
		System.out.println("temperature:" + temperature);
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
		this.temperature = temp;
		display();
	}

}
