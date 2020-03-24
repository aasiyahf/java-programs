package edu.ncsu.csc316.customer_service.tree;

import edu.ncsu.csc316.customer_service.data.Customer;
import edu.ncsu.csc316.customer_service.data.CustomerComparator;
import edu.ncsu.csc316.customer_service.data.HelpTicketComparator;

/**
 * Creates a binary search tree which can store help tickets by using a pair
 *  of methods, one which is public, and one which privately performs 
 *  necessary recursion
 * @author Aasiyah Feisal
 *
 * @param <HelpTicket> allows help tickets to be read in to this tree using comparators
 */
public class BinarySearchTree<HelpTicket extends edu.ncsu.csc316.customer_service.data.HelpTicket> {
     private Node root;
 
     /**
      * Sets the root to null initially
      */
     public BinarySearchTree() {
         root = null;
     }
     
     /**
      * Checks if the root is empty
      * @return true if the tree is empty, false otherwise
      */
     public boolean isEmpty() {
    	 return root == null;
     }

     /**
      * Inserts a specified help ticket into the tree
      * @param ticket the ticket to be inserted
      */
     public void insert(HelpTicket ticket) {
         root = insert(root, ticket);
     }

     /**
      * Inserts the ticket into the tree in a sorted manner using comparators
      * @param node the root node to start
      * @param ticket the ticket to be inserted
      * @return the node being inserted
      */
     private Node insert(Node node, HelpTicket ticket) {
    	 HelpTicketComparator comparator = new HelpTicketComparator();
         if (node == null)
             node = new Node(ticket);
         else {
             if (comparator.compare(ticket, node.getData()) < 0 )
                 node.left = insert(node.left, ticket);
             else if (comparator.compare(ticket, node.getData()) > 0 )
                 node.right = insert(node.right, ticket);
             else
            	 throw new IllegalArgumentException("Duplicate ticket");
         }
         return node;
     }
     
     /**
      * Deletes the node of the given customer
      * @param customer the customer to delete
      */
     public void deleteCustomer(Customer customer) {
         if (root == null)
        	 throw new IllegalArgumentException("Empty tree");
         else if (!searchForCustomer(customer))
        	 throw new IllegalArgumentException("Invalid user");
         else {
             root = deleteCustomer(root, customer);
         }
     }
     
     /**
      * Deletes the specified customer's help ticket
      * @param root the root node to start with
      * @param customer the customer being used as a key to delete
      *  the help ticket
      * @return the node deleted
      */
     private Node deleteCustomer(Node root, Customer customer) {
         Node node;
         CustomerComparator comparator = new CustomerComparator();
         
         Customer rootCustomer = new Customer(root.getData().getFirstName(), root.getData().getLastName());
         if (comparator.compareByName(rootCustomer, customer) == 0) {
             Node left = root.getLeft();
             Node right = root.getRight();
             
             if (left == null && right == null)
                 return null;
             else if (left == null) {
                 node = right;
                 return node;
             } else if (right == null) {
                 node = left;
                 return node;
             } else {
                 node = right;
                 Node duplicate = right;
                 while (node.getLeft() != null)
                     node = node.getLeft();
                 node.setLeft(left);
                 return duplicate;
             }
             
         }
         
         if (comparator.compareByName(customer, rootCustomer) < 0) {
             Node movingNode = deleteCustomer(root.getLeft(), customer);
             root.setLeft(movingNode);
         } else {
             Node movingNode = deleteCustomer(root.getRight(), customer);
             root.setRight(movingNode);             
         }
         
         return root;
     }
     
     /**
      * Searches for the specified customer's ticket
      * @param customer the customer being searched for
      * @return true if the ticket exists, false otherwise
      */
     public boolean searchForCustomer(Customer customer) {
         return searchForCustomer(root, customer);
     }

     /**
      * Searches for the specified customer's ticket
      * @param node the root node to start from
      * @param customer the customer being searched for
      * @return true if the ticket exists, false otherwise
      */
     private boolean searchForCustomer(Node node, Customer customer) {
    	 CustomerComparator comparator = new CustomerComparator();
         boolean found = false;
         
         while ((node != null) && !found) {
             Customer right = new Customer(node.getData().getFirstName(), node.getData().getLastName());
             if (comparator.compareByName(customer, right) < 0)
                 node = node.getLeft();
             else if (comparator.compareByName(customer, right) > 0)
                 node = node.getRight();
             else {
                 found = true;
                 return found;
             }
             
             found = searchForCustomer(node, customer);
         }
         
         return found;
     }
     
     /**
      * Looks up a help ticket based on the specified customer
      * @param customer the customer specified
      * @param steps the steps to take in line from where the customer is
      * @return the position of the customer in line
      */
     public int lookUpCustomer(Customer customer, int steps) {
         int newSteps = lookUpCustomer(root, customer, steps);
         return newSteps;
     }
     
