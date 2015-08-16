package rafael.ordonez.graphs.algorithms;

import rafael.ordonez.graphs.datastructure.Edge;
import rafael.ordonez.graphs.datastructure.Graph;


public class NumberOfPathsTakingOnlyAGivenNumberOfEdges {
    private int numberOfPaths;

    public NumberOfPathsTakingOnlyAGivenNumberOfEdges(Graph graph, int start, int target, int maximumNumberOfVertices) {
        numberOfPaths = 0;
        calculateNumberOfPaths(graph, start, target, maximumNumberOfVertices);
    }

    /**
     *
     * This method is an implementation of the Deep First Search algorithm that returns all the paths with a maximum of edges indicated
     * in the edges param.
     *
     * @param graph A graph to search for paths
     * @param start start vertex to begin the search
     * @param target target vertex of the path
     * @param edges The maximum number of edges allowed
     */
    private void calculateNumberOfPaths(Graph graph, int start, int target, int edges) {
        if(edges != 0) {
            for(Edge edge : graph.adjacent(start)) {
                if(edge.getTarget() == target) {
                    numberOfPaths++;
                }
                calculateNumberOfPaths(graph, edge.getTarget(), target, edges - 1);
            }
        }
    }

    /**
     *
     * This method returns the number of paths found for this algorithm
     *
     * @return the number of paths
     */
    public int getNumberOfPaths() {
        return numberOfPaths;
    }

}
