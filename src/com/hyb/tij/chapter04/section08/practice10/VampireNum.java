package com.hyb.tij.chapter04.section08.practice10;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class VampireNum {

	@Test
	public void outputVampireNum() {
		Set<VampirePair> rlt = new HashSet<>();
		
		for (int i = 10; i <= 99; i++) {

			check: for (int j = 10; j <= 99; j++) {
				int mul = i * j;
				if (mul > 9999) {
					return;
				}

				String mulStr = mul + "";
				String iStr = i + "";
				String jStr = j + "";

				for (int m = 0; m < iStr.length(); m++) {
					if (mulStr.contains(iStr.charAt(m) + "")) {
						mulStr = mulStr.replaceFirst(iStr.charAt(m) + "", "");
					} else {
						continue check;
					}
				}
				for (int m = 0; m < jStr.length(); m++) {
					if (mulStr.contains(jStr.charAt(m) + "")) {
						mulStr = mulStr.replaceFirst(jStr.charAt(m) + "", "");
					} else {
						continue check;
					}
				}
				VampirePair pair = new VampirePair(i, j);
				rlt.add(pair);
			}
		}
		
		System.out.println(rlt.toString());
	}

}
