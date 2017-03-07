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

import de.reservo.enums.VacationType;

@Entity
@Table(name = "VACATION")
public class VacationPAO {

	@Id
	@GeneratedValue
	private Long vacationId;
	@JoinColumn(name = "serviceProviderId", nullable = false, unique = false, updatable = false)
	@ManyToOne
	private ServiceProviderPAO serviceProvider;
	@JoinColumn(name = "employeeId", nullable = true, unique = false, updatable = false)
	@ManyToOne
	private EmployeePAO employee;
	@Column(nullable = false, unique = false, updatable = true)
	@Temporal(TemporalType.DATE)
	private Date startsAt;
	@Column(nullable = false, unique = false, updatable = true)
	@Temporal(TemporalType.DATE)
	private Date endsAt;
	@Column(nullable = false, unique = false, updatable = false)
	private VacationType type;
	@Column(nullable = false, unique = false, updatable = true)
	private String reason;

	public Long getVacationId() {
		return vacationId;
	}

	public void setVacationId(Long vacationId) {
		this.vacationId = vacationId;
	}

	public ServiceProviderPAO getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProviderPAO serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public EmployeePAO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeePAO employee) {
		this.employee = employee;
	}

	public Date getStartsAt() {
		return startsAt;
	}

	public void setStartsAt(Date startsAt) {
		this.startsAt = startsAt;
	}

	public Date getEndsAt() {
		return endsAt;
	}

	public void setEndsAt(Date endsAt) {
		this.endsAt = endsAt;
	}

	public VacationType getType() {
		return type;
	}

	public void setType(VacationType type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
