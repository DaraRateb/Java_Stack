package com.assignments.eventsbelt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignments.eventsbelt.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	List<Event> findAll();
	List<Event> findByState(String State);
	List<Event> findByStateNot(String State);
}
