package com.hyb.tij.chapter10.section04;

public class TestParcel {
	public static void main(String[] args) {
		Parcel4 p = new Parcel4();
		// PContents 向上转型为Contents，无法再向下转型回去了，因为Parcel4.PContents是私有的，只能在Parcel4内引用
		Contents c = p.contents();
		Destination d = p.destination("Tasmania");

	}
}
