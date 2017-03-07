package de.reservo.pao;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CLIENT")
public class ClientPAO {

	@Id
	@GeneratedValue
	@Column(unique = true, updatable = false, nullable = false)
	private Long clientId;
	@Column(unique = false, updatable = true, nullable = false)
	private String firstName;
	@Column(unique = false, updatable = true, nullable = false)
	private String familyName;
	@Column(unique = false, updatable = true, nullable = false)
	private String eMailAddress;
	@Column(unique = false, updatable = false, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	@Column(unique = false, updatable = true, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date bannedAt;
	@OneToMany(mappedBy = "appointmentId")
	private Set<AppointmentPAO> appointments;
	@OneToMany(mappedBy = "notificationId")
	private Set<NotificationPAO> notifications;

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String geteMailAddress() {
		return eMailAddress;
	}

	public void seteMailAddress(String eMailAddress) {
		this.eMailAddress = eMailAddress;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getBannedAt() {
		return bannedAt;
	}

	public void setBannedAt(Date bannedAt) {
		this.bannedAt = bannedAt;
	}

	public Set<AppointmentPAO> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<AppointmentPAO> appointments) {
		this.appointments = appointments;
	}

	public Set<NotificationPAO> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<NotificationPAO> notifications) {
		this.notifications = notifications;
	}

}
