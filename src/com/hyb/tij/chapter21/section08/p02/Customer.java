package com.hyb.tij.chapter21.section08.p02;

import java.util.concurrent.SynchronousQueue;

/**
 * 每个顾客构造时都对应一个waitPerson
 * 顾客遍历所有的食物类型，从每个类型里面随机选一个，通过waitPerson点餐
 * 从placeSetting 里面取餐用餐，SynchronousQueue 取餐时拿不到餐的时候就一直阻塞等待
 * 
 * @author HYB
 *
 */
public class Customer implements Runnable {

	private static int counter = 0;
	private final int id = counter++;
	private final WaitPerson waitPerson;
	private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<>();

	public Customer(WaitPerson w) {
		waitPerson = w;
	}

	public void deliver(Plate p) {
		try {
			placeSetting.put(p);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		for (Course course : Course.values()) {
			Food food = course.randomSelection();
			try {
				waitPerson.placeOrder(this, food);
				System.out.println(this + " eating " + placeSetting.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
		System.out.println(this + " finished meal, leaving");

	}

	@Override
	public String toString() {
		return "Customer " + id + " ";
	}
}
