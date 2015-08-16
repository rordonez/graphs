package rafael.ordonez.graphs.datastructure;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class EdgeTest {

    @Test
    public void testFindEdge() throws Exception {
        //Given
        List<Edge> edges = Arrays.asList(new Edge(1, 2, 3), new Edge(2,1,4));

        //When
        Edge edge = Edge.findEdge(edges, 2);

        //Then
        assertNotNull(edge);
        assertThat(edge.getTarget(), is(2));
    }

    @Test
    public void testFindEdgeWhenNoEdgeIsFound() throws Exception {
        //Given
        List<Edge> edges = Arrays.asList(new Edge(1, 2, 3), new Edge(2,1,4));

        //When
        Edge edge = Edge.findEdge(edges, 5);

        //Then
        assertNull(edge);
    }

    @Test
    public void testEquals() throws Exception {
        //Given
        Edge edge = new Edge(1, 2, 3);

        //When
        assertTrue(edge.equals(edge));
        assertTrue(edge.equals(new Edge(1, 2, 5)));
        assertFalse(edge.equals(null));
        assertFalse(edge.equals(new Object()));
        assertFalse(edge.equals(new Edge(2, 1, 3)));
    }
}
