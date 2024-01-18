package com.jci.dao;

import java.util.List;

import com.jci.model.EntryDerivativePrice;

public interface EntryDerivativePriceDao {
	public void create(EntryDerivativePrice edp);
	public void update(EntryDerivativePrice edp);
	public EntryDerivativePrice edit(int id);
	public void delete(int id);
	public EntryDerivativePrice findById(int id);
	public List <EntryDerivativePrice> getAllEDP();
	
}
