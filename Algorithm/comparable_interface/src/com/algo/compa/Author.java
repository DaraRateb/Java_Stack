package com.algo.compa;
//import java.util.Collections;
//import java.util.ArrayList;




public class Author implements Comparable<Author> {

	  String firstname;
	  String lastname;
	  String bookname;
	  
	  public Author (String firstname, String lastname, String bookname) {
		  this.firstname=firstname;
		  this.lastname=lastname;
		  this.bookname=bookname;
		  
	  }
	  @Override
	  public int compareTo(Author other) {
	      return this.firstname.compareTo(other.firstname);
	  }

}
