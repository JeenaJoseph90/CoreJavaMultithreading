package com.demo.multithreading;

/**
 * @author jeena
 * Thread demo by extending Thread Class
 *
 */
public class ThreadDemo extends Thread {
	
	/*
	 * Case-5 : Recommended to override run else thread will call run method in Thread class
	 * which has empty implementation. Result no output will be displayed.
	 */
	//Case-2 : run() - Thread's Job
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
	//Case-4 : Overloading of run is possible but Thread will always call run with no arg.
	public void run(int i) {
		System.out.println(Thread.currentThread().getName()+" : "+ i);
	}
	
	//Case-6 : Not recommended to override start method. Calling this will not create any separate thread.
	public void start() {
		super.start(); // Case-7 : Calling Thread Start from overridden start. A separate thread will be created.
		System.out.println("ThreadDemo class overridden start Method");
	}

	public static void main(String args[]) {
		System.out.println(Thread.currentThread().getName());
		ThreadDemo td = new ThreadDemo();
		//Case-1 : ThreadSchedular - Part of JVM
		td.start(); // Case-3 : Register thread with thread scheduler, Perform activities & involk run method.
		td.run(2); // Main Thread is responsible to execute this line.
		
		// Case-8 : Calling already started thread causes - java.lang.IllegalThreadStateException
		td.start();
	}
	
}
