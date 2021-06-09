package com.example.rand.RandJunitTests.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rand.RandJunitTests.model.Rand;

@RestController
public class RandController {

	@GetMapping("/random")
	public Rand rand(@RequestParam(value = "bound", defaultValue="100") String bound,
			@RequestParam(value = "size", defaultValue="50") String size,
			@RequestParam(value = "origin", defaultValue="0") String origin,
			@RequestParam(value = "secure", defaultValue="false") String secure) {
		return secure.equals("true") ?
				new Rand(new java.security.SecureRandom(), size, origin, bound):
				new Rand(new java.util.Random(), size, origin, bound);
	}
}
