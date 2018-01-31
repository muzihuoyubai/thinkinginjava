package com.hyb.tij.chapter04.section08.practice10;

public class VampirePair {
	int num1;
	int num2;

	VampirePair(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	@Override
	public int hashCode() {
		return this.num1 * this.num2;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VampirePair other = (VampirePair) obj;
		if ((num1 != other.num2 && num2 != other.num1) || (num1 != other.num1 && num2 != other.num2))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "VampirePair [num1=" + num1 + ", num2=" + num2 + ", mul:" + (num1 * num2) + "]\n";
	}

}
