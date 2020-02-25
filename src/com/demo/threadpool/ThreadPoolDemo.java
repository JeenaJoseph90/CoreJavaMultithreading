package com.demo.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PoolWork implements Runnable {
	
	String name;
	
	public PoolWork(String name) {
		super();
		this.name = name;
	}



	@Override
	public void run() {
		System.out.println(name+" job started by - "+Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+" job completed by - "+Thread.currentThread().getName());
	}
	
}

public class ThreadPoolDemo {
	
	public static void main(String[] args) {
		PoolWork [] jobs = new PoolWork [] {new PoolWork("Jeena"),new PoolWork("Sunil"),
											new PoolWork("Das"),new PoolWork("Joseph")};
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		for(PoolWork work : jobs)
			service.submit(work);
		
		service.shutdown();
				
	}

}
