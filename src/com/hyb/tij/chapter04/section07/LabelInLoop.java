package com.hyb.tij.chapter04.section07;

import org.junit.Test;

public class LabelInLoop {

	@Test
	public void LabelTest() {
		//跳转标签只能跳转嵌套循环中的标签
		outer: for (int i = 1; i < 20; i++) {
			System.out.println(i);
			while (true) {
				System.out.println("inner");
				if (i % 2 == 0) {
					// 退出标签处的循环
					break outer;
				} else {
					// 从标签处的循环继续
					continue outer;
				}
			}
		}
	}

}
