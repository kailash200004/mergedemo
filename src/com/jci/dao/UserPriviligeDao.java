package com.jci.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.model.UserPriviligeModel;
@Transactional
@Repository
public interface UserPriviligeDao {

	void create(UserPriviligeModel userprivilige);

	public String getUserPrivilegeListing(int role_Id);
	public List<String> getuserpriviligeajaxallData();
	

}
