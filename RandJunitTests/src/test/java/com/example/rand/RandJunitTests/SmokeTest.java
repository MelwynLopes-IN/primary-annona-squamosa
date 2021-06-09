package com.example.rand.RandJunitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.rand.RandJunitTests.controller.RandController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private RandController controller;
	
	@Test
	public void contextLoads() throws Exception {
		assertEquals(controller.getClass(), RandController.class);
	}
}
