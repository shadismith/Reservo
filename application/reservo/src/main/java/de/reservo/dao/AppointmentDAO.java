package de.reservo.dao;

import org.springframework.data.repository.CrudRepository;

import de.reservo.pao.AppointmentPAO;

public interface AppointmentDAO extends CrudRepository<AppointmentPAO, Long> {

}
