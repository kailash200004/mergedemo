package com.jci.service;

import java.util.List;

import com.jci.model.MSPPriceCalculationModel;

public interface MSPPriceCalculationService {

	public int create(MSPPriceCalculationModel mspPrices);
	public List<String> findGradeOfMSP(String parameter, int parseInt);
	public List<MSPPriceCalculationModel> getAll();
	public boolean validatejutevariety(String jutevariety, String cropyr);

}
