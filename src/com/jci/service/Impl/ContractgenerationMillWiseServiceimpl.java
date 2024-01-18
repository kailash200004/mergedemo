package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.ContractgenerationMillWiseDao;
import com.jci.model.ContractgenerationMillWise;
import com.jci.service.ContractgenerationMillWiseService;

@Service
public class ContractgenerationMillWiseServiceimpl implements ContractgenerationMillWiseService{

	@Autowired
	ContractgenerationMillWiseDao contractgenerationMillWiseDao;
	@Override
	public void create(ContractgenerationMillWise contractgeneration) {
		contractgenerationMillWiseDao.create(contractgeneration);
		
	}

	@Override
	public void update(ContractgenerationMillWise contractgeneration) {
		// TODO Auto-generated method stub
		contractgenerationMillWiseDao.update(contractgeneration);
	}

	@Override
	public ContractgenerationMillWise edit(int id) {
		// TODO Auto-generated method stub
		
		return contractgenerationMillWiseDao.edit(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		contractgenerationMillWiseDao.delete(id);
	}

	@Override
	public ContractgenerationMillWise find(int id) {
		// TODO Auto-generated method stub
		return contractgenerationMillWiseDao.find(id);
	}

	@Override
	public List<ContractgenerationMillWise> getAll() {
		// TODO Auto-generated method stub
		return contractgenerationMillWiseDao.getAll();
	}

	@Override
	public List<String> derivativePrice(String type, String contract_no) {
		// TODO Auto-generated method stub
		return contractgenerationMillWiseDao.derivativePrice(type, contract_no);
	}

	@Override
	public List<String> percentage(String contract_no) {
		// TODO Auto-generated method stub
		return contractgenerationMillWiseDao.percentage(contract_no);
	}
	
	

}
