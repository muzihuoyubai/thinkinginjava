package com.hyb.tij.chapter08.section02.p04;

public class Derived extends PrivateOveride {
	public void f() {
		System.out.println("public f()");
	}

	// public static void main(String[] args) {
	// PrivateOveride po = new Derived();
	// po.f(); //私有方法不会被覆盖，调用父类的私有方法，报错，无法访问
	// }
}
