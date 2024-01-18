package com.jci.service;

import java.util.List;

import com.jci.model.PCSOModel;
public interface PCSOServices {

	public void create(PCSOModel pcso);
	public void update(PCSOModel pcso);
	public PCSOModel edit(int id);
	public void delete(int id);
	public PCSOModel find(int id);
	//public List <EntryofpcsoModel> getAll();
	public boolean submitform(PCSOModel pcso);
}
