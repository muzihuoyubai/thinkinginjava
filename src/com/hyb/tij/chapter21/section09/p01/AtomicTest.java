package com.hyb.tij.chapter21.section09.p01;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicTest extends Accumulator {

	{
		id = "Atomic";
	}
	private AtomicInteger index = new AtomicInteger(0);
	private AtomicLong value = new AtomicLong(0);

	@Override
	public void accumulate() {
		int i = index.getAndIncrement();
		value.getAndAdd(preLoaded[i]);
		if (++i >= SIZE) {
			index.set(0);
		}
	}

	@Override
	public long read() {
		return value.get();
	}

}
