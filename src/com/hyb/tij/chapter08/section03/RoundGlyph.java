package com.hyb.tij.chapter08.section03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoundGlyph extends Glyph{
	
	private static final Logger LOG = LoggerFactory.getLogger(RoundGlyph.class);
	private int radius =1;
	RoundGlyph(int r){
		radius = r;
		LOG.info("RoundGlyph.RoundGlyph(), radius = {}", radius);
	}
	void draw() {
		LOG.info("RoundGlyph.draw(),radius={}",radius);
	}
}
