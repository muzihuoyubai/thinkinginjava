package com.hyb.tij.chapter14.section03.pet.creator;

import java.util.LinkedHashMap;
import java.util.Map;

import com.hyb.tij.chapter14.section03.pet.pets.Pet;

public class PetCount3 {
	@SuppressWarnings("serial")
	static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {
		public PetCounter() {
			for (Class<? extends Pet> one : LiteralPetCreator.allTypes) {
				put(one, 0);
			}
		}

		public void count(Pet pet) {
			for (Map.Entry<Class<? extends Pet>, Integer> one : entrySet()) {
				if (one.getKey().isInstance(pet)) {
					put(one.getKey(), one.getValue() + 1);
				}
			}
		}
		
		public String toString() {
			StringBuilder result = new StringBuilder("{");
			for (Map.Entry<Class<? extends Pet>, Integer> one : entrySet()) {
				result.append(one.getKey().getSimpleName());
				result.append("=");
				result.append(one.getValue());
				result.append(",");
			}
			result.deleteCharAt(result.length() - 1);
			result.append("}");
			
			return result.toString();
		}
	}
	
	public static void main(String[] args) {
		PetCounter petCount = new PetCounter();
		for(Pet pet : Pets.creatArray(20)) {
			System.out.println(pet.getClass().getSimpleName());
			petCount.count(pet);
		}
		System.out.println(petCount);
	}
}
