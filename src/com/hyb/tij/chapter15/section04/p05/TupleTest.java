package com.hyb.tij.chapter15.section04.p05;

public class TupleTest {
	static TwoTuple<String, Integer> f(){
		return Tuple.tuple("hi",47);
	}
	
	@SuppressWarnings("rawtypes")
	static TwoTuple f2() {
		return Tuple.tuple("hi",47);
	}
}
