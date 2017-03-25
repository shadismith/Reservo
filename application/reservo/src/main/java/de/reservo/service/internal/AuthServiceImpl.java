package de.reservo.service.internal;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.reservo.dao.AuthDAO;
import de.reservo.pao.AuthPAO;
import de.reservo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private AuthDAO authDAO;

	@Override
	public Object login(AuthPAO pAuthPAO) throws AuthenticationException {
		AuthPAO authenticationResult = authDAO.findOneByLoginAndPassword(pAuthPAO.getLogin(), pAuthPAO.getPassword());
		if (authenticationResult == null) {
			throw new AuthenticationException("Fehlerhafte Anmeldeinformationen.");
		}
		if (authenticationResult.getClient() != null) {
			return authenticationResult.getClient();
		}
		if (authenticationResult.getEmployee() != null) {
			return authenticationResult.getEmployee();
		}
		throw new AuthenticationException("Kein Client oder Employee gefunden.");
	}

}
