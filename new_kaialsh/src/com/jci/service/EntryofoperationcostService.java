package com.jci.service;

import java.util.List;

import com.jci.model.Entryofoperationcost;

public interface EntryofoperationcostService {

	public void create(Entryofoperationcost edprice);

	public void update(Entryofoperationcost edprice);

	public void delete(int id);

	public Entryofoperationcost findEDPBYId(int id);

	public List<Entryofoperationcost> getAll();
}
