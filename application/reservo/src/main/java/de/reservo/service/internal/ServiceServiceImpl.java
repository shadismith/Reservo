package de.reservo.service.internal;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mchange.rmi.NotAuthorizedException;

import de.reservo.dao.EmployeeDAO;
import de.reservo.dao.ServiceDAO;
import de.reservo.dto.ServiceGroupEmployeeDTO;
import de.reservo.enums.EmployeeRole;
import de.reservo.exception.InvalidInputException;
import de.reservo.pao.EmployeePAO;
import de.reservo.pao.ServicePAO;
import de.reservo.pao.ServiceProviderPAO;
import de.reservo.service.ServiceService;

@Service
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	private ServiceDAO serviceDAO;

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Set<ServicePAO> getServices(Long pServiceId, Long pServiceProviderId, Object pAuthenticationObject)
			throws InvalidInputException {
		if (pServiceId != null) {
			Set<ServicePAO> retSet = new HashSet<ServicePAO>();
			retSet.add(serviceDAO.findOne(pServiceId));
			return retSet;
		}
		if (pServiceProviderId != null) {
			return serviceDAO.findByServiceProviderServiceProviderId(pServiceProviderId);
		}
		try {
			EmployeePAO employee = (EmployeePAO) pAuthenticationObject;
			return serviceDAO
					.findByServiceProviderServiceProviderId(employee.getServiceProvider().getServiceProviderId());
		} catch (Exception e) {
			throw new InvalidInputException("Fehlende Parameter.");
		}
	}

	@Override
	public void addService(ServicePAO pService, EmployeePAO pEmployeePAO) throws NotAuthorizedException {
		if (pEmployeePAO.getRole() == EmployeeRole.EMPLOYEE) {
			throw new NotAuthorizedException();
		}
		pService.setServiceProvider(new ServiceProviderPAO());
		pService.setServiceId(null);
		pService.getServiceProvider().setServiceProviderId(pEmployeePAO.getServiceProvider().getServiceProviderId());
		serviceDAO.save(pService);
	}

	@Override
	public void deleteService(Long pServiceId, EmployeeRole pRole) throws NotAuthorizedException {
		if (pRole == EmployeeRole.EMPLOYEE) {
			throw new NotAuthorizedException();
		}
		serviceDAO.delete(pServiceId);
	}

	@Override
	public void assignServiceEmployeeOrGroup(ServiceGroupEmployeeDTO pServiceGroupEmployeeDTO, EmployeePAO pEmployeePAO)
			throws NotAuthorizedException {
		if (pEmployeePAO.getRole() == EmployeeRole.EMPLOYEE) {
			throw new NotAuthorizedException();
		}
		ServicePAO service = serviceDAO.findOne(pServiceGroupEmployeeDTO.getServiceId());
		if (service.getServiceProvider().getServiceProviderId() != pEmployeePAO.getServiceProvider()
				.getServiceProviderId()) {
			throw new NotAuthorizedException();
		}
		EmployeePAO employee = employeeDAO.findOne(pServiceGroupEmployeeDTO.getEmployeeId());
		if (employee.getServiceProvider().getServiceProviderId() != pEmployeePAO.getServiceProvider()
				.getServiceProviderId()) {
			throw new NotAuthorizedException();
		}
		if (employee.getServices() == null) {
			employee.setServices(new HashSet<ServicePAO>());
		}
		employee.getServices().add(service);
		employeeDAO.save(employee);
	}

	@Override
	public Set<EmployeePAO> getEmployeesWithService(Long pServiceId) throws NotAuthorizedException {
		return serviceDAO.findOne(pServiceId).getEmployees();
	}

	@Override
	public void removeAssignmentServiceEmployeeOrGroup(ServiceGroupEmployeeDTO pServiceGroupEmployeeDTO,
			EmployeePAO pEmployeePAO) throws NotAuthorizedException {
		if (pEmployeePAO.getRole() == EmployeeRole.EMPLOYEE) {
			throw new NotAuthorizedException();
		}
		ServicePAO service = serviceDAO.findOne(pServiceGroupEmployeeDTO.getServiceId());
		if (service.getServiceProvider().getServiceProviderId() != pEmployeePAO.getServiceProvider()
				.getServiceProviderId()) {
			throw new NotAuthorizedException();
		}
		EmployeePAO employee = employeeDAO.findOne(pServiceGroupEmployeeDTO.getEmployeeId());
		employee.setServices(employee.getServices().stream()
				.filter(emplService -> emplService.getServiceId() != pServiceGroupEmployeeDTO.getServiceId())
				.collect(Collectors.toSet()));
		employeeDAO.save(employee);
	}

}
