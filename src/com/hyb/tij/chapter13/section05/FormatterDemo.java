package com.hyb.tij.chapter13.section05;

import java.io.PrintStream;
import java.util.Formatter;

public class FormatterDemo {

	public static void main(String[] args) {
		PrintStream defaultOut = System.out;
		Formatter formatter = new Formatter(System.out);
		System.out.println("----------");
		formatter.format("%3s|%-5s", "21","1234");
		System.out.println();
		System.out.println("----------");
		formatter.format("%12.1f", 213.3);
		System.out.println();
		System.out.println("----------");
		formatter.format("%12.2f", 213.455);
		System.setOut(defaultOut);
		System.out.println();
		System.out.println("----------");
		System.out.println(String.format("%05d", 12));
		//formatter关闭后，控制台的输出也跟着一起关闭了
		formatter.close();
		System.out.println("this doesn't show after formatter close");
		
	}

}
