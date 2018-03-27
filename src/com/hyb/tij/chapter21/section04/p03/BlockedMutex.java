package com.hyb.tij.chapter21.section04.p03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedMutex {
	private Lock lock = new ReentrantLock();

	// 构造函数中加锁，并且不释放，将导致对象的方法在别的任务中不可用
	// 同一个线程中new 一个，是否可以调用f()方法？？
	public BlockedMutex() {
		lock.lock();
	}

	public void f() {
		try {
			System.out.println("in f()");
			lock.lockInterruptibly();
			System.out.println("lock acquired in f()");
		} catch (InterruptedException e) {
			System.out.println("Interrupted from lock acquisition in f()");
		}
	}

	public static void main(String[] args) throws Exception {
		BlockedMutex blocked = new BlockedMutex();
		// 可以调用，该任务获取了以上对象的锁，因此可以调用其方法
		blocked.f();

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// 无法调用，需要等待锁释放
				blocked.f();
			}
		});
		t.start();
	}
}
