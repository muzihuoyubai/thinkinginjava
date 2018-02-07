package com.hyb.tij.chapter10.section08.p01;

public class MyIncrement {
	public void increment() {
		System.out.println("other operation");
	}
	static void f(MyIncrement mi) {
		mi.increment();
	}
}
