package rafael.ordonez.graphs.datastructure;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by rafa on 13/8/15.
 */
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
}
