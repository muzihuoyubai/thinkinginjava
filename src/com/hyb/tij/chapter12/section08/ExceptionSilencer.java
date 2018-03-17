package com.hyb.tij.chapter12.section08;

public class ExceptionSilencer {

	public static void main(String[] args) throws Exception {
		exceptionThrower();
	}
	
	static void exceptionThrower() throws Exception {
		try {
			throw new Exception();
		} finally {
			//return 将导致异常被block
			return ;
		}
	}
}
