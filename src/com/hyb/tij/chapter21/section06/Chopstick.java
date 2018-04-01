package com.hyb.tij.chapter21.section06;

public class Chopstick {
	private boolean taken = false;

	public synchronized void take() throws InterruptedException {
		while (taken) {
			wait();
		}
		taken = true;
	}

	public synchronized void drop() {
		taken = false;
		// TODO 通知所有的Chopstick对象还是通知唯一的wait对象??
		notifyAll();
	}
}