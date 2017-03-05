package de.reservo.dao;

import org.springframework.data.repository.CrudRepository;

import de.reservo.pao.ServiceProviderPAO;

public interface ServiceProviderDAO extends CrudRepository<ServiceProviderPAO, Long> {

}
