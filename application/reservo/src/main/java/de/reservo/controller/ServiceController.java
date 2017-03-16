package de.reservo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.reservo.dto.ServiceGroupEmployeeDTO;
import de.reservo.pao.EmployeePAO;
import de.reservo.pao.ServicePAO;

@RestController
@RequestMapping(path = "/service")
public class ServiceController {

	@RequestMapping(method = RequestMethod.GET, path = "/get")
	public ResponseEntity<List<ServicePAO>> getService(
			@RequestParam(required = false, name = "serviceId") Long pServiceId) {
		return new ResponseEntity<List<ServicePAO>>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/add")
	public ResponseEntity<Object> addService(@RequestBody ServicePAO pService) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/edit")
	public ResponseEntity<Object> editService(@RequestBody ServicePAO pService) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/delete")
	public ResponseEntity<Object> deleteService(@RequestBody Long pServiceId) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/assignServiceEmployeeOrGroup")
	public ResponseEntity<Object> assignServiceEmployeeOrGroup(
			@RequestBody ServiceGroupEmployeeDTO pServiceGroupEmployeeDTO) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/getEmployeesWithService")
	public ResponseEntity<List<EmployeePAO>> getEmployeesWithService(
			@RequestParam(required = true, name = "serviceId") Long pServiceId) {
		return new ResponseEntity<List<EmployeePAO>>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/removeAssignmentServiceEmployeeOrGroup")
	public ResponseEntity<Object> removeAssignmentServiceEmployeeOrGroup(
			@RequestBody ServiceGroupEmployeeDTO pServiceGroupEmployeeDTO) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
