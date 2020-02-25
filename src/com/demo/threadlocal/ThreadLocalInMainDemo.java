package com.demo.threadlocal;

public class ThreadLocalInMainDemo {

	public static void main(String[] args) {
		
		//ThreadLocal<String> l = new ThreadLocal<String>();
		//Setting initial value instead of null.
		ThreadLocal<String> l = new ThreadLocal<String>() {
			public String initialValue() {
				return "Temp";
			}
		};
		System.out.println(l.get());
		l.set("Jeena");
		System.out.println(l.get());
	}
	
}
