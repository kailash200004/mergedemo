package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.UserActionDao;
import com.jci.model.UserActionModel;
import com.jci.service.UserActionService;
@Service
public class UserActionServiceImpl implements UserActionService {
	
	@Autowired
	UserActionDao useractiondao;

	@Override
	public void create(UserActionModel useraction) {
		useractiondao.create(useraction);
		
	}

	@Override
	public List<UserActionModel> getAll() {
		
		return useractiondao.getAll();
	}

}
