package edu.ncsu.csc316.customer_service.data;

/**
 * Creates a timestamp object to keep track of individual parts of the time
 *  the help ticke twas submitted
 * @author Aasiyah Feisal
 *
 */
public class Timestamp {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int second;
	
	/**
	 * Creates a timestamp from the given string, with separate fields for 
	 *  the year, month, day, hour, minute, and second
	 * @param time the string containing the timestamp
	 */
	public Timestamp( String time ) {
		if (time.contains(" ")) {
		    String[] fullTime = time.split(" ");
		    String date = fullTime[0];
		    String clockTime = fullTime[1];
		    
		    if (date.contains("/")) {
		    	String[] fullDate = date.split("/");
		    	this.setMonth(Integer.parseInt(fullDate[0]));
		    	this.setDay(Integer.parseInt(fullDate[1]));
		    	this.setYear(Integer.parseInt(fullDate[2]));
		    } else {
			    throw new IllegalArgumentException("Invalid date");
			}
		    
		    if (clockTime.contains(":")) {
		    	String[] fullClockTime = clockTime.split(":");
		    	this.setHour(Integer.parseInt(fullClockTime[0]));
		    	this.setMinute(Integer.parseInt(fullClockTime[1]));
		    	this.setSecond(Integer.parseInt(fullClockTime[2]));
		    } else {
			    throw new IllegalArgumentException("Invalid time");
			}
		    
		} else {
		    throw new IllegalArgumentException("Invalid string");
		}
	}

	/**
	 * Retrieves the year
	 * @return the year of the submission
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets the year
	 * @param year the year of the submission
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Retrieves the month
	 * @return the month of the submission
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Sets the month
	 * @param month the month of the submission
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Retrieves the day
	 * @return the day of the submission
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Sets the day
	 * @param day the day of the submission
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * Retrieves the hour
	 * @return the hour of the submission
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * Sets the hour
	 * @param hour the hour of the submission
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * Retrieves the minute
	 * @return the minute of the submission
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * Sets the minute
	 * @param minute the minute of the submission
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}

	/**
	 * Retrieves the second
	 * @return the second of the submission
	 */
	public int getSecond() {
		return second;
	}

	/**
	 * Sets the second
	 * @param second the second of the submission
	 */
	public void setSecond(int second) {
		this.second = second;
	}
}
