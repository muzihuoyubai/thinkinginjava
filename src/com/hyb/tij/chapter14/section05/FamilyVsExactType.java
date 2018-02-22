package com.hyb.tij.chapter14.section05;

public class FamilyVsExactType {

	public static void main(String[] args) {
		Base base = new Base();
		Derived derived = new Derived();
		System.out.println("BaseObj instanceof BaseClass " + (base instanceof Base));
		System.out.println("BaseObj instanceof DerivedClass " + (base instanceof Derived));
		System.out.println("DerivedObj instanceof BaseClass " + (derived instanceof Base));
		System.out.println("DerivedObj instanceof DerivedClass " + (derived instanceof Derived));
		System.out.println("Base.isInstance(BaseObj) " + Base.class.isInstance(base));
		System.out.println("Derived.isInstance(BaseObj) " + Derived.class.isInstance(base));
		System.out.println("Base.isInstance(DerivedObj) " + Base.class.isInstance(derived));
		System.out.println("Derived.isInstance(DerivedObj) " + Derived.class.isInstance(derived));
		System.out.println("BaseObj.getClass()==Base.class " + (base.getClass() == Base.class));
		System.out.println("BaseObj.getClass()==Derived.class " + (base.getClass() == Derived.class));
		//Incompatible operand types Class<capture#3-of ? extends Derived> and Class<Base>
		//System.out.println("DerivedObj.getClass()==Base.class " + (derived.getClass() == Base.class));
		System.out.println("DerivedObj.getClass()==Base.class " + "Incompatible operand types Class<capture#3-of ? extends Derived> and Class<Base>");
		System.out.println("DerivedObj.getClass()==Derived.class " + (derived.getClass() == Derived.class));
		
		System.out.println("BaseObj.getClass().equals(Base.class) " + (base.getClass().equals(Base.class)));
		System.out.println("BaseObj.getClass().equals(Derived.class) " + (base.getClass().equals(Derived.class)));
		System.out.println("DerivedObj.getClass().equals(Base.class) " + (derived.getClass().equals(Base.class)));
		System.out.println("DerivedObj.getClass().equals(Derived.class) " + (derived.getClass().equals(Derived.class)));
	}
}
