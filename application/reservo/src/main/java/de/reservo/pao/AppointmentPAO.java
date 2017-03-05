package de.reservo.pao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APPOINTMENT")
public class AppointmentPAO {
	
	@Id
	private Long appointmentId;
	
}
