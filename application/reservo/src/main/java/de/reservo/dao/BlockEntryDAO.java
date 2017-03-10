package de.reservo.dao;

import org.springframework.data.repository.CrudRepository;

import de.reservo.pao.BlockEntryPAO;

public interface BlockEntryDAO extends CrudRepository<BlockEntryPAO, Long> {

}
