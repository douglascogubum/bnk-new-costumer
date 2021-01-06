package com.zup.bank.controller.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zup.bank.controller.exceptions.dto.ErrorDTO;

@RestControllerAdvice
public class ResourceExceptions {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorDTO> handleInvalidArguments(MethodArgumentNotValidException exception) {
		List<ErrorDTO> dto = new ArrayList<>();

		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErrorDTO erro = new ErrorDTO(e.getField(), mensagem);
			dto.add(erro);
		});

		return dto;
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> resourceNotFound(DataIntegrityViolationException e, HttpServletRequest request) {
		String error = "Erro na base de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String validationError = "Campo duplicado";
		StandardError err = new StandardError(Instant.now(), status.value(), error, validationError, request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<StandardError> dateInvalid(HttpMessageNotReadableException e, HttpServletRequest request) {
		String error = "Entidade com erros";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String validationError = "Data com formato inválido";
		StandardError err = new StandardError(Instant.now(), status.value(), error, validationError, request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}