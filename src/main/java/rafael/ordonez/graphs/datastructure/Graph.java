package rafael.ordonez.graphs.datastructure;

import java.util.HashSet;

/**
 *
 * By convention, I use the names 0 through 1 for the vertices in a V-vertex graph.The main reason that I choose
 * this system is to make it easy to write code that efficiently accesses information corresponding to each vertex,
 * using array indexing. It is possible to use a class with a Graph with <code>String</code> nodes and transform it
 * to this graph.
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
     * @throws NullPointerException if the parameter <code>edge</code> is null
     * @throws IndexOutOfBoundsException if the source vertex in the edge parameter is out of bounds
     */
    public void addEdge(Edge edge) {
        parameterValidation(edge);
        adjacencyList[edge.getSource()].add(edge);
        numberOfEdges++;
    }

    private void parameterValidation(Edge edge) {
        if(edge == null) {
            throw new NullPointerException("The parameter edge is null");
        }
        else {
            validateRange(edge.getSource());
        }
    }

    private void validateRange(int source) {
        if (source < 0 || source >numberOfVertices) {
            throw new IndexOutOfBoundsException("Source vertex: " + source + " is out of bounds. Check the range.");
        }
    }

    /**
     *
     * This method returns a set of all adjacents vertices given a source one.
     *
     * @param vertex source vertex to obtain all its adjacents
     * @return a {@link HashSet} with all adjacents vertices to <code>vertex</code>
     * @throws IndexOutOfBoundsException if the source vertex is not on the graph.
     */
    public HashSet<Edge> adjacent(int vertex) {
        validateRange(vertex);
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