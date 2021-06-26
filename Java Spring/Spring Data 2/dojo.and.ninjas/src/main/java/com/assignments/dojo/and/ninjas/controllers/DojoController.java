package com.assignments.dojo.and.ninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignments.dojo.and.ninjas.models.Dojo;
import com.assignments.dojo.and.ninjas.models.Ninja;
import com.assignments.dojo.and.ninjas.services.DojoService;
import com.assignments.dojo.and.ninjas.services.NinjaService;

@Controller
public class DojoController {

	private final DojoService dojoService;
	private final NinjaService ninjaService;

	

	public DojoController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}

	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newdojo.jsp";
	}

	@RequestMapping("/dojos/new/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "/newdojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String showNinjas(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		List<Ninja> ninjas = ninjaService.findDojoNinjas(dojo);
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninja", ninjas);
		return "details.jsp";
	}

}
