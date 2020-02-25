package com.demo.synchronization;

class A {
	public void showA() {
		B b = new B();
		synchronized (b) {
			b.showB();
			C c = new C();
			synchronized (c) {
				c.showC();
			}
		}
		System.out.println("Showing A by "+ Thread.currentThread().getName());
	}
}

class B {
	public void showB() {
		System.out.println("Showing B by "+ Thread.currentThread().getName());
	}
}

class C {
	public void showC() {
		System.out.println("Showing C by "+ Thread.currentThread().getName());
	}
}

public class NestedSyncDemo extends Thread {

	A a;
	
	public NestedSyncDemo(A a) {
		super();
		this.a = a;
	}

	public void run() {
		a.showA();
	}
	
	public static void main(String[] args) {
		A a = new A();
		NestedSyncDemo t = new NestedSyncDemo(a);
		t.start();
		NestedSyncDemo t1 = new NestedSyncDemo(a);
		t1.start();
	}
	
}
