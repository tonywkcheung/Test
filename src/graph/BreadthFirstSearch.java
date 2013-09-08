package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch {

	private final List<Vertex> nodes;
	private final List<Edge> edges;
	private Map<Vertex, String> state;
	private Map<Vertex, Vertex> parent;

	public BreadthFirstSearch(Graph graph) {

		this.nodes = new ArrayList<Vertex>(graph.getVertices());
		this.edges = new ArrayList<Edge>(graph.getEdges());

		state = new HashMap<Vertex, String>();
		parent = new HashMap<Vertex, Vertex>();
	}

	private void initialize(Vertex source) {

		for (Vertex node : this.nodes) {
			if (!node.equals(source)) {
				state.put(node, "undiscovered");
			}
		}
	}

	public void search(Vertex source) {

		initialize(source);

		Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.add(source);

		while (!queue.isEmpty()) {

			Vertex current = queue.remove();

			List<Vertex> adjacentNodes = getAdjacent(current);
			for (Vertex target : adjacentNodes) {

				if (state.get(target).equals("undiscovered")) {
					state.put(target, "discovered");
					parent.put(target, current);
					queue.add(target);
				}
			}
			state.put(current, "processed");
		}
	}

	private List<Vertex> getAdjacent(Vertex node) {
		List<Vertex> neighbors = new ArrayList<Vertex>();
		for (Edge edge : edges) {
			if (edge.getSource().equals(node)) {
				neighbors.add(edge.getDestination());
			}
		}
		return neighbors;
	}

	/*
	 * This method returns the path from the source to the selected target and
	 * NULL if no path exists
	 */
	public LinkedList<Vertex> getPath(Vertex target) {
		LinkedList<Vertex> path = new LinkedList<Vertex>();
		Vertex step = target;
		// Check if a path exists
		if (parent.get(step) == null) {
			return null;
		}
		path.add(step);
		while (parent.get(step) != null) {
			step = parent.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		return path;
	}

}
