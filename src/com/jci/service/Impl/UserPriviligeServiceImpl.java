package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.UserPriviligeDao;
import com.jci.model.UserPriviligeModel;
import com.jci.service.UserPriviligeService;
@Service
public class UserPriviligeServiceImpl implements UserPriviligeService {
	
	@Autowired
	UserPriviligeDao userpriviligedao;

	public void create(UserPriviligeModel userprivilige) {
		userpriviligedao.create(userprivilige);
		
	}

	public String getUserPrivilegeListing(int role_Id) {
		return userpriviligedao.getUserPrivilegeListing(role_Id);
	}
		
	public List<String> getuserpriviligeajaxallData() {
		return userpriviligedao.getuserpriviligeajaxallData();
	}

}
