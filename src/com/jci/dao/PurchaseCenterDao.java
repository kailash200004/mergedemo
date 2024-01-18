package com.jci.dao;

import java.util.List;

import com.jci.model.RoDetailsModel;

public interface PurchaseCenterDao {
	public void create(RoDetailsModel roDetails);
	public void update(RoDetailsModel roDetails);
	public RoDetailsModel edit(int id);
	public void delete(int id);
	public RoDetailsModel find(int id);
	public List <RoDetailsModel> getAll();
	public boolean submitform(RoDetailsModel roDetails);
	public List<String> purchaseCenter(String region);
	public List<String> dpcbyid(String dpc);
	public List<String> getAllDpc();
	public String findDpcname(String dpccode);

}
