package com.jci.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.Entryofsaledao;
import com.jci.model.EntryofSaleModel;
import com.jci.service.EntryofsaleService;

@Service
public class EntryofsaleServiceImpl implements EntryofsaleService{

	@Autowired
	Entryofsaledao entryofsaledao;
	
	@Override
	public void create(EntryofSaleModel entryofsale) {
		// TODO Auto-generated method stub
		entryofsaledao.create(entryofsale);
	}

}
