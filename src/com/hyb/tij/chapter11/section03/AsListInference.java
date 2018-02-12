package com.hyb.tij.chapter11.section03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unused")
public class AsListInference {

	static class Snow {
	}

	static class Powder extends Snow {

	}

	static class Light extends Powder {

	}

	static class Heavy extends Powder {

	}

	static class Crusty extends Snow {

	}

	static class Slush extends Snow {

	}

	public static void main(String[] args) {
		List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder());
		//猜测新版本jdk中asList已经可以正确识别，子类，子类的子类型
		List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());
		List<Snow> snow3 = new ArrayList<>();
		Collections.addAll(snow3, new Light(), new Heavy());
		//显式类型参数说明
		List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy());
	}

}
