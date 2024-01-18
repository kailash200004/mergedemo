package com.jci.service;

import java.util.List;

import com.jci.model.Salepricecalculation;

public interface SalepricecalculationService {

	
	public void create(Salepricecalculation spc);
	public void update(Salepricecalculation spc);
	public Salepricecalculation edit(int spc_id);

	public void delete(int spc_id);
	public Salepricecalculation find(int spc_id);
	public List<Salepricecalculation> getAll();
}
