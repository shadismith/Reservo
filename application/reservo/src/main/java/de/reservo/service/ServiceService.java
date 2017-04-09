package de.reservo.service;

import java.util.Set;

import com.mchange.rmi.NotAuthorizedException;

import de.reservo.dto.ServiceGroupEmployeeDTO;
import de.reservo.enums.EmployeeRole;
import de.reservo.exception.InvalidInputException;
import de.reservo.pao.EmployeePAO;
import de.reservo.pao.ServicePAO;

public interface ServiceService {

	Set<ServicePAO> getServices(Long pServiceId, Long pServiceProviderId, Object pAuthenticationObject) throws InvalidInputException;

	void addService(ServicePAO pService, EmployeePAO pEmployeePAO) throws NotAuthorizedException;

	void deleteService(Long pLong, EmployeeRole pRole) throws NotAuthorizedException;

	void assignServiceEmployeeOrGroup(ServiceGroupEmployeeDTO pServiceGroupEmployeeDTO, EmployeePAO pEmployeePAO) throws NotAuthorizedException;

	Set<EmployeePAO> getEmployeesWithService(Long pServiceId) throws NotAuthorizedException;

	void removeAssignmentServiceEmployeeOrGroup(ServiceGroupEmployeeDTO pServiceGroupEmployeeDTO,
			EmployeePAO pEmployeePAO) throws NotAuthorizedException;

}
