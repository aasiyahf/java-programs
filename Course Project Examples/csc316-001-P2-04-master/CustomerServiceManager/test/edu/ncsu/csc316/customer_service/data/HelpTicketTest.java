/**
 * 
 */
package edu.ncsu.csc316.customer_service.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the HelpTicket class methods as well as the HelpTicketComparator class methods
 *  and Timestamp methods
 * @author Aasiyah Feisal
 *
 */
public class HelpTicketTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.customer_service.data.HelpTicket#HelpTicket(edu.ncsu.csc316.customer_service.data.Timestamp, int, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testHelpTicket() {
		Timestamp time = new Timestamp("09/03/2017 10:00:00");
		HelpTicket ticket = new HelpTicket(time, 5, "Suzanne" , "Smith" , "How do I check my mileage balance?");
		
		assertEquals(time.getMonth(), ticket.getTime().getMonth());
		assertEquals(time.getDay(), ticket.getTime().getDay());
		assertEquals(time.getYear(), ticket.getTime().getYear());
		assertEquals(time.getHour(), ticket.getTime().getHour());
		assertEquals(time.getMinute(), ticket.getTime().getMinute());
		assertEquals(time.getSecond(), ticket.getTime().getSecond());
		
		assertEquals(5, ticket.getPriority());
		assertEquals("Suzanne", ticket.getFirstName());
		assertEquals("Smith", ticket.getLastName());
		assertEquals("How do I check my mileage balance?", ticket.getQuestion());
		
		HelpTicket ticket2 = new HelpTicket(time, 6, "Suzanne" , "Smith" , "How do I check my mileage balance?");
		
		HelpTicketComparator comparator = new HelpTicketComparator();
		int compare = comparator.compare(ticket, ticket2);
		boolean valid = false;
		
		if (compare < 0) {
			valid = true;
		}
		
		assertTrue(valid);
		
		time = new Timestamp("09/03/2017 10:00:00");
		ticket = new HelpTicket(time, 5, "Suzanne" , "Smith" , "How do I check my mileage balance?");
		Timestamp time2 = new Timestamp("10/03/2017 10:00:00");
		ticket2 = new HelpTicket(time2, 5, "Suzanne" , "Smith" , "How do I check my mileage balance?");
		
		comparator = new HelpTicketComparator();
		compare = comparator.compare(ticket, ticket2);
		valid = false;
		
		if (compare < 0) {
			valid = true;
		}
		
		assertTrue(valid);
		
		time = new Timestamp("09/03/2017 10:00:00");
		ticket = new HelpTicket(time, 5, "Suzanne" , "Smith" , "How do I check my mileage balance?");
		time2 = new Timestamp("09/04/2017 10:00:00");
		ticket2 = new HelpTicket(time2, 5, "Suzanne" , "Smith" , "How do I check my mileage balance?");
		
		comparator = new HelpTicketComparator();
		compare = comparator.compare(ticket, ticket2);
		valid = false;
		
		if (compare < 0) {
			valid = true;
		}
		
		assertTrue(valid);
		
		time = new Timestamp("09/03/2017 10:00:00");
		ticket = new HelpTicket(time, 5, "Suzanne" , "Smith" , "How do I check my mileage balance?");
		time2 = new Timestamp("09/03/2018 10:00:00");
		ticket2 = new HelpTicket(time2, 5, "Suzanne" , "Smith" , "How do I check my mileage balance?");
		
		comparator = new HelpTicketComparator();
		compare = comparator.compare(ticket, ticket2);
		valid = false;
		
		if (compare < 0) {
			valid = true;
		}
		
		assertTrue(valid);
		
		time = new Timestamp("09/03/2017 10:00:00");
		ticket = new HelpTicket(time, 5, "Suzanne" , "Smith" , "How do I check my mileage balance?");
		time2 = new Timestamp("09/03/2017 11:00:00");
		ticket2 = new HelpTicket(time2, 5, "Suzanne" , "Smith" , "How do I check my mileage balance?");
		
		comparator = new HelpTicketComparator();
		compare = comparator.compare(ticket, ticket2);
		valid = false;
		
		if (compare < 0) {
			valid = true;
		}
		
		assertTrue(valid);
		
		time = new Timestamp("09/03/2017 10:00:00");
		ticket = new HelpTicket(time, 5, "Suzanne" , "Smith" , "How do I check my mileage balance?");
		time2 = new Timestamp("09/03/2017 10:15:00");
		ticket2 = new HelpTicket(time2, 5, "Suzanne" , "Smith" , "How do I check my mileage balance?");
		
		comparator = new HelpTicketComparator();
		compare = comparator.compare(ticket, ticket2);
		valid = false;
		
		if (compare < 0) {
			valid = true;
		}
		
		assertTrue(valid);
		
		time = new Timestamp("09/03/2017 10:00:00");
		ticket = new HelpTicket(time, 5, "Suzanne" , "Smith" , "How do I check my mileage balance?");
		time2 = new Timestamp("09/03/2017 10:00:30");
		ticket2 = new HelpTicket(time2, 5, "Suzanne" , "Smith" , "How do I check my mileage balance?");
		
		comparator = new HelpTicketComparator();
		compare = comparator.compare(ticket, ticket2);
		valid = false;
		
		if (compare < 0) {
			valid = true;
		}
		
		assertTrue(valid);
		
		time = new Timestamp("09/03/2017 10:00:00");
		ticket = new HelpTicket(time, 5, "Suzanne" , "Smith" , "How do I check my mileage balance?");
		time2 = new Timestamp("09/03/2017 10:00:00");
		ticket2 = new HelpTicket(time2, 5, "Suzanne" , "Szigethy" , "How do I check my mileage balance?");
		
		comparator = new HelpTicketComparator();
		compare = comparator.compare(ticket, ticket2);
		valid = false;
		
		if (compare < 0) {
			valid = true;
		}
		
		assertTrue(valid);
		
		time = new Timestamp("09/03/2017 10:00:00");
		ticket = new HelpTicket(time, 5, "Suzanne" , "Smith" , "How do I check my mileage balance?");
		time2 = new Timestamp("09/03/2017 10:00:00");
		ticket2 = new HelpTicket(time2, 5, "Tara" , "Smith" , "How do I check my mileage balance?");
		
		comparator = new HelpTicketComparator();
		compare = comparator.compare(ticket, ticket2);
		valid = false;
		
		if (compare < 0) {
			valid = true;
		}
		
		assertTrue(valid);
	}

}
