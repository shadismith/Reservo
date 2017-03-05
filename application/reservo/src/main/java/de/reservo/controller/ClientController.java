package de.reservo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.reservo.pao.ClientPAO;

@Controller
@RequestMapping(path = "/client")
public class ClientController {

	@RequestMapping(method = RequestMethod.GET, path = "/get")
	public @ResponseBody ResponseEntity<ClientPAO> get() {
		return new ResponseEntity<ClientPAO>(new ClientPAO(), HttpStatus.OK);
	}

}
