package com.hyb.tij.chapter18.section10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TransferTo {
	private static final String SOURCE = "C:\\Users\\HYB\\Desktop\\HeadFirst设计模式（中文版）.pdf";
	private static final String TARGET = "C:\\Users\\HYB\\Desktop\\out1.pdf";

	public static void main(String[] args) throws IOException {
		try (FileChannel in = new FileInputStream(SOURCE).getChannel();
				FileChannel out = new FileOutputStream(TARGET).getChannel();) {

			in.transferTo(0, in.size(), out);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
