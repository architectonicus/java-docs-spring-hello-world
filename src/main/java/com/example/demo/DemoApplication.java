package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	String sayHello() {
		return "miau!";
	}
	
	@RequestMapping(value = "/cats", method = RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON_VALUE)
	String getCats() {
		return "[ {\"id\": 1, \"name\": \"Eddie\", \"age\": 1.8, \"transportStatus\": \"IN_TRANSIT\" }, "
				+ "{\"id\": 2, \"name\": \"Joschi\", \"age\": 12} \"transportStatus\\\": \"IN_CAT_HEAVEN\" ]";
	}
	
}
