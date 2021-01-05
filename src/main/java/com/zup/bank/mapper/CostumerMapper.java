package com.zup.bank.mapper;

import org.mapstruct.Mapper;

import com.zup.bank.model.Costumer;
import com.zup.bank.model.dto.CostumerDTO;

@Mapper
public interface CostumerMapper {	
	
	Costumer toCostumer(CostumerDTO costumer);
}
