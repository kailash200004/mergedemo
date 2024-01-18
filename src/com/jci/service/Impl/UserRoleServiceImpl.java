package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.UserRoleDao;
import com.jci.model.UserRoleModel;
import com.jci.service.UserRoleService;
@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	UserRoleDao userroledao;
	
	@Override
	public void create(UserRoleModel userrole) {
		userroledao.create(userrole);
	}

	@Override
	public List<UserRoleModel> getAll() {
		
		return userroledao.getAll();
	}

	@Override
	public boolean validateRole(String role) {
		return userroledao.validateRole(role);
	}

	@Override
	public void deleteUserName(String roelname) {
		// TODO Auto-generated method stub
		 userroledao.deleteuserrole(roelname);
	}
	
    @Override
    public List<String> getuserrole(String user_type) {
           // TODO Auto-generated method stub
           return userroledao.getuserrole(user_type);
           
    }


}
