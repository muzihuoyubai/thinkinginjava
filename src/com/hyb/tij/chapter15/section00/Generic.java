package com.hyb.tij.chapter15.section00;

public class Generic<T> {
	
	public T newInstance(Class<T> t) throws InstantiationException, IllegalAccessException {
		return  t.newInstance();
	}
	
	class inner {
		public T newInstance(Class<T> t) throws InstantiationException, IllegalAccessException {
			return  t.newInstance();
		}
	}
}
