package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.beans.Author;
import com.youcode.beans.Book;
import com.youcode.dao.AuthorDaoInterface;

@Service
public class AuthorService implements AuthorServiceInterface{
	
	@Autowired
	AuthorDaoInterface dao;
	
	public void addAuthor(Author author) {
		dao.save(author);
	}
	
	public Optional<Author> getAuthor(int id){
		return dao.findById(id);
	}
	
	public List<Author> getAllAuthors(){
		return dao.findAll();
	}
	
	public List<Book> getAuthorBooks(int id){
		Author author = null;
		List<Book> books = null;

		Optional<Author> ById = dao.findById(id);
		if(ById.isPresent()) {
			author = ById.get();
			books = author.getBooks();
		}
		return books;
	}
	
	public void updateAuthor(Author author) {
		dao.save(author);
	}
	
	public void deleteAuthor(int id) {
		dao.deleteById(id);
	}
}

