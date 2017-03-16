package de.reservo.pao;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import de.reservo.enums.EmployeeRole;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeePAO {

	@Id
	@GeneratedValue
	private Long employeeId;
	@JoinColumn(name = "serviceProviderId", nullable = false, unique = false, updatable = false)
	@ManyToOne
	private ServiceProviderPAO serviceProvider;
	@Column(nullable = false, unique = false, updatable = true)
	private EmployeeRole role;
	@Column(nullable = false, unique = false, updatable = true)
	private String firstName;
	@Column(nullable = false, unique = false, updatable = true)
	private String familyName;
	@OneToMany(mappedBy = "appointmentId")
	private Set<AppointmentPAO> appointments;
	@ManyToMany(mappedBy = "employees")
	private Set<EmployeeGroupPAO> employeeGroups;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "SERVICE_EMPLOYEE", joinColumns = @JoinColumn(name = "employeeId", referencedColumnName = "employeeId"), inverseJoinColumns = @JoinColumn(name = "serviceId", referencedColumnName = "serviceId"))
	private Set<ServicePAO> services;
	@OneToOne(fetch = FetchType.LAZY)
	private AuthPAO auth;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long pEmployeeId) {
		employeeId = pEmployeeId;
	}

	public ServiceProviderPAO getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProviderPAO pServiceProvider) {
		serviceProvider = pServiceProvider;
	}

	public EmployeeRole getRole() {
		return role;
	}

	public void setRole(EmployeeRole pRole) {
		role = pRole;
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

	public Set<AppointmentPAO> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<AppointmentPAO> pAppointments) {
		appointments = pAppointments;
	}

	public Set<EmployeeGroupPAO> getEmployeeGroups() {
		return employeeGroups;
	}

	public void setEmployeeGroups(Set<EmployeeGroupPAO> pEmployeeGroups) {
		employeeGroups = pEmployeeGroups;
	}

	public Set<ServicePAO> getServices() {
		return services;
	}

	public void setServices(Set<ServicePAO> pServices) {
		services = pServices;
	}

	public AuthPAO getAuth() {
		return auth;
	}

	public void setAuth(AuthPAO pAuth) {
		auth = pAuth;
	}

}
