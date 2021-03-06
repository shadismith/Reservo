package de.reservo.controller;

import java.util.Date;
import java.util.List;
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
import de.reservo.pao.AppointmentPAO;
import de.reservo.pao.ClientPAO;
import de.reservo.pao.EmployeePAO;
import de.reservo.service.AppointmentService;

@RestController
@RequestMapping(path = "/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@RequestMapping(method = RequestMethod.GET, path = "/client/get")
	public ResponseEntity<Set<AppointmentPAO>> getClientAppointment(
			@RequestParam(required = false, name = "startDate") Date pStartDate,
			@RequestParam(required = false, name = "endDate") Date pEndDate,
			@RequestParam(required = false, name = "appointmentId") Long pAppointmentId, HttpServletRequest pRequest) {
		return new ResponseEntity<Set<AppointmentPAO>>(
				appointmentService.getClientAppointments(pStartDate, pEndDate, pAppointmentId,
						((ClientPAO) pRequest.getSession().getAttribute(Util.AUTHENTICATION_OBJECT)).getClientId()),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/client/add")
	public ResponseEntity<Object> addClientAppointment(@RequestBody AppointmentPAO pAppointmentPAO,
			HttpServletRequest pRequest) {
		appointmentService.addClientAppointment(pAppointmentPAO,
				((ClientPAO) pRequest.getSession().getAttribute(Util.AUTHENTICATION_OBJECT)).getClientId());
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/client/edit")
	public ResponseEntity<Object> editClientAppointment(@RequestBody AppointmentPAO pAppointmentPAO) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/client/cancel")
	public ResponseEntity<Object> cancelClientAppointment(@RequestBody Map<String, Long> pJsonRequest,
			HttpServletRequest pRequest) throws NotAuthorizedException {
		appointmentService.cancelClientAppointment(pJsonRequest.get("appointmentId"),
				((ClientPAO) pRequest.getSession().getAttribute(Util.AUTHENTICATION_OBJECT)).getClientId());
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/serviceprovider/get")
	public ResponseEntity<Set<AppointmentPAO>> getSPAppointment(
			@RequestParam(required = false, name = "startDate") Date pStartDate,
			@RequestParam(required = false, name = "endDate") Date pEndDate,
			@RequestParam(required = false, name = "appointmentId") Long pAppointmentId, HttpServletRequest pRequest) {
		return new ResponseEntity<Set<AppointmentPAO>>(appointmentService.getSPAppointment(pStartDate, pEndDate,
				pAppointmentId, ((EmployeePAO) pRequest.getSession().getAttribute(Util.AUTHENTICATION_OBJECT))
						.getServiceProvider().getServiceProviderId()),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/serviceprovider/add")
	public ResponseEntity<Object> addSPAppointment(@RequestBody AppointmentPAO pAppointmentPAO,
			HttpServletRequest pRequest) {
		appointmentService.addSPAppointment(pAppointmentPAO,
				((EmployeePAO) pRequest.getSession().getAttribute(Util.AUTHENTICATION_OBJECT)).getServiceProvider()
						.getServiceProviderId());
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/serviceprovider/edit")
	public ResponseEntity<Object> editSPAppointment(@RequestBody AppointmentPAO pAppointmentPAO) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/serviceprovider/delete")
	public ResponseEntity<Object> deleteSPAppointment(@RequestBody Map<String, Long> pJsonRequest,
			HttpServletRequest pRequest) throws NotAuthorizedException {
		appointmentService.deleteSPAppointment(Long.valueOf(pJsonRequest.get("appointmentId")),
				((EmployeePAO) pRequest.getSession().getAttribute(Util.AUTHENTICATION_OBJECT)).getServiceProvider()
						.getServiceProviderId());
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/serviceprovider/findByClientName")
	public ResponseEntity<List<AppointmentPAO>> findAppointmentsByClientName(
			@RequestParam(required = true, name = "name") String pName) {
		return new ResponseEntity<List<AppointmentPAO>>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/getSPAppointments")
	public ResponseEntity<List<AppointmentPAO>> getSPAppointments(
			@RequestParam(required = false, name = "serviceProviderId") Long pServiceProviderId,
			@RequestParam(required = false, name = "startDate") Date pStartDate,
			@RequestParam(required = false, name = "endDate") Date pEndDate) {
		return new ResponseEntity<List<AppointmentPAO>>(HttpStatus.OK);
	}

}
