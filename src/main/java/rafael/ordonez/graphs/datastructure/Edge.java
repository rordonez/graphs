package rafael.ordonez.graphs.datastructure;

import java.util.Iterator;

/**
 *
 * This class represents a Edge in a Graph
 */
public class Edge {

    private final int source;
    private final int target;
    private final int weight;

    public Edge(int source, int target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public int getWeight() {
        return weight;
    }

    public int getTarget() {
        return target;
    }

    /**
     *
     * This method looks for a edge whose target vertex is equal to the parameter in the method. If it does not find any,
     * this method will return a null value.
     *
     * @param edges a list of edges
     * @param target target edge to look for
     * @return the requested edge or <b>null</b>
     */
    public static Edge findEdge(Iterable<Edge> edges, int target) {
        Edge edgeFound = null;
        Iterator<Edge> it = edges.iterator();
        while (it.hasNext() && edgeFound == null) {
            Edge edge = it.next();
            if (edge.getTarget() == target) {
                edgeFound = edge;
            }
        }
        return edgeFound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (source != edge.source) return false;
        if (target != edge.target) return false;

        return true;
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f", source, target, weight);
    }
}
