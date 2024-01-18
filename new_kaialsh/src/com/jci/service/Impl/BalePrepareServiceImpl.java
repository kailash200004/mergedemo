package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.BalePrepareDao;
import com.jci.model.BalePreparation;
import com.jci.model.PurchaseCenterModel;
import com.jci.service.BalePrepareService;

@Service
public class BalePrepareServiceImpl implements BalePrepareService	{

	@Autowired
	BalePrepareDao balePrepare;

	@Override
	public void create(BalePreparation BalePreparation) {
		balePrepare.create(BalePreparation);
	}

	@Override
	public void update(BalePreparation BalePreparation) {
		balePrepare.update(BalePreparation);
	}

	@Override
	public BalePreparation edit(int id) {
		return balePrepare.edit(id);
	}

	@Override
	public void delete(int id) {
		balePrepare.delete(id);
	}

	@Override
	public BalePreparation find(int id) {
		return balePrepare.find(id);
	}

	@Override
	public List<BalePreparation> getAll(String place_of_packing) {
		return balePrepare.getAll(place_of_packing);
	}

	@Override
	public boolean submitform(BalePreparation BalePreparation) {
		return balePrepare.submitform(BalePreparation);
	}

	@Override
	public List<BalePreparation> getAlldata() {
		return balePrepare.getAlldata();

	}
}
