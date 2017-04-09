package de.reservo.dao;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import de.reservo.pao.AppointmentPAO;

public interface AppointmentDAO extends CrudRepository<AppointmentPAO, Long> {

	Set<AppointmentPAO> findByClientClientId(Long pClientId);

	Set<AppointmentPAO> findByServiceProviderServiceProviderId(Long pServiceProviderId);

}
