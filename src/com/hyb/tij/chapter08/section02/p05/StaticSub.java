package com.hyb.tij.chapter08.section02.p05;

public class StaticSub extends StaticSuper{
	public static String staticGet() {
		return "Derived staticGet()";
	}

	public String dynamicGet() {
		return "Derived dynamicGet()";
	}
}
