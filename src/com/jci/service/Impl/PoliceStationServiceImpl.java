package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.PoliceStationDao;
import com.jci.model.PoliceStationModel;
import com.jci.service.PoliceStationService;


@Service
public class PoliceStationServiceImpl implements PoliceStationService
{

	@Autowired
	PoliceStationDao PoliceStationDao;

	@Override
	public void create(PoliceStationModel PoliceStation) {
		PoliceStationDao.create(PoliceStation);

	}

	@Override
	public void update(PoliceStationModel PoliceStation) {
		PoliceStationDao.update(PoliceStation);

	}

	@Override
	public PoliceStationModel edit(int id) {
		return PoliceStationDao.edit(id);
	}

	@Override
	public void delete(int id) {
		PoliceStationDao.delete(id);

	}

	@Override
	public PoliceStationModel find(int id) {
		return PoliceStationDao.find(id);
	}

	@Override
	public boolean submitform(PoliceStationModel off) {
		return PoliceStationDao.submitform(off);
	}

	@Override
	public List<String> getAllFilledPoliceStation(String PoliceStation) {
		return PoliceStationDao.getAllFilledPoliceStation(PoliceStation);
	}

	@Override
	public List<PoliceStationModel> getAll() {
		return PoliceStationDao.getAll();
	}
}
