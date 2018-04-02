package com.hyb.tij.chapter21.section07.p07;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.hyb.tij.chapter16.section06.BasicGenerator;
import com.hyb.tij.chapter21.section07.p06.Fat;

public class ExchangerDemo {
	static int size = 10;
	static int delay  = 5;
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		Exchanger<List<Fat>> xc = new Exchanger<>();
		List<Fat> producerList = new CopyOnWriteArrayList<>();
		List<Fat> consumerList = new CopyOnWriteArrayList<>();
		exec.execute(new ExchangerProducer<Fat>(xc, BasicGenerator.create(Fat.class), producerList));
		exec.execute(new ExchangerConsumer<Fat>(xc, consumerList));
		TimeUnit.SECONDS.sleep(delay);
		exec.shutdownNow();
	}
}
