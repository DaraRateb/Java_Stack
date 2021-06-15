package com.assignments.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class DojoController {
	public static void main(String[] args) {
		SpringApplication.run(CodingController.class, args);
	}


	
@RequestMapping("/{dojo}")
public String hello(@PathVariable("dojo") String name) {
	return "the " +name + " is awsome!";
}
@RequestMapping("/burbank-dojo")	
public String dojo() {
	return "Burbank Dojo is located in Southern California";
}
	
@RequestMapping("/san-jose")	
public String san() {
	return "SJ dojo is the headquarters";
}
}
	
	








