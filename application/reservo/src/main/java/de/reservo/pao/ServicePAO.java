package de.reservo.pao;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICE")
public class ServicePAO {

	@Id
	@GeneratedValue
	private Long serviceId;
	@JoinColumn(name = "serviceProviderId", nullable = false, updatable = false, unique = false)
	@ManyToOne
	private ServiceProviderPAO serviceProvider;
	@Column(nullable = false, unique = false, updatable = true)
	private String name;
	@Column(nullable = false, unique = false, updatable = true)
	private BigDecimal price;
	@Column(nullable = false, unique = false, updatable = true)
	private String currency;
	@ManyToMany(mappedBy = "services")
	private Set<EmployeeGroupPAO> employeeGroups;
	@ManyToMany(mappedBy = "services")
	private Set<EmployeePAO> employees;
	@ManyToMany(mappedBy = "services")
	private Set<AppointmentPAO> appointments;

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public ServiceProviderPAO getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProviderPAO serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Set<EmployeeGroupPAO> getEmployeeGroups() {
		return employeeGroups;
	}

	public void setEmployeeGroups(Set<EmployeeGroupPAO> employeeGroups) {
		this.employeeGroups = employeeGroups;
	}

	public Set<EmployeePAO> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeePAO> employees) {
		this.employees = employees;
	}

	public Set<AppointmentPAO> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<AppointmentPAO> appointments) {
		this.appointments = appointments;
	}

}
