package clinic;

import java.util.Scanner;

/**
 * @author Haresh Shaha
 * @since 05-Apr-2021
 *
 */
public class ClinicMain {

	private static ClinicCalendar calendar;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		calendar = new ClinicCalendar();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Patient Intake Computer System!\n");
		String lastOption = "";

		while (!lastOption.equalsIgnoreCase("x")) {
			lastOption = displayMenu(sc);
		}
		System.out.println("\n Exiting System \n");

	}

	private static String displayMenu(Scanner sc) {
		System.out.println("\n\n Please select an option: ");
		System.out.println(" 1. Enter a Patient Appointment ");
		System.out.println(" 2. View All Appointments ");
		System.out.println(" X. Exit System");
		System.out.println(" Option: ");
		String option = sc.next();

		switch (option) {
		case "1":
			performPatientEntry(sc);
			return option;

		case "2":
			performAllAppointments();
			return option;

		default:
			if (!option.equalsIgnoreCase("X"))
				System.out.println(" Invalid option, please re-enter. ");
			return option;
		}
	}

	private static void performPatientEntry(Scanner sc) {
		sc.nextLine();
		System.out.println("\n\n Please enter appointment information ");

		System.out.println(" Patient First Name: ");
		String firstName = sc.nextLine();

		System.out.println(" Patient Last Name: ");
		String lastName = sc.nextLine();

		System.out.println(" Appointment date [M/d/yyyy h:mm a]:");
		String when = sc.nextLine();

		System.out.println(" Doctor first Name: ");
		String doc = sc.nextLine();

		try {
			calendar.addAppointment(firstName, lastName, doc, when);
		} catch (Throwable t) {
			System.err.println(" Error: " + t.getMessage());
		}

		System.out.println(" Patient entered successfully! \n\n");
	}

	private static void performAllAppointments() {
		System.out.println("\n\n All appointments in the system: ");
		for (PatientAppointment appointment : calendar.getAppointments()) {
			System.out.println(appointment);
		}
	}

}
