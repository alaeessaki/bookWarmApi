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

import com.youcode.beans.Author;
import com.youcode.beans.Book;
import com.youcode.services.AuthorServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/authors")
public class AuthorsController {
	
	@Autowired
	AuthorServiceInterface AuthorService;
	
	
	@GetMapping(value = "/all")
	public List<Author> getAuthors(){
		return AuthorService.getAllAuthors();
	}
	
	@GetMapping(value = "/{id}")
	public Author getAuthor(@PathVariable("id")int id) {
		Optional<Author> byId = AuthorService.getAuthor(id);
		if(!byId.isPresent()) {
			return null;
		}
		return byId.get();
	}
	
	@PostMapping(value = "/add")
	public Author addAuthor(@RequestBody Author author) {
		AuthorService.addAuthor(author);
		return author;
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void deleteAuthor(@PathVariable("id")int id) {
		AuthorService.deleteAuthor(id);
	}
	
	@GetMapping(value = "/{id}/books")
	public List<Book> getAuthorBooks(@PathVariable("id") int id){
		return AuthorService.getAuthorBooks(id);
	}
}
