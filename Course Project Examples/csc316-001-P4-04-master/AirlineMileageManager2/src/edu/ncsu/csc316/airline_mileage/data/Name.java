package edu.ncsu.csc316.airline_mileage.data;

/**
 * Creates an instance of a unique name in the file
 * @author Aasiyah Feisal
 *
 */
public class Name {
	private String firstName;
	private String lastName;
	
	/**
	 * Constructs a new name object with a first and last name
	 * @param firstName the first name to set
	 * @param lastName the last name to set
	 */
	public Name(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	/**
	 * Retrieves the first name of the person
	 * @return the person's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets a persons first name
	 * @param firstName the name to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Retrieves the last name of the person
	 * @return the person's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets a person's last name
	 * @param lastName the name to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
