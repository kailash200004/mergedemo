package com.jci.dao;

import java.util.List;

import com.jci.model.ContractgenerationMillWise;

public interface ContractgenerationMillWiseDao {

	public void create(ContractgenerationMillWise contractgeneration);

	public void update(ContractgenerationMillWise contractgeneration);

	public ContractgenerationMillWise edit(int id);

	public void delete(int id);

	public ContractgenerationMillWise find(int id);

	public List<ContractgenerationMillWise> getAll();
	
	public List<String> derivativePrice(String type, String contract_no);
	
	public List<String> percentage(String contract_no);
	
}
