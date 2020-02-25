package com.demo.multithreading.lock;

import java.util.concurrent.locks.ReentrantLock;

class Display {
	
	ReentrantLock l = new ReentrantLock();
	
	public void wish(String name) {
		l.lock();
		for (int i = 0; i < 10; i++) {
			System.out.println("Good Morning "+name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		l.unlock();
	}
}

class MyThread extends Thread {
	
	Display d;
	String name;
	
	public MyThread(Display d, String name) {
		super();
		this.d = d;
		this.name = name;
	}

	public void run() {
		d.wish(name);
	}
}

public class LockDemo {

	public static void main(String[] args) {
		Display d = new Display();
		MyThread mt = new MyThread(d, "Jeena");
		mt.start();
		MyThread mt1 = new MyThread(d, "Sunil");
		mt1.start();
	}

}
