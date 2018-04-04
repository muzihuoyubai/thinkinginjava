package com.hyb.tij.chapter21.section08.p03;

public class Reporter implements Runnable {

	private CarQueue carQueue;

	public Reporter(CarQueue cq) {
		carQueue = cq;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				System.out.println(carQueue.take());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Reporter off");
	}

}
