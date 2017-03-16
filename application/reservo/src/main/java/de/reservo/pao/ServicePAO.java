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

	public void setServiceId(Long pServiceId) {
		serviceId = pServiceId;
	}

	public ServiceProviderPAO getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProviderPAO pServiceProvider) {
		serviceProvider = pServiceProvider;
	}

	public String getName() {
		return name;
	}

	public void setName(String pName) {
		name = pName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal pPrice) {
		price = pPrice;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String pCurrency) {
		currency = pCurrency;
	}

	public Set<EmployeeGroupPAO> getEmployeeGroups() {
		return employeeGroups;
	}

	public void setEmployeeGroups(Set<EmployeeGroupPAO> pEmployeeGroups) {
		employeeGroups = pEmployeeGroups;
	}

	public Set<EmployeePAO> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeePAO> pEmployees) {
		employees = pEmployees;
	}

	public Set<AppointmentPAO> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<AppointmentPAO> pAppointments) {
		appointments = pAppointments;
	}

}
