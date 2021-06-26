package com.assignments.dojo.and.ninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignments.dojo.and.ninjas.models.Dojo;
import com.assignments.dojo.and.ninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
	List<Ninja> findByDojo(Dojo dojo);
}
