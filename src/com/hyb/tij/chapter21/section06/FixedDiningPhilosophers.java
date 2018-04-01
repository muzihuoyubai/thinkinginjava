package com.hyb.tij.chapter21.section06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 哲学家思考，吃东西解决死锁的版本，打破循环等待
 * 每个哲学家都是先拿右边的再拿左边的筷子，将会导致有机会所有的哲学家都拿了右边的筷子等待左边的筷子释放，造成死锁
 * 
 * @author HYB
 *
 */
public class FixedDiningPhilosophers {

	final static int PHI_NUM = 5;
	final static int PHI_PONDER = 0;

	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		Chopstick[] sticks = new Chopstick[PHI_NUM];
		for (int i = 0; i < sticks.length; i++) {
			sticks[i] = new Chopstick();
		}
		int size = PHI_NUM;
		int ponder = PHI_PONDER;
		for (int i = 1; i < sticks.length; i++) {

			if (i < (size - 1)) {
				exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder));
			} else {
				// 将一个哲学家修改为先拿左边的再拿右边的，打破循环等待
				exec.execute(new Philosopher(sticks[0], sticks[i], i, ponder));
			}

		}
		TimeUnit.SECONDS.sleep(20);
		exec.shutdownNow();

	}
}
