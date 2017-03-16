package de.reservo.dto;

import de.reservo.pao.AuthPAO;
import de.reservo.pao.EmployeePAO;
import de.reservo.pao.ServiceProviderPAO;

public class RegisterSPDTO {

	private ServiceProviderPAO serviceProvider;
	private EmployeePAO manager;
	private AuthPAO auth;

	public ServiceProviderPAO getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProviderPAO serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public EmployeePAO getManager() {
		return manager;
	}

	public void setManager(EmployeePAO manager) {
		this.manager = manager;
	}

	public AuthPAO getAuth() {
		return auth;
	}

	public void setAuth(AuthPAO auth) {
		this.auth = auth;
	}

}
