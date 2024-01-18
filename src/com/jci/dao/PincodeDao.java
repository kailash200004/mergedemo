package com.jci.dao;
import java.util.List;

import com.jci.model.PincodeModel;
public interface PincodeDao {
	public void create(PincodeModel pincode);
	public void update(PincodeModel pincode);
	public PincodeModel edit(int id);
	public void delete(int id);
	public PincodeModel find(int id);
	public List <PincodeModel> getAll();
	public boolean submitform(PincodeModel zone);
}
