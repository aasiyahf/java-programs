package edu.ncsu.csc316.airline_mileage.data;

/**
 * Creates a flight object
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class Flight {

	private String airline;
	private String flightNumber;
	private String origin;
	private String destination;
	private int distance;
	
	
	/**
	 * Constructs a flight object with the given parameters
	 * @param airline the airline of the flight
	 * @param flightNumber the flight number
	 * @param origin the origin location
	 * @param destination the destination location
	 * @param distance the distance in miles of the flight
	 */
	public Flight(String airline, String flightNumber, String origin, String destination, 
	  int distance) {
		this.setAirline(airline);
		this.setFlightNumber(flightNumber);
		this.setOrigin(origin);
		this.setDestination(destination);
		this.setDistance(distance);
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
	 * Returns the flight number
	 * @return the flightNumber
	 */
	public String getFlightNumber() {
		return flightNumber;
	}


	/**
	 * Sets the flight number
	 * @param flightNumber the flightNumber to set
	 */
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


	/**
	 * Returns the origin
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}


	/**
	 * Sets the origin
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
	 * Returns the distance
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}


	/**
	 * Sets the distance
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	/**
	 * Returns key for flight object
	 * @return the key as a string
	 */
	public String getKey() {
		return (this.airline + this.flightNumber);
	}
}
