package com.hyb.tij.chapter15.section11;

public class AutoPackTest {

	// static void show(int[] test) {
	// System.out.println("show(int [] test)");
	// for (int one : test) {
	// System.out.println(one);
	// }
	// }

	static void show(int test) {
		System.out.println(" show(int test)");
		System.out.println(test);
	}

	static void show(Integer[] test) {
		System.out.println("show(Integer [] test)");
		for (int one : test) {
			System.out.println(one);
		}
	}

	static void show(Integer test) {
		System.out.println("show(Integer test)");
		System.out.println(test);
	}

	public static void main(String[] args) {
		//数组不能自动包装和解包
		//show(new int[] { 1, 2, 3, 4 });
		show(new Integer(1));
		show(1);
	}
}
