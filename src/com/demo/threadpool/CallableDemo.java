package com.demo.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Calculate implements Callable<Integer>{
	
	int num;

	public Calculate(int num) {
		super();
		this.num = num;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("Job started for "+num);
		int total = 0;
		for (int i = 1; i <=num; i++) {
			total = total+i;
		}
		System.out.println("Job completed for "+num);
		return Integer.valueOf(total);
	}
}

public class CallableDemo {

	public static void main(String[] args) {
		Calculate [] jobs = new Calculate [] {
				new Calculate(5),
				new Calculate(2),
				new Calculate(10),
				new Calculate(100)
		};
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		for(Calculate c : jobs) {
			Future<Integer> result = service.submit(c);
			try {
				System.out.println(result.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		service.shutdown();
	}
}
