package de.reservo.pao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICE_PROVIDER")
public class ServiceProviderPAO {

	@Id
	private Long serviceProviderId;
	
}
