package de.reservo.service.internal;

import java.util.Date;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.reservo.Util;
import de.reservo.dao.AuthDAO;
import de.reservo.dao.ClientDAO;
import de.reservo.dao.EmployeeDAO;
import de.reservo.dao.ServiceProviderDAO;
import de.reservo.enums.EmployeeRole;
import de.reservo.exception.InvalidInputException;
import de.reservo.exception.MailOrLoginExistsException;
import de.reservo.pao.AuthPAO;
import de.reservo.pao.EmployeePAO;
import de.reservo.pao.ServiceProviderPAO;
import de.reservo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthDAO authDAO;

	@Autowired
	private ServiceProviderDAO serviceProviderDAO;
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Autowired
	ClientDAO clientDAO;

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

	@Override
	public void registerClient(AuthPAO pAuthPAO) throws InvalidInputException, MailOrLoginExistsException {
		if (pAuthPAO == null || pAuthPAO.getClient() == null
				|| !Util.stringsNotEmpty(pAuthPAO.getLogin(), pAuthPAO.getPassword(),
						pAuthPAO.getClient().geteMailAddress(), pAuthPAO.getClient().getFamilyName(),
						pAuthPAO.getClient().getFirstName())) {
			throw new InvalidInputException("Unvollständige Eingaben.");
		}
		pAuthPAO.getClient().setAppointments(null);
		pAuthPAO.getClient().setBannedAt(null);
		pAuthPAO.getClient().setBlockEntries(null);
		pAuthPAO.getClient().setClientId(null);
		pAuthPAO.getClient().setNotifications(null);
		pAuthPAO.getClient().setCreatedAt(new Date());
		pAuthPAO.setAuthId(null);
		pAuthPAO.setSalt(null);
		if (authDAO.findOneByLogin(pAuthPAO.getLogin()) != null
				|| clientDAO.findOneByeMailAddress(pAuthPAO.getClient().geteMailAddress()) != null) {
			throw new MailOrLoginExistsException("Benutzer order E-Mail schon vorhanden.");
		}
		authDAO.save(pAuthPAO);
	}

	@Override
	public void registerServiceProvider(AuthPAO pAuthPAO) throws InvalidInputException, MailOrLoginExistsException {
		EmployeePAO manager = pAuthPAO.getEmployee();
		if (manager == null) {
			throw new InvalidInputException("Unvollständige Eingaben.");
		}
		ServiceProviderPAO serviceProvider = manager.getServiceProvider();
		if (pAuthPAO == null || !Util.stringsNotEmpty(serviceProvider.getName(), serviceProvider.getAddress(),
				serviceProvider.getDescription(), serviceProvider.getPhone(), manager.getFirstName(),
				manager.getFamilyName(), pAuthPAO.getLogin(), pAuthPAO.getPassword())) {
			throw new InvalidInputException("Unvollständige Eingaben.");
		}
		serviceProvider.setAppointments(null);
		serviceProvider.setBlockEntries(null);
		serviceProvider.setEmployees(null);
		serviceProvider.setGroups(null);
		serviceProvider.setOpeningTimes(null);
		serviceProvider.setServiceProviderId(null);
		serviceProvider.setServices(null);
		serviceProvider.setVacations(null);
		manager.setAppointments(null);
		manager.setEmployeeGroups(null);
		manager.setEmployeeId(null);
		manager.setRole(EmployeeRole.MANAGER);
		manager.setServices(null);
		pAuthPAO.setAuthId(null);
		pAuthPAO.setSalt(null);
		if (authDAO.findOneByLogin(pAuthPAO.getLogin()) != null) {
			throw new MailOrLoginExistsException("Benutzer schon vorhanden.");
		}
//		serviceProvider = serviceProviderDAO.save(serviceProvider);
		AuthPAO auth = authDAO.save(pAuthPAO);
//		auth.getEmployee().setServiceProvider(serviceProvider);
//		employeeDAO.save(auth.getEmployee());
	}

}
