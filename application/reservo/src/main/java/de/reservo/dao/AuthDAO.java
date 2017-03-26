package de.reservo.dao;

import org.springframework.data.repository.CrudRepository;

import de.reservo.pao.AuthPAO;

public interface AuthDAO extends CrudRepository<AuthPAO, Long> {
	
	AuthPAO findOneByLoginAndPassword(String login, String password);
	
	AuthPAO findOneByLogin(String login);

}
