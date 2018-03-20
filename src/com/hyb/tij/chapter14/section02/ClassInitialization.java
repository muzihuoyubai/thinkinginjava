package com.hyb.tij.chapter14.section02;

import java.util.Random;

public class ClassInitialization {
	public static Random rand = new Random(47);
	public static void main(String[] args) {
		@SuppressWarnings({ "rawtypes", "unused" })
		Class initable = Initable.class;
		System.out.println("After creating Initable class ref");
		System.out.println(Initable.staticFinal);
		System.out.println(Initable.statciFinal2);
		System.out.println(Initable2.staticNonFinal);
	}
}
