package de.reservo.dao;

import org.springframework.data.repository.CrudRepository;

import de.reservo.pao.AuthPAO;

public interface AuthDAO extends CrudRepository<AuthPAO, Long> {

}
