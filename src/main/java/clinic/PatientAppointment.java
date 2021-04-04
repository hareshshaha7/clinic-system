package clinic;

import java.time.LocalDateTime;

/**
 * @author Haresh Shaha
 * @since 04-Apr-2021
 *
 */
public class PatientAppointment {
	private String patientFisrtName;
	private String patientLastName;
	private LocalDateTime appointmenDateTime;
	private Doctor doctor;

	/**
	 * @param patientFisrtName
	 * @param patientLastName
	 * @param appointmenDateTime
	 * @param doctor
	 */
	public PatientAppointment(String patientFisrtName, String patientLastName, LocalDateTime appointmenDateTime,
			Doctor doctor) {
		this.patientFisrtName = patientFisrtName;
		this.patientLastName = patientLastName;
		this.appointmenDateTime = appointmenDateTime;
		this.doctor = doctor;
	}

	/**
	 * @return the patientFisrtName
	 */
	public String getPatientFisrtName() {
		return this.patientFisrtName;
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

}
