package de.reservo.pao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NOTIFICATION")
public class NotificationPAO {
	
	@Id
	private Long notificationId;

}
