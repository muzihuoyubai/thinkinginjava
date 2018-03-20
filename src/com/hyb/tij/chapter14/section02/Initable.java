package com.hyb.tij.chapter14.section02;

public class Initable {
	static final int staticFinal = 47;
	static final int statciFinal2 = ClassInitialization.rand.nextInt(1000);
	static {
		System.out.println("Initializing Initable in static");
	}
	
	{
		System.out.println("Initializing Initable in non-static");
	}
	
	public Initable() {
		System.out.println("Initable constructor");
	}
}
