package com.hyb.tij.chapter21.section02.p14;

import java.util.concurrent.ThreadFactory;

public class HandlerThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		System.out.println(this + " creating new Thread");
		System.out.println("runnable + " + r);
		Thread t = new Thread(r);
		System.out.println("created " + t);
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		System.out.println("eh = " + t.getUncaughtExceptionHandler());
		return t;
	}
}
