package com.hyb.tij.chapter21.section08.p03;

public class DriveTrainRobot extends Robot {

	public DriveTrainRobot(RobotPool pool) {
		super(pool);
	}

	@Override
	protected void performService() {
		System.out.println(this + " installing DriveTrain");
		assembler.car().addDriveTrain();

	}

}
