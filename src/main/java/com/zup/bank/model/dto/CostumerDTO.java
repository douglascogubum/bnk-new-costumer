package com.zup.bank.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.zup.bank.model.validation.CpfConstraint;

import lombok.Data;

@Data
public class CostumerDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank
	private String name;
	
	@Email
	@Column(unique = true)
	private String email;
	
	@CpfConstraint
	@Column(unique = true)
	private String cpf;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name = "birth_date")
	private LocalDate birthDate;
}
