package com.hyb.tij.chapter14.section04;

public class OilFilter extends Filter {
	public static class Factory implements com.hyb.tij.chapter14.section04.Factory<OilFilter>{
		@Override
		public OilFilter create() {
			return new OilFilter();
		}
		
	}
}
