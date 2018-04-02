package com.hyb.tij.chapter21.section07.p06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Pool<T> {
	private int size;
	private List<T> items = new ArrayList<>();

	private volatile boolean[] checkedOut;

	private Semaphore available;

	public Pool(Class<T> classObject, int size) {
		this.size = size;
		checkedOut = new boolean[size];
		available = new Semaphore(size, true);
		for (int i = 0; i < size; i++) {
			try {
				items.add(classObject.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public T checkOut() throws InterruptedException {
		available.acquire();
		return getItem();
	}

	public void checkIn(T x) {
		if (releaseItem(x)) {
			available.release();
		}
	}

	private boolean releaseItem(T x) {
		int index = items.indexOf(x);
		if (index == -1) {
			return false;
		}
		if (checkedOut[index]) {
			checkedOut[index] = false;
			return true;
		}
		return false;
	}

	private T getItem() {
		for (int i = 0; i < size; i++) {
			if (!checkedOut[i]) {
				checkedOut[i] = true;
				return items.get(i);
			}
		}
		throw new RuntimeException();
	}
}
