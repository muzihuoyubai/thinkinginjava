package com.hyb.tij.chapter21.section05.p03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 餐厅、厨师、服务员模拟 生产者和消费者
 * 
 * @author HYB
 *
 */
public class Restaurant {
	Meal meal;
	ExecutorService exec = Executors.newCachedThreadPool();
	WaitPerson waitPerson = new WaitPerson(this);
	Chef chef = new Chef(this);

	public Restaurant() {
		exec.execute(chef);
		exec.execute(waitPerson);
	}

	public static void main(String[] args) {
		new Restaurant();
	}
}
