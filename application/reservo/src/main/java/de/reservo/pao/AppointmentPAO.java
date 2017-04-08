package de.reservo.pao;

import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@OneToMany(mappedBy = "appointment")
	private Set<NotificationPAO> notifications;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "APPOINTMENT_SERVICE", joinColumns = @JoinColumn(name = "appointmentId", referencedColumnName = "appointmentId"), inverseJoinColumns = @JoinColumn(name = "serviceId", referencedColumnName = "serviceId"))
	private Set<ServicePAO> services;

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long pAppointmentId) {
		appointmentId = pAppointmentId;
	}

	public ClientPAO getClient() {
		return client;
	}

	public void setClient(ClientPAO pClient) {
		client = pClient;
	}

	public ServiceProviderPAO getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProviderPAO pServiceProvider) {
		serviceProvider = pServiceProvider;
	}

	public EmployeePAO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeePAO pEmployee) {
		employee = pEmployee;
	}

	public String getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(String pCustomerInfo) {
		customerInfo = pCustomerInfo;
	}

	public Date getStartsAt() {
		return startsAt;
	}

	public void setStartsAt(Date pStartsAt) {
		startsAt = pStartsAt;
	}

	public Date getEndsAt() {
		return endsAt;
	}

	public void setEndsAt(Date pEndsAt) {
		endsAt = pEndsAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String pDescription) {
		description = pDescription;
	}

	public AppointmentState getState() {
		return state;
	}

	public void setState(AppointmentState pState) {
		state = pState;
	}

	@JsonIgnore
	public Set<NotificationPAO> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<NotificationPAO> pNotifications) {
		notifications = pNotifications;
	}

	public Set<ServicePAO> getServices() {
		return services;
	}

	public void setServices(Set<ServicePAO> pServices) {
		services = pServices;
	}

}
