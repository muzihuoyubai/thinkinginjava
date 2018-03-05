package com.hyb.tij.chapter15.section04.p01;

import java.util.List;
import java.util.Map;

import com.hyb.tij.chapter14.section03.pet.pets.Pet;

public class LimitsOfInference {
	static void f(Map<Pet,List<? extends Pet>> petPeople) {
		
	}
	
	public static void main(String[] args) {
		f(New.map());
		f(New.<Pet,List<? extends Pet>>map());
	}
}
