package rafael.ordonez.graphs.algorithms;

import rafael.ordonez.graphs.datastructure.Edge;
import rafael.ordonez.graphs.datastructure.Graph;

/**
 *
 * This class provides a modification of Deep First Search algorithm to calculate all the routes with a distance smaller than a given one.
 */
public class NumberOfRoutesUnderDistance {

    private int numberOfRoutes;

    public NumberOfRoutesUnderDistance(Graph graph, int sourceVertex, int targetVertex, int distance) {
        numberOfRoutes = 0;
        calculateDistancesWithin(graph, sourceVertex, targetVertex, 0, distance);
    }

    private void calculateDistancesWithin(Graph graph, int sourceVertex, int targetVertex, int accumulatedDistance, int distance) {
        if(accumulatedDistance < distance) {
            for(Edge edge : graph.adjacent(sourceVertex)) {
                if(targetVertex == edge.getTarget() && accumulatedDistance + edge.getWeight() < distance) {
                    numberOfRoutes++;
                }
                calculateDistancesWithin(graph, edge.getTarget(), targetVertex, accumulatedDistance + edge.getWeight(), distance);
            }
        }
    }

    public int getNumberOfRoutes() {
        return numberOfRoutes;
    }
}
