package de.reservo.dao;

import org.springframework.data.repository.CrudRepository;

import de.reservo.pao.EmployeePAO;

public interface EmployeeDAO extends CrudRepository<EmployeePAO, Long> {

}
