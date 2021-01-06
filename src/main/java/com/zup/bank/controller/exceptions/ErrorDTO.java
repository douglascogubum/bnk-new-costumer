package com.zup.bank.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class ErrorDTO {
	
	private String field;
	private String error;
}
