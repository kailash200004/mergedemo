package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.EntryofoperationcostDao;
import com.jci.model.Entryofoperationcost;
import com.jci.service.EntryofoperationcostService;

@Service
public class EntryofoperationcostServiceImpl implements EntryofoperationcostService {
	
	@Autowired
	EntryofoperationcostDao  entryofoperationcostDao;
	
	@Override
	public void create(Entryofoperationcost eooc) {
	
		this.entryofoperationcostDao.create(eooc);
	}

	@Override
	public void update(Entryofoperationcost eooc) {
		this.entryofoperationcostDao.update(eooc);

	}

	@Override
	public void delete(int id) {
		this.entryofoperationcostDao.delete(id);

	}

	@Override
	public Entryofoperationcost findEDPBYId(int id) {
	
		return this.entryofoperationcostDao.findById(id);
	}

	@Override
	public List<Entryofoperationcost> getAll() {
	
		return this.entryofoperationcostDao.getAll();
	}

	
}
