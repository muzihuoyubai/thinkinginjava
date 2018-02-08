package com.hyb.tij.chapter10.section08.p02;

public abstract class Event {
	private long eventTime;
	protected final long delayTime;

	public Event(long delayTime) {
		this.delayTime = delayTime;
	}

	public void start() {
		System.out.println("start time:"+eventTime);
	}

	public boolean ready() {
		return System.currentTimeMillis() >= eventTime;
	}

	public abstract void action();
}
