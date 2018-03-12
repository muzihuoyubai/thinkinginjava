package com.hyb.tij.chapter15.section08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class ListOfGenerics<T> {
	public final static int SIZE = 10;
	private List<T> arrayList = new ArrayList<>();
	@SuppressWarnings("unchecked")
	private T[] array = (T[]) new Object[5];
	//不能直接new泛型
	//	private T[] array = (T[]) new T[5];
	static ArrayList<Integer>[] integerLists;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.util.ArrayList;
		//integerLists = (ArrayList<Integer>[]) new Object[SIZE];
		//Cannot create a generic array of ArrayList<Integer>
		//ArrayList<Integer>[] temp = new ArrayList<Integer>[SIZE];
		ArrayList<Integer>[] temp = (ArrayList<Integer>[])new ArrayList[SIZE];
		
		integerLists = new ArrayList[SIZE];
		System.out.println(integerLists.getClass().getSimpleName());
		integerLists[0] = new ArrayList<Integer>();
		System.out.println(Arrays.toString(integerLists));
		//Type mismatch: cannot convert from Object to ArrayList<Integer>
		//integerLists[1] = new Object();
	}

}
