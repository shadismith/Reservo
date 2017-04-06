package de.reservo.service.internal;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mchange.rmi.NotAuthorizedException;

import de.reservo.dao.AppointmentDAO;
import de.reservo.dao.ClientDAO;
import de.reservo.enums.AppointmentState;
import de.reservo.pao.AppointmentPAO;
import de.reservo.pao.ClientPAO;
import de.reservo.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentDAO appointmentDAO;

	@Autowired
	private ClientDAO clientDAO;

	@Override
	public Set<AppointmentPAO> getClientAppointments(Date pStartDate, Date pEndDate, Long pAppointmentId,
			Long pClientId) {
		// ClientPAO client = clientDAO.findOne(pClientId);
		// Set<AppointmentPAO> appointments = client.getAppointments();
		// return appointments;
		return appointmentDAO.findByClientClientId(pClientId);
	}

	@Override
	public void addClientAppointment(AppointmentPAO pAppointmentPAO, Long pClientId) {
		pAppointmentPAO.setClient(new ClientPAO());
		pAppointmentPAO.getClient().setClientId(pClientId);
		pAppointmentPAO.setState(AppointmentState.PLANNED);
		appointmentDAO.save(pAppointmentPAO);
	}

	@Override
	public void cancelClientAppointment(Long pAppointmentId, Long pClientId) throws NotAuthorizedException {
		AppointmentPAO appointment = appointmentDAO.findOne(pAppointmentId);
		if (appointment.getClient().getClientId() == pClientId) {
			appointment.setState(AppointmentState.CANCELLED);
			appointmentDAO.save(appointment);
		} else {
			throw new NotAuthorizedException();
		}
	}

}
