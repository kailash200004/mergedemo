package com.jci.service_phase2;

import java.util.List;




import com.jci.model.GenerationOfBillSupplyModel;


public interface GenerationofBillService {
	public void create(GenerationOfBillSupplyModel generationOfBillSupplyModel);
	 public List<GenerationOfBillSupplyModel>getAll();
	  public List<Object[]>ChallanNo();
	  public  List<Object[]>contarctno(String  st);
	  public  List<Object[]>contarctnoformaster(String  st);
	  public  List<Object[]>Dispatchentry(String  st);
	  public   String billofsupplyno(String  st);
}
