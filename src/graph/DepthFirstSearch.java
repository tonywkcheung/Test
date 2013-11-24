package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DepthFirstSearch {

    private final List<Vertex> nodes;
    private final List<Edge> edges;
    private Map<Vertex, String> state;
    private Map<Vertex, Vertex> parent;

    public DepthFirstSearch(Graph graph) {

        this.nodes = new ArrayList<Vertex>(graph.getVertices());
        this.edges = new ArrayList<Edge>(graph.getEdges());

        state = new HashMap<Vertex, String>();
        parent = new HashMap<Vertex, Vertex>();
    }

    private void initialize(Vertex source) {

        for (Vertex node : this.nodes) {
            state.put(node, "unvisited");
        }
    }
    
    public void search(Vertex source) {

        initialize(source);

        Stack<Vertex> stack = new Stack<Vertex>();
        stack.push(source);
        state.put(source, "visiting"); 

        while (!stack.isEmpty()) {

            Vertex current = stack.pop();

            List<Vertex> adjacentNodes = getAdjacent(current);
            for (Vertex target : adjacentNodes) {

                if (state.get(target).equals("unvisited")) {
                    state.put(target, "visiting");
                    parent.put(target, current);
                    stack.push(target);
                }
            }
            state.put(current, "visited");
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
