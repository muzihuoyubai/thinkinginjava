package com.hyb.tij.chapter11.section11;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		Random rand = new Random(47);
		for (int i = 0; i < 10; i++) {
			priorityQueue.offer(rand.nextInt(i + 10));
		}
		System.out.println(priorityQueue.toString());
		printQ(priorityQueue);

		List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 26);
		priorityQueue = new PriorityQueue<>(ints);
		System.out.println(priorityQueue.toString());
		printQ(priorityQueue);
		priorityQueue = new PriorityQueue<>(ints.size(), Collections.reverseOrder());
		priorityQueue.addAll(ints);
		System.out.println(priorityQueue.toString());
		printQ(priorityQueue);	
		
		String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
		List<String> strings = Arrays.asList(fact.split(""));
		PriorityQueue<String> stringPQ = new PriorityQueue<>(strings);
		System.out.println(stringPQ.toString());
		printQ(stringPQ);	
		
		stringPQ = new PriorityQueue<>(strings.size(), Collections.reverseOrder());
		stringPQ.addAll(strings);
		
		System.out.println(stringPQ.toString());
		printQ(stringPQ);	
		
		Set<Character> charSet = new HashSet<>();
		for(char c:fact.toCharArray()) {
			charSet.add(c);
		}
		PriorityQueue<Character> characterQueue = new PriorityQueue<>(charSet);
		printQ(characterQueue);	
		
	}
	
	private static void printQ(Queue<?> q) {
		while(q.peek()!=null) {
			System.out.print(q.poll() + " ");
		}
		System.out.println();
	}
}
