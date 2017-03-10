package de.reservo.pao;

import java.util.Set;

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
	@ManyToMany
	@JoinTable(name = "SERVICE_EMPLOYEEGROUP", joinColumns = @JoinColumn(name = "groupId", referencedColumnName = "groupId"), inverseJoinColumns = @JoinColumn(name = "serviceId", referencedColumnName = "serviceId"))
	private Set<ServicePAO> services;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
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

	public Set<ServicePAO> getServices() {
		return services;
	}

	public void setServices(Set<ServicePAO> services) {
		this.services = services;
	}

}
