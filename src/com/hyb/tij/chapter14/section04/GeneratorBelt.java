package com.hyb.tij.chapter14.section04;

public class GeneratorBelt extends Belt {
	public static class Factory implements com.hyb.tij.chapter14.section04.Factory<GeneratorBelt>{
		@Override
		public GeneratorBelt create() {
			return new GeneratorBelt();
		}
		
	}
}
