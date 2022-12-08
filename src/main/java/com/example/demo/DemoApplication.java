package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	String sayHello() {
		return "Hack-a-cat!";
	}
	
	@RequestMapping(value = "/cats", method = RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON_VALUE)
	String getCats() {
		return "[ {\"id\": 1, \"name\": \"Eddie\", \"age\": 1.8}, {\"id\": 2, \"name\": \"Joschi\", \"age\": 12} ]";
	}
	
}
