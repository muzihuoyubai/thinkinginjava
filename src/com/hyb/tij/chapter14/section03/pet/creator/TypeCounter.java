package com.hyb.tij.chapter14.section03.pet.creator;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class TypeCounter extends LinkedHashMap<Class<?>, Integer> {
	private Class<?> baseType;

	public TypeCounter(Class<?> baseType) {
		this.baseType = baseType;
	}

	public void count(Object obj) {
		Class<?> type = obj.getClass();
		if (!baseType.isAssignableFrom(type)) {
			throw new RuntimeException(String.format("%s incorrect type: %s , should be type  or subtype of %s",
					obj.toString(), type.toString(), baseType.toString()));
		}
		countClass(type);
	}

	private void countClass(Class<?> type) {
		Integer quantity = get(type);
		put(type, quantity == null ? 1 : quantity + 1);
		Class<?> superClass = type.getSuperclass();
		if (superClass != null && baseType.isAssignableFrom(superClass)) {
			countClass(superClass);
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder("{");
		for (Map.Entry<Class<?>, Integer> pair : entrySet()) {
			result.append(pair.getKey().getSimpleName());
			result.append("=");
			result.append(pair.getValue());
			result.append(",");
		}
		result.deleteCharAt(result.length() - 1);

		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(TypeCounter.class.isAssignableFrom(LinkedHashMap.class));
		System.out.println(TypeCounter.class.isAssignableFrom(TypeCounter.class));
		System.out.println(LinkedHashMap.class.isAssignableFrom(TypeCounter.class));
	}
}
