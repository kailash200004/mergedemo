package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.SalepricecalculationDao;
import com.jci.model.Salepricecalculation;
import com.jci.service.SalepricecalculationService;

@Service
public class SalepricecalculationServiceImpl implements SalepricecalculationService {

	@Autowired
	SalepricecalculationDao salepricecalculationDao;

	@Override
	public void create(Salepricecalculation spc) {
		this.salepricecalculationDao.create(spc);

	}

	@Override
	public void update(Salepricecalculation spc) {

		this.salepricecalculationDao.update(spc);
	}

	@Override
	public Salepricecalculation edit(int spc_id) {

		return this.salepricecalculationDao.edit(spc_id);
	}

	@Override
	public void delete(int spc_id) {
		this.salepricecalculationDao.delete(spc_id);

	}

	@Override
	public Salepricecalculation find(int spc_id) {

		return this.salepricecalculationDao.findById(spc_id);
	}

	@Override
	public List<Salepricecalculation> getAll() {

		return this.salepricecalculationDao.getAll();
	}

}
