package com.jci.dao;

import java.util.List;

import com.jci.model.Entryofoperationcost;

public interface EntryofoperationcostDao {

	public void create(Entryofoperationcost eooc);

	public void update(Entryofoperationcost eooc);

	public Entryofoperationcost edit(int eooc_id);

	public void delete(int eooc_id);

	public Entryofoperationcost findById(int eooc_id);

	public List<Entryofoperationcost> getAll();
}
