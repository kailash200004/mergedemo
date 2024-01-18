package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jci.dao_phase2.GenerationofBillDao;
import com.jci.model.GenerationOfBillSupplyModel;
import com.jci.service_phase2.GenerationofBillService;


@Service
public class GenerationofBillServiceImpl implements GenerationofBillService {

	
	
	@Autowired
	GenerationofBillDao generationofBillDao;


	@Override
	public void create(GenerationOfBillSupplyModel generationOfBillSupplyModel) {
		System.out.println(generationOfBillSupplyModel);
		generationofBillDao.create(generationOfBillSupplyModel);
		
	}

	@Override
	public List<GenerationOfBillSupplyModel> getAll() {
		
		 return generationofBillDao.getAll();
	}

	@Override
	public List<Object[]>ChallanNo() {
		return generationofBillDao.ChallanNo();
	}

//	
	@Override
	public  List<Object[]> contarctno( String st) {
		return generationofBillDao.contarctno(st);
	}
//	@Override
//	public  List<Object[]>contarctnoformaster( String st) {
//		return generationofBillDao.contarctnoformaster(st);
//	}
	@Override
	public  List<Object[]> Dispatchentry( String st) {
		return generationofBillDao.Dispatchentry(st);
	}

	@Override
	public String billofsupplyno(String st) {
		
		return generationofBillDao.billofsupplyno(st);
	}

	@Override
	public List<Object[]>contarctnoformaster(String st) {
		
		return generationofBillDao.contarctnoformaster(st);
	}


}
