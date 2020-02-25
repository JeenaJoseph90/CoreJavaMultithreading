package com.demo.synchronization;

class Demo {
	
	public void show() {
		for(int i=1;i<=10;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
		synchronized (this) {
			for(int i=1;i<=10;i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Inside Sync block "+Thread.currentThread().getName());
			}
		}
	}
}

public class SynchronizedBlockDemo extends Thread {

	Demo d;
	
	
	
	public SynchronizedBlockDemo(Demo d) {
		super();
		this.d = d;
	}

	public void run() {
		d.show();
	}
	
	public static void main(String[] args) {
		Demo d = new Demo();
		SynchronizedBlockDemo t = new SynchronizedBlockDemo(d);
		t.start();
		SynchronizedBlockDemo t1 = new SynchronizedBlockDemo(d);
		t1.start();
	}
	
}
