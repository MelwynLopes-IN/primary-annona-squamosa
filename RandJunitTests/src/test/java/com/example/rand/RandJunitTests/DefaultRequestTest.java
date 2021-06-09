package com.example.rand.RandJunitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.example.rand.RandJunitTests.model.Rand;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DefaultRequestTest {
	@LocalServerPort
	private int localPort;
	
	@Autowired
	private TestRestTemplate testTemplate;
	
	@Test
	public void badparamShouldReturnZeroArrayLength() throws Exception {
		String rawJson = this.testTemplate.getForObject("http://localhost:" + 
				localPort + "/random?size=foo&origin=1&bound=1000", String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		Rand rand = mapper.readValue(rawJson, Rand.class);
		
		assertEquals(rand.getnumArray().length, 0);
	}
}
