package com.demo.synchronization;

class Display {

	public synchronized void wish(String name) {
		for(int i=0;i<10;i++) {
			System.out.println("Good Morning " + name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized void callStaticSync(String name) {
		for(int i=0;i<10;i++) {
			System.out.println("Inside Static Sync by "+ name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
		Display.callStaticSync(name);
	}
}

public class SynchronizatonDemo {
	
	public static void main(String[] args) {
		Display d = new Display();
		MyThread t1 = new MyThread(d, "Jeena");
		t1.start();
		MyThread t2 = new MyThread(d, "Sunil");
		t2.start();
		/*
		 * MyThread t3 = new MyThread(new Display(), "Das"); t3.start();
		 */
	}
	
}
