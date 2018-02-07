package com.hyb.tij.chapter10.section08.p01;

public class Caller {
	private Incrementable callbackReference;
	Caller(Incrementable cbh){
		callbackReference = cbh;
	}
	void go() {
		callbackReference.increment();
	}
}
