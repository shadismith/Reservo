package de.reservo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.reservo.pao.ClientPAO;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

	@RequestMapping(method = RequestMethod.GET, path = "/get")
	public ResponseEntity<ClientPAO> getClient() {
		return new ResponseEntity<ClientPAO>(new ClientPAO(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/edit")
	public ResponseEntity<Object> editClient(@RequestBody(required = true) ClientPAO pClient) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/delete")
	public ResponseEntity<Object> deleteClient() {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
