package de.reservo.dao;

import org.springframework.data.repository.CrudRepository;

import de.reservo.pao.EmployeeGroupPAO;

public interface EmployeeGroupDAO extends CrudRepository<EmployeeGroupPAO, Long>{

}
