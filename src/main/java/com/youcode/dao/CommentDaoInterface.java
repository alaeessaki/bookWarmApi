package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.beans.Comment;

@Repository
public interface CommentDaoInterface extends JpaRepository<Comment, Integer>{

}
