package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.beans.Quote;

@Repository
public interface QuoteDaoInterface extends JpaRepository<Quote, Integer>{

}
