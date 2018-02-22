package com.hyb.tij.chapter14.section03.pet.creator;

import java.util.List;

import com.hyb.tij.chapter14.section03.pet.pets.Pet;

public class Pets {
	public static final PetCreator creator = new LiteralPetCreator();

	public static Pet randomPet() {
		return creator.randomPet();
	}

	public static Pet[] creatArray(int size) {
		return creator.createArray(size);
	}

	public static List<Pet> arrayList(int size) {
		return creator.arrayList(size);
	}

}
