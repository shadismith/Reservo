package de.reservo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.reservo.pao.ClientPAO;
import de.reservo.pao.ServiceProviderPAO;

@RestController
@RequestMapping(path = "/serviceprovider")
public class ServiceProviderController {

	@RequestMapping(method = RequestMethod.GET, path = "/findByName")
	public ResponseEntity<List<ServiceProviderPAO>> findSPByName(
			@RequestParam(required = true, name = "spName") String pSpName) {
		return new ResponseEntity<List<ServiceProviderPAO>>(HttpStatus.OK);
	}



	@RequestMapping(method = RequestMethod.GET, path = "/getSPList")
	public ResponseEntity<List<ServiceProviderPAO>> getSPList(
			@RequestParam(required = false, name = "count") Long pCount,
			@RequestParam(required = false, name = "page") Long pPage) {
		return new ResponseEntity<List<ServiceProviderPAO>>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/get")
	public ResponseEntity<ServiceProviderPAO> getServiceProvider() {
		return new ResponseEntity<ServiceProviderPAO>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/edit")
	public ResponseEntity<Object> editServiceProvider(@RequestBody ServiceProviderPAO pServiceProvider) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/delete")
	public ResponseEntity<Object> deleteServiceProvider(@RequestBody ServiceProviderPAO pServiceProvider) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/client/block")
	public ResponseEntity<Object> blockClient(@RequestBody Long pClientId) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/client/getBlockedClients")
	public ResponseEntity<List<ClientPAO>> getBlockedClients() {
		return new ResponseEntity<List<ClientPAO>>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/client/unblock")
	public ResponseEntity<Object> unblock() {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
