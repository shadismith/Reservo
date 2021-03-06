package de.reservo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.reservo.pao.VacationPAO;

@RestController
@RequestMapping(path = "vacation")
public class VacationController {

	@RequestMapping(method = RequestMethod.GET, path = "/get")
	public ResponseEntity<List<VacationPAO>> getVacations(
			@RequestParam(required = false, name = "startDate") Date pStartDate,
			@RequestParam(required = false, name = "endDate") Date pEndDate,
			@RequestParam(required = false, name = "vacationId") Long pVacationId) {
		return new ResponseEntity<List<VacationPAO>>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/add")
	public ResponseEntity<Object> addVacation(@RequestBody VacationPAO pVacation) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/edit")
	public ResponseEntity<Object> editVacation(@RequestBody VacationPAO pVacation) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/delete")
	public ResponseEntity<Object> deleteVacation(@RequestBody Long pVacationId) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
