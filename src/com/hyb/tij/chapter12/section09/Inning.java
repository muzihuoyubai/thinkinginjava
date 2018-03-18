package com.hyb.tij.chapter12.section09;

public abstract class Inning {
	public Inning() throws BaseballException {
	};
	
	public Inning(String s) {
	};

	public void event() throws BaseballException {
	};

	public abstract void atBat() throws Strike, Foul;

	public void walk() {
	}
}
