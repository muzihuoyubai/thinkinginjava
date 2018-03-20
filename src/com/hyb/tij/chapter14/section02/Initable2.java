package com.hyb.tij.chapter14.section02;

public class Initable2 {
	static int staticNonFinal = 147;
	static {
		System.out.println("Initializing Initable2 in static");
	}
	
	{
		System.out.println("Initializing Initable2 in non-static");
	}
	
	public Initable2() {
		System.out.println("Initable2 constructor");
	}
}
