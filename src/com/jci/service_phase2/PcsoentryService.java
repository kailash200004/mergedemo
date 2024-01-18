package com.jci.service_phase2;

import java.util.Date;
import java.util.List;

import com.jci.model.EntryofpcsoModel;
import com.jci.model.PcsoDateModel;

public interface PcsoentryService {
	
	void create(EntryofpcsoModel entryofpcso);

	List<EntryofpcsoModel> getAlldata();
	
	List<Date> getAll();
	
	List<PcsoDateModel> pcso_details(String pcso);
}
