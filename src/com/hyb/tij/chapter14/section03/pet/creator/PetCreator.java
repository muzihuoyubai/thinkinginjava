package com.hyb.tij.chapter14.section03.pet.creator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.hyb.tij.chapter14.section03.pet.pets.Pet;

public abstract class PetCreator {
	private Random rand = new Random(47);

	public abstract List<Class<? extends Pet>> types();

	public Pet randomPet() {
		int n = rand.nextInt(types().size());
		try {
			return types().get(n).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public Pet[] createArray(int size) {
		Pet[] rlt = new Pet[size];
		for (int i = 0; i < size; i++) {
			rlt[i] = randomPet();
		}
		return rlt;
	}

	public List<Pet> arrayList(int size) {
		List<Pet> rlt = new ArrayList<>();
		Collections.addAll(rlt, createArray(size));
		return rlt;
	}
}
