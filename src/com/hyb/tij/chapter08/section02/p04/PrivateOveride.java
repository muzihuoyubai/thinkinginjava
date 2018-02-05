package com.hyb.tij.chapter08.section02.p04;

public class PrivateOveride {
	private void f() {
		System.out.println("private f()");
	}

	public static void main(String[] args) {
		PrivateOveride po = new Derived();
		po.f();
	}
}
