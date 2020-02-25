package com.demo.preventthread;

public class SleepInterreptDemo extends Thread {
	
	public void run() {
		
		System.out.println("I'm lazy & going to sleep for 5000ms");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("I got interrepted");
		}

		System.out.println("I'm done");
	}
	
	public static void main(String[] args) {
		SleepInterreptDemo sid = new SleepInterreptDemo();
		sid.start();
		// No impact if thread never goes to sleeping state.
		sid.interrupt(); // Waits until thread enters into sleeping state.
		System.out.println("Main ends");
	}
	
}
