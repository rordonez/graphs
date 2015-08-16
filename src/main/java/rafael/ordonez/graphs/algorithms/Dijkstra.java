package rafael.ordonez.graphs.algorithms;

import rafael.ordonez.graphs.datastructure.Edge;
import rafael.ordonez.graphs.datastructure.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * This is an implementation of the Dijkstra algorithm to find shortest paths between vertices.
 *
 */
public class Dijkstra {
    private Edge[] shortestEdgesInTree;
    private int [] distanceTo;
    private PriorityQueue<Integer> eligibleEdges;

    public Dijkstra(Graph graph,  int sourceVertex) {
        this.shortestEdgesInTree = new Edge[graph.getNumberOfVertices()];
        this.distanceTo = new int[graph.getNumberOfVertices()];
        Arrays.fill(distanceTo, Integer.MAX_VALUE);
        this.eligibleEdges = new PriorityQueue<>(graph.getNumberOfVertices());

        distanceTo[sourceVertex] = 0;
        eligibleEdges.add(sourceVertex);
        while(!eligibleEdges.isEmpty()) {
            relax(graph, eligibleEdges.poll());
        }
    }

    private void relax(Graph graph, int vertex) {
        for (Edge edge : graph.adjacent(vertex)) {
            int toVertex = edge.getTarget();
            if(distanceTo[toVertex] > distanceTo[vertex] + edge.getWeight()) {
                eligibleEdges.remove(toVertex);
                distanceTo[toVertex] = distanceTo[vertex] + edge.getWeight();
                shortestEdgesInTree[toVertex] = edge;
                eligibleEdges.add(toVertex);
            }
        }
    }

    public int shortestDistance(int targetVertex) {
        if(distanceTo[targetVertex] == Integer.MAX_VALUE) {
            return -1;
        }
        return distanceTo[targetVertex];
    }
}
