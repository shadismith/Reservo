package de.reservo.dao;

import org.springframework.data.repository.CrudRepository;

import de.reservo.pao.OpeningTimePAO;

public interface OpeningTimeDAO extends CrudRepository<OpeningTimePAO, Long> {

}
