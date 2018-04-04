package com.hyb.tij.chapter21.section09.p01;

public class SynchronizationComarisions {
	static BaseLine baseLine = new BaseLine();
	static SynchronizedTest synch = new SynchronizedTest();
	static LockTest lock = new LockTest();
	static AtomicTest atomic = new AtomicTest();

	static void test() {
		System.out.println("==================");
		System.out.println(String.format("%-12s : %13d\n", "Cycles", Accumulator.cycles));
		baseLine.timedTest();
		synch.timedTest();
		lock.timedTest();
		// atomic.timedTest();
		Accumulator.report(synch, baseLine);
		Accumulator.report(lock, baseLine);
		// Accumulator.report(atomic, baseLine);
		Accumulator.report(synch, lock);
		// Accumulator.report(synch, atomic);
		// Accumulator.report(lock, atomic);
	}

	public static void main(String[] args) {
		int iterations = 5;
		baseLine.timedTest();
		for (int i = 0; i < iterations; i++) {
			test();
			Accumulator.cycles *= 2;
		}

		Accumulator.exec.shutdown();
	}
}
