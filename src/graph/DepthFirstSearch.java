package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DepthFirstSearch {

    private final List<Edge> edges;
    private Map<Vertex, String> state;
    private Map<Vertex, Vertex> parent;

    public DepthFirstSearch(Graph graph) {

        this.edges = new ArrayList<Edge>(graph.getEdges());

        state = new HashMap<Vertex, String>();
        parent = new HashMap<Vertex, Vertex>();
    }

    public void search(Vertex v) {

        state.put(v, "discovered");

        List<Vertex> adjacentNodes = getAdjacent(v);
        for (Vertex adj : adjacentNodes) {

            if (!state.containsKey(adj)
                    || state.get(adj).equals("undiscovered")) {
                parent.put(adj, v);

                search(adj);
            }
        }

        state.put(v, "processed");

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
