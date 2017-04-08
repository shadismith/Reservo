package de.reservo.pao;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<OpeningTimePAO> openingTimes;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceProvider")
	@JsonIgnore
	private Set<EmployeePAO> employees;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceProvider")
	@JsonIgnore
	private Set<VacationPAO> vacations;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceProvider")
	@JsonIgnore
	private Set<EmployeeGroupPAO> groups;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceProvider")
	@JsonIgnore
	private Set<ServicePAO> services;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceProvider")
	@JsonIgnore
	private Set<AppointmentPAO> appointments;
	@OneToMany(mappedBy = "serviceProvider")
	@JsonIgnore
	private Set<BlockEntryPAO> blockEntries;

	public Long getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(Long pServiceProviderId) {
		serviceProviderId = pServiceProviderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String pName) {
		name = pName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String pAddress) {
		address = pAddress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String pDescription) {
		description = pDescription;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String pPhone) {
		phone = pPhone;
	}

	public Set<OpeningTimePAO> getOpeningTimes() {
		return openingTimes;
	}

	public void setOpeningTimes(Set<OpeningTimePAO> pOpeningTimes) {
		openingTimes = pOpeningTimes;
	}

	@JsonIgnore
	public Set<EmployeePAO> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeePAO> pEmployees) {
		employees = pEmployees;
	}

	@JsonIgnore
	public Set<VacationPAO> getVacations() {
		return vacations;
	}

	public void setVacations(Set<VacationPAO> pVacations) {
		vacations = pVacations;
	}

	@JsonIgnore
	public Set<EmployeeGroupPAO> getGroups() {
		return groups;
	}

	public void setGroups(Set<EmployeeGroupPAO> pGroups) {
		groups = pGroups;
	}

	@JsonIgnore
	public Set<ServicePAO> getServices() {
		return services;
	}

	public void setServices(Set<ServicePAO> pServices) {
		services = pServices;
	}

	@JsonIgnore
	public Set<AppointmentPAO> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<AppointmentPAO> pAppointments) {
		appointments = pAppointments;
	}

	@JsonIgnore
	public Set<BlockEntryPAO> getBlockEntries() {
		return blockEntries;
	}

	public void setBlockEntries(Set<BlockEntryPAO> pBlockEntries) {
		blockEntries = pBlockEntries;
	}

}
