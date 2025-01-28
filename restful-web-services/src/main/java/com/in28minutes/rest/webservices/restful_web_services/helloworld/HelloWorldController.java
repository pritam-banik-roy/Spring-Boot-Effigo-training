package com.in28minutes.rest.webservices.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController {
	
	//hello-world
	
	//
	public String helloWorld() {
		return "Hello World";
	}

}
