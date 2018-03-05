package com.hyb.tij.chapter15.section00;

import java.util.Iterator;

public class IteratorTest implements Iterator<Integer>,Iterable<Integer>{
	
	private int count;
	IteratorTest(int count){
		this.count = count;
	}

	@Override
	public boolean hasNext() {
		System.out.println("hasNext");
		return count > 0;
	}

	@Override
	public Integer next() {
		return count--;
	}
	
	public static void main(String[] args) {
		for(Integer i : new IteratorTest(20)) {
			System.out.println(i);
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new IteratorTest(20);
	}

}
