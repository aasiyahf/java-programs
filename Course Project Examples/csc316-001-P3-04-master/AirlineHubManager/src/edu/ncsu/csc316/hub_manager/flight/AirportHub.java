package edu.ncsu.csc316.hub_manager.flight;

/**
 * Creates an instance of an Airport Hub with and airport and
 * record or the connections it has
 * @author Aasiyah Feisal
 *
 */
public class AirportHub {
	/** Airport of potential hub */
	public Airport potentialHub;
	/** Number of connections for airport */
	public int connections;
	
	/**
	 * Constructs a new instance of an Airport Hub
	 * @param potentialHub the airport to be set
	 * @param connections the connections of the specified airport
	 */
	public AirportHub(Airport potentialHub, int connections) {
		this.setPotentialHub(potentialHub);
		this.setConnections(connections);
	}

	/**
	 * Retrieves the airport of the potential hub
	 * @return the airport
	 */
	public Airport getPotentialHub() {
		return potentialHub;
	}

	/**
	 * Sets the airport for the potential hub
	 * @param potentialHub the airport to set
	 */
	private void setPotentialHub(Airport potentialHub) {
		this.potentialHub = potentialHub;
	}

	/**
	 * Retrieves the connections for the airport
	 * @return the connections of the potential hub
	 */
	public int getConnections() {
		return connections;
	}

	/**
	 * Sets the connections for the hub
	 * @param connections the connections to be initially set
	 */
	private void setConnections(int connections) {
		this.connections = connections;
	}
	
	/**
	 * Increments the connections for the specified airport
	 */
	public void incConnections() {
		connections++;
	}
}
