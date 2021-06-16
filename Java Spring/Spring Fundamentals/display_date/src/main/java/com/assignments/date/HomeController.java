package com.assignments.date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		SimpleDateFormat formatteddate = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMMM ',' yyyy");
        model.addAttribute("date", formatteddate.format(date));
        return "date.jsp";
		
	}

	@RequestMapping("/time")
	public String time(Model model) {
		Date time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
        model.addAttribute("time", dateFormat.format(time));
        return "time.jsp";
		
	}
	
	
	
}
