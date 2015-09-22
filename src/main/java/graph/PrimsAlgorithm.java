package graph;

import java.util.*;

public class PrimsAlgorithm {

    private final List<Vertex> nodes;
    private final List<Edge> edges;
    private Set<Vertex> unvisitedNodes;
    private List<Edge> mst;

    public PrimsAlgorithm(Graph graph) {

        this.nodes = new ArrayList<>(graph.getVertices());
        this.edges = new ArrayList<>(graph.getEdges());

        unvisitedNodes = new HashSet<>();
        mst = new ArrayList<>();
    }

    private void initialize() {

        for (Vertex node : this.nodes) {
            unvisitedNodes.add(node);
        }
    }

    public void search(Vertex source) {

        initialize();

        unvisitedNodes.remove(source);

        while (!unvisitedNodes.isEmpty()) {

            Edge minEdge = getMinEdge();
            if (minEdge == null) {
                // No more connected edges, stop
                break;
            }

            mst.add(minEdge);

            unvisitedNodes.remove(minEdge.getDestination());
        }
    }

    private Edge getMinEdge() {
        int x = Integer.MAX_VALUE;
        Edge minEdge = null;

        for (Edge edge : edges) {
            if (edge.getWeight() < x
                    && isVisited(edge.getSource())
                    && !isVisited(edge.getDestination())) {
                x = edge.getWeight();
                minEdge = edge;
            }
        }

        return minEdge;
    }


    private boolean isVisited(Vertex vertex) {
        return !unvisitedNodes.contains(vertex);
    }

    public List<Edge> getMst() {
        return mst;
    }

}
