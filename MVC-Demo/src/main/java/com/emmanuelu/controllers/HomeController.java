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
import org.springframework.web.bind.annotation.RequestParam;

import com.emmanuelu.models.Book;
import com.emmanuelu.models.User;
import com.emmanuelu.services.BookService;
import com.emmanuelu.services.UserService;

@Controller
@RequestMapping("/books")
public class HomeController {

//service dependency
	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;

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

	// Post without data binding
	// Show the form page
	@GetMapping("/new")
	public String showBookForm() {
		return "bookForm.jsp";
	}

	// Process the form, and redirect
	@PostMapping("/new")
	public String create(@RequestParam(value = "title") String title, @RequestParam(value = "description") String desc,
			@RequestParam(value = "language") String lang, @RequestParam(value = "pages") Integer numOfPages) {

		Book book = new Book(title, desc, lang, numOfPages);
		bookService.createBook(book);
		return "redirect:/books/dashboard";
	}

	// ------------Post using data binding----------------
	@GetMapping("/databinding/new")
	public String showDatabindingForm(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("writersList", userService.returnAllUsers());

		return "databindingForm.jsp";
	}

	// Process Data binding form

	@PostMapping("/databinding/new")
	public String processDataBindingForm(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("writersList", userService.returnAllUsers());
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
		model.addAttribute("writersList", userService.returnAllUsers());
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

	// ------ Advanced Queries ------
	@GetMapping("/other")
	public String returnSomeBookBasedOnSearchTerm(@RequestParam(value = "q", required = false) String search,
			Model model) {

//		bookService.returnBookByLanguageContaining(search);
//		model.addAttribute("allBooks", bookService.returnBookByLanguageContaining(search));
		List<Book> booksFound = bookService.returnTopThreeBooksByOrder();
		model.addAttribute("allBooks", booksFound);

		return "dashboard.jsp";
	}

	// ------ Show Create user form ------
	@GetMapping("/users/new")
	public String showUserForm(@ModelAttribute("newUser") User writer) {
		return "userForm.jsp";
	}

	// Show all users
	@GetMapping("/users")
	public String showAllUsers(Model model) {
		model.addAttribute("allUsersList", userService.returnAllUsers());
		return "allUsers.jsp";
	}

	@PostMapping("/users/new")
	public String createWriter(@Valid @ModelAttribute("newUser") User writer, BindingResult result) {
		if (result.hasErrors()) {
			return "userForm.jsp";
		} else {

			userService.createUser(writer);
			return "redirect:/books/users";
		}
	}

}
