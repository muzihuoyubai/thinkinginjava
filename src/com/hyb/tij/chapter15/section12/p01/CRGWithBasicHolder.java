package com.hyb.tij.chapter15.section12.p01;

public class CRGWithBasicHolder {

	public static void main(String[] args) {
		Subtype st1 = new Subtype(), st2 = new Subtype();
		st1.set(st2);
		st1.f();
		Subtype st3 = st1.get();
		System.out.println(st3.equals(st2));
	}
}
