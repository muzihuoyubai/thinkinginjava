package com.hyb.tij.chapter14.section07;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler{
	private Object proxied;

	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println(
				"Proxy: " + proxy.getClass().getSimpleName() + "." + method.getName() + "(" + args + ")");
		return method.invoke(proxied, args);
	}
}
