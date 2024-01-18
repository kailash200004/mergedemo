package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.MSPPriceCalculationDao;
import com.jci.model.MSPPriceCalculationModel;
import com.jci.service.MSPPriceCalculationService;

@Service
public class MSPPriceCalculationServiceImpl implements MSPPriceCalculationService{

	@Autowired
	MSPPriceCalculationDao mSPPriceCalculationDao;

	@Override
	public List<String> findGradeOfMSP(String variety, int basis_no) {
		return  mSPPriceCalculationDao.findGradeOfMSP(variety, basis_no);
	}

	@Override
	public int create(MSPPriceCalculationModel mspPrices) {
		int msp =	mSPPriceCalculationDao.create(mspPrices);
		return msp;


	}

	@Override
	public List<MSPPriceCalculationModel> getAll() {

		return mSPPriceCalculationDao.getAll();
	}

	@Override
	public boolean validatejutevariety(String jutevariety, String cropyr) {
		return mSPPriceCalculationDao.validatejutevariety(jutevariety, cropyr);
	}


}
