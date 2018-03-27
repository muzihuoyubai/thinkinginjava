package com.hyb.tij.chapter21.section04.p01;

import java.util.Random;

/**
 * 公园中的总人数
 * @author HYB
 *
 */
public class Count {
	private int count = 0;
	private Random rand = new Random(47);

	public synchronized int increment() {
		int temp = count;
		// 一半的几率通知cpu可以切换线程时间片
		if (rand.nextBoolean()) {
			Thread.yield();
		}
		return (count = ++temp);
	}

	// 去变量的方法也需要synchronized修饰，不然会出现不同步的问题
	public synchronized int value() {
		return count;
	}
}
