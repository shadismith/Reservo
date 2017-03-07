package de.reservo.pao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import de.reservo.enums.NotificationType;

@Entity
@Table(name = "NOTIFICATION")
public class NotificationPAO {

	@Id
	@GeneratedValue
	private Long notificationId;
	@JoinColumn(name = "clientId", nullable = false, updatable = false, unique = false)
	@ManyToOne
	private ClientPAO client;
	@JoinColumn(name = "appointmentId", nullable = true, updatable = false, unique = false)
	@ManyToOne
	private AppointmentPAO appointment;
	@Column(nullable = false, updatable = false, unique = false)
	private String message;
	@Column(nullable = false, updatable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date sendAt;
	@Column(nullable = true, updatable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date sentAt;
	@Column(nullable = false, updatable = true, unique = false)
	private Integer attempts;
	@Column(nullable = false, updatable = true, unique = false)
	private NotificationType type;

	public Long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}

	public ClientPAO getClient() {
		return client;
	}

	public void setClient(ClientPAO client) {
		this.client = client;
	}

	public AppointmentPAO getAppointment() {
		return appointment;
	}

	public void setAppointment(AppointmentPAO appointment) {
		this.appointment = appointment;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getSendAt() {
		return sendAt;
	}

	public void setSendAt(Date sendAt) {
		this.sendAt = sendAt;
	}

	public Date getSentAt() {
		return sentAt;
	}

	public void setSentAt(Date sentAt) {
		this.sentAt = sentAt;
	}

	public Integer getAttempts() {
		return attempts;
	}

	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}

	public NotificationType getType() {
		return type;
	}

	public void setType(NotificationType type) {
		this.type = type;
	}

}
