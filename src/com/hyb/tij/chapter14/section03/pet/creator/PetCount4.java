package com.hyb.tij.chapter14.section03.pet.creator;

import com.hyb.tij.chapter14.section03.pet.pets.Pet;

public class PetCount4 {

	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Pet.class);
		for(Pet one : Pets.creatArray(20)) {
			System.out.println(one.getClass().getSimpleName());
			counter.count(one);
		}
		
		System.out.println(counter);
	}

}
