package com.example.demo;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		return "[ {\"id\": 1, \"name\": \"Eddie\", \"age\": 1.9, \"transportStatus\": \"IN_TRANSIT\" }, "
				+ "{\"id\": 2, \"name\": \"Joschi\", \"age\": 12, \"transportStatus\": \"IN_CAT_HEAVEN\"} ]";
	}
	
	@RequestMapping(value = "/echo", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_XHTML_XML_VALUE)
	String echo( @RequestHeader(required = false) Map<String, String> headers, 
			@RequestBody(required = false) String body) {
		
		
		StringBuffer sb = new StringBuffer();
		sb.append("---");
	    headers.forEach((key, value) -> {
	        sb.append(String.format("%s: %s", key, value));
	        sb.append("\n");
	    });
	    sb.append("\n");
	    sb.append(body);
	    sb.append("\n");
	    sb.append("---");
	    
		return sb.toString();
			
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	String getProp(@RequestHeader(name = "Authorization", required = false) String authHeader) {
		
		final String input = System.getenv("DAMAP");
		String decoded = new String(Base64.getDecoder().decode(authHeader));
		return doCheck(decoded, input);
			
	}
	
	String doCheck(String authHeader, String mapString) {
		
		final Map<String, String> map = new HashMap<>();
		Boolean v = Boolean.FALSE;
		if( authHeader == null || mapString == null ) {
			
		} else {
			for(String kv : mapString.split(",")) {
				String[] s = kv.split("\\|");
				map.put(s[0], s[1]);
			}
			String[] u = authHeader.split(":");
			v = map.containsKey(u[0]) && map.get(u[0]) != null;
		}
		
		
		
				
		return "{\"value\": \""+v.toString()+"\"}";
		
	}
	
	
}
