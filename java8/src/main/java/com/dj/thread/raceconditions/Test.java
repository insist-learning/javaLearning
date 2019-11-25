package com.dj.thread.raceconditions;

public class Test {
	public static void main(String[] args) {
		NotThreadSafe sharedInstance = new NotThreadSafe();
		
		// 这样是线程不安全的，因为他们使用了同一个对象
		new Thread(new MyRunnable(sharedInstance)).start();
		new Thread(new MyRunnable(sharedInstance)).start();
		
		System.out.println(sharedInstance.builder);
		// 这样是线程安全的，因为他们用的是各自的对象，这说明即使成员方法是不安全的，也有方法使其不产生竞争导致的线程不安全问题
//		new Thread(new MyRunnable(new NotThreadSafe())).start();
//		new Thread(new MyRunnable(new NotThreadSafe())).start();
		
	}
}
