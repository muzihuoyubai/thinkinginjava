package com.hyb.tij.chapter21.section08.p02;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Chef implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private final Restaurant restaurant;
	private static Random rand = new Random(47);

	public Chef(Restaurant rest) {
		restaurant = rest;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Order order = restaurant.orders.take();
				Food requestItem = order.item();
				TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
				Plate plate = new Plate(order, requestItem);
				order.getWaitPerson().filledOrders.put(plate);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(this + " off duty");

	}

	@Override
	public String toString() {
		return "Chef " + id + " ";
	}

}
