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
		LocalDateTime localDateTime = convertToDateFRomString(dateTime);

		PatientAppointment patientAppointment = new PatientAppointment(patientFisrtName, patientLastName, localDateTime,
				doctor);
		this.appointments.add(patientAppointment);
	}

	private LocalDateTime convertToDateFRomString(String dateTime) {
		LocalDateTime localDateTime;

		try {
			if (dateTime.toLowerCase().startsWith("today")) {
				String[] parts = dateTime.split(" ", 2);
				LocalTime time = LocalTime.parse(parts[1].toUpperCase(),
						DateTimeFormatter.ofPattern("h:mm a", Locale.US));
				localDateTime = LocalDateTime.of(today, time);
			} else {
				localDateTime = LocalDateTime.parse(dateTime.toUpperCase(),
						DateTimeFormatter.ofPattern("M/d/yyyy h:mm a", Locale.US));
			}

		} catch (Throwable t) {

			throw new RuntimeException("Unable to create date time from: [" + dateTime.toUpperCase()
					+ "], please enter with format [M/d/yyyy h:mm a]");
		}
		return localDateTime;
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
