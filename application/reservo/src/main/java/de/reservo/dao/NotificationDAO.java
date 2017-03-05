package de.reservo.dao;

import org.springframework.data.repository.CrudRepository;

import de.reservo.pao.NotificationPAO;

public interface NotificationDAO extends CrudRepository<NotificationPAO, Long> {

}
