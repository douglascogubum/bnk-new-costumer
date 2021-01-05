package com.zup.bank.model.validation;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;

public class CpfValidator implements 
 ConstraintValidator<CpfConstraint, String>{

	@Override
    public void initialize(CpfConstraint cpf) {
    }
 
	@Override
    public boolean isValid(String cpf, ConstraintValidatorContext cxt) {
		if(cpf == null) return false;
		
		CPFValidator cpfValidator = new CPFValidator();
		List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf); 
		return erros.size() == 0; 
    }
}
