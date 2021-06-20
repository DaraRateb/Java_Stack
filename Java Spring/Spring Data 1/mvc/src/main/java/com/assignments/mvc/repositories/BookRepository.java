package com.assignments.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignments.mvc.models.Book;

import java.util.List;




@Repository
public interface BookRepository extends CrudRepository <Book, Long>{
	  List<Book> findAll();

	    List<Book> findByDescriptionContaining(String search);
	    Long countByTitleContaining(String search);
	    Long deleteByTitleStartingWith(String search);
}
