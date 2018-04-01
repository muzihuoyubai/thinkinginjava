package com.hyb.tij.chapter21.section06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 哲学家思考，吃东西的死锁版本
 * @author HYB
 *
 */
public class DeadlockingDiningPhilosophers {

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
		for (int i = 0; i < sticks.length; i++) {
			exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder));
		}
		TimeUnit.SECONDS.sleep(20);
		exec.shutdownNow();

	}
}
