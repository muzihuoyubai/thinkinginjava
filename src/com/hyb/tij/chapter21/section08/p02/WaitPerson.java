package com.hyb.tij.chapter21.section08.p02;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class WaitPerson implements Runnable {

	private static int counter = 0;
	private final int id = counter++;
	private final Restaurant restaurant;
	BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<>();

	public WaitPerson(Restaurant rest) {
		restaurant = rest;
	}

	/**
	 * 服务员将单子添加到餐厅的点单队列中
	 * @param cust
	 * @param food
	 */
	public void placeOrder(Customer cust, Food food) {
		try {
			restaurant.orders.put(new Order(cust, this, food));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 将处理好的点单、将食物分配给指定的顾客
	 */
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Plate plate = filledOrders.take();
				System.out.println(this + " received " + plate + " delivering to " + plate.getOrder().getCustomer());
				plate.getOrder().getCustomer().deliver(plate);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(this + " off duty");
	}

	public String toString() {
		return "WaitPerson " + id + " ";
	}
}
