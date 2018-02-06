package com.hyb.tij.chapter09.section08;

public class NestingInterfaces {
	public class BImp implements A.B{
		public void f() {
			
		}
	}
	
	class CImp implements A.C {
		public void f() {
			
		}
	}
	//不能实现类中的私有接口
	// class Dimp implements A.D {
	// public void f() {
	//
	// }
	// }
	
	class EImp implements E{
		public void g() {
			
		}
	}
	
	class EGImp implements E.G{
		public void f() {
			
		}
	}
	
	class EImp2 implements E{
		public void g() {
			
		}
		class EG implements E.G{
			public void f() {
				
			}
		}
	}
	
	public static void main(String[] args) {
		A a = new A();
		A.DImp2 adimp = new A().new DImp2();
		//a.getD返回 private D
		//无法调用私有接口的方法
		//a.getD().f();
		//无法引用A.D
		//A.D ad = a.getD();
		A.DImp2 di2 = (A.DImp2) a.getD();
		a.receiveD(a.getD());
	}
}
