package com.assignments.code;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Code {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	

	@RequestMapping(value="/check",  method=RequestMethod.POST)
	 public String check(RedirectAttributes redirectAttributes , @RequestParam(value="code") String code) {
		if (code.equals("bushido")) { 
			 return "redirect:/code";
		}else {
			redirectAttributes.addFlashAttribute("error", "You must train harder!");
		return "redirect:/";}
		 
    
  }
			
	@RequestMapping("/code")
	public String code() {
		return "codes.jsp";
	}

}
