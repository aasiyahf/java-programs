package edu.ncsu.csc316.airline_mileage.data;

/**
 * Creates a flight object
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class Flight {

	private int year;
	private int month;
	private int day;
	private int dayOfWeek;
	private String airline;
	private String flightNumber;
	private String origin;
	private String destination;
	private int scheduledDeparture;
	private int departure;
	private int distance;
	private int scheduledArrival;
	private int arrivalDelay;
	
	
	/**
	 * Constructs a flight object with the given parameters
	 * @param year the year of the flight
	 * @param month the month of the flight
	 * @param day the day of the flight
	 * @param dayOfWeek the day of the week of the flight
	 * @param airline the airline of the flight
	 * @param flightNumber the flight number
	 * @param origin the origin location
	 * @param destination the destination location
	 * @param scheduledDeparture the intended departure time
	 * @param departure the actual departure time
	 * @param distance the distance in miles of the flight
	 * @param scheduledArrival the expected arrival time of the flight
	 * @param arrivalDelay the difference in the expected and actual arrival times
	 */
	public Flight(int year, int month, int day, int dayOfWeek, String airline, 
	  String flightNumber, String origin, String destination, int scheduledDeparture, 
	  int departure, int distance, int scheduledArrival, int arrivalDelay) {
		this.setYear(year);
		this.setMonth(month);
		this.setDay(day);
		this.setDayOfWeek(dayOfWeek);
		this.setAirline(airline);
		this.setFlightNumber(flightNumber);
		this.setOrigin(origin);
		this.setDestination(destination);
		this.setScheduledDeparture(scheduledDeparture);
		this.setDeparture(departure);
		this.setDistance(distance);
		this.setScheduledArrival(scheduledArrival);
		this.setArrivalDelay(arrivalDelay);
	}


	/**
	 * Returns the year
	 * @return the year
	 */
	public int getYear() {
		return year;
	}


	/**
	 * Sets the year
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}


	/**
	 * Returns the month
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}


	/**
	 * Sets the month
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}


	/**
	 * Returns the day
	 * @return the day
	 */
	public int getDay() {
		return day;
	}


	/**
	 * Sets the day
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}


	/**
	 * Returns the day of the week
	 * @return the dayOfWeek
	 */
	public int getDayOfWeek() {
		return dayOfWeek;
	}


	/**
	 * Sets the day of the week
	 * @param dayOfWeek the dayOfWeek to set
	 */
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
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
	 * Returns the expected departure
	 * @return the scheduledDeparture
	 */
	public int getScheduledDeparture() {
		return scheduledDeparture;
	}


	/**
	 * Sets the expected departure
	 * @param scheduledDeparture the scheduledDeparture to set
	 */
	public void setScheduledDeparture(int scheduledDeparture) {
		this.scheduledDeparture = scheduledDeparture;
	}

	/**
	 * Returns the departure
	 * @return the departure
	 */
	public int getDeparture() {
		return departure;
	}


	/**
	 * Sets the departure
	 * @param departure the departure to set
	 */
	public void setDeparture(int departure) {
		this.departure = departure;
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
	 * Returns the expected arrival
	 * @return the scheduledArrival
	 */
	public int getScheduledArrival() {
		return scheduledArrival;
	}


	/**
	 * Sets the expected arrival
	 * @param scheduledArrival the scheduledArrival to set
	 */
	public void setScheduledArrival(int scheduledArrival) {
		this.scheduledArrival = scheduledArrival;
	}


	/**
	 * Returns the difference in the expected and actual arrival times
	 * @return the arrivalDelay
	 */
	public int getArrivalDelay() {
		return arrivalDelay;
	}


	/**
	 * Sets the difference in the expected and actual arrival times
	 * @param arrivalDelay the arrivalDelay to set
	 */
	public void setArrivalDelay(int arrivalDelay) {
		this.arrivalDelay = arrivalDelay;
	}
}
