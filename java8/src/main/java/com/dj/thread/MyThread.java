package com.dj.thread;

public class MyThread {
	// 创建线程有两种方法，一种是定义 Thread 的子类，重写 run 方法，实例化然后调 start 方法
	// 实例化 Thread,实现 Runnable 接口，重写 run 方法
	public static void main(String[] args) {
//		// 第一种
//		Thread thread = new FirstThread();
//		thread.start();
//		
//		// 第二种
//		Thread thread2 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("This is the second thread");
//			}
//		});
//		thread2.start();
//		
//		// lamda 写法
//		Thread thread3 = new Thread(()->{
//			System.out.println("This is the third thread");
//		});
//		thread3.start();
//		
//		// give a name
//		Thread thread4 = new Thread("fourThread") {
//			@Override
//			public void run() {
//				System.out.println("This is the "+getName());
//			}
//		};
//		thread4.start();
//		
//		Thread thread5 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("This is the five thread");
//			}
//		},"fiveThread");
//		thread5.start();
//		System.out.println(thread5.getName());
//		
		
//		System.out.println(Thread.currentThread().getName());
//	    for(int i=0; i<10; i++){
//	      new Thread("" + i){
//	        public void run(){
//	          System.out.println("Thread: " + getName() + " running");
//	        }
//	      }.start();
//	    }
		
//		try {
//		    Thread.sleep(10L * 1000L);
//		} catch (InterruptedException e) {
//		    e.printStackTrace();
//		}
//		System.out.println("finish");
		
		// 线程终止不能直接调用 stop 方法，而是通过代码的设计，将代码包裹在一个 while中，默认为true即一直执行，
		// 当调用终止方法后，改变循环条件，视为终止（但是如果不终止，包裹在 while 中的语句不就会一直执行？线程里面的代码默认不是应该只执行一次？）
		StopRunnable myRunnable = new StopRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        try {
            Thread.sleep(1L * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myRunnable.doStop();
}
}
