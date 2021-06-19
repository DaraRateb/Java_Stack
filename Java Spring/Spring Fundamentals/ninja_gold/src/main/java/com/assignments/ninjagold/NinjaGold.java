package com.assignments.ninjagold;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class NinjaGold {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	ArrayList<String> myArray = new ArrayList<String>();
	@RequestMapping(value="/process_money", method=RequestMethod.POST)
	public String process(HttpSession session,@RequestParam(value="place") String place) {
		Random r = new Random();
		Date date = new Date();
		SimpleDateFormat formatteddate = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMMM ',' yyyy");
		
		
		int x = 0;
		
		Integer gold =(Integer)session.getAttribute("score");
		 if (gold==null) {
			   session.setAttribute("score",0);
			   session.setAttribute("activites",null);
		   }
		
		if (place.equals("farm")){
			x= (Integer)r.nextInt(20-10)+10;
			myArray.add("You  entered a farm and earned "+ x +" "+"gold. "+ "(" +formatteddate.format(date) + ")");
		}
		else if (place.equals("cave")){
			x= (Integer)r.nextInt(10-5)+5;
			myArray.add("You  entered a cave and earned "+ x +" "+"gold. "+ "(" +formatteddate.format(date) + ")");
		}
		else if (place.equals("house")){
			x= (Integer)r.nextInt(5-2)+2;
			myArray.add("You  entered a house and earned "+ x +" "+"gold. "+ "(" +formatteddate.format(date) + ")");
		}
		else if (place.equals("casino")){
			x= (Integer)r.nextInt(50 + 50) - 50;
			 if (x>0) {
				 myArray.add("You  entered a casino and earned "+ x +" "+"gold. "+ "(" +formatteddate.format(date) + ")");
			 }else
				 myArray.add("You entered a casino and lost "+Math.abs(x) +" "+"Ouch " + "(" +formatteddate.format(date) + ")");
		}
		
            
		session.setAttribute("score",(Integer)session.getAttribute("score")+x);
		session.setAttribute("activites",myArray);
		
		
		
		return "redirect:/";
	}
}
