package com.example.rand.RandJunitTests.model;

import java.util.Random;

public class Rand {
	private int[] numArray;
	Random random;
	
	public Rand(Random random, String size, String origin, String bound) {
		this.random = random;
		randGen(size, origin, bound);
	}
	
	public Rand() {
		
	}
	
	public int[] getnumArray() {
		return numArray;
	}
	
	public void setNumArray(int[] numArray) {
		this.numArray = numArray;
	}
	
	public void randGen(String sSize, String sOrigin, String sBound) {
		try {
			long size = Long.parseLong(sSize);
			if (size > 1000) size = 1000;
			int origin = Integer.parseInt(sOrigin);
			int bound = Integer.parseInt(sBound);
			numArray = random.ints(size, origin, bound).toArray();
		} catch(Exception e) {
			numArray = new int[0];
		}
		return;
	}
	
	public void setRandom(Random random) {
		this.random = random;
	}
}
