package de.reservo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.reservo.dto.GroupEmployeeDTO;
import de.reservo.pao.EmployeeGroupPAO;
import de.reservo.pao.EmployeePAO;

@RestController
@RequestMapping(path = "/group")
public class GroupController {

	@RequestMapping(method = RequestMethod.GET, path = "/get")
	public ResponseEntity<List<EmployeeGroupPAO>> editGroup(
			@RequestParam(required = false, name = "groupId") Long pGroupId) {
		return new ResponseEntity<List<EmployeeGroupPAO>>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/add")
	public ResponseEntity<Object> addGroup(@RequestBody EmployeeGroupPAO pEmployeeGroup) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/edit")
	public ResponseEntity<Object> editGroup(@RequestBody EmployeeGroupPAO pEmployeeGroup) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/delete")
	public ResponseEntity<Object> deleteGroup(@RequestBody Long pGroupId) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/assignGroupEmployee")
	public ResponseEntity<Object> assignGroupEmployee(@RequestBody GroupEmployeeDTO pGroupEmployeeDTO) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/getEmployeesInGroup")
	public ResponseEntity<List<EmployeePAO>> getEmployeesInGroup(
			@RequestParam(required = true, name = "groupId") Long pGroupId) {
		return new ResponseEntity<List<EmployeePAO>>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/removeAssignmentGroupEmployee")
	public ResponseEntity<Object> removeAssignmentGroupEmployee(@RequestBody GroupEmployeeDTO pGroupEmployeeDTO) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
