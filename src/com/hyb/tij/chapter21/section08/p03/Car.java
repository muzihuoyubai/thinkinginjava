package com.hyb.tij.chapter21.section08.p03;

public class Car {
	private final int id;
	private boolean engine = false, driveTrain = false, wheels = false;

	public Car(int idn) {
		id = idn;
	}

	public synchronized int getId() {
		return id;
	}

	public synchronized void addEngin() {
		engine = true;
	}

	public synchronized void addDriveTrain() {
		driveTrain = true;
	}

	public synchronized String toString() {
		return "Car " + id + " [" + " engine: " + engine + " driveTrain: " + driveTrain + " wheels: " + wheels + " ]";
	}

	public void addWheels() {
		wheels = true;
	}

}
