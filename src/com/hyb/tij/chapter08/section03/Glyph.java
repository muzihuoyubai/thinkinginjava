package com.hyb.tij.chapter08.section03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Glyph {
	
	private static final Logger LOG = LoggerFactory.getLogger(Glyph.class);
	void draw() {
		LOG.info("Glyph.draw()");
	}
	
	Glyph(){
		LOG.info("Glyph() before draw()");
		draw();
		LOG.info("Glyph() after draw()");
	}
}
