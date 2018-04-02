package com.hyb.tij.chapter21.section07.p07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ExchangerConsumer<T> implements Runnable {

	private Exchanger<List<T>> exchanger;
	private List<T> holder;
	private volatile T value;

	ExchangerConsumer(Exchanger<List<T>> ex, List<T> holder) {
		exchanger = ex;
		this.holder = holder;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("ExchangerConsumer exchange holder before:" + holder);
				holder = exchanger.exchange(holder);
				System.out.println("ExchangerConsumer exchange holder:" + holder);
				for (T x : holder) {
					value = x;
					// CopyOnWriteArrayList 可以在循环里处理
					holder.remove(x);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Final value: " + value);
	}

	public static void main(String[] args) {
		List<String> l1 = new ArrayList<>();
		List<String> l2 = new CopyOnWriteArrayList<>();
		List<String> l3 = new ArrayList<>();

		l1.add("0");
		l1.add("1");
		l1.add("2");
		l1.add("3");
		l1.add("4");
		l2.addAll(l1);
		l3.addAll(l1);

		for (int i = 0; i < l1.size(); i++) {
			if ((i + 1) % 2 == 0) {
				l1.remove(i);
			}
		}
		//刪除有问题，因为删除一个元素后数组索引变了
		//[0, 2, 3]
		System.out.println(l1);

		// for (int i = 0; i < l2.size(); i++) {
		// if ((i + 1) % 2 == 0) {
		// l2.remove(i);
		// }
		// }

		// java.util.ConcurrentModificationException
		// for (String one : l1) {
		// l1.remove(one);
		// }

		//CopyOnWriteArrayList 可以使用
		for (String one : l2) {
			l2.remove(one);
		}
		System.out.println(l2);

		Iterator<String> iter = l3.iterator();
		int count = 0;
		while (iter.hasNext()) {
			iter.next();
			count++;
			if (count % 2 == 0) {
				iter.remove();
			}
		}
		//[0, 2, 4]
		System.out.println(l3);

	}
}
