package com.youcode.services;

import java.util.Optional;

import com.youcode.beans.Comment;

public interface CommentsServiceInterface {
	
	public void addComment(Comment comment);
	public void updateComment(Comment comment);
	public Optional<Comment> getComment(int id);
	public void deleteComment(int id);
	
}
