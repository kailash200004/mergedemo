package com.jci.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.model.UserRoleModel;
@Transactional
@Repository
public interface UserRoleDao {

	void create(UserRoleModel userrole);
	public boolean validateRole(String role);
	public List<UserRoleModel> getAll();
	void deleteuserrole(String roelname);
    public List<String> getuserrole(String user_type);



}
