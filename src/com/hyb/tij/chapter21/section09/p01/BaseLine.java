package com.hyb.tij.chapter21.section09.p01;

public class BaseLine extends Accumulator {

	{
		id = "BaseLine";
	}

	@Override
	public void accumulate() {
		index++;
		if (index >= SIZE) {
			index = 0;
		}
		value += preLoaded[index];
	}

	@Override
	public long read() {
		return value;
	}

}
