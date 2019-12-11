package com.youcode.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "authors")
public class Author{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", nullable = false)
	@NotBlank(message = "enter name")
	private String name;
	
	@Column(name = "lastname", nullable = false)
	@NotBlank(message = "enter lastname")
	private String lastname;
	
	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Book> books;

	public Author() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@JsonIgnore
	public List<Book> getBooks() {
		return books;
	}
	@JsonIgnore
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public int getNumberOfBooks() {
		return this.books.size();
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", lastname=" + lastname + ", books=" + books + "]";
	}

	
	
	
	
}
