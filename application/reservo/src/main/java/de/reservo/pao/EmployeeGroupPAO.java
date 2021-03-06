package de.reservo.pao;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEEGROUP")
public class EmployeeGroupPAO {

	@Id
	@GeneratedValue
	private Long groupId;
	@JoinColumn(name = "serviceProviderId", nullable = false, unique = false, updatable = false)
	@ManyToOne
	private ServiceProviderPAO serviceProvider;
	@Column(updatable = true, nullable = false, unique = false)
	private String name;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "SERVICE_EMPLOYEEGROUP", joinColumns = @JoinColumn(name = "groupId", referencedColumnName = "groupId"), inverseJoinColumns = @JoinColumn(name = "serviceId", referencedColumnName = "serviceId"))
	private Set<ServicePAO> services;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "GROUP_EMPLOYEEGROUP", joinColumns = @JoinColumn(name = "groupId", referencedColumnName = "groupId"), inverseJoinColumns = @JoinColumn(name = "employeeId", referencedColumnName = "employeeId"))
	private Set<EmployeePAO> employees;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long pGroupId) {
		groupId = pGroupId;
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

	public Set<ServicePAO> getServices() {
		return services;
	}

	public void setServices(Set<ServicePAO> pServices) {
		services = pServices;
	}

	public Set<EmployeePAO> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeePAO> pEmployees) {
		employees = pEmployees;
	}

}
