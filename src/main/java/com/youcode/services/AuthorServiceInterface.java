package com.youcode.services;

import java.util.List;
import java.util.Optional;

import com.youcode.beans.Author;
import com.youcode.beans.Book;

public interface AuthorServiceInterface {
	
	public void addAuthor(Author author);
	public Optional<Author> getAuthor(int id);
	public void updateAuthor(Author author);
	public void deleteAuthor(int id);
	public List<Author> getAllAuthors();
	public List<Book> getAuthorBooks(int id);
	
}
