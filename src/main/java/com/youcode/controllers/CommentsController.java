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

import com.youcode.beans.Comment;
import com.youcode.services.BookServiceInterface;
import com.youcode.services.CommentsServiceInterface;

@RestController
@RequestMapping("/comments")
public class CommentsController {

	@Autowired
	CommentsServiceInterface commentService;
	
	@Autowired
	BookServiceInterface bookService;
	
	@GetMapping(value = "/{book_id}")
	public List<Comment> getBookComments(@PathVariable("book_id")int id){
		return bookService.getbookComments(id);
	}
	
	@PostMapping(value = "/addComment")
	public Comment addComment(@RequestBody Comment comment) {
		commentService.addComment(comment);
		return comment;
	}
	
	@DeleteMapping(value = "delete/{comment_id}")
	public String deleteComment(@PathVariable("comment_id")int id) {
		commentService.deleteComment(id);
		return "comment "+id+" is deleted successfully";
	}
}
