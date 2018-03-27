package com.hyb.tij.chapter21.section02.p14;

import java.lang.Thread.UncaughtExceptionHandler;

public class MyUncaughtExceptionHandler implements UncaughtExceptionHandler{

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("caught " + e);
		e.printStackTrace();
		System.out.println(Thread.currentThread());
	}
	
}
