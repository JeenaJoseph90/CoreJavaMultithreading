package com.demo.multithreading;

/**
 * @author jeena
 * This approach is possible but not recommended to use.
 *
 */
public class HybridApproachDemo extends Thread {
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		HybridApproachDemo had = new HybridApproachDemo();
		Thread t = new Thread(had);
		t.start();
		//Defining Thread Name.
		Thread t1 = new Thread(had,"MyThread");
		t1.start();
	}

}
