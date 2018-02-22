package com.hyb.tij.chapter14.section04;

public class RegisteredFactories {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Part.creatRandom());
		}
	}
}
