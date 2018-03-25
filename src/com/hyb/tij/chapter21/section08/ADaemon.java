package com.hyb.tij.chapter21.section08;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程在程序退出后被关闭，不会抛异常，不会走finally
 * @author HYB
 *
 */
public class ADaemon implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("Starting ADaemon");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("Exiting via InterruptedException");
		} finally {
			System.out.println("This is finally print");
		}

	}

	public static void main(String[] args) {
		Thread t = new Thread(new ADaemon());
		t.setDaemon(true);
		t.start();
	}
}
