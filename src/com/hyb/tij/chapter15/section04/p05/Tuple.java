package com.hyb.tij.chapter15.section04.p05;

public class Tuple {
	public static <A,B> TwoTuple<A,B> tuple(A a,B b){
		return new TwoTuple<A,B>(a,b);
	}
}
