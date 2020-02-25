package com.demo.synchronization;

class X {
	public synchronized void displayX(Y y) {
		System.out.println("Displaying X");
		y.last();
	}
	
	public synchronized void last() {
		System.out.println("Inside X last");
	}
}

class Y {
	public synchronized void displayY(X x) {
		System.out.println("Displaying Y");
		x.last();
	}
	
	public synchronized void last() {
		System.out.println("Inside Y last");
	}
}

public class SynchronizationDeadLockDemo extends Thread {
	
	X x = new X();
	Y y = new Y();

	public void run() {
		y.displayY(x); // Executed by child
	}
	
	public void m1() {
		this.start();
		x.displayX(y); // Executed by main
	}
	
	
	public static void main(String[] args) {

		SynchronizationDeadLockDemo t = new SynchronizationDeadLockDemo();
		t.m1();
	}
	
}
