package com.jci.service;

import java.util.List;

import com.jci.model.Contractgenerationcommercial;

public interface ContractgenerationcommercialService {

	public void create(Contractgenerationcommercial contractgenerationcommercial);

	public void update(Contractgenerationcommercial contractgenerationcommercial);

	public Contractgenerationcommercial edit(int cgc_id);

	public void delete(int cgc_id);

	public Contractgenerationcommercial findById(int cgc_id);

	public List<Contractgenerationcommercial> getAll();
}
