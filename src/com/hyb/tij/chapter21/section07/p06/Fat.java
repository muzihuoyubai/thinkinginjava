package com.hyb.tij.chapter21.section07.p06;

public class Fat {
	@SuppressWarnings("unused")
	private volatile double d;
	private static int counter = 0;
	private final int id = counter++;

	public Fat() {
		for (int i = 1; i < 10000; i++) {
			d += (Math.PI + Math.E) / i;
		}
	}

	public void operation() {
		System.out.println(this);
	}

	public String toString() {
		return "Fat id: " + id;
	};
}
