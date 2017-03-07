package de.reservo.pao;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICE_PROVIDER")
public class ServiceProviderPAO {

	@Id
	@GeneratedValue
	@Column(unique = true, updatable = false, nullable = false)
	private Long serviceProviderId;
	@Column(unique = false, updatable = true, nullable = false)
	private String name;
	@Column(unique = false, updatable = true, nullable = false)
	private String address;
	@Column(unique = false, updatable = true, nullable = false)
	private String description;
	@Column(unique = true, updatable = true, nullable = false)
	private String phone;
	@OneToMany(mappedBy = "openingTimeId", cascade = CascadeType.ALL)
	private Set<OpeningTimePAO> openingTimes;
	@OneToMany(mappedBy = "employeeId", cascade = CascadeType.ALL)
	private Set<EmployeePAO> employees;
	@OneToMany(mappedBy = "vacationId", cascade = CascadeType.ALL)
	private Set<VacationPAO> vacations;
	@OneToMany(mappedBy = "groupId", cascade = CascadeType.ALL)
	private Set<EmployeeGroupPAO> groups;
	@OneToMany(mappedBy = "serviceId", cascade = CascadeType.ALL)
	private Set<ServicePAO> services;
	@OneToMany(mappedBy = "appointmentId", cascade = CascadeType.ALL)
	private Set<AppointmentPAO> appointments;

	public Long getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(Long serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<OpeningTimePAO> getOpeningTimes() {
		return openingTimes;
	}

	public void setOpeningTimes(Set<OpeningTimePAO> openingTimes) {
		this.openingTimes = openingTimes;
	}

	public Set<EmployeePAO> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeePAO> employees) {
		this.employees = employees;
	}

	public Set<VacationPAO> getVacations() {
		return vacations;
	}

	public void setVacations(Set<VacationPAO> vacations) {
		this.vacations = vacations;
	}

	public Set<EmployeeGroupPAO> getGroups() {
		return groups;
	}

	public void setGroups(Set<EmployeeGroupPAO> groups) {
		this.groups = groups;
	}

	public Set<ServicePAO> getServices() {
		return services;
	}

	public void setServices(Set<ServicePAO> services) {
		this.services = services;
	}

	public Set<AppointmentPAO> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<AppointmentPAO> appointments) {
		this.appointments = appointments;
	}

}
