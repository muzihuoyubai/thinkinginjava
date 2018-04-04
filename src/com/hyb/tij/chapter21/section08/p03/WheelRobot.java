package com.hyb.tij.chapter21.section08.p03;

public class WheelRobot extends Robot {

	public WheelRobot(RobotPool pool) {
		super(pool);
	}

	@Override
	protected void performService() {
		System.out.println(this + " installing Wheels");
		assembler.car().addWheels();
	}

}
