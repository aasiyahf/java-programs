package edu.ncsu.csc316.customer_service.data;

/**
 * Compares two help tickets through various parameters
 * @author Aasiyah Feisal
 *
 */
public class HelpTicketComparator {

	/**
	 * Compares the timestamps of two different help tickets based on year, then
	 *  month, then day, then hour, then minute, then second
	 * @param time1 the timestamp for the first help ticket
	 * @param time2 the timestamp for the second help ticket
	 * @return a number n greater than 0 if time1 is before time2, 
	 *  less than 0 if vice versa, and 0 if they are the same
	 */
	private int compareTimes(Timestamp time1, Timestamp time2) {
		if (time1.getYear() > time2.getYear()) {
			return 1;
		} else if (time1.getYear() < time2.getYear()) {
			return -1;
		}
		
		if (time1.getMonth() > time2.getMonth()) {
			return 1;
		} else if (time1.getMonth() < time2.getMonth()) {
			return -1;
		}
		
		if (time1.getDay() > time2.getDay()) {
			return 1;
		} else if (time1.getDay() < time2.getDay()) {
			return -1;
		}
		
		if (time1.getHour() > time2.getHour()) {
			return 1;
		} else if (time1.getHour() < time2.getHour()) {
			return -1;
		}
		
		if (time1.getMinute() > time2.getMinute()) {
			return 1;
		} else if (time1.getMinute() < time2.getMinute()) {
			return -1;
		}
		
		if (time1.getSecond() > time2.getSecond()) {
			return 1;
		} else if (time1.getSecond() < time2.getSecond()) {
			return -1;
		}
		
		return 0;
	}

	/**
	 * Compares two help tickets first based on priority, then time, 
	 *  then last name, then first
	 * @param ticket the ticket being compared against
	 * @param data the current data used to compare
	 * @return a number n greater than 0 if ticket is before data, 
	 *  less than 0 if vice versa, and 0 if they are the same
	 */
	public int compare(HelpTicket ticket, HelpTicket data) {
		if (ticket.getPriority() > data.getPriority()) {
			return 1;
		} else if (ticket.getPriority() < data.getPriority()) {
			return -1;
		} 
		
		if (compareTimes(ticket.getTime(), data.getTime()) == 0) {
			if (ticket.getLastName().compareTo(data.getLastName()) == 0) {
				return ticket.getFirstName().compareTo(data.getFirstName());
			} else {
				return ticket.getLastName().compareTo(data.getLastName());
			}
		} else {
			return compareTimes(ticket.getTime(), data.getTime());
		}
	}
}
