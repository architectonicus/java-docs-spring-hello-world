package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DemoApplicationTest {

	@Test
	void test() {
		String r = new DemoApplication().doCheck("asbc", "eddie|green");
		System.out.println(r);
		
		String r2 = new DemoApplication().doCheck("eddie:green", "eddie|green,joschi|white");
		System.out.println(r2);
		
	}

}
