package com.youcode.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "books")
public class Book{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", nullable = false)
	@NotBlank(message = "enter book name")
	private String name;
	
	@Column(name = "description", nullable = false)
	@NotBlank(message = "enter book description")
	private String description;
	
	@Column(name = "creation_date")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Temporal(TemporalType.DATE)
	private Date creation_date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", nullable = false)
	private Author author;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Quote> quotes;
	
	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Comment> comments;

	public Book() {
		super();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	@JsonIgnore
	public Author getAuthor() {
		return author;
	}
	
	@JsonIgnore
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public int getCommentsNumber() {
		return comments.size();
	}
	
	public int getQuotesNumber() {
		return quotes.size();
	}
	
	public int getAuthorId() {
		return author.getId();
	}
	
	public String getAuthorName() {
		String fullName = author.getName()+ " "+author.getLastname();
		return fullName;
	}
	
	public String getCategoryName() {
		return category.getLabel();
	}
	
	@JsonIgnore
	public Category getCategory() {
		return category;
	}
	@JsonIgnore
	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Quote> getQuotes() {
		return quotes;
	}
	
	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", description=" + description + ", creation_date=" + creation_date
				+ ", author=" + author + ", category=" + category + ", quotes=" + quotes + ", comments=" + comments
				+ "]";
	}
	


	
	
	
}
