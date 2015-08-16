package rafael.ordonez.graphs.datastructure;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GraphTest {

    @Test
    public void testEmptyGraphCreation() throws Exception {
        //When
        Graph graph = new Graph(0);

        //Then
        assertThat(graph.isEmpty(), is(true));
        assertThat(graph.getNumberOfEdges(), is(0));
        assertThat(graph.getNumberOfVertices(), is(0));
    }

    @Test
    public void testOneVertexGraph() throws Exception {
        //When
        Graph graph = new Graph(1);

        //Then
        assertThat(graph.isEmpty(), is(false));
        assertThat(graph.getNumberOfEdges(), is(0));
        assertThat(graph.getNumberOfVertices(), is(1));
        assertThat(graph.adjacent(0).size(), is(0));
    }


    @Test(expected = NullPointerException.class)
    public void testAddEdgeWithNullEdge() throws Exception {
        //Given
        Graph graph = new Graph(3);

        //Then
        graph.addEdge(null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddEdgeWithInvalidSourceEdge() throws Exception {
        //Given
        Graph graph = new Graph(1);

        //Then
        graph.addEdge(new Edge(2, 1, 3));
    }

    @Test
    public void testAddEdge() throws Exception {
        //Given
        Graph graph = new Graph(3);

        //When
        graph.addEdge(new Edge(1, 2, 4));
        graph.addEdge(new Edge(2, 3, 6));
        graph.addEdge(new Edge(1, 3, 3));

        //Then
        assertThat(graph.getNumberOfEdges(), is(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAdjacentWithInvalidVertex() throws Exception {
        //Given
        Graph graph = new Graph(0);

        //When
        graph.adjacent(1);
    }

    @Test
    public void testAdjacent() throws Exception {
        //Given
        Graph graph = new Graph(3);

        //When
        graph.addEdge(new Edge(1, 2, 4));
        graph.addEdge(new Edge(2, 3, 6));
        graph.addEdge(new Edge(1, 3, 3));

        //Then
        assertThat(graph.adjacent(1).size(), is(2));
        assertThat(graph.adjacent(2).size(), is(1));
    }
}
