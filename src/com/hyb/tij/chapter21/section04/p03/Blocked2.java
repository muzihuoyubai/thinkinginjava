package com.hyb.tij.chapter21.section04.p03;

public class Blocked2 implements Runnable {

	// 构造方法中 lock了，因此线程调用blocked对象的方法将会阻塞等待锁释放
	BlockedMutex blocked = new BlockedMutex();

	@Override
	public void run() {
		System.out.println("Waiting for f() in BlockedMutex");
		// 这样也会被阻塞，说明属性声明获取的锁，在run方法中不可用
		blocked.f();
		System.out.println("Broken out of blocked call");
	}

	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new Blocked2());
		t.start();
		// 打断未释放的锁？？ TODO
		// t.interrupt();
	}
}
