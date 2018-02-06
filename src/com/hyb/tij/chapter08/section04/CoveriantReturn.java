package com.hyb.tij.chapter08.section04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoveriantReturn {

private static final Logger LOG = LoggerFactory.getLogger(CoveriantReturn.class);
	public static void main(String[] args) {
		Mill m = new Mill();
		Grain g = m.process();
		LOG.info(g.toString());
		m = new WheatMill();
		g = m.process();
		LOG.info(g.toString());

	}

}
