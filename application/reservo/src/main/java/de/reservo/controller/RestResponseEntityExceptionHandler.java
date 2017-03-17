package de.reservo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import de.reservo.exception.InvalidInputException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = InvalidInputException.class)
	protected ResponseEntity<Object> handleConflict(InvalidInputException pInvalidInputException, WebRequest request) {
		return new ResponseEntity<Object>("Die Anfrage enthielt ungültige/unvollständige Daten.", HttpStatus.BAD_REQUEST);
	}

}
