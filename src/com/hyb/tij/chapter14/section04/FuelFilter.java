package com.hyb.tij.chapter14.section04;

public class FuelFilter extends Filter {
	public static class Factory implements com.hyb.tij.chapter14.section04.Factory<FuelFilter>{
		@Override
		public FuelFilter create() {
			return new FuelFilter();
		}
		
	}
}
