package de.reservo.pao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CLIENT")
public class ClientPAO {

	@Id
	@Column(unique = true, updatable = false, nullable = false, insertable = false)
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

}
