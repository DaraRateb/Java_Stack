package com.assignments.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignments.relationships.models.License;
import com.assignments.relationships.models.Person;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
	List<License> findAll();
	
}
