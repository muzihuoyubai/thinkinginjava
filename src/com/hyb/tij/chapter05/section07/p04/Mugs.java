package com.hyb.tij.chapter05.section07.p04;

public class Mugs {
	
	Mug mug1;
	Mug mug2;
	Mug mug4 = new Mug(4);
	
	{
		mug1 = new Mug(1);
		mug2 = new Mug(2);
	}
	
	Mug mug3 = new Mug(3);
	
	Mugs() {
		System.out.println("Mugs()");
	}
	
	Mugs(int marker) {
		System.out.println("Mug(" + marker + ")");
	}
	
	public static void main(String[] args) {
		System.out.println("Inside main()");
		new Mugs();
		System.out.println("new Mugs complieted");
		new Mugs(1);
		System.out.println("new Mugs(1) complieted");
	}
}
