package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.DailyPurchaseConfDao;
import com.jci.model.DailyPurchaseConfModel;
import com.jci.service.DailyPurchaseModelConfService;

@Service
public class DailyPurchaseConfModelServiceImpl  implements DailyPurchaseModelConfService{

	@Autowired
	DailyPurchaseConfDao dailyPurchaseConfDao;

	@Override
	public void create(DailyPurchaseConfModel dailyPurchaseConfModel) {
		dailyPurchaseConfDao.create(dailyPurchaseConfModel);

	}

	@Override
	public void update(DailyPurchaseConfModel dailyPurchaseConfModel) {
		dailyPurchaseConfDao.update(dailyPurchaseConfModel);
	}

	@Override
	public DailyPurchaseConfModel edit(int id) {
		return dailyPurchaseConfDao.edit(id);
	}

	@Override
	public void delete(int id) {
		dailyPurchaseConfDao.delete(id);
	}

	@Override
	public DailyPurchaseConfModel find(int id) {
		return dailyPurchaseConfDao.find(id);
	}

	@Override
	public List<DailyPurchaseConfModel> getAll(String dpcid, String regionId, String zoneId) {
		return dailyPurchaseConfDao.getAll(dpcid, regionId, zoneId);
	}

	@Override
	public boolean submitform(DailyPurchaseConfModel dailyPurchaseConfModel) {
		return dailyPurchaseConfDao.submitform(dailyPurchaseConfModel);
	}

	@Override
	public List<DailyPurchaseConfModel> dpc2() {
		return dailyPurchaseConfDao.dpc2();
		
	}

	@Override
	public String findGradePriceJuteVariety(String variety, int msp_no, String cropyr, String dpcid) {
		return dailyPurchaseConfDao.findGradePriceJuteVariety(variety,msp_no,cropyr,dpcid);	
		}

	@Override
	public void firstLevel(String cropyr, String basis) {
		dailyPurchaseConfDao.firstLevel(cropyr, basis);
		
	}


}
