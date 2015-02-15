package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DijkstraAlgorithm {

    private final List<Vertex> nodes;
    private final List<Edge> edges;
    private Set<Vertex> visitedNodes;
    private Set<Vertex> unvisitedNodes;
    private Map<Vertex, Vertex> parent;
    private Map<Vertex, Integer> distance;

    // 1 function Dijkstra(Graph, source):
    // 2 for each vertex v in Graph: // Initializations
    // 3 dist[v] := infinity ; // Unknown distance function from
    // 4 // source to v
    // 5 previous[v] := undefined ; // Previous node in optimal path
    // 6 end for // from source
    // 7
    // 8 dist[source] := 0 ; // Distance from source to source
    // 9 Q := the set of all nodes in Graph ; // All nodes in the graph are
    // 10 // unoptimized � thus are in Q
    // 11 while Q is not empty: // The main loop
    // 12 u := vertex in Q with smallest distance in dist[] ; // Source node in
    // first case
    // 13 remove u from Q ;
    // 14 if dist[u] = infinity:
    // 15 break ; // all remaining vertices are
    // 16 end if // inaccessible from source
    // 17
    // 18 for each neighbor v of u: // where v has not yet been
    // 19 // removed from Q.
    // 20 alt := dist[u] + dist_between(u, v) ;
    // 21 if alt < dist[v]: // Relax (u,v,a)
    // 22 dist[v] := alt ;
    // 23 previous[v] := u ;
    // 24 decrease-key v in Q; // Reorder v in the Queue
    // 25 end if
    // 26 end for
    // 27 end while
    // 28 return dist;
    // 29 endfunction

    public DijkstraAlgorithm(Graph graph) {

        this.nodes = new ArrayList<>(graph.getVertices());
        this.edges = new ArrayList<>(graph.getEdges());

        visitedNodes = new HashSet<>();
        unvisitedNodes = new HashSet<>();
        distance = new HashMap<>();
        parent = new HashMap<>();
    }

    private void initialize() {

        for (Vertex node : this.nodes) {
            unvisitedNodes.add(node);
        }
    }

    public void search(Vertex source) {

        initialize();

        Vertex current = source;
        distance.put(source, 0);
        unvisitedNodes.remove(source);

        while (!unvisitedNodes.isEmpty()) {

            int distanceToCurrent = getShortestDistance(current);
            
            // Stop if we have unconnected node
            if (distanceToCurrent == Integer.MAX_VALUE) {
                break;
            }

            List<Vertex> adjacentNodes = getAdjacent(current);
            
            for (Vertex target : adjacentNodes) {
                int distanceToTarget = distanceToCurrent + getDistance(current, target);
                if (getShortestDistance(target) > distanceToTarget) {
                    distance.put(target, distanceToTarget);
                    parent.put(target, current);
                }
            }

            unvisitedNodes.remove(current);
            visitedNodes.add(current);

            current = getClosestUnvisited();
        }
    }

    private int getDistance(Vertex node, Vertex target) {
        for (Edge edge : edges) {
            if (edge.getSource().equals(node) && edge.getDestination().equals(target)) {
                return edge.getWeight();
            }
        }
        return Integer.MAX_VALUE;
    }

    private List<Vertex> getAdjacent(Vertex node) {
        List<Vertex> neighbors = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(node) && !isVisited(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private Vertex getClosestUnvisited() {
        Vertex nearest = null;
        for (Vertex vertex : unvisitedNodes) {
            if (nearest == null) {
                nearest = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(nearest)) {
                    nearest = vertex;
                }
            }
        }
        return nearest;
    }

    private boolean isVisited(Vertex vertex) {
        return visitedNodes.contains(vertex);
    }

    private int getShortestDistance(Vertex destination) {
        Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    /*
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     */
    public LinkedList<Vertex> getPath(Vertex target) {
        LinkedList<Vertex> path = new LinkedList<>();
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
