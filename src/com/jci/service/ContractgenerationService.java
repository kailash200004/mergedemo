package com.jci.service;

import java.util.List;

import com.jci.model.Contractgeneration;
import com.jci.model.UpdatedContractQtyDTO;

public interface ContractgenerationService {
	public void create(UpdatedContractQtyDTO updatedcontractqtyDTO);

	public void update(Contractgeneration contractgeneration);

	public Contractgeneration edit(int contract_id);

	public void delete(int contract_id);

	public Contractgeneration find(int contract_id);

	public UpdatedContractQtyDTO getAll(int id);
	
	public List<UpdatedContractQtyDTO> getAllMills();

	public void create(Contractgeneration contractgenerationPsco);
}
