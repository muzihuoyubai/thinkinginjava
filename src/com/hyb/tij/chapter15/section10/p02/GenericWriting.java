package com.hyb.tij.chapter15.section10.p02;

import java.util.Arrays;
import java.util.List;

import com.hyb.tij.chapter15.section10.Apple;
import com.hyb.tij.chapter15.section10.Fruit;

public class GenericWriting {
	static <T> T readExact(List<T> list) {
		return list.get(0);
	}

	static List<Apple> apples = Arrays.asList(new Apple());
	static List<Fruit> fruit = Arrays.asList(new Fruit());

	@SuppressWarnings("unused")
	static void f1() {
		Apple a = readExact(apples);
		Fruit f = readExact(fruit);
		f = readExact(apples);
	}

	static class Reader<T> {
		T readExact(List<T> list) {
			return list.get(0);
		}
	}

	@SuppressWarnings("unused")
	static void f2() {
		Reader<Fruit> fruitReader = new Reader<>();
		Fruit f = fruitReader.readExact(fruit);
		// fruitReader只能接受Fruit类型的list参数
		// fruitReader.readExact(apples);
	}

	static class CovariantReader<T> {
		T readCovariant(List<? extends T> list) {
			return list.get(0);
		}
	}

	@SuppressWarnings("unused")
	static void f3() {
		CovariantReader<Fruit> fruitReader = new CovariantReader<>();
		Fruit f = fruitReader.readCovariant(fruit);
		Fruit a = fruitReader.readCovariant(apples);
	}
}
