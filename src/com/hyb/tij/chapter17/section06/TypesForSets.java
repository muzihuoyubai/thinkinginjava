package com.hyb.tij.chapter17.section06;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TypesForSets {
	public static void main(String[] args) {
		Set<SetType> hashSet = new HashSet<>();
		Set<SetType> treeSet = new TreeSet<>();
		treeSet.add(new SetType(1));
		// treeSet.add(new SetType(3));

		hashSet.add(new SetType(2));
	}

	static class SetType {
		int i;

		public SetType(int n) {
			i = n;
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof SetType && (i == ((SetType) obj).i);
		}
	}

}
