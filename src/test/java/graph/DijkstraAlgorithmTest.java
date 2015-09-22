package graph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DijkstraAlgorithmTest {
    private List<Vertex> nodes;
    private List<Edge> edges;

    @Before
    public void setUp() {
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();

        nodes.add(new Vertex("Node_0", "PVD"));
        nodes.add(new Vertex("Node_1", "LGA"));
        nodes.add(new Vertex("Node_2", "MIA"));
        nodes.add(new Vertex("Node_3", "ORD"));
        nodes.add(new Vertex("Node_4", "DFW"));
        nodes.add(new Vertex("Node_5", "LAX"));
        nodes.add(new Vertex("Node_6", "HNL"));
        nodes.add(new Vertex("Node_7", "SFO"));

        addLane("Edge_0", 0, 3, 849);
        addLane("Edge_1", 0, 1, 142);
        addLane("Edge_2", 0, 2, 1205);
        addLane("Edge_3", 1, 0, 142);
        addLane("Edge_4", 1, 2, 1099);
        addLane("Edge_5", 1, 4, 1233);
        addLane("Edge_6", 2, 0, 1205);
        addLane("Edge_7", 2, 1, 1099);
        addLane("Edge_8", 2, 4, 1120);
        addLane("Edge_9", 3, 0, 849);
        addLane("Edge_10", 3, 4, 802);
        addLane("Edge_11", 3, 5, 1843);
        addLane("Edge_12", 3, 7, 1743);
        addLane("Edge_13", 4, 3, 802);
        addLane("Edge_14", 4, 5, 1743);
        addLane("Edge_15", 4, 2, 1120);
        addLane("Edge_16", 4, 1, 1387);
        addLane("Edge_17", 5, 6, 2555);
        addLane("Edge_18", 5, 7, 337);
        addLane("Edge_19", 5, 4, 1233);
        addLane("Edge_20", 5, 3, 1743);
        addLane("Edge_21", 6, 5, 2555);
        addLane("Edge_22", 7, 5, 337);
        addLane("Edge_23", 7, 3, 1843);

    }

    @Test
    public void dijkstraShortestPath() {
        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.search(nodes.get(0));
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(6));

        assertNotNull(path);
        assertTrue(path.size() > 0);

        Vertex prevVertex = null;
        for (Vertex vertex : path) {
            if (prevVertex != null) {
                for (Edge edge : edges) {
                    if (edge.getSource().equals(prevVertex)
                            && edge.getDestination().equals(vertex)) {
                        System.out.println(edge);
                    }
                }
            }
            System.out.println(vertex);
            prevVertex = vertex;
        }

    }

    @Test
    public void dijkstraNoPath() {

        Graph graph = new Graph(nodes, new ArrayList<Edge>());
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.search(nodes.get(0));
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(6));

        assertNull(path);
    }

    private void addLane(String laneId, int sourceNo, int destNo, int duration) {
        Edge lane = new Edge(laneId, nodes.get(sourceNo), nodes.get(destNo), duration);
        edges.add(lane);
    }
}
