package com.hyb.tij.chapter11.section07;

import java.util.LinkedList;

public class LinkedListFeatures {
	public static void main(String[] args) {
		LinkedList<Integer> nums = new LinkedList<>();
		for (int i = 10; i > 0; i--) {
			nums.add(i);
		}
		System.out.println(nums.toString());
		//获取list第一个元素，NoSuchElementException - if this list is empty
		System.out.println(nums.getFirst());
		System.out.println(nums.element());
		//获取list第一个元素，null returned if this list is empty
		System.out.println(nums.peek());
		
		//Retrieves and removes the head (first element) of this list.
		//NoSuchElementException - if this list is empty
		//remove = removeFirst
		System.out.println(nums.remove());
		System.out.println(nums.removeFirst());
		//null if this list is empty
		System.out.println(nums.poll());
		System.out.println(nums);
		
		nums.addFirst(10);
		//add = addLast
		nums.add(20);
		nums.addLast(21);
		System.out.println(nums);
		nums.offer(11);
		nums.addLast(12);
		System.out.println(nums);
		
	}
}
