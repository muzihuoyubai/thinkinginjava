package com.hyb.tij.chapter21.section09.p01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest extends Accumulator {

	{
		id = "Lock";
	}
	private Lock lock = new ReentrantLock();

	@Override
	public void accumulate() {
		lock.lock();
		try {
			value += preLoaded[index++];
			if (index >= SIZE) {
				index = 0;
			}
		} finally {
			lock.unlock();
		}

	}

	@Override
	public long read() {
		lock.lock();
		try {
			return value;
		} finally {
			lock.unlock();
		}

	}

}
