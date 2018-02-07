package com.hyb.tij.chapter10.section06;

public class Parcel8 {

	public Wrapping wrapping(int x) {
		//返回一个wrapping类
		return new Wrapping(x);
	}

	public Wrapping wrapping1(int x) {
		//返回一个匿名内部类，继承自wrapping，覆写了value方法
		return new Wrapping(x) {
			public int value() {
				return x + 1;
			}
		};
	}

	public static void main(String[] args) {
		Parcel8 p = new Parcel8();
		System.out.println(p.wrapping(2).value());
		System.out.println(p.wrapping1(2).value());
	}
}
