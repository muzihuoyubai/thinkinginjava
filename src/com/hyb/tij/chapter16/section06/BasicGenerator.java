package com.hyb.tij.chapter16.section06;

public class BasicGenerator<T> implements Generator<T> {
	private Class<T> type;
	public BasicGenerator(Class<T> type) {
		this.type = type;
	}
	
	public T next() {
		try {
			return type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T> Generator<T> create(Class<T> type){
		return new BasicGenerator<T>(type);
	}
}
