package com.demo.threadgroup;

class MyThread implements Runnable {
	public void run() {
		System.out.println("Executing MyThread");
	}
}

class YourThread implements Runnable {
	public void run() {
		System.out.println("Executing YourThread");
	}
}

public class ThreadGroupDemo {

	public static void main(String[] args) {
		ThreadGroup grp = new ThreadGroup("Thread Group 1");
		Thread t1 = new Thread(grp, new MyThread()); // Priority won't change
		Thread t2 = new Thread(grp, new YourThread()); // Priority won't change
		grp.setMaxPriority(3);
		Thread t3 = new Thread(grp, new YourThread()); // Priority will change
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(t3.getPriority());
		// Getting details of System Thread Group.
		ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
		Thread [] t = new Thread[system.activeCount()];
		system.enumerate(t); // Copies all active threads from system group to array t.
		for(Thread temp : t) {
			System.out.println(temp.getName() + " : "+ temp.isDaemon());
		}
	}
	
}
