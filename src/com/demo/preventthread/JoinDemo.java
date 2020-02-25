package com.demo.preventthread;

class MyThread extends Thread { 
	
	static Thread mt;
	
	public void run() {
		try {
			mt.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 0; i < 10; i++) {
			System.out.println("Child Thread");
		}
	}

}

public class JoinDemo {
	public static void main(String[] args) {
		MyThread.mt = Thread.currentThread();
		MyThread t = new MyThread();
		t.start();
		for(int i = 0; i < 10; i++) {
			System.out.println("Main Thread");
		}
	}
}
