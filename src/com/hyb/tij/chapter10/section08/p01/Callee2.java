package com.hyb.tij.chapter10.section08.p01;

public class Callee2 extends MyIncrement {
	private int i = 0;

	@Override
	public void increment() {
		super.increment();
		i++;
		System.out.println(i);
	}

	private class Closure implements Incrementable {
		@Override
		public void increment() {
			// 调用外部类的increment方法，不能写this.increment()，会导致自己调用自己的死循环
			Callee2.this.increment();
		}
	}

	Incrementable getCallbackReference() {
		return new Closure();
	}
}
