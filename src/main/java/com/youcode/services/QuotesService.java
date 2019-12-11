package com.youcode.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.beans.Quote;
import com.youcode.dao.QuoteDaoInterface;

@Service
public class QuotesService implements QuotesServiceInterface{
	
	@Autowired
	QuoteDaoInterface dao;
	
	public Optional<Quote> getQuote(int id){
		return dao.findById(id);
	}
	
	public void addQuote(Quote quote) {
		dao.save(quote);
	}
	public void updatQuote(Quote quote) {
		dao.save(quote);
	}
	public void deleteQuote(int id) {
		dao.deleteById(id);
	}
}
