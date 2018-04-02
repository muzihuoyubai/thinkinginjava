package com.hyb.tij.chapter21.section07.p03;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueCompareDemo {

	public static void main(String[] args) throws InterruptedException {
		DelayQueue<Compared> q = new DelayQueue<>();
		q.add(new Compared(-200));
		q.add(new Compared(-300));

		System.out.println(q.take());
	}

	static class Compared implements Delayed {

		static int counter = 0;
		final int id = counter++;
		long delay;

		Compared(long delay) {
			this.delay = delay;
		}

		@Override
		public int compareTo(Delayed o) {
			long rlt = getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS);
			System.out.println(this + "compared to " + o + ":" + rlt);
			if (rlt > 0) {
				return -1;
			} else if (rlt == 0) {
				return 0;
			} else {
				return 1;
			}
		}

		@Override
		public long getDelay(TimeUnit unit) {
			return delay;
		}

		@Override
		public String toString() {
			return id + "";
		}

	}
}
