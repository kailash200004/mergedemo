package com.jci.dao_phase2;

import java.util.Date;
import java.util.List;

import com.jci.model.EntryofpcsoModel;
import com.jci.model.PcsoDateModel;

public interface PcsoentryDao {

	public void create(EntryofpcsoModel entryofpcso);

	public List<EntryofpcsoModel> getAlldata();

	List<Date> getAll();
	
	public List<PcsoDateModel> pcso_details(String pcso);
}
