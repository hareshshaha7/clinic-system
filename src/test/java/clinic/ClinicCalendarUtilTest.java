/**
 * 
 */
package clinic;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

/**
 * @author Haresh Shaha
 * @since 06-Apr-2021
 *
 */
class ClinicCalendarUtilTest {

	@Test
	void convertToDateFromStringTest() {
		LocalDateTime dateFromString = ClinicCalendarUtil.convertToDateFromString("09/22/1992 8:00 AM",
				LocalDate.now());
		assertEquals(LocalDateTime.of(1992, 9, 22, 8, 0), dateFromString);
	}

	@Test
	void convertTodayFromStringTest() {
		LocalDateTime dateFromString = ClinicCalendarUtil.convertToDateFromString("today 1:00 PM", LocalDate.now());
		assertEquals(LocalDateTime.of(2021, 4, 6, 13, 0), dateFromString);
	}

	@Test
	void convertToDateFromStringExceptionTest() {

		RuntimeException exception = assertThrows(RuntimeException.class,
				() -> ClinicCalendarUtil.convertToDateFromString("22/09/1992 8:00 AM", LocalDate.now()));
		assertEquals(
				"Unable to create date time from: [22/09/1992 8:00 AM], please enter with format [M/d/yyyy h:mm a]",
				exception.getMessage());
	}
}
