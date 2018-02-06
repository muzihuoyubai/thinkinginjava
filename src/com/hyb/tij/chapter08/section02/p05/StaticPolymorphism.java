package com.hyb.tij.chapter08.section02.p05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaticPolymorphism {
	
	private static final Logger LOG = LoggerFactory.getLogger(StaticPolymorphism.class);
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		StaticSuper sup = new StaticSub();
		LOG.info(sup.staticGet());
		LOG.info(sup.dynamicGet());
	}
}
