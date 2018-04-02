package com.hyb.tij.chapter21.section07.p05;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduleWithFixedDelayTest {
	static int counter = 0;

	public static void main(String[] args) {
		ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor(3);
		schedule.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				int id = counter++;
				try {
					System.out.println(id + " run at " + new Date().toString());
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(id + " finish  at " + new Date().toString());
			}
		}, 1, 3, TimeUnit.SECONDS);

		schedule.schedule(new Runnable() {
			@Override
			public void run() {
				schedule.shutdownNow();
			}

		}, 15, TimeUnit.SECONDS);
	}
}
