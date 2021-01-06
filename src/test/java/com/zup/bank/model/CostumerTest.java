package com.zup.bank.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CostumerTest {
	
	private Long id;
	private String name;
	private String email;
	private String cpf;
	private LocalDate birthDate;
	private Costumer costumer;

	@BeforeEach
	public void setUp( ) {
		id = 1L;
		name = "Douglas Cogubum";
		email = "doug.cogubum@gmail.com";
		cpf = "357.672.271-87";
		birthDate = stringToLocalDateConverter( "15/05/1983");
		costumer = new Costumer(id, name, email, cpf, birthDate);
	}
	
	
	@Test
	public void CostumerClassTest() {
		assertThat(costumer.getName(), equalTo(name));
		assertThat(costumer.getCpf(), equalTo(cpf));
		assertThat(costumer.getEmail(), equalTo(email));
		assertThat(costumer.getBirthDate(), equalTo(birthDate));
	}

	private static LocalDate stringToLocalDateConverter(String birthDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(birthDate, formatter);
	}
}
