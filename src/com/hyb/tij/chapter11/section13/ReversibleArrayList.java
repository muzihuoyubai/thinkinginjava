package com.hyb.tij.chapter11.section13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@SuppressWarnings("serial")
public class ReversibleArrayList<T> extends ArrayList<T> {
	
	public ReversibleArrayList() {
		super();
	}

	public ReversibleArrayList(Collection<? extends T> c) {
		super(c);
	}

	public ReversibleArrayList(int initialCapacity) {
		super(initialCapacity);
	}

	public Iterable<T> reversed() {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>() {
					int current = size() - 1;

					@Override
					public boolean hasNext() {
						return current > -1;
					}

					@Override
					public T next() {
						return get(current--);
					}
				};
			}

		};
	}
}
