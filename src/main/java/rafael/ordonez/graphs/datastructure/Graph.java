package rafael.ordonez.graphs.datastructure;

import java.util.HashSet;

/**
 *
 * By convention, I use the names 0 through 1 for the vertices in a V-vertex graph.The main reason that I choose
 * this system is to make it easy to write code that efficiently accesses information corresponding to each vertex,
 * using array indexing. The class {@link ExampleGraph} uses this class to transform symbol vertex names into
 * indexes.
 *
 * An array of adjacency sets, where I maintain a vertex-indexed array of sets of the vertices adjacent to each vertex.
 * This Graph implementation achieves the following performance characteristics:
 *
 * <ul>
 *  <li>Space usage proportional to V + E</li>
 *  <li>Constant time to add an edge</li>
 *  <li>Time proportional to the degree of v to iterate through vertices adjacent to v (constant time per adjacent vertex
 *  processed)</li>
 *</ul>
 *
 *  <b>Note:</b> It is important to realize that the order in which edges are added to the graph determines the order in
 *  which vertices appear in the array.
 */
public class Graph {

    private final int numberOfVertices;
    private int numberOfEdges;
    private HashSet<Edge> [] adjacencyList;

    /**
     *
     * Create a graph given a number of vertices. This constructor initializes a structure to store the adjacent of
     * each vertex. The data structure used is an array where each vertex is an index of the array.
     *
     * @param numberOfVertices
     */
    public Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.numberOfEdges = 0;
        adjacencyList = new HashSet[numberOfVertices];
        for (int vertex = 0; vertex < numberOfVertices; vertex++)
            adjacencyList[vertex] = new HashSet<>();
    }

    /**
     *
     * This method returns the number of vertices of the Graph
     *
     * @return the number of vertices of the graph
     */
    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    /**
     *
     * This method returns the number of edges of the Graph
     *
     * @return number of edges of the Graph
     */
    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    /**
     *
     * This method adds a new Edge to the Graph. The new edge is added to the corresponding array of vertices at index
     * {@link Edge#getSource()}
     *
     * @param edge is the edge to add
     */
    public void addEdge(Edge edge) {
        adjacencyList[edge.getSource()].add(edge);
        numberOfEdges++;
    }

    public HashSet<Edge> adjacent(int vertex) {
        return adjacencyList[vertex];
    }

    public boolean isEmpty() {
        return numberOfVertices == 0;
    }


    @Override
    public String toString() {
        StringBuilder graphRepresentation = new StringBuilder(numberOfVertices).append(" vertices, ").append(numberOfEdges).append(" edges\n");
        for (int vertex = 0; vertex < numberOfVertices; vertex++) {
            graphRepresentation.append(vertex).append(": ");
            for (Edge w : this.adjacent(vertex)) {
                graphRepresentation.append(w.getTarget()).append(" ");
            }
            graphRepresentation. append("\n");
        }
        return graphRepresentation.toString();
    }

}