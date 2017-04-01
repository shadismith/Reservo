package de.reservo.service;

import javax.naming.AuthenticationException;

import de.reservo.exception.InvalidInputException;
import de.reservo.exception.MailOrLoginExistsException;
import de.reservo.pao.AuthPAO;

public interface AuthService {
	
	Object login(AuthPAO pAuthPAO) throws AuthenticationException;

	void registerClient(AuthPAO pAuthPAO) throws InvalidInputException, MailOrLoginExistsException;

	void registerServiceProvider(AuthPAO pAuthPAO) throws InvalidInputException, MailOrLoginExistsException;

}
