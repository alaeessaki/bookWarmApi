package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.beans.Book;
import com.youcode.beans.Category;
import com.youcode.dao.CategoryDaoInterface;

@Service
public class CategoryService implements CategoryServiceInterface{

	@Autowired
	CategoryDaoInterface dao;
	
	public List<Category> getAll(){
		return dao.findAll();
	}
	
	public Optional<Category> getCategory(int id) {
		return dao.findById(id);
	}
	
	public List<Book> getCategoryBooks(int id){
		Category category = null;
		List<Book> books = null;
		Optional<Category> byId = dao.findById(id);
		if(byId.isPresent()) {
			category = byId.get();
			books = category.getBooks();
		}
		return books;
	}
	
	public void addCategory(Category category) {
		dao.save(category);
	}
	
	public void updateCategory(Category category) {
		dao.save(category);
	}
	
	public void deleteCategory(int id) {
		dao.deleteById(id);
	}
}

