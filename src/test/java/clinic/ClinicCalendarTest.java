package clinic;

import static org.junit.jupiter.api.Assertions.*;

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
	}

}
