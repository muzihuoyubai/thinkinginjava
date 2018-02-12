package com.hyb.tij.chapter11.section06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleIteration {
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		for (int i = 10; i > 0; i--) {
			nums.add(i);
		}

		Iterator<Integer> it = nums.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		it = nums.iterator();

		System.out.println(nums);
		//[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
		//[5, 4, 3, 2, 1]
		for (int i = 0; i < 5; i++) {
			// java.lang.IllegalStateException 先移动再删除
			// it.remove();
			it.next();
			it.remove();
		}
		System.out.println(nums);
		
		System.out.println(nums.iterator());
	}
}
