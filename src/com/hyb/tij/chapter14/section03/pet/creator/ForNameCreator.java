package com.hyb.tij.chapter14.section03.pet.creator;

import java.util.ArrayList;
import java.util.List;

import com.hyb.tij.chapter14.section03.pet.pets.Pet;

public class ForNameCreator extends PetCreator {

	@SuppressWarnings("unchecked")
	@Override
	public List<Class<? extends Pet>> types() {
		List<Class<? extends Pet>> rlt = new ArrayList<>();
		String[] typeNames = { "com.hyb.tij.chapter14.section03.pet.pets.Mutt",
				"com.hyb.tij.chapter14.section03.pet.pets.Pug",
				"com.hyb.tij.chapter14.section03.pet.pets.EgyptianMau",
				"com.hyb.tij.chapter14.section03.pet.pets.Manx",
				"com.hyb.tij.chapter14.section03.pet.pets.Cymric",
				"com.hyb.tij.chapter14.section03.pet.pets.Rat",
				"com.hyb.tij.chapter14.section03.pet.pets.Mouse",
				"com.hyb.tij.chapter14.section03.pet.pets.Hamster", };
		for (String one : typeNames) {
			try {
				rlt.add((Class<? extends Pet>) Class.forName(one));
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}

		return rlt;
	}

}
