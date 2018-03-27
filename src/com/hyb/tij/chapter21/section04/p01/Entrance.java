package com.hyb.tij.chapter21.section04.p01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 旋转门
 * 
 * @author HYB
 *
 */
public class Entrance implements Runnable {

	private static Count count = new Count();
	private static List<Entrance> entrances = new ArrayList<>();
	// 通过这个门的人, 当前线程自己维护，不需要volatile
	private int number = 0;
	private final int id;
	private static volatile boolean canceled = false;

	// 关闭所有的门
	public static void cancel() {
		canceled = true;
	}

	public Entrance(int id) {
		this.id = id;
		// new出来就直接把自己添加到list里面去
		entrances.add(this);
	}

	@Override
	public void run() {
		// 只要不是主动取消，就隔一会放一个人进去，number++ count++
		while (!canceled) {
			synchronized (this) {
				++number;
			}
			System.out.println(this + " Total: " + count.increment());
		}
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("sleep interrupted");
		}
		System.out.println("Stopping " + this);
	}

	public synchronized int getValue() {
		return number;
	}

	public String toString() {
		return "Entrance " + id + ": " + getValue();
	}

	// 返回公园人数
	public static int getTotalCount() {
		return count.value();
	}

	// 统计每个门放进去的人的数量和
	public static int sumEntrances() {
		int sum = 0;
		for (Entrance entrance : entrances) {
			sum += entrance.getValue();
		}
		return sum;
	}

}
