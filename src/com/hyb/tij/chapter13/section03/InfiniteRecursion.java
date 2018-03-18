package com.hyb.tij.chapter13.section03;

public class InfiniteRecursion {

	public String toString() {
		return "InfiniteRecursion address:" + super.toString();
		// 将产生递归调用
		// return "InfiniteRecursion address:" + this;
	}

	public static void main(String[] args) {
		System.out.println(new InfiniteRecursion());

	}
}
