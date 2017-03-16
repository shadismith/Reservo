package de.reservo.pao;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	@OneToMany(mappedBy = "blockEntryId")
	private Set<BlockEntryPAO> blockEntries;
	@OneToOne(fetch = FetchType.LAZY)
	private AuthPAO auth;

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long pClientId) {
		clientId = pClientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String pFirstName) {
		firstName = pFirstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String pFamilyName) {
		familyName = pFamilyName;
	}

	public String geteMailAddress() {
		return eMailAddress;
	}

	public void seteMailAddress(String pEMailAddress) {
		eMailAddress = pEMailAddress;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date pCreatedAt) {
		createdAt = pCreatedAt;
	}

	public Date getBannedAt() {
		return bannedAt;
	}

	public void setBannedAt(Date pBannedAt) {
		bannedAt = pBannedAt;
	}

	public Set<AppointmentPAO> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<AppointmentPAO> pAppointments) {
		appointments = pAppointments;
	}

	public Set<NotificationPAO> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<NotificationPAO> pNotifications) {
		notifications = pNotifications;
	}

	public Set<BlockEntryPAO> getBlockEntries() {
		return blockEntries;
	}

	public void setBlockEntries(Set<BlockEntryPAO> pBlockEntries) {
		blockEntries = pBlockEntries;
	}

	public AuthPAO getAuth() {
		return auth;
	}

	public void setAuth(AuthPAO pAuth) {
		auth = pAuth;
	}

}
