package de.reservo.controller;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mchange.rmi.NotAuthorizedException;

import de.reservo.exception.InvalidInputException;
import de.reservo.exception.MailOrLoginExistsException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = InvalidInputException.class)
	protected ResponseEntity<Object> handleConflict(InvalidInputException pInvalidInputException, WebRequest request) {
		return new ResponseEntity<Object>(pInvalidInputException.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = MailOrLoginExistsException.class)
	protected ResponseEntity<Object> handleConflict(MailOrLoginExistsException pMailOrLoginExistsException, WebRequest request) {
		return new ResponseEntity<Object>(pMailOrLoginExistsException.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = AuthenticationException.class)
	protected ResponseEntity<Object> handleConflict(AuthenticationException pAuthenticationException, WebRequest request) {
		return new ResponseEntity<Object>(pAuthenticationException.getMessage(), HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(value = NotAuthorizedException.class)
	protected ResponseEntity<Object> handleConflict(NotAuthorizedException pNotAuthorizedException, WebRequest request) {
		return new ResponseEntity<Object>(pNotAuthorizedException.getMessage(), HttpStatus.FORBIDDEN);
	}

}
