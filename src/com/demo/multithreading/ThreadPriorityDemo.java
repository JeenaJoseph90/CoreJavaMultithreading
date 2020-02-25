package com.demo.multithreading;

/**
 * @author jeena
 * Some OS doesn't support Thread Priority.
 */
public class ThreadPriorityDemo extends Thread {
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		ThreadPriorityDemo tpd = new ThreadPriorityDemo();
		tpd.setPriority(MIN_PRIORITY);
		tpd.start();
		ThreadPriorityDemo tpd1 = new ThreadPriorityDemo();
		// Default priority inherited from parent to child. main thread has priority 5.
		// Parent thread is different from parent class.
		tpd1.start();
		System.out.println(tpd1.getPriority());
		ThreadPriorityDemo tpd2 = new ThreadPriorityDemo();
		tpd2.setPriority(NORM_PRIORITY);
		tpd2.start();
		ThreadPriorityDemo tpd3 = new ThreadPriorityDemo();
		//tpd3.setPriority(11); //java.lang.IllegalArgumentException. (Valid Range 1-10)
		tpd3.start();
		ThreadPriorityDemo tpd4 = new ThreadPriorityDemo();
		tpd4.setPriority(MAX_PRIORITY);
		tpd4.start();
	}

}
