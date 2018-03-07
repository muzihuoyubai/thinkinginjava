package com.hyb.tij.chapter15.section09;

import java.awt.Color;

public class Colored2 <T extends HasColor> extends HoldItem<T>{

	Colored2(T item){
		super(item);
	}
	
	Color color() {
		return item.getColor();
	}
}
