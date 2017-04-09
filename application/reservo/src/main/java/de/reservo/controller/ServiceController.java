package de.reservo.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mchange.rmi.NotAuthorizedException;

import de.reservo.Util;
import de.reservo.dto.ServiceGroupEmployeeDTO;
import de.reservo.exception.InvalidInputException;
import de.reservo.pao.EmployeePAO;
import de.reservo.pao.ServicePAO;
import de.reservo.service.ServiceService;

@RestController
@RequestMapping(path = "/service")
public class ServiceController {

	@Autowired
	private ServiceService serviceService;

	@RequestMapping(method = RequestMethod.GET, path = "/get")
	public ResponseEntity<Set<ServicePAO>> getService(
			@RequestParam(required = false, name = "serviceId") Long pServiceId,
			@RequestParam(required = false, name = "serviceProviderId") Long pServiceProviderId,
			HttpServletRequest pRequest) throws InvalidInputException {
		return new ResponseEntity<Set<ServicePAO>>(serviceService.getServices(pServiceId, pServiceProviderId,
				pRequest.getSession().getAttribute(Util.AUTHENTICATION_OBJECT)), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/add")
	public ResponseEntity<Object> addService(@RequestBody ServicePAO pService, HttpServletRequest pRequest)
			throws NotAuthorizedException {
		serviceService.addService(pService,
				((EmployeePAO) pRequest.getSession().getAttribute(Util.AUTHENTICATION_OBJECT)));
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/edit")
	public ResponseEntity<Object> editService(@RequestBody ServicePAO pService) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/delete")
	public ResponseEntity<Object> deleteService(@RequestBody Map<String, Long> pJsonRequest,
			HttpServletRequest pRequest) throws NotAuthorizedException {
		serviceService.deleteService(pJsonRequest.get("serviceId"),
				((EmployeePAO) pRequest.getSession().getAttribute(Util.AUTHENTICATION_OBJECT)).getRole());
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/assignServiceEmployeeOrGroup")
	public ResponseEntity<Object> assignServiceEmployeeOrGroup(
			@RequestBody ServiceGroupEmployeeDTO pServiceGroupEmployeeDTO, HttpServletRequest pRequest)
			throws NotAuthorizedException {
		serviceService.assignServiceEmployeeOrGroup(pServiceGroupEmployeeDTO,
				((EmployeePAO) pRequest.getSession().getAttribute(Util.AUTHENTICATION_OBJECT)));
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/getEmployeesWithService")
	public ResponseEntity<Set<EmployeePAO>> getEmployeesWithService(
			@RequestParam(required = true, name = "serviceId") Long pServiceId, HttpServletRequest pRequest)
			throws NotAuthorizedException {
		return new ResponseEntity<Set<EmployeePAO>>(serviceService.getEmployeesWithService(pServiceId), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/removeAssignmentServiceEmployeeOrGroup")
	public ResponseEntity<Object> removeAssignmentServiceEmployeeOrGroup(
			@RequestBody ServiceGroupEmployeeDTO pServiceGroupEmployeeDTO, HttpServletRequest pRequest)
			throws NotAuthorizedException {
		serviceService.removeAssignmentServiceEmployeeOrGroup(pServiceGroupEmployeeDTO,
				((EmployeePAO) pRequest.getSession().getAttribute(Util.AUTHENTICATION_OBJECT)));
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
