package com.assignments.queriesandjoins.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Country extends CrudRepository<Country, Long> {

}
