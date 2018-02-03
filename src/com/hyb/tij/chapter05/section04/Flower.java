package com.hyb.tij.chapter05.section04;


/**
 * 
 * @description this中调用构造器
 *
 * @author Liyi
 * @date 2018年2月3日
 */
public class Flower {

	int petalCount = 0;
	String s = "initial value";

	Flower(int petals) {
		petalCount = petals;
		System.out.println("Constructor int arg only, petalCount=" + petalCount);
	}

	Flower(String ss) {
		System.out.println("Constructor String arg only, s=" + ss);
		s = ss;
	}

	Flower(String s, int petals) {
		this(petals);
		this.s = s;
		System.out.println("String & int args");
	}

	Flower() {
		this("hi", 47);
		System.out.println("default constructor (no arges)");
	}

	void printPetalCount() {
		System.out.println("petalCount = " + petalCount + "s = " + s);
	}

	public static void main(String[] args) {
		Flower x = new Flower();
		x.printPetalCount();
	}

}
