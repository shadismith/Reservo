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

@Entity
@Table(name = "BLOCK_ENTRY")
public class BlockEntryPAO {

	@Id
	@GeneratedValue
	private Long blockEntryId;
	@JoinColumn(name = "clientId", nullable = false, unique = false, updatable = false)
	@ManyToOne
	private ClientPAO client;
	@JoinColumn(name = "serviceProviderId", nullable = false, unique = false, updatable = false)
	@ManyToOne
	private ServiceProviderPAO serviceProvider;
	@Column(nullable = false, unique = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	@Column(nullable = false, unique = false, updatable = false)
	private String reason;

	public Long getBlockEntryId() {
		return blockEntryId;
	}

	public void setBlockEntryId(Long blockEntryId) {
		this.blockEntryId = blockEntryId;
	}

	public ClientPAO getClient() {
		return client;
	}

	public void setClient(ClientPAO client) {
		this.client = client;
	}

	public ServiceProviderPAO getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProviderPAO serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
