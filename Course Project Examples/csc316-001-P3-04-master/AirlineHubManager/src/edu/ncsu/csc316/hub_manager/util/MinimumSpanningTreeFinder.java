package edu.ncsu.csc316.hub_manager.util;

import edu.ncsu.csc316.hub_manager.disjoint_set.UpTree;
import edu.ncsu.csc316.hub_manager.disjoint_set.UpTree.Node;
import edu.ncsu.csc316.hub_manager.flight.Airport;
import edu.ncsu.csc316.hub_manager.flight.FlightLeg;
import edu.ncsu.csc316.hub_manager.list.MultiPurposeList;
import edu.ncsu.csc316.hub_manager.priority_queue.MinHeap;

/**
 * Finds a minimum spanning tree from the given parameters of vertices
 * and edges
 * @author Aasiyah Feisal
 *
 */
public class MinimumSpanningTreeFinder {

	/**
	 * Uses Kruskal's algorithm to find a minimum spanning tree from the
	 * lists given as parameters
	 * @param edges a list of edges in the graph
	 * @param vertices a list or vertices in the graph
	 * @return a list of edges for the MST
	 */
	@SuppressWarnings("rawtypes")
	public MultiPurposeList<FlightLeg> kruskalMST(MultiPurposeList<FlightLeg> edges, MultiPurposeList<Airport> vertices) {
		MultiPurposeList<FlightLeg> minFlights = new MultiPurposeList<FlightLeg>();
		MinHeap heap = new MinHeap(edges.size());
		UpTree tree = new UpTree();
		
		for(int i = 0; i < edges.size(); i++) {
			heap.insert(edges.get(i).getDistance(), edges.get(i));
		}
		
		int numV = vertices.size();
		MultiPurposeList<Node> nodes = new MultiPurposeList<Node>();
		for(int i = 0; i < numV; i++) {
			nodes.add(i, tree.makeSet(vertices.get(i)));
		}
		
		int remainingEdges = numV - 1;
		while(remainingEdges > 0) {
			FlightLeg leg = heap.deleteMin().getElement();
			Airport origin = leg.getOrigin();
			Airport dest = leg.getDestination();
			
			int originI = vertices.find(origin);
			int destI = vertices.find(dest);
			
			Node originNode = nodes.get(originI);
			Node destNode = nodes.get(destI);
			
			Node originParent = tree.find(originNode);
			Node destParent = tree.find(destNode);
			if(originParent != destParent) {
				tree.union(originParent, destParent);
				minFlights.add(leg);
				remainingEdges = remainingEdges - 1;
			}
			
		}
		
		return minFlights;
	}
}
