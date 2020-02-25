package com.demo.interthread.communication;

class MyThread extends Thread {
	int total = 0;
	public void run() {
		synchronized (this) {
			System.out.println("Child Thread started calculation");
			for (int i = 0; i < 10; i++) {
				total = total + i;
			}
			System.out.println("Child Thread giving notification");
			this.notify();
		}
	}
}
public class ITCDemo {

	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
		synchronized (thread) {
			System.out.println("Main trying to call wait");
			try {
				thread.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Main thread got notified");
			System.out.println(thread.total);
		}
	}
	
}
