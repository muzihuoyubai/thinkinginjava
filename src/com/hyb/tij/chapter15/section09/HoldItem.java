package com.hyb.tij.chapter15.section09;

public class HoldItem <T>{
	T item;
	HoldItem(T item){
		this.item = item;
	}
	
	T getItem() {
		return item;
	}
}
