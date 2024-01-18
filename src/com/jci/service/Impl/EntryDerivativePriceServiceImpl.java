package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.EntryDerivativePriceDao;
import com.jci.dao.impl.EntryDerivativePriceDaoImpl;
import com.jci.model.EntryDerivativePrice;
import com.jci.service.EntryDeryvativePriceService;


@Service
public class EntryDerivativePriceServiceImpl implements EntryDeryvativePriceService
{
   
	@Autowired
	EntryDerivativePriceDao entryDerivativePriceDao;
	
	@Override
	public void create(EntryDerivativePrice edprice) {
		this.entryDerivativePriceDao.create(edprice);

	}

	@Override
	public void update(EntryDerivativePrice edprice) {
		this.entryDerivativePriceDao.update(edprice);
	}

	@Override
	public void delete(int id) {
		this.entryDerivativePriceDao.delete(id);

	}

	@Override
	public EntryDerivativePrice findEDPBYId(int id) {
	
		return this.entryDerivativePriceDao.findById(id);
	}

	@Override
	public List<EntryDerivativePrice> getAllEDP() {
		return this.entryDerivativePriceDao.getAllEDP();
	}

}
