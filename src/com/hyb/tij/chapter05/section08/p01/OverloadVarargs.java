package com.hyb.tij.chapter05.section08.p01;

public class OverloadVarargs {
	static void f(float i, Character...characters) {
		
	}
	
	static void f(Character...characters) {
		
	}
	
	public static void main(String[] args) {
		f(1,'a');
		//f('a','b'); //error
	}
	
}
