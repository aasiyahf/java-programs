package edu.ncsu.csc316.customer_service.data;

/**
 * Creates a help ticket object with time, priority, name, and question as the parameters
 * @author Aasiyah Feisal
 *
 */
public class HelpTicket {
	private Timestamp time;
	private int priority;
	private String firstName;
	private String lastName;
	private String question;
	
	/**
	 * Constructs a help ticket for the user
	 * @param time the time the ticket was submitted
	 * @param priority the number priority of the help ticket
	 * @param firstName the first name of the user
	 * @param lastName the last name of the user
	 * @param question the user's question
	 */
	public HelpTicket( Timestamp time, int priority, String firstName, String lastName, String question ) {
		this.setTime(time);
		this.setPriority(priority);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setQuestion(question);
	}

	/**
	 * Retrieves the timestamp for the ticket
	 * @return the time the ticket was submitted
	 */
	public Timestamp getTime() {
		return time;
	}
	
	/**
	 * Sets the timestamp for the help ticket
	 * @param time the time the ticket was submitted
	 */
	private void setTime(Timestamp time) {
		this.time = time;
	}

	/**
	 * Retrieves the priority of the ticket
	 * @return the priority number of the ticket
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Sets the priority of the ticket
	 * @param priority the priority of the ticket
	 */
	private void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * Retrieves the first name of the user who submitted the ticket
	 * @return the first name of the user
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the user
	 * @param firstName the first name of the user
	 */
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Retrieves the last name of the user
	 * @return the last name of the user
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the user
	 * @param lastName the last name of the user
	 */
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Retrieves the question on the help ticket
	 * @return the question on the help ticket
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * Sets the question for the help ticket
	 * @param question the question for the help ticket
	 */
	private void setQuestion(String question) {
		this.question = question;
	}
}
