package com.hyb.tij.chapter21.section02.p14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程的异常处理 UncaughtExceptionHandler
 * 
 * @author HYB
 *
 */
public class CaptureUncaughtException {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool(new HandlerThreadFactory());
		// 这里的runnable 经过了 ThreadFactory 的处理, setUncaughtExceptionHandler
		service.execute(new ExceptionThread2());
		// TODO 遗留问题 如果不shutdown 则会出现new
		// 了两个线程，一个线程的异常被catch，程序不会退出，有一个线程处于运行的状态，异常没有被catch
		// 推测是 ExceptionThread2 抛出的runtimeException 导致了executor的异常
		// service.shutdown();
	}
}
