package com.jci.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jci.model.UserRoleModel;
@Service
public interface UserRoleService {

	void create(UserRoleModel userrole);
	boolean validateRole(String role);
	List<UserRoleModel> getAll();
	void deleteUserName(String roelname);
    public List<String> getuserrole(String user_type);
}
