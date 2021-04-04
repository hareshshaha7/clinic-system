package clinic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Haresh Shaha
 * @since 04-Apr-2021
 *
 */
public class ClinicCalendar {
	private List<PatientAppointment> appointments;

	/**
	 * @param appointments
	 */
	public ClinicCalendar() {
		this.appointments = new ArrayList<PatientAppointment>();
	}

	public void addAppointment(String patientFisrtName, String patientLastName, String doctorKey, String dateTime) {
		Doctor doctor = Doctor.valueOf(doctorKey.toLowerCase());
		LocalDateTime localDateTime;
		
		try {
			localDateTime = LocalDateTime.parse(dateTime.toUpperCase(),
					DateTimeFormatter.ofPattern("M/d/yyyy h:mm a", Locale.US));
		} catch (Throwable t) {

			throw new RuntimeException("Unable to create date time from: [" + dateTime.toUpperCase()
					+ "], please enter with format [M/d/yyyy h:mm a]");
		}

		PatientAppointment patientAppointment = new PatientAppointment(patientFisrtName, patientLastName, localDateTime,
				doctor);
		this.appointments.add(patientAppointment);
	}

	public List<PatientAppointment> getAppointments() {
		return this.appointments;
	}

}
