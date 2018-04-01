package com.hyb.tij.chapter21.section05.p03;

import java.util.concurrent.TimeUnit;

public class Chef implements Runnable {

	private Restaurant restaurant;
	private int count = 0;

	public Chef(Restaurant r) {
		this.restaurant = r;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (restaurant.meal != null) {
						// 等待餐点送走
						wait();
					}
				}
				if (++count == 10) {
					System.out.println("out of food, closing");
					restaurant.exec.shutdownNow();
				}
				System.out.println("order up");
				// 通知waitPerson线程释放阻塞，先要获取其wait时监视器对象的锁，
				// 然后调用监视器对象的notify方法
				synchronized (restaurant.waitPerson) {
					restaurant.meal = new Meal(count);
					restaurant.waitPerson.notifyAll();
				}
				System.out.println("before chef sleep");
				// shutdownNow 后，将会在阻塞中或者进入阻塞之前抛出InterruptedException
				TimeUnit.MICROSECONDS.sleep(100);
				System.out.println("after chef sleep");
			}
		} catch (InterruptedException e) {
			System.out.println("Chef interrupted");
		}
	}

}