     /**
      * Looks up a help ticket based on the specified customer
      * @param root is the root node to start
      * @param customer the customer specified
      * @param steps the steps to take in line from where the customer is
      * @return the position of the customer in line
      */
     private int lookUpCustomer(Node root, Customer customer, int steps) {
    	 CustomerComparator comparator = new CustomerComparator();
    	 
         if (root != null) {
             lookUpCustomer(root.getLeft(), customer, steps);
             
             Customer current = new Customer(root.getData().getFirstName(), root.getData().getLastName());
    		 if (comparator.compareByName(current, customer) == 0) {
    			 steps++;
    			 return steps;
    		 } else {
    			 steps++;
    		 }
    		 
             lookUpCustomer(root.getRight(), customer, steps);
         }
         
         return steps;
     }

     /**
      * Looks up a ticket based on the user who submitted it
      * @param customer the customer who submitted the ticket
      * @return the help ticket submitted
      */
     public HelpTicket lookUpTicket(Customer customer) {
    	 HelpTicket ticket = lookUpTicket(root, customer);
         if (ticket == null)
        	 throw new IllegalArgumentException("Customer does not exist");
         else
        	 return ticket;
     }
     
     /**
      * Looks up a ticket based on the user who submitted it
      * @param root the root node to start with
      * @param customer the customer who submitted the ticket
      * @return the help ticket submitted
      */
    private HelpTicket lookUpTicket(Node root, Customer customer) {
    	 CustomerComparator comparator = new CustomerComparator();
    	 
         if (root != null) {
             lookUpTicket(root.getLeft(), customer);
             
             Customer current = new Customer(root.getData().getFirstName(), root.getData().getLastName());
    		 if (comparator.compareByName(current, customer) == 0) {
    			 return root.getData();
    		 }
    		 
             lookUpTicket(root.getRight(), customer);
         }
         
         return null;
     }
     
     /**
      * Creates a list of in order help tickets from the tree
      * @return the list of help tickets
      */
     public String inOrder() {
    	 String valid = "";
    	 valid = inOrder(root);
    	 if (valid.isEmpty())
    		 throw new IllegalArgumentException("Empty tree");
    	 else 
    		 return inOrder(root);
     }
     
     /**
      * Gets the size of the tree
      * @return the size of the tree
      */
     public int size() {
    	 return size(root);
     }
     
     /**
      * Finds the size of the tree
      * @param root the root to start with
      * @return the size of the tree
      */
     private int size(Node root) {
         if (root == null)
             return 0;
         else
         {
             int size = 1;
             size += size(root.getLeft());
             size += size(root.getRight());
             return size;
         }
     }

     /**
      * Creates an in order list of help tickets in the tree
      * @param root the root to start with
      * @return the list of help tickets
      */
	 public String inOrder(Node root) {
     	 String output = "";
    	 if (root != null) {
             inOrder(root.getRight());
             
             output += "Priority " + root.getData().getPriority() + ": ";
             output += "submitted at " + root.getData().getTime().getMonth() + "/";
             output += root.getData().getTime().getDay() + "/" + root.getData().getTime().getYear();
             output += " " + root.getData().getTime().getHour() + ":";
             output += root.getData().getTime().getMinute() + ":" + root.getData().getTime().getSecond();
             output += " by " + root.getData().getFirstName() + " " + root.getData().getLastName();
             output += ", Question: " + root.getData().getQuestion();
             
             inOrder(root.getLeft());
         }
    	 
    	 return output;
      }

   /**
    * An inner class to define a node within the tree
    * @author Aasiyah Feisal
    *
    */
   private class Node {
        private Node left;
        private Node right;
        private HelpTicket data;
         
        /**
         * Creates a new node with a ticket parameter
         * @param ticket the ticket for a particular node
         */
        public Node(HelpTicket ticket) {
            left = null;
            right = null;
            data = ticket;
        }

        /**
         * Sets the left of the current node
         * @param newNode the new node to set
         */
        public void setLeft(Node newNode) {
            left = newNode;
        }
 
        /**
         * Sets the right of the current node
         * @param newNode the new node to set
         */
        public void setRight(Node newNode) {
            right = newNode;
        }
        
        /**
         * Retrieves the left of the current node
         * @return the node
         */
        public Node getLeft() {
            return left;
        }

        /**
         * Retrieves the right of the current node
         * @return the node
         */
        public Node getRight() {
            return right;
        }

        /**
         * Retrieves the data at the current node
         * @return the help ticket at the node
         */
        public HelpTicket getData() {
            return data;
        }     
    }
 }