package com.hyb.tij.chapter21.section09.p01;

public class SynchronizedTest extends Accumulator {

	{
		id = "synchronized";
	}

	@Override
	public synchronized void accumulate() {
		value += preLoaded[index++];
		if (index >= SIZE) {
			index = 0;
		}

	}

	@Override
	public long read() {
		return value;
	}

}
