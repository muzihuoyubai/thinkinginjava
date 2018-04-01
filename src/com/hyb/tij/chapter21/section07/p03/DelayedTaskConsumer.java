package com.hyb.tij.chapter21.section07.p03;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DelayedTaskConsumer implements Runnable {

	private DelayQueue<DelayedTask> q;

	public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
		this.q = q;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				q.take().run();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finished DelayedTaskConsumer");
	}
	
	public static void main(String[] args) {
		Random rand = new Random(47);

		ExecutorService exec = Executors.newCachedThreadPool();
		DelayQueue<DelayedTask> queue = new DelayQueue<>();
		for (int i = 0; i < 20; i++) {
			queue.put(new DelayedTask(rand.nextInt(5000)));
		}
		//put add 都是调用offer
		queue.add(new DelayedTask.EndSentinel(5000, exec));
		exec.execute(new DelayedTaskConsumer(queue));
	}

}
