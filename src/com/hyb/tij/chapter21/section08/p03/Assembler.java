package com.hyb.tij.chapter21.section08.p03;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Assembler implements Runnable {

	private CarQueue chassisQueue, finishingQueue;
	private Car car;
	private CyclicBarrier barrier = new CyclicBarrier(4);
	private RobotPool robotPool;

	public Assembler(CarQueue cq, CarQueue fq, RobotPool rp) {
		chassisQueue = cq;
		finishingQueue = fq;
		robotPool = rp;
	}

	public Car car() {
		return car;
	}

	public CyclicBarrier barrier() {
		return barrier;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				car = chassisQueue.take();
				robotPool.hire(EngineRobot.class, this);
				robotPool.hire(DriveTrainRobot.class, this);
				robotPool.hire(WheelRobot.class, this);
				barrier.await();
				finishingQueue.put(car);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		
		System.out.println("Assembler off");
	}

}
