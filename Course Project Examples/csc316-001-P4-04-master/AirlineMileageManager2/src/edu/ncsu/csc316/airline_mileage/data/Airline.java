package edu.ncsu.csc316.airline_mileage.data;

/**
 * Creates airline object
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class Airline {

	private String name;
	private String code;
	private String callSign;
	private String country;
	
	/**
	 * Constructs new airline object
	 * @param name the name of the airline
	 * @param code the code of the airline
	 * @param callSign the call sign of the airline
	 * @param country the country of the airline
	 */
	public Airline(String name, String code, String callSign, String country) {
		this.setName(name);
		this.setCode(code);
		this.setCallSign(callSign);
		this.setCountry(country);
	}

	/**
	 * Returns name of airline
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name of airline
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns code of the airline
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code of the airline
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Returns the call sign
	 * @return the callSign
	 */
	public String getCallSign() {
		return callSign;
	}

	/**
	 * Sets the call sign
	 * @param callSign the callSign to set
	 */
    public void setCallSign(String callSign) {
		this.callSign = callSign;
	}

	/**
	 * Returns the country of the airline
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country of the airline
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Returns key for airline object
	 * @return the key as a string
	 */
	public String getKey() {
		return this.code;
	}

}
