package com.zup.bank.controller.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class ErrorDTO {
	
	private String field;
	private String error;
}
