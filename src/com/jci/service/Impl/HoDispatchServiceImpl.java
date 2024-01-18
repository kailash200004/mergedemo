package com.jci.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.HoDispatchdao;
import com.jci.model.HODispatchInstructionModel;
import com.jci.service.HoDispatchService;

@Service
public class HoDispatchServiceImpl implements HoDispatchService {
	
	@Autowired
	private HoDispatchdao hodispatchdao;

	@Override
	public void create(HODispatchInstructionModel hodispatch) {
		// TODO Auto-generated method stub
		hodispatchdao.create(hodispatch);
		
	}

}
