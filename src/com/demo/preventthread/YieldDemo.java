package com.demo.preventthread;

//Passes execution to same or higher priority waiting threads.
//If no waiting thread or all waiting thread has low priority, the same thread continuous execution.
//No output guarantee, all depends on thread scheduler.
//Some OS doesn't support this method.
public class YieldDemo extends Thread {

	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
			Thread.yield();
		}
	}
	
	public static void main(String[] args) {
		YieldDemo yd = new YieldDemo();
		yd.setName("YD");
		yd.start();
		YieldDemo yd1 = new YieldDemo();
		yd1.setName("YD1");
		yd1.setPriority(MAX_PRIORITY);
		yd1.start();
	}
	
}
