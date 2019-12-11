package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.beans.Book;
import com.youcode.beans.Comment;
import com.youcode.beans.Quote;
import com.youcode.dao.BookDaoInterface;

@Service
public class BookService implements BookServiceInterface{
	
	@Autowired
	BookDaoInterface dao;
	
	public Optional<Book> getBook(int id) {
		return dao.findById(id);
	}
	
	public void addBook(Book book) {
		dao.save(book);
	}
	
	public List<Book> getAllBooks() {
		return dao.findAll();
	}
	
	public void updateBook(Book book) {
		dao.save(book);
	}
	
	public void deleteBook(int id) {
		dao.deleteById(id);
	}
	
	public List<Quote> getBookQuotes(int id){
		List<Quote> quotes = null;
		Book book = null;
		Optional<Book> byId = dao.findById(id);
		if(byId.isPresent()) {
			book = byId.get();
			quotes = book.getQuotes();
		}
		return quotes;
	}
	
	public List<Comment> getbookComments(int id){
		List<Comment> comments = null;
		Book book = null;
		Optional<Book> byId = dao.findById(id);
		if(byId.isPresent()) {
			book = byId.get();
			comments = book.getComments();
		}
		return comments;
	}

}
