package com.dj.observer;
/**气象站超类
 * 主题需要实现的接口规范
 */
public interface Subject {
//  注册观察者
	public void registerObserver(Observer observer);

//  注销观察者
	public void removeObserver(Observer observer);

//  主题发生变化的时候 通知在注册的观察者
	public void notifyObserver();
}
