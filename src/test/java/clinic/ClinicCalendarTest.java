package clinic;

import static org.junit.jupiter.api.Assertions.*;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * @author Haresh Shaha
 * @since 05-Apr-2021
 *
 */
class ClinicCalendarTest {

	@Test
	void AllowEntryOfAnAppointment() {
		ClinicCalendar calendar = new ClinicCalendar();
		calendar.addAppointment("test", "test", "haresh", "09/22/1992 08:00 AM");

		List<PatientAppointment> appointments = calendar.getAppointments();
		assertNotNull(appointments);
		assertEquals(1, appointments.size());

		PatientAppointment appointment = appointments.get(0);
		assertEquals("test", appointment.getPatientFirstName());
		assertEquals("test", appointment.getPatientLastName());
		assertSame(Doctor.haresh, appointment.getDoctor());
		assertEquals("9/22/1992 8:00 AM",
				appointment.getAppointmenDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy h:mm a")));
	}

}
