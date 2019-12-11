package com.youcode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.beans.Quote;
import com.youcode.services.BookServiceInterface;
import com.youcode.services.QuotesServiceInterface;

@RestController
@RequestMapping("/quotes")
public class QuotesController {
	
	@Autowired
	QuotesServiceInterface quotesService;
	
	@Autowired
	BookServiceInterface booksService;
	
	@GetMapping(value = "/{book_id}")
	public List<Quote> getAllQuotes(@PathVariable("book_id")int id){
		return booksService.getBookQuotes(id);
	}
	
	@PostMapping(value = "addQuote")
	public Quote addQuote(@RequestBody Quote quote) {
		quotesService.addQuote(quote);
		return quote;
	}
	
	@DeleteMapping(value = "delete/{quote_id}")
	public String deleteQuote(@PathVariable("quote_id")int id) {
		quotesService.deleteQuote(id);
		return "quote "+id+" is deleted successfully";
	}
}
