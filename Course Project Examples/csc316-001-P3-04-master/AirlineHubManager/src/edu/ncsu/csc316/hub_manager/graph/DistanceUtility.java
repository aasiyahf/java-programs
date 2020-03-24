package edu.ncsu.csc316.hub_manager.graph;

/**
 * Calculates the distance between two airports
 * @author CSC316 staff
 *
 */
public class DistanceUtility {

	/** Constant variable for calculating distance */
	private static final double R = 3961.0;
	
	/**
	 * Calculates the distance between 2 airports using the Haversine formula
	 * @param latitude1 the origin latitude
	 * @param longitude1 the origin longitude
	 * @param latitude2 the destination latitude
	 * @param longitude2 the destination longitude
	 * @return the distance between airports
	 */
	public double getDistance(double latitude1, double longitude1, double latitude2, double longitude2)
	{
		// Convert degrees lat/lon to radians
		double lat1 = Math.toRadians(latitude1);
		double lat2 = Math.toRadians(latitude2);
		double lon1 = Math.toRadians(longitude1);
		double lon2 = Math.toRadians(longitude2);
		
		// Apply Haversine formula
		double dlon = lon2 - lon1; 
		double dlat = lat2 - lat1;
		double a  = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
		double c  = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)); // great circle distance in radians
		double d = R * c;
		return d;
	}
}
