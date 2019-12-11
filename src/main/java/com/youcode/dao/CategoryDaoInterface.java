package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.beans.Category;

@Repository
public interface CategoryDaoInterface extends JpaRepository<Category, Integer>{

}
