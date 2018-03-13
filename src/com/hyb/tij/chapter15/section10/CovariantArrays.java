package com.hyb.tij.chapter15.section10;

import java.util.ArrayList;
import java.util.List;

public class CovariantArrays {
	public static void main(String[] args) {
		// 一个apple数组可以放Apple
		// 和他的子类，但是不能放fruit类型，虽然fruit是一个Fruit类型的引用，但是指向Apple[]数组后，将不能存放Fruit，但是编译通过
		Fruit[] fruit = new Apple[10];
		fruit[0] = new Apple();
		fruit[1] = new Jonathan();

		// java.lang.ArrayStoreException
		// fruit[2] = new Fruit();
		// java.lang.ArrayStoreException
		// fruit[3] = new Orange();

		// Type mismatch: cannot convert from ArrayList<Apple> to List<Fruit>
		// List<Fruit> fList = new ArrayList<Apple>();

		@SuppressWarnings("unused")
		List<? extends Fruit> fList = new ArrayList<Apple>();
		// The method add(capture#1-of ? extends Fruit) in the type List<capture#1-of
		// ? extends Fruit> is not applicable for the arguments (Apple)
		// fList.add(new Apple());
		// fList.add(new Fruit());
		// fList.add(new Object());
	}

	static void writeTo(List<? super Apple> apples) {
		apples.add(new Apple());
		apples.add(new Jonathan());
	}
}
