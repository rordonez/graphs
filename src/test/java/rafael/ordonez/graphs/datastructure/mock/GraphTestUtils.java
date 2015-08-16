package rafael.ordonez.graphs.datastructure.mock;

import rafael.ordonez.graphs.datastructure.Edge;
import rafael.ordonez.graphs.datastructure.Graph;

public class GraphTestUtils {

    public static Graph createGraph() {
        Graph graph = new Graph(5);
        graph.addEdge(new Edge(0, 1, 5));
        graph.addEdge(new Edge(1, 2, 4));
        graph.addEdge(new Edge(2, 3, 8));
        graph.addEdge(new Edge(3, 2, 8));
        graph.addEdge(new Edge(3, 4, 6));
        graph.addEdge(new Edge(0, 3, 5));
        graph.addEdge(new Edge(2, 4, 2));
        graph.addEdge(new Edge(4, 1, 3));
        graph.addEdge(new Edge(0, 4, 7));

        return graph;
    }
}
