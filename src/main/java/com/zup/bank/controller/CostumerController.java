package com.zup.bank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.bank.mapper.CostumerMapper;
import com.zup.bank.model.dto.CostumerDTO;
import com.zup.bank.services.CostumerService;

@RestController
@RequestMapping(value = "/api/v1/costumers")
public class CostumerController {

	@Autowired
	private CostumerService service;
	
	private CostumerMapper mapper;
	
	@PostMapping
	public ResponseEntity<CostumerDTO> registrate(@Valid @RequestBody CostumerDTO costumerDTO) {
		service.registrate(mapper.toCostumer(costumerDTO));
		return ResponseEntity.status(HttpStatus.CREATED).body(costumerDTO);
	}
}
