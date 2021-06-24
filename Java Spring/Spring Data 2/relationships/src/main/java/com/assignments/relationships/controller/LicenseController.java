package com.assignments.relationships.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assignments.relationships.models.License;
import com.assignments.relationships.models.Person;
import com.assignments.relationships.services.LicenseService;
import com.assignments.relationships.services.PersonService;

@Controller
public class LicenseController {
	private final LicenseService licenseService;
	private final PersonService personService;

	public LicenseController(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}

	@RequestMapping("/licenses/new")
	public String index(@ModelAttribute("license") License license, Model model) {
		List<Person> persons = personService.unlicensePersons();
		model.addAttribute("person", persons);
		return ("relationships/license.jsp");
	}

	@RequestMapping(value = "/licenses/new/create", method = RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			return "relationships/license.jsp";
		} else {
			licenseService.createLicense(license);
			return "redirect:/persons/" + license.getId();
		}
	}

	@RequestMapping("/persons/{id}")
	public String details(Model model, @PathVariable("id") Long id) {
		License license = licenseService.findLicense(id);
		Person person = personService.findPerson(id);
		model.addAttribute("license", license);
		model.addAttribute("person",person);
		return ("relationships/details.jsp");
	}
}
