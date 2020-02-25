package com.demo.multithreading.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class TryForLockWT extends Thread{
	
	static ReentrantLock l = new ReentrantLock();
	
	public void run() {
		do {
			try {
				if(l.tryLock(5000,TimeUnit.MILLISECONDS)) {
					System.out.println("Got Lock Performing safe operation-"+Thread.currentThread().getName());
					try {
						Thread.sleep(30000);
						l.unlock();
						System.out.println("Releases Lock-"+Thread.currentThread().getName());
						break;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("Unable to get lock, will try again-"+ Thread.currentThread().getName());
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			
		} while (true);
		
	}
}

public class TryForLockWithTimeDemo {

	public static void main(String[] args) {
		TryForLockWT mt = new TryForLockWT();
		TryForLockWT mt1 = new TryForLockWT();
		mt.start();
		mt1.start();
	}

}
