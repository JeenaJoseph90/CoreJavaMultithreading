package com.demo.preventthread;

/**
 * @author jeena
 * Thread calls join with itself leads to DeadLock
 */
public class DeadLockDueToJoin {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main Started Executing");
		Thread.currentThread().join();
		System.out.println("Main After calling join");
	}
	
}
