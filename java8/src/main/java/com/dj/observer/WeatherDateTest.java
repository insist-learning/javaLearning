package com.dj.observer;

import com.dj.observer.impl.CurrentHumidityDisplay;
import com.dj.observer.impl.CurrentPressureDisplay;
import com.dj.observer.impl.CurrentTemperatureDisplay;

public class WeatherDateTest {
	public static void main(String[] args) {
		/**
		 * 定义 List 来存放观察者，定义通知的方法，当观察者观测的东西发生改变时，遍历 List 去通知每个人
		 */
		
//      新建一个气象站
		WeatherDate weatherDate = new WeatherDate();
//      注册三个布告板
		CurrentTemperatureDisplay temperature = new CurrentTemperatureDisplay(weatherDate);
		new CurrentHumidityDisplay(weatherDate);
		new CurrentPressureDisplay(weatherDate);
//      模拟气象站发布新气象,在 set 的时候去调用list里面的每个布告板，动态更新并且发布更新信息
		weatherDate.setMeasurements(80, 60, 30.4f);
		weatherDate.setMeasurements(40, 30, 20.1f);
		weatherDate.setMeasurements(20, 10, 10.7f);
		System.out.println("移除一号温度观察者");
		weatherDate.removeObserver(temperature);
		System.out.println(weatherDate.getObservers().size());
		weatherDate.setMeasurements(20, 10, 10.7f);
	}
}
