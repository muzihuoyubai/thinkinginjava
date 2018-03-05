package com.hyb.tij.chapter15.section00;

public class GenericFunction {
	public <T> T newInstance(Class<T> t) throws InstantiationException, IllegalAccessException {
		return  t.newInstance();
	}
}
