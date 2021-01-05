package com.zup.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.bank.model.Costumer;
import com.zup.bank.repository.CostumerRepository;

@Service
public class CostumerService {

	@Autowired
	private CostumerRepository costumerRepository;
	
	public Costumer registrate(Costumer costumer) {
		return costumerRepository.save(costumer);
	}
}
