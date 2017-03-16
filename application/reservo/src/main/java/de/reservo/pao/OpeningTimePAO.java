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

	public void setOpeningTimeId(Long pOpeningTimeId) {
		openingTimeId = pOpeningTimeId;
	}

	public ServiceProviderPAO getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProviderPAO pServiceProvider) {
		serviceProvider = pServiceProvider;
	}

	public Byte getWeekday() {
		return weekday;
	}

	public void setWeekday(Byte pWeekday) {
		weekday = pWeekday;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date pDate) {
		date = pDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date pStartTime) {
		startTime = pStartTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date pEndTime) {
		endTime = pEndTime;
	}

	public Date getStartBreak() {
		return startBreak;
	}

	public void setStartBreak(Date pStartBreak) {
		startBreak = pStartBreak;
	}

	public Date getEndBreak() {
		return endBreak;
	}

	public void setEndBreak(Date pEndBreak) {
		endBreak = pEndBreak;
	}

	public OpeningTimeType getType() {
		return type;
	}

	public void setType(OpeningTimeType pType) {
		type = pType;
	}

}
