package com.hyb.tij.chapter14.section03.pet.creator;

import java.util.HashMap;

import com.hyb.tij.chapter14.section03.pet.pets.Cat;
import com.hyb.tij.chapter14.section03.pet.pets.Cymric;
import com.hyb.tij.chapter14.section03.pet.pets.Dog;
import com.hyb.tij.chapter14.section03.pet.pets.EgyptianMau;
import com.hyb.tij.chapter14.section03.pet.pets.Hamster;
import com.hyb.tij.chapter14.section03.pet.pets.Manx;
import com.hyb.tij.chapter14.section03.pet.pets.Mouse;
import com.hyb.tij.chapter14.section03.pet.pets.Mutt;
import com.hyb.tij.chapter14.section03.pet.pets.Pet;
import com.hyb.tij.chapter14.section03.pet.pets.Pug;
import com.hyb.tij.chapter14.section03.pet.pets.Rat;
import com.hyb.tij.chapter14.section03.pet.pets.Rodent;

public class PetCount {
	@SuppressWarnings("serial")
	static class PetCounter extends HashMap<String, Integer> {
		public void count(String type) {
			Integer quantity = get(type);
			if (quantity == null) {
				put(type, 1);
			} else {
				put(type, quantity + 1);
			}
		}
	}
	
	public static void countPets(PetCreator creator) {
		PetCounter counter = new PetCounter();
		for (Pet pet : creator.createArray(20)) {
			System.out.println(pet.getClass().getSimpleName());
			if (pet instanceof Pet) {
				counter.count("Pet");
			}
			if (pet instanceof Dog) {
				counter.count("Dog");
			}
			if (pet instanceof Mutt) {
				counter.count("Mutt");
			}
			if (pet instanceof Pug) {
				counter.count("Pug");
			}
			if (pet instanceof Cat) {
				counter.count("Cat");
			}
			if (pet instanceof EgyptianMau) {
				counter.count("EgyptianMau");
			}
			if (pet instanceof Manx) {
				counter.count("Manx");
			}
			if (pet instanceof Cymric) {
				counter.count("Cymric");
			}
			if (pet instanceof Rodent) {
				counter.count("Rodent");
			}
			if (pet instanceof Rat) {
				counter.count("Rat");
			}
			if (pet instanceof Mouse) {
				counter.count("Mouse");
			}
			if (pet instanceof Hamster) {
				counter.count("Hamster");
			}
		}
		System.out.println(counter);
	}
	
	
	public static void main(String[] args) {
		countPets(new ForNameCreator());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
