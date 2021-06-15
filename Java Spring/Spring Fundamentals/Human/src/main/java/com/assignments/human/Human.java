package com.assignments.human;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Human {


@RequestMapping(value="/")
public String returnHello(@RequestParam(value="someone",required=false)String name) {
	if(name != null) {
		return "<h1>Hello " + name + " ! </h1>"+"welcome to Spring Boot";
	}else {
		return "<h1>Hello Human!</h1>" +"welcome to Spring Boot";
}
	
}
}
