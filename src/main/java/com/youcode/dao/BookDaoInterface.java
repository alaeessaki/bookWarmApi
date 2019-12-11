package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.beans.Book;

@Repository
public interface BookDaoInterface extends JpaRepository<Book, Integer>{

}
