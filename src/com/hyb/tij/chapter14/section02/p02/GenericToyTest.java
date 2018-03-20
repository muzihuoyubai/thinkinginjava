package com.hyb.tij.chapter14.section02.p02;

public class GenericToyTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {

		Class<FancyToy> ftClass = FancyToy.class;
		FancyToy fancyToy = ftClass.newInstance();
		Class<? super FancyToy> up = ftClass.getSuperclass();
		// 不能获取到指定父类的Class引用，只能是"某个超类"的引用
		// Class<Toy> tClass = ftClass.getSuperclass();
		Toy toy = (Toy) up.newInstance();
		System.out.println(up.newInstance());

	}

}
