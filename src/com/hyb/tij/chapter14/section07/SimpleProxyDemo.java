package com.hyb.tij.chapter14.section07;

public class SimpleProxyDemo {
	
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("consumer");
	}

	public static void main(String[] args) {
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
	}

}
