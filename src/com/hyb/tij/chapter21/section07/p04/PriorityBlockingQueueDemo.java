package com.hyb.tij.chapter21.section07.p04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();
		service.execute(new PrioritizedTaskConsumer(queue));
		service.execute(new PrioritizedTaskProducer(queue, service));
	}
}
