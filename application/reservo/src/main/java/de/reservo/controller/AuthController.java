package de.reservo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.reservo.dto.RegisterSPDTO;
import de.reservo.pao.AuthPAO;
import de.reservo.pao.ClientPAO;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

	@RequestMapping(method = RequestMethod.POST, path = "/login")
	public ResponseEntity<Object> login(@RequestBody(required = true) AuthPAO pAuth) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/logout")
	public ResponseEntity<Object> logout() {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/resetPassword")
	public ResponseEntity<Object> resetPassword(@RequestBody(required = true) AuthPAO pAuth) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/registerServiceProvider")
	public ResponseEntity<Object> registerServiceProvider(@RequestBody(required = true) RegisterSPDTO pRegisterSPDTO) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/registerClient")
	public ResponseEntity<Object> registerClient(@RequestBody(required = true) ClientPAO pClientPAO) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
