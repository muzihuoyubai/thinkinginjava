package com.hyb.tij.chapter21.section04.p03;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;

/**
 * NIO 读取阻塞线程
 * 
 * @author HYB
 *
 */
public class NIOBlocked implements Runnable {

	private final SocketChannel sc;

	public NIOBlocked(SocketChannel sc) {
		this.sc = sc;
	}

	@Override
	public void run() {
		try {
			System.out.println("Waiting for read() in " + this);
			sc.read(ByteBuffer.allocate(1));
			// Future.cannel(true) 触发该异常
		} catch (ClosedByInterruptException e) {
			System.out.println("ClosedByInterruptException");
		} catch (AsynchronousCloseException e) {
			// 资源关闭触发该异常
			System.out.println("AsynchronousCloseException");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Exiting NIOBlocked.run() " + this);
	}

}
