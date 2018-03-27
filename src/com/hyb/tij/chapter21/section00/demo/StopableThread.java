package com.hyb.tij.chapter21.section00.demo;

import java.util.concurrent.TimeUnit;

/**
 * 不使用 volatile 造成修改变量不可见
 * @author HYB
 *
 */
public class StopableThread extends Thread {

	StopableThread(String name) {
		super(name);
	}

	// 不使用violate将会出现死循环，无法退出
	private boolean isRunning = true;
	// 使用violate 将会正常退出
	// private volatile boolean isRunning = true;

	@Override
	public void run() {
		while (isRunning) {

		}
	}

	public void stopRun() {
		isRunning = false;
		System.out.println(getName() + " stopRun");
	}

	public static void main(String[] args) {
		StopableThread thread = new StopableThread("test thread");
		thread.start();

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thread.stopRun();

	}
}
