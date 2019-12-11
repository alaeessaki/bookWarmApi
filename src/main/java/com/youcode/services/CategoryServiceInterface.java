package com.youcode.services;

import java.util.List;
import java.util.Optional;

import com.youcode.beans.Book;
import com.youcode.beans.Category;

public interface CategoryServiceInterface {
	
	public Optional<Category> getCategory(int id);
	public List<Book> getCategoryBooks(int id);
	public void addCategory(Category category);
	public void updateCategory(Category category);
	public void deleteCategory(int id);
	public List<Category> getAll();
	
}
