package rafael.ordonez.graphs.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * This class contains a vertices table to establish a 1 to 1 mapping to associate V arbitrary vertex names with the V
 * integers between 0 and V1, so the convenience of using indices as vertex names comes without loss of generality
 * <code>and without much loss of efficiency</code>
 */
public class ExampleGraph {

    private Map<String, Integer> verticesTable;
    private Graph graph;

    /**
     *
     * This constructor loads a graph from a <code>String</code>, loads the vertices table and creates a
     * <code>Graph</code>. To parse the routes, it is used a delimiter and a routesPattern defined in the <code>Main</code>
     * This can be changed for convenience.
     *
     * @param routesString string that contains the list of the routes of the graph
     * @param delimiter is a delimiter to separate the routes
     * @param routesPattern each route matches with the regular expression defined in Main.ROUTES_REG_EXP
     */
    public ExampleGraph(String routesString, String delimiter, String routesPattern) {
        String [] routes = routesString.split(delimiter);
        loadVerticesTable(routes, routesPattern);
        createGraph(routes, routesPattern);
    }

    /**
     *
     * This method returns the index associated to the vertex name specified
     *
     * @param vertexName vertex name
     * @return the index at the vertices table
     */
    public int index(String vertexName) {
        return verticesTable.get(vertexName);
    }

    public Graph getGraph() {
        return graph;
    }

    private void loadVerticesTable(String[] routes, String routesPattern) {
        verticesTable = new HashMap<>();

        for (String route : routes) {
            if(validateSyntax(route, routesPattern)) {
                addVertexToVerticesTable(route.substring(0, 1));
                addVertexToVerticesTable(route.substring(1, 2));
            }
        }
    }

    private void addVertexToVerticesTable(String vertex) {
        if(!verticesTable.containsKey(vertex)) {
            verticesTable.put(vertex, verticesTable.size());
        }
    }

    private void createGraph(String[] routes, String routesPattern) {
        graph = new Graph(verticesTable.size());
        for (String route : routes) {
            if(validateSyntax(route, routesPattern)) {
                graph.addEdge(new Edge(verticesTable.get(route.substring(0, 1)), verticesTable.get(route.substring(1, 2)), Integer.parseInt(route.substring(2))));
            }
        }
    }

    private boolean validateSyntax(String route, String routesPattern) {
        Pattern p = Pattern.compile(routesPattern);
        Matcher m = p.matcher(route);
        return m.find();
    }
}
