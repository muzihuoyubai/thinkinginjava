package com.hyb.tij.chapter21.section08.p03;

import java.util.concurrent.BrokenBarrierException;

public abstract class Robot implements Runnable {

	private RobotPool pool;
	protected Assembler assembler;

	public Robot(RobotPool p) {
		pool = p;
	}

	public Robot assignAssembler(Assembler assembler) {
		this.assembler = assembler;
		return this;
	}

	//机器人被使用装配的标志
	private boolean engage = false;

	public synchronized void engage() {
		engage = true;
		notifyAll();
	}

	abstract protected void performService();

	public void run() {
		try {
			powerDown();
			while (!Thread.interrupted()) {
				performService();
				assembler.barrier().await();
				powerDown();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this + " off");
	}

	private synchronized void powerDown() throws InterruptedException {
		engage = false;
		assembler = null;
		pool.release(this);
		while (engage == false) {
			wait();
		}
	}

	public String toString() {
		return getClass().getName();
	}
}
