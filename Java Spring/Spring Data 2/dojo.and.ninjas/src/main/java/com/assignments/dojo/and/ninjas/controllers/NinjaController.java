package com.assignments.dojo.and.ninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignments.dojo.and.ninjas.models.Dojo;
import com.assignments.dojo.and.ninjas.models.Ninja;
import com.assignments.dojo.and.ninjas.services.DojoService;
import com.assignments.dojo.and.ninjas.services.NinjaService;

public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;

	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}

	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojo", dojos);
		return "newninja.jsp";
	}

	@RequestMapping("/ninjas/new/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "/newninja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}

}
