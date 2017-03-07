package de.reservo.pao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import de.reservo.enums.OpeningTimeType;

@Entity
@Table(name = "OPENING_TIME")
public class OpeningTimePAO {

	@Id
	@GeneratedValue
	private Long openingTimeId;
	@JoinColumn(name = "serviceProviderId", nullable = false, unique = false, updatable = false)
	@ManyToOne
	private ServiceProviderPAO serviceProvider;
	@Column(nullable = true, unique = false, updatable = true)
	private Byte weekday;
	@Column(nullable = true, unique = false, updatable = true)
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(nullable = false, unique = false, updatable = true)
	@Temporal(TemporalType.TIME)
	private Date startTime;
	@Column(nullable = false, unique = false, updatable = true)
	@Temporal(TemporalType.TIME)
	private Date endTime;
	@Column(nullable = true, unique = false, updatable = true)
	@Temporal(TemporalType.TIME)
	private Date startBreak;
	@Column(nullable = true, unique = false, updatable = true)
	@Temporal(TemporalType.TIME)
	private Date endBreak;
	@Column(nullable = false, unique = false, updatable = false)
	private OpeningTimeType type;

	public Long getOpeningTimeId() {
		return openingTimeId;
	}

	public void setOpeningTimeId(Long openingTimeId) {
		this.openingTimeId = openingTimeId;
	}

	public ServiceProviderPAO getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProviderPAO serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public Byte getWeekday() {
		return weekday;
	}

	public void setWeekday(Byte weekday) {
		this.weekday = weekday;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getStartBreak() {
		return startBreak;
	}

	public void setStartBreak(Date startBreak) {
		this.startBreak = startBreak;
	}

	public Date getEndBreak() {
		return endBreak;
	}

	public void setEndBreak(Date endBreak) {
		this.endBreak = endBreak;
	}

	public OpeningTimeType getType() {
		return type;
	}

	public void setType(OpeningTimeType type) {
		this.type = type;
	}

}
