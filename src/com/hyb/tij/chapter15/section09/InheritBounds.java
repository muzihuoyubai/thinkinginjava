package com.hyb.tij.chapter15.section09;

public class InheritBounds {
	public static void main(String[] args) {
		Solid2<Bounded> solid2 = new Solid2<Bounded>(new Bounded());
		solid2.color();
		solid2.getY();
		solid2.weight();
	}
}
