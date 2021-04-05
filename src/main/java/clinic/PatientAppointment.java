package clinic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Haresh Shaha
 * @since 04-Apr-2021
 *
 */
public class PatientAppointment {
	private String patientFirstName;
	private String patientLastName;
	private LocalDateTime appointmenDateTime;
	private Doctor doctor;

	/**
	 * @param patientFirstName
	 * @param patientLastName
	 * @param appointmenDateTime
	 * @param doctor
	 */
	public PatientAppointment(String patientFirstName, String patientLastName, LocalDateTime appointmenDateTime,
			Doctor doctor) {
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.appointmenDateTime = appointmenDateTime;
		this.doctor = doctor;
	}

	/**
	 * @return the patientFirstName
	 */
	public String getPatientFirstName() {
		return this.patientFirstName;
	}

	/**
	 * @return the patientLastName
	 */
	public String getPatientLastName() {
		return this.patientLastName;
	}

	/**
	 * @return the appointmenDateTime
	 */
	public LocalDateTime getAppointmenDateTime() {
		return this.appointmenDateTime;
	}

	/**
	 * @return the doctor
	 */
	public Doctor getDoctor() {
		return this.doctor;
	}

	@Override
	public String toString() {
		return "PatientAppointment [" + patientFirstName + " " + patientLastName + ", on "
				+ DateTimeFormatter.ofPattern("M/d/yyyy h:mm a").format(appointmenDateTime) + ", with doctor "
				+ doctor.getName() + "]";
	}

}
