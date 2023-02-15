package com.emmanuelu.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emmanuelu.models.Book;
import com.emmanuelu.services.BookService;

@RestController()
@RequestMapping("/api")
public class APIController {

	private final BookService bookService;

	public APIController(BookService bookService) {
		this.bookService = bookService;
	}

//  @Autowired
//  private BookService bookService;

	
	//Post route
	@PostMapping("/books")
	public Book create(@RequestParam(value = "title") String title, @RequestParam(value = "description") String desc,
			@RequestParam(value = "language") String lang, @RequestParam(value = "pages") Integer numOfPages) {
		
		Book book = new Book(title, desc, lang, numOfPages);
		return bookService.createBook(book);
	}

	//Returning all books
	@GetMapping("books")
	public List<Book> index() {
		return bookService.returnAllBooks();
	}

	//get just one book
	@RequestMapping("/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}
	
	
	//Update a book present in the database
	@PutMapping("/books")
	public Book updateBook(@RequestParam(value="id") Long id, @RequestParam(value = "title") String title, @RequestParam(value = "description") String desc,
			@RequestParam(value = "language") String lang, @RequestParam(value = "pages") Integer numOfPages) {
		
		//Firstly get the book you need to update
		Book bookToUpdate = bookService.findBook(id);
		
		bookToUpdate.setLanguage(lang);
		bookToUpdate.setTitle(title);
		bookToUpdate.setNumberOfPages(numOfPages);
		bookToUpdate.setDescription(desc);

		return bookService.createBook(bookToUpdate);
	}
	
	//Delete book method
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") Long id) {
		Book bookToDelete = bookService.findBook(id);
		bookService.deleteBook(bookToDelete);
	}

}
