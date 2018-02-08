package com.hyb.tij.chapter10.section08.p02;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class GreenhouseControls extends Controller {
	
	private static final Logger LOG = LoggerFactory.getLogger(GreenhouseControls.class);
	private boolean light = false;

	public class LightOn extends Event {
		public LightOn(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			light = true;
		}

		public String toString() {
			return "Light is on";
		}
	}

	public class LightOff extends Event {

		public LightOff(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			light = false;
		}

		public String toString() {
			return "Light is off";
		}
	}

	private boolean water = false;

	public class WaterOn extends Event {

		public WaterOn(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			water = true;
		}

		public String toString() {
			return "Greenhouse water is on";
		}
	}

	public class WaterOff extends Event {

		public WaterOff(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			water = false;
		}

		public String toString() {
			return "Greenhouse water is off";
		}
	}

	private String thermostat = "Day";

	public class ThermostatNigth extends Event {

		public ThermostatNigth(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			thermostat = "Night";
		}

		public String toString() {
			return "Thermostat on night setting";
		}
	}

	public class ThermostatDay extends Event {

		public ThermostatDay(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			thermostat = "Day";
		}

		public String toString() {
			return "Thermostat on day setting";
		}
	}

	public class Bell extends Event {

		public Bell(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			Bell bell = new Bell(delayTime);
			bell.start();
			addEvent(bell);
		}

		public String toString() {
			return "Bing";
		}

	}
	
	public class Restart extends Event {
		private Event[] eventList;
		public Restart(long delayTime, Event[] eventList) {
			super(delayTime);
			this.eventList = eventList;
			for(Event e: eventList) {
				addEvent(e);
				LOG.info("add event:{}",e);
			}
		}

		@Override
		public void action() {
			for(Event e: eventList) {
				e.start();
				addEvent(e);
			}
			start();
			addEvent(this);
		}

		public String toString() {
			LOG.info(Arrays.toString(eventList));
			return "restart system";
		}
	}
	
	public class Terminate extends Event {
		public Terminate(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			System.exit(0);
		}

		public String toString() {
			return "Terminating";
		}
	}

}
