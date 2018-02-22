package com.hyb.tij.chapter14.section07;

public class RealObject implements Interface {

	@Override
	public void doSomething() {
		System.out.println("RealObject do something");
	}

	@Override
	public void somethingElse(String arg) {
		System.out.println("RealObject do something else "  + arg);
	}

}
