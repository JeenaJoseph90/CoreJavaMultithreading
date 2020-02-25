package com.demo.multithreading;

/**
 * @author jeena
 * Thread demo by implementing Runnable interface.
 *
 */
public class ThreadRunnableDemo implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());	
	}
	
	public static void main(String[] args) {
		ThreadRunnableDemo trd = new ThreadRunnableDemo();
		Thread t1 = new Thread();
		Thread t2 = new Thread(trd);
		t1.start(); // Case-1 :  New Thread will be created & responsible to execute Thread's run method with empty implementation.
		t2.start(); // Case-2 : New Thread will be created & responsible for executing ThreadRunnableDemo's run method.
		t1.run(); // Case-3 :  No new Thread will be created & executes Thread's run with empty implementation. 
		t2.run(); // Case-4 : No new Thread will be created & executes ThreadRunnableDemo's run method.
		trd.run(); // Case-5 : No new Thread will be created & executes ThreadRunnableDemo's run method.
	}
}
