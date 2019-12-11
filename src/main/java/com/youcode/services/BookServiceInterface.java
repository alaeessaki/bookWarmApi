package com.youcode.services;

import java.util.List;
import java.util.Optional;

import com.youcode.beans.Book;
import com.youcode.beans.Comment;
import com.youcode.beans.Quote;

public interface BookServiceInterface {
	
	public void addBook(Book book);
	public List<Book> getAllBooks();
	public void updateBook(Book book);
	public void deleteBook(int id);
	public Optional<Book> getBook(int id);
	public List<Quote> getBookQuotes(int id);
	public List<Comment> getbookComments(int id);
}
