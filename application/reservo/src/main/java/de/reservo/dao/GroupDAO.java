package de.reservo.dao;

import org.springframework.data.repository.CrudRepository;

import de.reservo.pao.GroupPAO;

public interface GroupDAO extends CrudRepository<GroupPAO, Long>{

}
