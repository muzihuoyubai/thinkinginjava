package com.hyb.tij.chapter21.section07.p06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
	final static int SIZE = 25;

	public static void main(String[] args) throws InterruptedException {
		final Pool<Fat> pool = new Pool<>(Fat.class, SIZE);

		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < SIZE; i++) {
			exec.execute(new CheckoutTask<Fat>(pool));
		}
		System.out.println("All checkoutTasks created");

		List<Fat> list = new ArrayList<>();

		for (int i = 0; i < SIZE; i++) {
			Fat f = pool.checkOut();
			System.out.println(i+":main() thread checked out ");
			f.operation();
			list.add(f);
		}
		
		Future<?> blocked = exec.submit(new Runnable() {

			@Override
			public void run() {
				try {
					pool.checkOut();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		TimeUnit.SECONDS.sleep(2);
		blocked.cancel(true);
		System.out.println("Checking in objects in " + list);
		for(Fat f : list) {
			pool.checkIn(f);
		}
		for(Fat f : list) {
			pool.checkIn(f);
		}
		exec.shutdown();
	}
}
