package com.jci.service.Impl_phase2;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.PcsoentryDao;
import com.jci.model.EntryofpcsoModel;
import com.jci.model.PcsoDateModel;
import com.jci.service_phase2.PcsoentryService;

@Service
public class PcsoentryServiceImpl implements PcsoentryService {
	
	@Autowired
	PcsoentryDao pcsoentrydao;

	public void create(EntryofpcsoModel entryofpcso) {
		// TODO Auto-generated method stub
		pcsoentrydao.create(entryofpcso);
		
	}

	public List<EntryofpcsoModel> getAlldata() {
		// TODO Auto-generated method stub
			return pcsoentrydao.getAlldata();
	}

	@Override
	public List<Date> getAll() {
		// TODO Auto-generated method stub
		return pcsoentrydao.getAll();
	}

	@Override
	public List<PcsoDateModel> pcso_details(String pcso) {
		// TODO Auto-generated method stub
		return pcsoentrydao.pcso_details(pcso);
	}

}
