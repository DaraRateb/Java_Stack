package com.assignments.eventsbelt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignments.eventsbelt.models.Event;
import com.assignments.eventsbelt.models.Message;
import com.assignments.eventsbelt.repositories.EventRepository;
import com.assignments.eventsbelt.repositories.MessageRepository;

@Service
public class EventService {

	private final EventRepository eventRepository;
	private final MessageRepository messageRepository;
	
	

	public EventService(EventRepository eventRepository, MessageRepository messageRepository) {
		this.eventRepository = eventRepository;
		this.messageRepository = messageRepository;
	}

	public List<Event> allEvents() {
		return eventRepository.findAll();
	}
	
    public Event updateEvent(Event event) {
      	 return eventRepository.save(event);
   }


	public Event findById(Long id) {
		Optional<Event> event = eventRepository.findById(id);

		if (event.isPresent()) {
			return event.get();
		} else {
			return null;
		}
	}

	public Event createEvent(Event event) {
		return eventRepository.save(event);
	}
	public void deleteEvent(Long id) {
		eventRepository.deleteById(id);
	}
	public List<Event> findByState(String state) {
		return eventRepository.findByState(state);
	}

	public List<Event> findOtherStates(String state) {
		return eventRepository.findByStateNot(state);
	}
	
	
	public List<Message> allMessages() {
		return messageRepository.findAll();
	}
	
	public Message createMessage(Message message) {
		return messageRepository.save(message);
	}
}
