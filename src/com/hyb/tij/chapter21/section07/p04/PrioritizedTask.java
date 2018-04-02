package com.hyb.tij.chapter21.section07.p04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {

	private Random rand = new Random(47);
	private static int counter = 0;
	private final int id = counter++;
	private final int priority;
	protected static List<PrioritizedTask> sequence = new ArrayList<>();

	public PrioritizedTask(int priority) {
		this.priority = priority;
		sequence.add(this);
	}

	@Override
	public int compareTo(PrioritizedTask o) {
		return priority < o.priority ? 1 : (priority > o.priority ? -1 : 0);
	}

	@Override
	public void run() {
		try {
			TimeUnit.MICROSECONDS.sleep(rand.nextInt(250));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this + "runned");
	}

	@Override
	public String toString() {
		return String.format("[%1$-3d]", priority) + " Task " + id;
	}

	public String summary() {
		return "(" + id + ":" + priority + ")";
	}

	public static class EndSentinel extends PrioritizedTask {
		private ExecutorService exec;

		public EndSentinel(ExecutorService e) {
			super(-1);
			exec = e;
		}

		@Override
		public void run() {
			for (PrioritizedTask pt : sequence) {
				System.out.println(pt.summary());
			}
			System.out.println(this + " Calling ShutdownNow()");
			exec.shutdownNow();
		}
	}

}
