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
	@OneToMany(cascade = CascadeType.ALL)
	private Set<EmployeePAO> employees;
	@OneToMany(mappedBy = "vacationId", cascade = CascadeType.ALL)//TODO evtl entfernen, wie bei employees auch
	private Set<VacationPAO> vacations;
	@OneToMany(mappedBy = "groupId", cascade = CascadeType.ALL)
	private Set<EmployeeGroupPAO> groups;
	@OneToMany(mappedBy = "serviceId", cascade = CascadeType.ALL)
	private Set<ServicePAO> services;
	@OneToMany(mappedBy = "appointmentId", cascade = CascadeType.ALL)
	private Set<AppointmentPAO> appointments;
	@OneToMany(mappedBy = "blockEntryId")
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

	public Set<EmployeePAO> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeePAO> pEmployees) {
		employees = pEmployees;
	}

	public Set<VacationPAO> getVacations() {
		return vacations;
	}

	public void setVacations(Set<VacationPAO> pVacations) {
		vacations = pVacations;
	}

	public Set<EmployeeGroupPAO> getGroups() {
		return groups;
	}

	public void setGroups(Set<EmployeeGroupPAO> pGroups) {
		groups = pGroups;
	}

	public Set<ServicePAO> getServices() {
		return services;
	}

	public void setServices(Set<ServicePAO> pServices) {
		services = pServices;
	}

	public Set<AppointmentPAO> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<AppointmentPAO> pAppointments) {
		appointments = pAppointments;
	}

	public Set<BlockEntryPAO> getBlockEntries() {
		return blockEntries;
	}

	public void setBlockEntries(Set<BlockEntryPAO> pBlockEntries) {
		blockEntries = pBlockEntries;
	}

}
