package com.hyb.tij.chapter11.section07;

import java.util.LinkedList;

public class LinkedListSummary {

	public static void main(String[] args) {
		LinkedList<Integer> nums = new LinkedList<>();
		//添加首尾元素
		//add = addLast 区别是add 返回boolean  addLast 返回void
		//QUEUE offer = add 直接调用add ， offerFirst = addFirst， offerLast = addLast
		//STACK push = addFirst 直接调用
		nums.add(10);
		nums.addLast(11);
		nums.addFirst(14);
		nums.offerFirst(15);
		nums.offerLast(16);
		nums.offer(12);
		nums.push(13);
		
		//查询首尾元素
		//QUEUE element = getFirst 直接调用   空列表的话抛异常 NoSuchElementException
		//STACK peek 空列表的话返回null
		nums.getFirst();
		nums.getLast();
		nums.element();
		nums.peek();
		nums.peekFirst();
		nums.peekLast();
		
		//移除首尾元素 remove = removeFirst 直接盗用  空列表的话抛异常 NoSuchElementException
		//QUEUE poll = pollFirst 空列表返回null
		//STACK pop = removeFirst 直接调用
		nums.remove();
		nums.removeLast();
		nums.removeFirst();
		
		nums.poll();
		nums.pollFirst();
		nums.pollLast();
		
		nums.pop();
		
	}

}
