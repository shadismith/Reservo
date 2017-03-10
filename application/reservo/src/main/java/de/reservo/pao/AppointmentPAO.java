package de.reservo.pao;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import de.reservo.enums.AppointmentState;

@Entity
@Table(name = "APPOINTMENT")
public class AppointmentPAO {

	@Id
	@GeneratedValue
	private Long appointmentId;
	@JoinColumn(name = "clientId", nullable = true, unique = false, updatable = true)
	@ManyToOne
	private ClientPAO client;
	@JoinColumn(name = "serviceProviderId", nullable = false, unique = false, updatable = false)
	@ManyToOne
	private ServiceProviderPAO serviceProvider;
	@JoinColumn(name = "employeeId", nullable = false, unique = false, updatable = true)
	@ManyToOne
	private EmployeePAO employee;
	@Column(nullable = true, updatable = true, unique = false)
	private String customerInfo;
	@Column(nullable = false, updatable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date startsAt;
	@Column(nullable = false, updatable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date endsAt;
	@Column(nullable = true, updatable = true, unique = false)
	private String description;
	@Column(nullable = false, updatable = true, unique = false)
	private AppointmentState state;
	@OneToMany(mappedBy = "notificationId")
	private Set<NotificationPAO> notifications;
	@ManyToMany
	@JoinTable(name = "APPOINTMENT_SERVICE", joinColumns = @JoinColumn(name = "appointmentId", referencedColumnName = "appointmentId"), inverseJoinColumns = @JoinColumn(name = "serviceId", referencedColumnName = "serviceId"))
	private Set<ServicePAO> services;

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
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

	public EmployeePAO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeePAO employee) {
		this.employee = employee;
	}

	public String getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(String customerInfo) {
		this.customerInfo = customerInfo;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AppointmentState getState() {
		return state;
	}

	public void setState(AppointmentState state) {
		this.state = state;
	}

	public Set<NotificationPAO> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<NotificationPAO> notifications) {
		this.notifications = notifications;
	}

	public Set<ServicePAO> getServices() {
		return services;
	}

	public void setServices(Set<ServicePAO> services) {
		this.services = services;
	}

}
