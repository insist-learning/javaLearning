package com.dj.thread.raceconditions;

public class MyRunnable implements Runnable {
	NotThreadSafe instance = null;

	public MyRunnable(NotThreadSafe instance) {
		this.instance = instance;
	}
	@Override
	public void run() {
		this.instance.add("some text");
	}

}
