package com.jci.service;

import java.util.List;

import com.jci.model.PurchaseCenterModel;
import com.jci.model.RoDetailsModel;

public interface PurchaseCenterService {
	public void create(RoDetailsModel roDetails);
	public void update(RoDetailsModel roDetails);
	public RoDetailsModel edit(int id);
	public void delete(int id);
	public RoDetailsModel find(int id);
	public List <RoDetailsModel> getAll();
	public boolean submitform(RoDetailsModel roDetails);
	public List<String> purchaseCenter(String regionCode);
	public List<String> dpcbyId(String dpc);
	public List<String> getAllDpc();
//	public List<PurchaseCenterModel>getCenterCodeByCode(int rocode);
}
