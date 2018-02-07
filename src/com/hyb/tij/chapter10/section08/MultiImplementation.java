package com.hyb.tij.chapter10.section08;

public class MultiImplementation {
	static void takes(D d) {

	}

	static void takes(E e) {

	}

	public static void main(String[] args) {
		Z z = new Z();
		takes(z);
		takes(z.makeE());
	}
}
