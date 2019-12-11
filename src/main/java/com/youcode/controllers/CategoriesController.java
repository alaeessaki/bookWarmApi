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

import com.youcode.beans.Category;
import com.youcode.services.CategoryServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categories")
public class CategoriesController {

	@Autowired
	CategoryServiceInterface categoryService;
	
	@GetMapping(value = "/all")
	public List<Category> getAllCategories(){
		return categoryService.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public Category getCategory(@PathVariable("id")int id) {
		Optional<Category> byId = categoryService.getCategory(id);
		if(!byId.isPresent()) {
			return null;
		}
		return byId.get();
	}
	
	@PostMapping(value = "/add")
	public Category addCategory(@RequestBody Category category) {
		categoryService.addCategory(category);
		return category;
	}
	
	@DeleteMapping(value = "delete:{id}")
	public String deletedCategory(@PathVariable("id")int id) {
		categoryService.deleteCategory(id);
		return "category "+id+" is deleted successfully";
	}
}
