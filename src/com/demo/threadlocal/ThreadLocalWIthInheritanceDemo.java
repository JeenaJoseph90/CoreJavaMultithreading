package com.demo.threadlocal;

class Parent extends Thread {
	
	//Parent thread's ThreadLocal value will not available to child thread
	/* static ThreadLocal<String> tl = new ThreadLocal<String>(); */
	
	//Values will be now available with InheritableThreadLocal.
	static InheritableThreadLocal<String> tl = new InheritableThreadLocal<String>() {
		// Override if require specific child value.
		public String childValue(String p) {
			return "Child "+p;
		}
	};
	
	public void run() {
		tl.set("PP");
		System.out.println(tl.get());
		//Don't get confuse with child thread & child class.
		Child c = new Child();
		c.start();
	}
	
}

class Child extends Thread {
	public void run() {
		System.out.println("Child Value-" + Parent.tl.get());
	}
}

public class ThreadLocalWIthInheritanceDemo {

	public static void main(String[] args) {
		Parent p = new Parent();
		p.start();
	}
	
}
