package edu.ncsu.csc316.hub_manager.flight;

/**
 * Creates an airport object with a code, latitude, and longitude
 * @author Aasiyah Feisal
 *
 */
public class Airport {
	/** String code for airport */
	public String airportCode;
	/** Latitude coordinates */
	public double latitude;
	/** Longitude coordinates */
	public double longitude;
	
	/**
	 * Constructs an airport object with the given parameters
	 * @param airportCode the code for the airport
	 * @param latitude the latitude coordinates
	 * @param longitude the longitude coordinates
	 */
	public Airport(String airportCode, double latitude, double longitude) {
		this.setAirportCode(airportCode);
		this.setLatitude(latitude);
		this.setLongitude(longitude);
	}

	/**
	 * Retrieves the airport code
	 * @return the code of the airport
	 */
	public String getAirportCode() {
		return airportCode;
	}

	/**
	 * Sets the airport code
	 * @param airportCode the code to set
	 */
	private void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	/**
	 * Retrieves the latitude coordinates
	 * @return the latitude coordinates of the airport
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Sets the latitude coordinates
	 * @param latitude the coordinates to be set
	 */
	private void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Retrieves the longitude coordinates
	 * @return the longitude coordinates of the airport
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Sets the longitude coordinates
	 * @param longitude the coordinates to be set
	 */
	private void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
