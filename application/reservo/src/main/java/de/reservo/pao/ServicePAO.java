package de.reservo.pao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICE")
public class ServicePAO {

	@Id
	private Long serviceId;
	
}
