package de.reservo.service;

import java.util.Date;
import java.util.Set;

import com.mchange.rmi.NotAuthorizedException;

import de.reservo.pao.AppointmentPAO;

public interface AppointmentService {

	Set<AppointmentPAO> getClientAppointments(Date pStartDate, Date pEndDate, Long pAppointmentId, Long pClientId);

	void addClientAppointment(AppointmentPAO pAppointmentPAO, Long pClientId);

	void cancelClientAppointment(Long pAppointmentId, Long pClientId) throws NotAuthorizedException;

}
