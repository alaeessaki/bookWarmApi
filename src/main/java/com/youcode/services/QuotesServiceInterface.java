package com.youcode.services;

import java.util.Optional;

import com.youcode.beans.Quote;

public interface QuotesServiceInterface {
	public Optional<Quote> getQuote(int id);
	public void addQuote(Quote quote);
	public void updatQuote(Quote quote);
	public void deleteQuote(int id);
}
