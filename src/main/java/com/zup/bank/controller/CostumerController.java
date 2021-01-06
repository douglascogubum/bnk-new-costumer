package com.zup.bank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.bank.mapper.CostumerMapper;
import com.zup.bank.model.Costumer;
import com.zup.bank.model.dto.CostumerDTO;
import com.zup.bank.services.CostumerService;

@RestController
@RequestMapping(value = "/api/v1/costumers")
public class CostumerController {

	@Autowired
	private CostumerService service;
	
	@Autowired
	private CostumerMapper mapper;
	
	@PostMapping
	public ResponseEntity<CostumerDTO> registrate(@Valid @RequestBody CostumerDTO costumerDto) throws MethodArgumentNotValidException {
		return ResponseEntity.status(HttpStatus.OK).body(entityToDto(costumerDto));
	}

	private CostumerDTO entityToDto(CostumerDTO costumerDto) {
		return mapper.toCostumerDTO(dtoToEntity(costumerDto));
	}

	private Costumer dtoToEntity(CostumerDTO costumerDto) {
		return service.registrate(mapper.toCostumer(costumerDto));
	}
}
