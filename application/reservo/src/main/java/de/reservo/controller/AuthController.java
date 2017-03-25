package de.reservo.controller;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.reservo.Constants;
import de.reservo.dto.RegisterSPDTO;
import de.reservo.pao.AuthPAO;
import de.reservo.pao.ClientPAO;
import de.reservo.service.AuthService;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@RequestMapping(method = RequestMethod.POST, path = "/login")
	public ResponseEntity<Object> login(@RequestBody(required = true) AuthPAO pAuth, HttpServletRequest pRequest)
			throws AuthenticationException {
		pRequest.getSession().invalidate();
		HttpSession session = pRequest.getSession();
		session.setAttribute(Constants.AUTHENTICATION_OBJECT, authService.login(pAuth));
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/logout")
	public ResponseEntity<Object> logout(HttpServletRequest pRequest) {
		pRequest.getSession().setAttribute(Constants.AUTHENTICATION_OBJECT, null);
		pRequest.getSession().invalidate();
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
