package com.hyb.tij.chapter12.section09;

public interface Storm {
	public void event() throws RainedOut;

	public void rainHard() throws StormException;
}
