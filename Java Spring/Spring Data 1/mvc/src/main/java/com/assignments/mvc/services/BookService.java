package com.assignments.mvc.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import java.util.List;

import com.assignments.mvc.models.Book;
import com.assignments.mvc.repositories.BookRepository;

@Service
public class BookService {

private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	   Optional<Book> optionalBook = bookRepository.findById(id);
    	   if (optionalBook.isPresent()) {
    		   Book update=optionalBook.get();
    		    update.setTitle(title);
    		    update.setDescription(desc);
    		    update.setLanguage(lang);
    		    update.setNumberOfPages(numOfPages);


    		return bookRepository.save(update);}
    		else {
    		    return null;
    		    }
    	   }
}
	
	


