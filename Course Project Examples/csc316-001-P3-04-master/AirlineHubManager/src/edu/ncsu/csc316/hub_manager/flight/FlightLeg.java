package edu.ncsu.csc316.hub_manager.flight;

import edu.ncsu.csc316.hub_manager.graph.DistanceUtility;

/**
 * Creates a flight leg class of two airports
 * @author Aasiyah Feisal
 *
 */
public class FlightLeg {
	/** Origin airport for flight */
	public Airport origin;
	/** Destination airport of flight */
	public Airport destination;
	/** Distance between airports */
	public double distance;
	
	/**
	 * Constructs a new FlightLeg object with the given airports
	 * @param origin the origin airport
	 * @param destination the destination airport
	 */
	public FlightLeg(Airport origin, Airport destination) {
		this.setOrigin(origin);
		this.setDestination(destination);
		
		DistanceUtility calculator = new DistanceUtility();
		this.setDistance(calculator.getDistance(origin.getLatitude(), origin.getLongitude(),
		  destination.getLatitude(), destination.getLongitude()));
	}

	/**
	 * Retrieves the origin airport of the flight
	 * @return the origin airport
	 */
	public Airport getOrigin() {
		return origin;
	}

	/**
	 * Sets the origin airport of the flight
	 * @param origin the origin to set
	 */
	private void setOrigin(Airport origin) {
		this.origin = origin;
	}
	
	/**
	 * Retrieves the destination airport of the flight
	 * @return the destination airport
	 */
	public Airport getDestination() {
		return destination;
	}

	/**
	 * Sets the destination airport of the flight
	 * @param destination the destination to set
	 */
	private void setDestination(Airport destination) {
		this.destination = destination;
	}

	/**
	 * Retrieves the distance of the flight
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * Sets the distance between the airports
	 * @param distance the distance to set
	 */
	private void setDistance(double distance) {
		this.distance = distance;
	}
}
