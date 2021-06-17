package com.assignments.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller	
public class Counter {
	@RequestMapping("/")
	public String index(HttpSession session) {
		Integer count =(Integer)session.getAttribute("count");
		 if (count==null) {
			   session.setAttribute("count",0);
		   }
		   else { 
			   count++;
			   session.setAttribute("count", count);
		   }
		return "index.jsp";	
	}
	
	@RequestMapping("/counter")
	public String secondController() {
	
		return "counter.jsp";
	}


}
