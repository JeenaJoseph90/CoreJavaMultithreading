package com.demo.multithreading.lock;

import java.util.concurrent.locks.ReentrantLock;

class TryForLock extends Thread{
	
	static ReentrantLock l = new ReentrantLock();
	
	TryForLock(String name) {
		super(name);
	}
	
	public void run() {
		if(l.tryLock()) {
				System.out.println("Got Lock Performing safe operation-"+Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			l.unlock();
		} else {
			System.out.println("Unable to get lock so performing alternate operation-"+ Thread.currentThread().getName());
		}
	}
}

public class TryForLockDemo {

	public static void main(String[] args) {
		TryForLock mt = new TryForLock("Jeena");
		TryForLock mt1 = new TryForLock("Sunil");
		mt.start();
		mt1.start();
	}

}
