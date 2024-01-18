package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.ContractgenerationcommercialDao;
import com.jci.model.Contractgenerationcommercial;
import com.jci.service.ContractgenerationcommercialService;

@Service
public class ContractgenerationcommercialServiceImpl implements ContractgenerationcommercialService {

	@Autowired
	ContractgenerationcommercialDao contractgenerationcommercialDao;
	
	@Override
	public void create(Contractgenerationcommercial contractgenerationcommercial) {
	
		this.contractgenerationcommercialDao.create(contractgenerationcommercial);
	}

	@Override
	public void update(Contractgenerationcommercial contractgenerationcommercial) {
		this.contractgenerationcommercialDao.update(contractgenerationcommercial);

	}

	@Override
	public Contractgenerationcommercial edit(int cgc_id) {
		
		return this.contractgenerationcommercialDao.edit(cgc_id);
	}

	@Override
	public void delete(int cgc_id) {
		this.contractgenerationcommercialDao.delete(cgc_id);

	}

	@Override
	public Contractgenerationcommercial findById(int cgc_id) {
	
		return this.contractgenerationcommercialDao.find(cgc_id);
	}

	@Override
	public List<Contractgenerationcommercial> getAll() {
		
		return this.contractgenerationcommercialDao.getAll();
	}

}
