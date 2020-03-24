package edu.ncsu.csc316.airline_mileage.data;

/**
 * Miles helps to keep track of miles when being calculated later
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class Miles {

	private String airline;
	private int miles;
	
	/**
	 * Constructs a miles object to keep track of miles per airline traveled
	 * @param airline the airline traveled
	 * @param miles the miles for the specified airline
	 */
	public Miles(String airline, int miles) {
		this.setAirline(airline);
		this.setMiles(miles);
	}

	/**
	 * Returns the airline
	 * @return the airline
	 */
	public String getAirline() {
		return airline;
	}

	/**
	 * Sets the airline
	 * @param airline the airline to set
	 */
	public void setAirline(String airline) {
		this.airline = airline;
	}

	/**
	 * Returns the miles
	 * @return the miles
	 */
	public int getMiles() {
		return miles;
	}

	/**
	 * Sets the miles
	 * @param miles the airline to set
	 */
	public void setMiles(int miles) {
		this.miles = miles;
	}

	/**
	 * Allows miles to be added on to an an object with the same airline
	 * @param milesAdded the miles to be added
	 */
	public void addMiles(int milesAdded) {
		this.miles += milesAdded;
	}

}
