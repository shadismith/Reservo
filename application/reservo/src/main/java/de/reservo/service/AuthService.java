package de.reservo.service;

import javax.naming.AuthenticationException;

import de.reservo.pao.AuthPAO;

public interface AuthService {
	
	Object login(AuthPAO pAuthPAO) throws AuthenticationException;

}
