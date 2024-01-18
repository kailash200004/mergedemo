package com.jci.dao;

import java.util.List;

import com.jci.model.PoliceStationModel;


public interface PoliceStationDao
{
     public void create(PoliceStationModel PoliceStationlist);
	public void update(PoliceStationModel PoliceStationlist);
	public PoliceStationModel  edit(int id);
	public void delete(int id);
	public PoliceStationModel find(int id);
	public List <PoliceStationModel> getAll();
	public List<String> getAllFilledPoliceStation(String id);
	public boolean submitform(PoliceStationModel off);

}
