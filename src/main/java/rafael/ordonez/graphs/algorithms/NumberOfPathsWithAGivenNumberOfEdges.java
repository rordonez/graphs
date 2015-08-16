package rafael.ordonez.graphs.algorithms;


import rafael.ordonez.graphs.datastructure.Edge;
import rafael.ordonez.graphs.datastructure.Graph;

public class NumberOfPathsWithAGivenNumberOfEdges {

    private int numberOfPaths;

    public NumberOfPathsWithAGivenNumberOfEdges(Graph graph, int start, int target, int numberOfEdges) {
        numberOfPaths = 0;
        calculateNumberOfPaths(graph, start, target, numberOfEdges);
    }

    /**
     *
     * This is an implementation of the Deep First Search Algorithm that counts all the paths with an exactly amount of edges
     *
     * @param graph input graph
     * @param start start vertex to begin the path
     * @param target target vertex of the path
     * @param edges exact number of edges of the path
     */
    private void calculateNumberOfPaths(Graph graph, int start, int target, int edges) {
        if(edges == 0) {
            if(start == target) {
                numberOfPaths++;
            }
        }
        else {
            for(Edge edge : graph.adjacent(start)) {
                calculateNumberOfPaths(graph, edge.getTarget(), target, edges - 1);
            }
        }
    }

    public int getNumberOfPaths() {
        return numberOfPaths;
    }
}
