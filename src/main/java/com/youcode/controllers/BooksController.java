package com.youcode.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.beans.Book;
import com.youcode.services.BookServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/books")
public class BooksController {
	
	@Autowired
	BookServiceInterface bookService;
	
	@GetMapping(value = "/all")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping(value = "/{id}")
	public Book getBook(@PathVariable("id")int id) {
		Optional<Book> byId = bookService.getBook(id);
		if(!byId.isPresent()) {
			return null;
		}
		return byId.get();
	}
	
	@PostMapping(value = "/add")
	public Book addBook(@RequestBody Book book) {
		bookService.addBook(book);
		return book;
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void deleteBook(@PathVariable("id")int id) {
		bookService.deleteBook(id);
	}
	
	
	
	
}
