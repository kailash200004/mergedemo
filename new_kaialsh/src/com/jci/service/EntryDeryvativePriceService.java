package com.jci.service;

import java.util.List;

import com.jci.model.EntryDerivativePrice;

public interface EntryDeryvativePriceService {
	public void create(EntryDerivativePrice edprice);
	public void update(EntryDerivativePrice edprice);
	public void delete(int id);
	public EntryDerivativePrice findEDPBYId(int id);
	public List <EntryDerivativePrice> getAllEDP();
	
}
