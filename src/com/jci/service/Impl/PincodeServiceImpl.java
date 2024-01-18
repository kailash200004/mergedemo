package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.PincodeDao;
import com.jci.model.PincodeModel;
import com.jci.service.PincodeService;

@Service
public class PincodeServiceImpl implements PincodeService {

	@Autowired
	PincodeDao pincodeDao;

	@Override
	public void create(PincodeModel pincode) {
		pincodeDao.create(pincode);

	}

	@Override
	public void update(PincodeModel pincode) {
		pincodeDao.update(pincode);

	}

	@Override
	public PincodeModel edit(int id) {
		return pincodeDao.edit(id);
	}

	@Override
	public void delete(int id) {
		pincodeDao.delete(id);

	}

	@Override
	public PincodeModel find(int id) {
		return pincodeDao.find(id);
	}

	@Override
	public List<PincodeModel> getAll() {
		return pincodeDao.getAll();
	}

	@Override
	public boolean submitform(PincodeModel pincode) {
		return pincodeDao.submitform(pincode);
	}

}
