package de.reservo.pao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GROUP")
public class GroupPAO {
	
	@Id
	private Long groupId;

}
