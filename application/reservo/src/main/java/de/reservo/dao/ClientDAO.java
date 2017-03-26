package de.reservo.dao;

import org.springframework.data.repository.CrudRepository;

import de.reservo.pao.ClientPAO;

public interface ClientDAO extends CrudRepository<ClientPAO, Long> {
	
	ClientPAO findOneByeMailAddress(String eMailAddress);

}
