package de.reservo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.reservo.dto.RegisterClientDTO;
import de.reservo.dto.RegisterSPDTO;
import de.reservo.pao.AuthPAO;

@Controller
@RequestMapping(path = "/auth")
public class AuthController {

	@RequestMapping(method = RequestMethod.POST, path = "/login")
	public ResponseEntity<Object> login(@RequestBody AuthPAO pAuth) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/logout")
	public ResponseEntity<Object> logout() {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/resetPassword")
	public ResponseEntity<Object> resetPassword(@RequestBody AuthPAO pAuth) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/registerServiceProvider")
	public ResponseEntity<Object> registerServiceProvider(@RequestBody RegisterSPDTO pRegisterSPDTO) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/registerClient")
	public ResponseEntity<Object> registerClient(@RequestBody RegisterClientDTO pRegisterClientDTO) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
