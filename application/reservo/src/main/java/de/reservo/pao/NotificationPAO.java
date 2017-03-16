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

	public void setNotificationId(Long pNotificationId) {
		notificationId = pNotificationId;
	}

	public ClientPAO getClient() {
		return client;
	}

	public void setClient(ClientPAO pClient) {
		client = pClient;
	}

	public AppointmentPAO getAppointment() {
		return appointment;
	}

	public void setAppointment(AppointmentPAO pAppointment) {
		appointment = pAppointment;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String pMessage) {
		message = pMessage;
	}

	public Date getSendAt() {
		return sendAt;
	}

	public void setSendAt(Date pSendAt) {
		sendAt = pSendAt;
	}

	public Date getSentAt() {
		return sentAt;
	}

	public void setSentAt(Date pSentAt) {
		sentAt = pSentAt;
	}

	public Integer getAttempts() {
		return attempts;
	}

	public void setAttempts(Integer pAttempts) {
		attempts = pAttempts;
	}

	public NotificationType getType() {
		return type;
	}

	public void setType(NotificationType pType) {
		type = pType;
	}

}
