package com.hyb.tij.chapter21.section07.p03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class DelayedTask implements Runnable, Delayed {

	private static int counter = 0;
	private final int id = counter++;
	private final int delta;
	// 纳秒级的触发时间
	private final long trigger;
	protected static List<DelayedTask> sequence = new ArrayList<>();

	public DelayedTask(int delayInMilliseconds) {
		delta = delayInMilliseconds;
		trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delta, TimeUnit.MILLISECONDS);
		sequence.add(this);
	}

	@Override
	public int compareTo(Delayed o) {
		int rlt = 0;
		DelayedTask that = (DelayedTask) o;
		if (trigger < that.trigger) {
			rlt = -1;
		} else if (trigger == that.trigger) {
			rlt = 0;
		} else {
			rlt = 1;
		}
		System.out.println(this + " comparedTo" + o + ":" + rlt);
		return rlt;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		System.out.println(this + " getDelay");
		return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
	}

	@Override
	public void run() {
		System.out.println(this + " run");

	}

	public String toString() {
		// %1$ 参数化索引，第一个参数
		// - 左对齐
		// 4d 至少4位数字
		return String.format("[%1$-4d]", delta) + " Task " + id;
	}

	public String summary() {
		return "(" + id + ":" + delta + ")";
	}

	public static class EndSentinel extends DelayedTask {
		private ExecutorService exec;

		public EndSentinel(int delay, ExecutorService e) {
			super(delay);
			exec = e;
		}

		@Override
		public void run() {
			for (DelayedTask pt : sequence) {
				System.out.print(pt.summary() + " ");
			}
			System.out.println();
			System.out.println(this + " Calling shutdownNow()");
			exec.shutdownNow();
		}
	}
}
