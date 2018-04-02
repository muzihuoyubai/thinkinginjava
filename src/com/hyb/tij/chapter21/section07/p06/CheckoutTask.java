package com.hyb.tij.chapter21.section07.p06;

import java.util.concurrent.TimeUnit;

public class CheckoutTask<T> implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private Pool<T> pool;

	public CheckoutTask(Pool<T> pool) {
		this.pool = pool;
	}

	@Override
	public void run() {
		try {
			T item = pool.checkOut();
			System.out.println(this + " checked out " + item);
			TimeUnit.SECONDS.sleep(1);
			System.out.println(this + " checking in " + item);
			pool.checkIn(item);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "CheckoutTask " + id + " ";
	}

}
