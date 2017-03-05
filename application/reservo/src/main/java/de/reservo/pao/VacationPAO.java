package de.reservo.pao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VACATION")
public class VacationPAO {

	@Id
	private Long vacationId;

}
