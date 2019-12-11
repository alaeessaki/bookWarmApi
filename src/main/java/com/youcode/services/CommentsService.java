package com.youcode.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.beans.Comment;
import com.youcode.dao.CommentDaoInterface;

@Service
public class CommentsService implements CommentsServiceInterface{
	
	@Autowired
	CommentDaoInterface dao;
	
	public void addComment(Comment comment) {
		dao.save(comment);
	}
	
	public void updateComment(Comment comment) {
		dao.save(comment);
	}
	
	public Optional<Comment> getComment(int id){
		return dao.findById(id);
	}
	
	public void deleteComment(int id) {
		dao.deleteById(id);
	}
	
}
