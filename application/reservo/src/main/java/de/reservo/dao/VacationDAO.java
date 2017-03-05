package de.reservo.dao;

import org.springframework.data.repository.CrudRepository;

import de.reservo.pao.VacationPAO;

public interface VacationDAO extends CrudRepository<VacationPAO, Long>{

}
