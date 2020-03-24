package edu.ncsu.csc316.airline_mileage.data;

/**
 * Creates customer object
 * @author Aasiyah Feisal (anfeisal)
 */
public class Customer {

	private String firstName;
	private String lastName;
	private String date;
	private String airlineNumber;
	private String origin;
	private String destination;
	
	
	/**
	 * Constructs new customer object
	 * @param firstName the first name of the customer
	 * @param lastName the last name of the customer
	 * @param date the date of the customer
	 * @param airlineNumber the airline number of the customer
	 * @param origin the origin of the flight taken
	 * @param destination the destination of the flight taken
	 */
	public Customer(String firstName, String lastName, String date, String airlineNumber, String origin, String destination) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setDate(date);
		this.setAirline(airlineNumber);
		this.setOrigin(origin);
		this.setDestination(destination);
	}


	/**
	 * Returns the first name of the customer
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * Sets the first name
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * Returns the last name of the customer
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * Sets the last name
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * Returns the date of the flight
	 * @return the date
	 */
	public String getDate() {
		return date;
	}


	/**
	 * Sets the date of the flight
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}


	/**
	 * Returns the airline
	 * @return the airline
	 */
	public String getAirline() {
		return airlineNumber;
	}


	/**
	 * Sets the airline
	 * @param airline the airline to set
	 */
	public void setAirline(String airline) {
		this.airlineNumber = airline;
	}

	/**
	 * Returns the origin location
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}


	/**
	 * Sets the origin location
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}


	/**
	 * Returns the destination
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}


	/**
	 * Sets the destination
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	/**
	 * Returns key for customer object
	 * @return the key as a string
	 */
	public String getKey() {
		return (this.lastName + this.firstName);
	}

}