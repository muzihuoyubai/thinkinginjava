package com.hyb.tij.chapter14.section04;

public class CabinAirFilter extends Filter {
	public static class Factory implements com.hyb.tij.chapter14.section04.Factory<CabinAirFilter>{
		@Override
		public CabinAirFilter create() {
			return new CabinAirFilter();
		}
		
	}
}
