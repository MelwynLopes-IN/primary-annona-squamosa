package com.example.rand.RandJunitTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class SecureRandomTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturnSecureRandomArray() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/random?secure=true")
					.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$numArray").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$numArray.length()").value(50));
	}
}
