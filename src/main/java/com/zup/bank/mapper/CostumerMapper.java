package com.zup.bank.mapper;

import org.mapstruct.Mapper;

import com.zup.bank.model.Costumer;
import com.zup.bank.model.dto.CostumerDTO;

@Mapper(componentModel="spring")
public interface CostumerMapper {
	
  Costumer toCostumer(CostumerDTO dto); 
  CostumerDTO toCostumerDTO(Costumer costumer);
}