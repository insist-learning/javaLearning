package com.dj.observer;

import java.util.ArrayList;
/**气象站实现类
 * 主题的实现类
 */
public class WeatherDate implements Subject {

//  用于存储观察者的集合
	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;

	
	
	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}

	/**
	 * 初始化集合！很重要！
	 */
	public WeatherDate() {
		this.observers = new ArrayList<Observer>();
	}

	/**
	 * 注册观察者
	 * 
	 * @param observer
	 */
	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	/**
	 * 注销观察者
	 * 
	 * @param observer
	 */
	@Override
	public void removeObserver(Observer observer) {
//      注意防止非空
			observers.remove(observer);
	}

	/**
	 * 唤醒观察者
	 */
	@Override
	public void notifyObserver() {
		observers.forEach(observer -> {
			observer.update(temperature, humidity, pressure);
		});
	}

	/**
	 * 通知观察者
	 */
	public void measurementsChanged() {
		notifyObserver();
	}

	/**
	 * 模拟气象站抓取数据
	 * 
	 * @param temperature
	 * @param humidity
	 * @param pressure
	 */
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

}
