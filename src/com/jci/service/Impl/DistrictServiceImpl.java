package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.DistrictDao;
import com.jci.model.DistrictModel;
import com.jci.service.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	DistrictDao distrdao;

	@Override
	public void create(DistrictModel productlist) {
		distrdao.create(productlist);

	}

	@Override
	public void update(DistrictModel productlist) {
		distrdao.update(productlist);

	}

	@Override
	public DistrictModel edit(int id) {
		return distrdao.edit(id);
	}

	@Override
	public void delete(int id) {
		distrdao.delete(id);

	}

	@Override
	public DistrictModel find(int id) {
		return distrdao.find(id);
	}

	@Override
	public List<DistrictModel> getAll() {
		return distrdao.getAll();
	}

	/*
	 * @Override public List<String> getAllFilledPosition(String id) {
	 * System.out.println("value of query in product Service"+distrdao.
	 * getAllFilledPosition(id)); return distrdao.getAllFilledPosition(id); }
	 */

	@Override
	public boolean submitform(DistrictModel off) {
		return distrdao.submitform(off);
	}

	@Override
	public List<String> findByDistrictId(String dids) {
		List<String> findByDistrictId = distrdao.findByDistrictId(dids);
		System.out.println("findByDistrictId service"+findByDistrictId);
		return findByDistrictId;
	}

	
	@Override
	public List<String> getAllFilledPosition(String id) {
		return distrdao.getAllFilledPosition(id);
	}
}
