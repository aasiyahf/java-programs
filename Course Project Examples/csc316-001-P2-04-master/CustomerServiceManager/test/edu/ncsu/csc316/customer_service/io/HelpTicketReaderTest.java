/**
 * 
 */
package edu.ncsu.csc316.customer_service.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.customer_service.data.HelpTicket;
import edu.ncsu.csc316.customer_service.tree.BinarySearchTree;

/**
 * Tests the HelpTicketReader class methods to make sure it reads in help tickets
 *  from a file correctly
 * @author Aasiyah Feisal
 *
 */
public class HelpTicketReaderTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.customer_service.io.HelpTicketReader#readHelpTickets(java.lang.String)}.
	 */
	@Test
	public void testReadHelpTickets() {
		HelpTicketReader reader = new HelpTicketReader();
		BinarySearchTree<HelpTicket> tree = null;
		boolean validTree = false;
		
		try {
			tree = reader.readHelpTickets("helpTickets.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (tree != null) {
			validTree = true;
		}
		assertTrue(validTree);
	}

}
