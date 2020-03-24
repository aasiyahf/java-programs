package edu.ncsu.csc316.customer_service.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.customer_service.data.HelpTicket;
import edu.ncsu.csc316.customer_service.data.Timestamp;
import edu.ncsu.csc316.customer_service.tree.BinarySearchTree;

/**
 * Reads parameters from a file into a binary search tree of HelpTicket elements
 * @author Aasiyah Feisal
 *
 */
public class HelpTicketReader {
	
	/**
	 * Reads the file for potential help tickets into a binary search tree
	 * @param file the file to be read
	 * @return a binary search tree of help ticket elements
	 * @throws FileNotFoundException if the file given cannot be read or does not exist
	 */
	public BinarySearchTree<HelpTicket> readHelpTickets(String file) throws FileNotFoundException {
        Scanner fileReader = null;
		
		try {
		    fileReader = new Scanner(new FileInputStream("input/" + file));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Invalid file");
		}
		
		BinarySearchTree<HelpTicket> tickets = new BinarySearchTree<HelpTicket>();
		fileReader.nextLine(); //skips first line
		
		while (fileReader.hasNextLine()) {
			try {
				HelpTicket ticket = readHelpTicket(fileReader.nextLine());
				tickets.insert(ticket);
			} catch (IllegalArgumentException e) {
				//skip the line
			}
		}
		
		fileReader.close();
		return tickets;
	}

	/**
	 * Reads a line of the file
	 * @param line the line to be read into a help ticket object
	 * @return the help ticket created
	 * @throws IllegalArgumentException if the ticket cannot be created
	 */
	private static HelpTicket readHelpTicket(String line) throws IllegalArgumentException {
		HelpTicket ticket = null;
		String[] tokens = line.split(",");
		if (tokens.length == 5)
			ticket = new HelpTicket(new Timestamp(tokens[0]), Integer.parseInt(tokens[1]), tokens[2], tokens[3], tokens[4]);
		
		if (ticket == null)
			throw new IllegalArgumentException();
		
		return ticket;
	}
}
