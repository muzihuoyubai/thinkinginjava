package com.hyb.tij.chapter18.section10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
	private static final int SIZE = 1024;
	private static final String SOURCE = "C:\\Users\\HYB\\Desktop\\HeadFirst设计模式（中文版）.pdf";
	private static final String TARGET = "C:\\Users\\HYB\\Desktop\\out.pdf";

	public static void main(String[] args) throws IOException {
		try (FileChannel in = new FileInputStream(SOURCE).getChannel();
				FileChannel out = new FileOutputStream(TARGET).getChannel();) {

			ByteBuffer buffer = ByteBuffer.allocate(SIZE);
			while (in.read(buffer) != -1) {
				buffer.flip();
				out.write(buffer);
				buffer.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
