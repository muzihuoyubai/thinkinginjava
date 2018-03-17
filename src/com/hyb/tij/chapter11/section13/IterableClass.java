package com.hyb.tij.chapter11.section13;

import java.util.Iterator;

public class IterableClass implements Iterable<String> {

	protected String[] words = "And that is how we know the Earth to be banana-shaped.".split(" ");

	@Override
	public Iterator<String> iterator() {
		
		return new Iterator<String>() {
			int index = 0;
			@Override
			public boolean hasNext() {
				return index < words.length;
			}

			@Override
			public String next() {
				return words[index++];
			}
		};
	}

}
