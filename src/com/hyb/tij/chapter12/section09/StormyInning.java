package com.hyb.tij.chapter12.section09;

public class StormyInning extends Inning implements Storm {

	// 子类构造器必须抛出父类构造器中约定的异常
	// 子类构造器可以抛出额外的异常
	public StormyInning() throws BaseballException, RainedOut {
	}

	// 子类构造器初始化前必须初始化父类构造器，因此必须处理父类构造器的异常
	public StormyInning(String s) throws BaseballException {
		// 子类初始化时默认调用父类无参的构造器，可以强制调用带参数的构造器
		// super(s); 如果父类对应的构造器没有异常抛出，子类构造器可以不抛异常
	}

	// 子类覆写的方法可以抛出父类方法约定的异常的子类
	@Override
	public void rainHard() throws RainedOut {

	}

	// 子类覆写的方法可以抛出父类方法约定的异常的子类
	@Override
	public void atBat() throws PopFoul {

	}

	// 不能够抛出任何异常，因为父类 要抛BaseballException，接口要抛RainedOut
	// 继承或实现的方法抛出的异常必须是父类异常或其异常的子类
	// 可以不抛异常
	public void event() {

	}

}
