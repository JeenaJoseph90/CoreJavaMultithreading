package com.demo.threadlocal;

class CustomerThread extends Thread {
	static Integer custId = 0;
	private static ThreadLocal<Integer> tl = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return ++custId;
		}
	};
	
	CustomerThread(String name) {
		super(name);
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+" Executing with custId - "+ tl.get());
	}
}

public class ThreadLocalDemo {

	public static void main(String[] args) {
		CustomerThread ct1 = new CustomerThread("Customer 1");
		CustomerThread ct2 = new CustomerThread("Customer 2");
		CustomerThread ct3 = new CustomerThread("Customer 3");
		CustomerThread ct4 = new CustomerThread("Customer 4");

		ct1.start();
		ct2.start();
		ct3.start();
		ct4.start();

	}
	
}
