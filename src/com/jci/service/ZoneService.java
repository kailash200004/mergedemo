package com.jci.service;
import java.util.List;

import com.jci.model.ZoneModel;
public interface ZoneService {

	public void create(ZoneModel Zone);
	public void update(ZoneModel Zone);
	public ZoneModel edit(int id);
	public void delete(int id);
	public ZoneModel find(int id);
	public List<ZoneModel> getAll();
	public boolean submitform(ZoneModel Zone);
}
