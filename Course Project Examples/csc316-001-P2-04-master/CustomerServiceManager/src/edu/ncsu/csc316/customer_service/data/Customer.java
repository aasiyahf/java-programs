package edu.ncsu.csc316.customer_service.data;

/**
 * Creates a customer object with first and last name parameters
 * @author Aasiyah Feisal
 *
 */
public class Customer {
	private String firstName;
	private String lastName;
	
	/**
	 * Constructs the customer with the given parameters
	 * @param firstName the first name of the user
	 * @param lastName the last name of the user
	 */
	public Customer(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	/**
	 * Retrieves first name
	 * @return the first name of the user
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the user
	 * @param firstName the first name of the user
	 */
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Retrieves the last name of the user
	 * @return the last name of the user
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the user
	 * @param lastName the last name of the user
	 */
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
