package clinic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @author Haresh Shaha
 * @since 04-Apr-2021
 *
 */
public class ClinicCalendar {
	private List<PatientAppointment> appointments;
	private LocalDate today;

	/**
	 * @param appointments
	 */
	public ClinicCalendar(LocalDate today) {
		this.today = today;
		this.appointments = new ArrayList<PatientAppointment>();
	}

	public void addAppointment(String patientFisrtName, String patientLastName, String doctorKey, String dateTime) {
		Doctor doctor = Doctor.valueOf(doctorKey.toLowerCase());
		LocalDateTime localDateTime = ClinicCalendarUtil.convertToDateFromString(dateTime, today);

		PatientAppointment patientAppointment = new PatientAppointment(patientFisrtName, patientLastName, localDateTime,
				doctor);
		this.appointments.add(patientAppointment);
	}

	public List<PatientAppointment> getAppointments() {
		return this.appointments;
	}

	public boolean hasAppointment(LocalDate date) {
		return this.appointments.stream().anyMatch(a -> a.getAppointmenDateTime().toLocalDate().equals(date));
	}

	public List<PatientAppointment> getTodaysAppointments() {
		return this.appointments.stream().filter(a -> a.getAppointmenDateTime().toLocalDate().equals(today))
				.collect(Collectors.toList());
	}
}
