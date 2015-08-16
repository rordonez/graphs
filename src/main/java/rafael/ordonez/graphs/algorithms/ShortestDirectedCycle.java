package rafael.ordonez.graphs.algorithms;

import rafael.ordonez.graphs.datastructure.Edge;
import rafael.ordonez.graphs.datastructure.Graph;

/**
 *
 * Dijkstra algorithm finds all the distances between a source vertex and the others. A call to Dijkstra to find
 * a distance for vertex itself returns 0. One solution to find all distances between vertices is to use the Floyd-Warshall
 * algorithm with O(V)3 complexity. This class reuses Dijkstra algorithm to this purpose.
 *
 */
public class ShortestDirectedCycle {

    private int shortestDistance = Integer.MAX_VALUE;

    public ShortestDirectedCycle(Graph graph, int vertex) {
        for (Edge edge : graph.adjacent(vertex)) {
            Dijkstra dijkstra = new Dijkstra(graph, edge.getTarget());
            int distance = dijkstra.shortestDistance(vertex);
            if (distance != -1) {
                distance += edge.getWeight();
                if (distance < shortestDistance) {
                    shortestDistance = distance;
                }
            }
        }
    }

    public int getShortestDistance() {
        return shortestDistance;
    }
}
