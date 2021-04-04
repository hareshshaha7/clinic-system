package clinic;

/**
 * @author Haresh Shaha
 * @since 04-Apr-2021
 *
 */
public enum Doctor {
	haresh("Haresh Shaha"), prachi("Prachi Shaha"), akash("Akash Doshi"), sanket("Sanket Gargate");

	private String name;

	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 */
	private Doctor(String name) {
		this.name = name;
	}
}
