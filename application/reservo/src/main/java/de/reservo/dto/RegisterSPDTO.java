package de.reservo.dto;

import de.reservo.pao.EmployeePAO;
import de.reservo.pao.ServiceProviderPAO;

public class RegisterSPDTO {

	private ServiceProviderPAO serviceProvider;
	private EmployeePAO manager;

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

}
