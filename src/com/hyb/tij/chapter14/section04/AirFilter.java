package com.hyb.tij.chapter14.section04;

public class AirFilter extends Filter {
	public static class Factory implements com.hyb.tij.chapter14.section04.Factory<AirFilter>{
		@Override
		public AirFilter create() {
			return new AirFilter();
		}
		
	}
}
