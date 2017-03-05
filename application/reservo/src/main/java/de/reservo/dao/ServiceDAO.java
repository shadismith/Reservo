package de.reservo.dao;

import org.springframework.data.repository.CrudRepository;

import de.reservo.pao.ServicePAO;

public interface ServiceDAO extends CrudRepository<ServicePAO, Long> {

}
