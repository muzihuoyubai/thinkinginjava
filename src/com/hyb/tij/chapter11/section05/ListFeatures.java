package com.hyb.tij.chapter11.section05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListFeatures {
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		for (int i = 10; i > 0; i--) {
			nums.add(i);
		}
		System.out.println(nums);

		// [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
		// true
		System.out.println(nums.contains(3));

		// [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
		// 2
		System.out.println(nums.indexOf(8));

		nums.add(3);
		System.out.println(nums);

		// [10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3]
		// [10, 9, 8, 6, 5, 4, 3, 2, 1, 3]
		nums.remove(3);
		System.out.println(nums);

		// [10, 9, 8, 6, 5, 4, 3, 2, 1, 3]
		// [10, 9, 8, 6, 5, 4, 2, 1, 3]
		nums.remove(new Integer(3));
		System.out.println(nums);

		// [3,4)
		// [10, 9, 8, 6, 5, 4, 2, 1, 3]
		// [6]
		System.out.println(nums.subList(3, 4));

		// false
		System.out.println(nums.containsAll(Arrays.asList(1, 2, 33)));

		// true
		System.out.println(nums.containsAll(Arrays.asList(1, 2, 3)));

		// 洗牌
		// [10, 8, 5, 9, 6, 1, 3, 4, 2]
		Collections.shuffle(nums, new Random(33));
		System.out.println(nums);

		Collections.shuffle(nums);
		System.out.println(nums);

		// [1, 2, 3, 4, 5, 6, 8, 9, 10]
		Collections.sort(nums);
		System.out.println(nums);

		List<Integer> retain = new ArrayList<>(nums);
		// [1, 2, 3, 4, 5, 6, 8, 9, 10]
		// [1, 2]
		retain.retainAll(Arrays.asList(1, 2, 33));
		System.out.println(retain);

		List<Integer> remove = new ArrayList<>(nums);
		// [1, 2, 3, 4, 5, 6, 8, 9, 10]
		// [3, 4, 5, 6, 8, 9, 10]
		remove.removeAll(Arrays.asList(1, 2, 33));
		System.out.println(remove);

		// [1, 2, 3, 4, 5, 6, 8, 9, 10]
		// [1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 23, 33]
		nums.addAll(Arrays.asList(11, 23, 33));
		System.out.println(nums);

		// [Ljava.lang.Object;@6d06d69c
		System.out.println(nums.toArray());
		
		//[Ljava.lang.Integer;@7852e922
		System.out.println(nums.toArray(new Integer[0]));
		
		//false
		System.out.println(nums.isEmpty());
		
		//[]
		nums.clear();
		System.out.println(nums);
		
		//true
		System.out.println(nums.isEmpty());

	}
}
