package com.emmanuelu.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuelu.models.Book;
import com.emmanuelu.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    
    @Autowired
    private BookRepository bookRepo;
    
    
    public List<Book> returnAllBooks() {
    	return bookRepo.findAll();
    }
    
    public Book createBook(Book book) {
    	return bookRepo.save(book);
    }
    
    //Retrieve a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
       if(optionalBook.isPresent()) {
    	   return optionalBook.get();
       }else {
    	   return null;
       }
    }
    
    
    //Delete book
    public void deleteBook(Book bookToDelete) {
    	bookRepo.delete(bookToDelete);
    }
    
    
    //Delete book by id
    public void deleteById(Long id) {
    	bookRepo.deleteById(id);
    }
    

}
