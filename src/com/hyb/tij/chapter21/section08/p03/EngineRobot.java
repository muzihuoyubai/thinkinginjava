package com.hyb.tij.chapter21.section08.p03;

public class EngineRobot extends Robot {

	public EngineRobot(RobotPool pool) {
		super(pool);
	}

	@Override
	protected void performService() {
		System.out.println(this + " installing engin");
		assembler.car().addEngin();

	}

}
