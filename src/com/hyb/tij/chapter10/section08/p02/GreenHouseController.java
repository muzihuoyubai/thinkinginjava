package com.hyb.tij.chapter10.section08.p02;

public class GreenHouseController {

	public static void main(String[] args) {
		GreenhouseControls gc = new GreenhouseControls();
		gc.addEvent(gc.new Bell(900));
		
		Event[] eventList = {
				gc.new ThermostatNigth(800),
				gc.new LightOn(200),
				gc.new LightOff(400),
				gc.new WaterOn(600),
				gc.new WaterOff(800),
				gc.new ThermostatDay(1400),
		};
		
		gc.addEvent(gc.new Restart(2000, eventList));
		if(args.length == 1) {
			gc.addEvent(gc.new Terminate(new Long(args[0])));
		}
		
		gc.run();
	}

}
