package com.hyb.tij.chapter14.section04;

public class FanBelt extends Belt {
	public static class Factory implements com.hyb.tij.chapter14.section04.Factory<FanBelt>{
		@Override
		public FanBelt create() {
			return new FanBelt();
		}
		
	}
}
