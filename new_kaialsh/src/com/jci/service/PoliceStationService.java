package com.jci.service;

import java.util.List;

import com.jci.model.PoliceStationModel;;

public interface PoliceStationService
{
	public void create(PoliceStationModel PoliceStation);
	public void update(PoliceStationModel PoliceStation);
	public PoliceStationModel edit(int id);
	public void delete(int id);
	public PoliceStationModel find(int id);
	public List <PoliceStationModel> getAll();
	public boolean submitform(PoliceStationModel off);
	public List <String> getAllFilledPoliceStation(String  PoliceStation);

}
