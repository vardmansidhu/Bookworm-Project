package com.bookworm.bookworm_middleware.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookworm_middleware.entities.Beneficiary;
import com.bookworm.bookworm_middleware.repositories.IBeneficiaryRepository;

@Service
public class BeneficiaryManagerImpl implements IBenificiaryManager {

	@Autowired
	private IBeneficiaryRepository repository;

	@Override
	public void addBeneficiary(Beneficiary b) {
		repository.save(b);
	}

	@Override
	public List<Beneficiary> getallBen() {
		return repository.findAll();
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById((int) id);
	}

	@Override
	public Optional<Beneficiary> getBen(long id) {
		return repository.findById((int) id);
	}

	@Override
	public void update(Beneficiary updateBen, long id) {
		// TODO Auto-generated method stub

	}

	/**
	 * @Override public void update(Beneficiary updateBen, long id) {
	 *           repository.update(updateBen.getBenName(),updateBen.getEmail(),updateBen.getContact(),updateBen.getBankName(),updateBen.getBankBranch(),updateBen.getIFSC(),updateBen.getAccNo(),updateBen.getAccType(),updateBen.getPAN(),id);
	 * 
	 *           }
	 **/

}
