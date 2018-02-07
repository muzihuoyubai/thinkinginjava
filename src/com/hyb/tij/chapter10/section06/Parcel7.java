package com.hyb.tij.chapter10.section06;

public class Parcel7 {
	// 匿名内部类
	public Contents Contents() {
		//返回了匿名内部类，实现了接口Contents
		return new Contents() {
			private int i = 11;

			@Override
			public int value() {
				return i;
			}
		};
	}

	public static void main(String[] args) {
		Parcel7 p = new Parcel7();
		Contents c = p.Contents();
		c.value();
	}
}
