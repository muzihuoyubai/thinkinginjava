package com.hyb.tij.chapter10.section05;

public class Parcel5 {
	public Destination destination(String s) {
		// 方法中的内部类，作用于为该方法中，但是如果内部类继承了公共接口被向上转型为了接口，那么只要外部获取了对接口的引用，就可以脱离方法作用于使用接口调用
		class PDestination implements Destination {
			private String label;

			private PDestination(String whereTo) {
				label = whereTo;
			}

			public String readLabel() {
				return label;
			}
		}
		return new PDestination(s);
	}

	public static void main(String[] args) {
		Parcel5 p = new Parcel5();
		Destination d = p.destination("Tasmania");
		System.out.println(d.readLabel());
	}
}
