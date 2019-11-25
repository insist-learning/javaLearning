package com.dj.thread;

public class StopRunnable implements Runnable{
	private boolean isStop = false;

    public synchronized void doStop() {
        this.isStop = true;
    }

    private synchronized boolean keepRunning() {
        return this.isStop == false;
    }


	
	@Override
	public void run() {
		// 线程会一直执行，但是在调用了 doStop 时，代码 就不会执行了
		while(keepRunning()) {
            // keep doing what this thread should do.
            System.out.println("Running");
            try {
                Thread.sleep(3L * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
		System.out.println("have been stop");
		
	}

}
