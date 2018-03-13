package com.hyb.tij.chapter15.section11.p03;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class NeedCasting {
	@SuppressWarnings({ "unused", "unchecked" })
	public void f(String[] args) throws Exception{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
		List<Integer> shapes = (List<Integer>) in.readObject();
		List<Integer> shapes1 = List.class.cast(in.readObject());
		in.close();
	}
}
