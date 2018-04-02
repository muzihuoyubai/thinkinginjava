package com.hyb.tij.chapter21.section07.p04;

import java.util.concurrent.PriorityBlockingQueue;

public class PrioritizedTaskConsumer implements Runnable {

	private PriorityBlockingQueue<Runnable> q;

	public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> q) {
		this.q = q;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				q.take().run();
				System.out.println("cousum one");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finished PrioritizedTaskConsumer");
	}

}
