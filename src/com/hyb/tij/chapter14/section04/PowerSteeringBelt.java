package com.hyb.tij.chapter14.section04;

public class PowerSteeringBelt extends Belt {
	public static class Factory implements com.hyb.tij.chapter14.section04.Factory<PowerSteeringBelt>{
		@Override
		public PowerSteeringBelt create() {
			return new PowerSteeringBelt();
		}
		
	}
}
