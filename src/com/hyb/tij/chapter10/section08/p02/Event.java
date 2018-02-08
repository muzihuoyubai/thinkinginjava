package com.hyb.tij.chapter10.section08.p02;

public abstract class Event {
	private long eventTime;
	protected final long delayTime;

	public Event(long delayTime) {
		this.delayTime = delayTime;
		start();
	}

	public void start() {
		eventTime = System.currentTimeMillis() + delayTime;
	}

	public boolean ready() {
		return System.currentTimeMillis() >= eventTime;
	}

	public abstract void action();
}
