package com.assignments.relationships.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assignments.relationships.models.Person;
import com.assignments.relationships.services.PersonService;

@Controller
public class PersonController {
	private final PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping("/persons/new")
	public String index(@ModelAttribute("person") Person person) {
		return ("relationships/person.jsp");
	}

	@RequestMapping(value = "/persons/new/create", method = RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "relationships/person.jsp";
		} else {
			personService.createPerson(person);
			return "redirect:/persons/new";
		}
	}
}
