package de.reservo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.reservo.dto.RegisterEmployeeDTO;
import de.reservo.pao.EmployeePAO;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

	@RequestMapping(method = RequestMethod.GET, path = "/get")
	public ResponseEntity<List<EmployeePAO>> getEmployee(
			@RequestParam(required = false, name = "employeeId") Long pEmployeeId) {
		return new ResponseEntity<List<EmployeePAO>>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/add")
	public ResponseEntity<Object> addEmployee(
			@RequestBody RegisterEmployeeDTO pRegisterEmployeeDTO) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/edit")
	public ResponseEntity<Object> editEmployee(
			@RequestBody EmployeePAO pEmployee) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/delete")
	public ResponseEntity<Object> deleteEmployee(
			@RequestBody Long pEmployeeId) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
