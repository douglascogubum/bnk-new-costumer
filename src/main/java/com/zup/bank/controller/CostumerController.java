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

import com.zup.bank.mapper.CostumerDTOMapper;
import com.zup.bank.model.Costumer;
import com.zup.bank.model.dto.CostumerDTO;
import com.zup.bank.services.CostumerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiOperation(value = "Cadastra um cliente")
@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Retorna cliente salvo"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 400, message = "Houve um erro na validação dos campos"),
	})
@RestController
@RequestMapping(value = "/api/v1/costumers")
public class CostumerController {

	@Autowired
	private CostumerService service;
	
	@Autowired
	private CostumerDTOMapper mapper;
	
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
