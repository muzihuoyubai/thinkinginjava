package com.hyb.tij.chapter21.section08.p02;

public class Plate {
	private final Order order;
	private final Food food;
	public Plate(Order ord, Food f) {
		order = ord ;
		food = f;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public Food getFood() {
		return food;
	}
	
	@Override
	public String toString() {
		return food.toString();
	}
}
