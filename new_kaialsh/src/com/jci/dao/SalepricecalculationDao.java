package com.jci.dao;

import java.util.List;

import com.jci.model.Salepricecalculation;

public interface SalepricecalculationDao {

	
	public void create(Salepricecalculation spc);

	public void update(Salepricecalculation spc);

	public Salepricecalculation edit(int spc_id);

	public void delete(int spc_id);

	public Salepricecalculation findById(int spc_id);

	public List<Salepricecalculation> getAll();
}
