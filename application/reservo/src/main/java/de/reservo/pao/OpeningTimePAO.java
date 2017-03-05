package de.reservo.pao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OPENING_TIME")
public class OpeningTimePAO {
	
	@Id
	private Long openingTimeId;

}
