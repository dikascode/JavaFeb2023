package com.emmanuelu.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emmanuelu.models.Book;
import com.emmanuelu.models.User;
import com.emmanuelu.services.BookService;
import com.emmanuelu.services.UserService;

@Controller()
@RequestMapping("/books")
public class HomeController {
	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	// Return all books
	@GetMapping("/dashboard")
	public String returnAllBooks(Model model) {
		List<Book> listOfAllBooks = bookService.returnAllBooks();
		model.addAttribute("allBooks", listOfAllBooks);
		return "dashboard.jsp";
	}

	// Get a single book
	@GetMapping("/{id}")
	public String returnSingleBook(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "bookDetails.jsp";
	}

	// ------------Post using data binding----------------
	@GetMapping("/databinding/new")
	public String showDatabindingForm(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("writersList", userService.findAllUsers());

		return "databindingForm.jsp";
	}

	// Process Data binding form

	@PostMapping("/databinding/new")
	public String processDataBindingForm(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("writersList", userService.findAllUsers());
			return "databindingForm.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books/dashboard";
		}

	}

	// ------------EDIT using data binding----------------

	// Display Edit form
	@GetMapping("/binding/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Book bookFound = bookService.findBook(id);
		model.addAttribute("writersList", userService.findAllUsers());
		model.addAttribute("book", bookFound);
		return "editBindingBookForm.jsp";
	}

	// process edit form using data binding
	@PutMapping("/binding/edit/{id}")
	public String editBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {

		if (result.hasErrors()) {
			return "editBindingBookForm.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books/dashboard";
		}

	}

	// Delete a book and redirect to dash board
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookService.deleteById(id);
		return "redirect:/books/dashboard";
	}

	// --------- User Section--------------
	// Show user form
	@GetMapping("/users/new")
	public String showUserForm(Model model) {
		model.addAttribute("newUser", new User());
		return "userForm.jsp";
	}
	
	
	@GetMapping("/users")
	public String showAllUsers(Model model) {
		model.addAttribute("listOfUsers", userService.findAllUsers());
		return "allUsers.jsp";
	}

	@PostMapping("/users/new")
	public String createuser(@Valid @ModelAttribute("newUser") User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "userForm.jsp";
		}else {
			userService.createUser(user);
			return "redirect:/books/users";
		}
		
		
	}
	

}
