package edu.ncsu.csc316.hub_manager.disjoint_set;

/**
 * Creates an up tree which keeps track of disjoint sets to create 
 * a minimum spanning tree
 * @author Aasiyah Feisal
 *
 */
public class UpTree {

	/**
	 * Makes a set
	 * @param airport the airport used to make a set
	 * @return the node made for a set
	 */
	public Node makeSet(Object airport) {
		return newNode(airport, null, 1);
	}
	
	/**
	 * Creates a new node for the up tree
	 * @param airport the airport object within the node
	 * @param parent the parent node for the node being created
	 * @param count number of nodes within a set
	 * @return the node created
	 */
	private Node newNode(Object airport, Node parent, int count) {
		Node node = new Node(airport, parent, count);
		return node;
	}
	
	/**
	 * Find the parent of the specified node
	 * @param node the node to used to find the parent of
	 * @return the parent node of the specified node
	 */
	public Node find(Node node) {
		while (node.parent != null) {
			node = node.parent;
		}
		
		return node;
	}
	
	/**
	 * Unites the clusters containing the specified nodes
	 * @param firstRoot the node within the first cluster
	 * @param secondRoot the node within the second cluster
	 * @return the node which becomes the parent of the other
	 */
	public Node union(Node firstRoot, Node secondRoot) {
		if (firstRoot.count >= secondRoot.count) {
			firstRoot.count = firstRoot.count + secondRoot.count;
			secondRoot.parent = firstRoot;
			return firstRoot;
		} else {
			secondRoot.count = firstRoot.count + secondRoot.count;
			firstRoot.parent = secondRoot;
			return secondRoot;
		}
	}

	/**
	 * Creates a Node object
	 * @author Aasiyah Feisal
	 *
	 */
	public class Node {
		Object object;
		Node parent;
		int count;
		
		/**
		 * Creates a new instance of a node
		 * @param object the object contained in the node
		 * @param parent the parent of the created node
		 * @param count the count of the cluster which the node is within
		 */
		public Node(Object object, Node parent, int count) {
			this.setObject(object);
			this.setParent(parent);
			this.setCount(count);
		}

		/**
		 * Sets the object within the node
		 * @param object the object to set at the node
		 */
		private void setObject(Object object) {
			this.object = object;
		}

		/**
		 * Retrieves the parent of the node
		 * @return the parent node
		 */
		public Node getParent() {
			return parent;
		}

		/**
		 * Sets the parent of the node
		 * @param parent the parent to set
		 */
		private void setParent(Node parent) {
			this.parent = parent;
		}

		/**
		 * Retrieves the count for the cluster of the node
		 * @return the count of the cluster
		 */
		public int getCount() {
			return count;
		}

		/**
		 * Sets the count of the node
		 * @param count the count to set
		 */
		private void setCount(int count) {
			this.count = count;
		}
	}
}
