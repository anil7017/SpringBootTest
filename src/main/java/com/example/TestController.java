package com.example;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/")
	public String test() {

		return "ffrom Spring Bott application : " + LocalDateTime.now();
	}
	
	@GetMapping("/test")
	public String test1() {

		return "ffrom Spring Bott application : " + LocalDateTime.now();
	}
}
