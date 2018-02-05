package com.hyb.tij.chapter08.section02.p05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FieldAccess {

	private static final Logger LOG = LoggerFactory.getLogger(FieldAccess.class);

	public static void main(String[] args) {
		Super sup = new Sub();
		LOG.info("sup.filed={},sup.getFiled()={}", sup.field, sup.getField());
		Sub sub = new Sub();
		LOG.info("sub.filed={},sub.getFiled()={},sub.getSuperField={}", sub.field, sub.getField(), sub.getSuperField());
	}

}
