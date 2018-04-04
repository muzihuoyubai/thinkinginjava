package com.hyb.tij.chapter21.section08.p03;

import java.util.concurrent.TimeUnit;

public class ChassisBuilder implements Runnable {

	private CarQueue carQueue;
	private int counter = 0;

	public ChassisBuilder(CarQueue cq) {
		carQueue = cq;
	}

	@Override
	public void run() {

		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(500);
				Car c = new Car(counter++);
				System.out.println("ChassisBuilder created " + c);
				carQueue.put(c);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ChassisBuilder off");
	}

}
