package graph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BreadthFirstSearchTest {
	private List<Vertex> nodes;
	private List<Edge> edges;

	Graph graph;
	BreadthFirstSearch bfs;

	@Before
	public void setUp() {
		nodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();

		nodes.add(new Vertex("Node_0", "Tony"));
		nodes.add(new Vertex("Node_1", "James"));
		nodes.add(new Vertex("Node_2", "Jimmy"));
		nodes.add(new Vertex("Node_3", "Jeremy"));
		nodes.add(new Vertex("Node_4", "Nat"));
		nodes.add(new Vertex("Node_5", "Bob"));
		nodes.add(new Vertex("Node_6", "Carol"));

		addLane("Edge_0", 0, 3, 0);
		addLane("Edge_1", 0, 1, 0);
		addLane("Edge_2", 0, 2, 0);
		addLane("Edge_3", 1, 0, 0);
		addLane("Edge_4", 1, 2, 0);
		addLane("Edge_5", 1, 4, 0);
		addLane("Edge_6", 2, 0, 0);
		addLane("Edge_7", 2, 1, 0);
		addLane("Edge_8", 2, 4, 0);
		addLane("Edge_9", 3, 0, 0);
		addLane("Edge_10", 3, 4, 0);
		addLane("Edge_11", 3, 5, 0);
		addLane("Edge_13", 4, 3, 0);
		addLane("Edge_14", 4, 5, 0);
		addLane("Edge_15", 4, 2, 0);
		addLane("Edge_19", 5, 4, 0);
		addLane("Edge_20", 5, 3, 0);

		// Lets check from location Loc_1 to Loc_10
		graph = new Graph(nodes, edges);

		bfs = new BreadthFirstSearch(graph);
	}

	@Test
	public void doesTonyLinkToJeremy() {
		bfs.search(nodes.get(0));
		LinkedList<Vertex> path = bfs.getPath(nodes.get(3));

		assertNotNull(path);
		assertTrue(path.size() > 0);

		printPath(path);
	}

	@Test
	public void doesNatLinkJames() {
		bfs.search(nodes.get(4));
		LinkedList<Vertex> path = bfs.getPath(nodes.get(1));

		assertNotNull(path);
		assertTrue(path.size() > 0);

		printPath(path);
	}

	@Test
	public void doesCarolLinkToJimmy() {
		bfs.search(nodes.get(6));
		LinkedList<Vertex> path = bfs.getPath(nodes.get(2));

		assertNull(path);
	}

	@Test
	public void doesJimmyLinkToCarol() {
		bfs.search(nodes.get(2));
		LinkedList<Vertex> path = bfs.getPath(nodes.get(6));

		assertNull(path);
	}

	private void printPath(LinkedList<Vertex> path) {
		int i = 0;
		for (Vertex vertex : path) {
			if (i > 0) {
				System.out.print("->");
			}
			System.out.print(vertex);
			i++;
		}
		System.out.print("\n");
	}

	private void addLane(String laneId, int sourceNo, int destNo, int duration) {
		Edge lane = new Edge(laneId, nodes.get(sourceNo), nodes.get(destNo),
		        duration);
		edges.add(lane);
	}
}
