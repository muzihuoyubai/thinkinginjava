package com.hyb.tij.chapter10.section08.p01;

public class Callbacks {
	public static void main(String[] args) {
		Callee1 c1 = new Callee1();
		Callee2 c2 = new Callee2();
		MyIncrement.f(c2);
		Caller caller1 = new Caller(c1);
		//getCallbackReference 返回了一个内部类，包含了Callee2的信息
		//提供了一个返回Callee2的钩子
		Caller caller2 = new Caller(c2.getCallbackReference());
		caller1.go();
		caller1.go();
		caller2.go();
		caller2.go();
	}
}
