package com.jci.dao;

import java.util.List;

import com.jci.model.PCSOModel;

public interface PCSODao {

	public void create(PCSOModel pcso);
	public void update(PCSOModel pcso);
	public PCSOModel edit(int id);
	public void delete(int id);
	public PCSOModel find(int id);
	public List <PCSOModel> getAll();
	public boolean submitform(PCSOModel pcso);

}
