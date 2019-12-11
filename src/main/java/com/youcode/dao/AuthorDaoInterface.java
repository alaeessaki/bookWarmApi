package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.beans.Author;

@Repository
public interface AuthorDaoInterface extends JpaRepository<Author, Integer>{

}
