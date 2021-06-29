package com.assignments.eventsbelt.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assignments.eventsbelt.models.Event;
import com.assignments.eventsbelt.models.Message;
import com.assignments.eventsbelt.models.User;
import com.assignments.eventsbelt.services.EventService;
import com.assignments.eventsbelt.services.UserService;

@Controller
public class EventController {

	private final EventService eventService;
	private final UserService userService;

	public EventController(EventService eventService, UserService userService) {
		this.eventService = eventService;
		this.userService = userService;
	}

	@RequestMapping("/welcome")
	public String home(HttpSession session, Model model, @ModelAttribute("event") Event event) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}else {
		
		Long Id = (Long) session.getAttribute("userId");
		User user = userService.findUserById(Id);
		List<Event> eventstate = eventService.findByState(user.getState());
		List<Event> otherevents = eventService.findOtherStates(user.getState());
		model.addAttribute("user", user);
		model.addAttribute("events", eventstate);
		model.addAttribute("other", otherevents);
		return "welcome.jsp";
	}
	}

	@RequestMapping(value = "/event/create", method = RequestMethod.POST)
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result) {
		if (result.hasErrors()) {
			return "welcome.jsp";
		} else {
			eventService.createEvent(event);
			return "redirect:/welcome";
		}
	}

	@RequestMapping(value = "/events/join/{id}")
	public String addAttendee(@PathVariable("id") Long event_id, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}else {
		Long Id = (Long) session.getAttribute("userId");
		User user = userService.findUserById(Id);
		Event event = eventService.findById(event_id);
		List<User> attendees = event.getUsers();
		attendees.add(user);
		event.setUsers(attendees);
		eventService.updateEvent(event);
		return "redirect:/welcome";
	}
	}

	@RequestMapping(value = "/events/cancel/{id}")
	public String cancelAttendee(@PathVariable("id") Long event_id, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}else {
		Long Id = (Long) session.getAttribute("userId");
		User user = userService.findUserById(Id);
		Event event = eventService.findById(event_id);
		List<User> attendees = event.getUsers();
		attendees.remove(user);
		event.setUsers(attendees);
		eventService.updateEvent(event);
		return "redirect:/welcome";
	}
	}

	@RequestMapping("/events/{id}")
	public String showEvent(@PathVariable("id") Long id, HttpSession session, Model model,
			@Valid @ModelAttribute("message") Message message, BindingResult result) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}else {
		Long Id = (Long) session.getAttribute("userId");
		User user = userService.findUserById(Id);
		Event event = eventService.findById(id);
		model.addAttribute("user", user);
		model.addAttribute("event", event);
		return "event.jsp";
	}
	}
	
	@RequestMapping(value="/message/create", method=RequestMethod.POST)
	public String createMessage(@Valid @ModelAttribute("message") Message message, BindingResult result) {
		if (result.hasErrors()) {
			return "event.jsp";
		} else {
			eventService.createMessage(message);
			return "redirect:/events/"+message.getEvent().getId();
		}
	}
	
	@RequestMapping("/events/edit/{id}")
	public String editEvent(@PathVariable("id") Long id, Model model,HttpSession session) {
		Event event = eventService.findById(id);
		if (session.getAttribute("userId") != event.getHost() ){
			return "redirect:/welcome";
		}else {
		model.addAttribute("event", event);
		return "editevent.jsp";
		}
		
	}

	@RequestMapping(value = "/events/edit/{id}", method = RequestMethod.POST)
	public String updateEvent(@Valid @ModelAttribute("event") Event event, BindingResult result) {
		if (result.hasErrors()) {
			return "editevent.jsp";
		} else {
			eventService.updateEvent(event);
			return "redirect:/welcome";
		}
	}
	
	@RequestMapping("/events/delete/{id}")
	public String deleteEvent(@PathVariable("id") Long id,HttpSession session) {
		if (session.getAttribute("userId") != id) {
			return "redirect:/welcome";
		}else {
		eventService.deleteEvent(id);
    	return "redirect:/welcome";
	}
	}

}
