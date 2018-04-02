package com.hyb.tij.chapter21.section07.p07;

import java.util.List;
import java.util.concurrent.Exchanger;

import com.hyb.tij.chapter16.section06.Generator;

public class ExchangerProducer<T> implements Runnable {

	private Generator<T> generator;
	private Exchanger<List<T>> exchanger;
	private List<T> holder;

	ExchangerProducer(Exchanger<List<T>> exchg, Generator<T> gen, List<T> holder) {
		exchanger = exchg;
		generator = gen;
		this.holder = holder;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				for (int i = 0; i < ExchangerDemo.size; i++) {
					holder.add(generator.next());
				}
				System.out.println("Producer exchange holder before: " + holder);
				holder = exchanger.exchange(holder);
				System.out.println("Producer exchange holder : " + holder);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
