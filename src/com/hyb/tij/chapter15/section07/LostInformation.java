package com.hyb.tij.chapter15.section07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LostInformation {
	
	public static void main(String[] args) {
		Map<Integer, String>  map = new HashMap<>();
		//output : [K, V]
		System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
	}
	
}
