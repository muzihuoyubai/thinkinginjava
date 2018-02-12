package com.hyb.tij.chapter11.section06.p01;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteration {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		for (int i = 10; i > 0; i--) {
			nums.add(i);
		}
		
		ListIterator<Integer> it = nums.listIterator();
		while(it.hasNext()) {
			System.out.println("index:" +it.nextIndex());
			System.out.println(it.next());
		}
		System.out.println("backwards");
		while(it.hasPrevious()) {
			System.out.println("index:" + it.previousIndex());
			System.out.println(it.previous());
		}
		
		System.out.println("from index 3");
		it = nums.listIterator(3);
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
