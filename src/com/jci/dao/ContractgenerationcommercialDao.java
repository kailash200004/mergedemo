package com.jci.dao;

import java.util.List;

import com.jci.model.Contractgenerationcommercial;

public interface ContractgenerationcommercialDao {

	public void create(Contractgenerationcommercial contractgenerationcommercial);

	public void update(Contractgenerationcommercial contractgenerationcommercial);

	public Contractgenerationcommercial edit(int cgc_id);

	public void delete(int cgc_id);

	public Contractgenerationcommercial find(int cgc_id);

	public List<Contractgenerationcommercial> getAll();

}
