package de.reservo.dao;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import de.reservo.pao.ServicePAO;

public interface ServiceDAO extends CrudRepository<ServicePAO, Long> {

	Set<ServicePAO> findByServiceProviderServiceProviderId(Long serviceProviderId);
	
}
