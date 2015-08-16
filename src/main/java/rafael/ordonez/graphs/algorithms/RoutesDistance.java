package rafael.ordonez.graphs.algorithms;

import rafael.ordonez.graphs.datastructure.Edge;
import rafael.ordonez.graphs.datastructure.Graph;

/**
 * This class contains a method to calculate the distance along a route.
 */
public class RoutesDistance {


    private int distance;
    private boolean existRoute;

    public RoutesDistance(Graph graph, int [] route) {
        this.distance = 0;
        this.existRoute = route != null && route.length > 1;
        calculateDistance(graph, route);
    }

    /**
     *
     * This method returns the distance within a route. It must exist each edge that connects every vertex inside the
     * give route.
     *
     * @param graph a graph to look for a route
     * @param route a route to look for
     * @return a distance for the given route or zero if this route does not exist
     */
    private void calculateDistance(Graph graph, int[] route) {
        int i = 0;
        while (existRoute && i < route.length - 1) {
            addEdgeToRoute(Edge.findEdge(graph.adjacent(route[i++]), route[i]));
        }
    }

    private void addEdgeToRoute(Edge edge) {
        existRoute = edge != null;
        distance = existRoute ? distance + edge.getWeight() : 0;
    }

    public int getDistance() {
        return distance;
    }

    public boolean existRoute() {
        return existRoute;
    }
}
