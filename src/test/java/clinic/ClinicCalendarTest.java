package clinic;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Haresh Shaha
 * @since 05-Apr-2021
 *
 */
class ClinicCalendarTest {

	private ClinicCalendar calendar;

	@BeforeAll
	static void SetUpBeforeAll() {
		System.out.println(" Setting up before all ");
	}

	@BeforeEach
	void SetUpBeforeEach() {
		System.out.println("\n Setting up before each ");

		calendar = new ClinicCalendar(LocalDate.now());
	}

	@Test
	void AllowEntryOfAnAppointment() {
		System.out.println(" Test basic appointment flow ");

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

	@Test
	void hasAppointmentTest() {
		System.out.println(" Test has appointment ");

		assertFalse(calendar.hasAppointment(LocalDate.of(1992, 9, 22)));

		calendar.addAppointment("test", "test", "haresh", "09/22/1992 08:00 AM");
		assertTrue(calendar.hasAppointment(LocalDate.of(1992, 9, 22)));

	}

	@Test
	void getTodaysAppointmentsTest() {
		System.out.println(" Test today's appointments ");
		calendar.addAppointment("test1", "test1", "haresh", "today 08:00 AM");
		calendar.addAppointment("test2", "test2", "sanket", "09/22/1992 12:00 AM");
		calendar.addAppointment("test3", "test3", "akash", "today 06:00 AM");

		assertEquals(2, calendar.getTodaysAppointments().size());

	}

	@AfterEach
	void tearDownAfterEach() {
		System.out.println(" Tear down after each\n ");
	}

	@AfterAll
	static void tearDownAfterAll() {
		System.out.println(" Tear down after all ");
	}
}
