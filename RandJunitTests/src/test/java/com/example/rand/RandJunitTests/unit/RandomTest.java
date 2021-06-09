package com.example.rand.RandJunitTests.unit;

import org.junit.jupiter.api.Test;

import com.example.rand.RandJunitTests.model.Rand;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeAll;

public class RandomTest {

	private static Rand rand;
	
	@BeforeAll
	static void setup() {
		rand = new Rand();
	}
	
	@Test 
	void getSetTest() {
		int[] expected = {0,1,2,3,4};
		rand.setNumArray(expected);
		int[] actual = rand.getnumArray();
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void lengthTest() {
		rand.setRandom(new java.util.Random());
		for(int i = 0; i < 100; i++) {
			String size = "" + i;
			String origin = "1";
			String bound = "100";
			rand.randGen(size, origin, bound);
			Assertions.assertEquals(i, rand.getnumArray().length);
		}
	}
}
