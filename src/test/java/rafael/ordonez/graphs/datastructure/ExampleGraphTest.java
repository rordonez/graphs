package rafael.ordonez.graphs.datastructure;

import org.hamcrest.core.IsCollectionContaining;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class ExampleGraphTest {

    public static final String ROUTES_DELIMITER = ", ";
    public static final String ROUTES_REG_EXP = "^[A-Z][A-Z][0-9]+$";

    @Test
    public void create_a_ExampleGraph_with_an_empty_string_should_return_an_empty_graph() {
        //Given
        String input = "";

        //When
        ExampleGraph exampleGraph = new ExampleGraph(input, ROUTES_DELIMITER, ROUTES_REG_EXP);

        //Then
        Assert.assertTrue(exampleGraph.getGraph().isEmpty());
    }

    @Test
    public void create_a_graph_with_an_invalid_route_should_return_an_empty_graph() throws Exception {
        //Given
        String input = "sd";

        //When
        ExampleGraph exampleGraph = new ExampleGraph(input, ROUTES_DELIMITER, ROUTES_REG_EXP);

        //Then
        Assert.assertTrue(exampleGraph.getGraph().isEmpty());
    }

    @Test
    public void create_a_graph_with_invalid_routes_separated_by_delimiters_should_return_an_empty_graph() throws Exception {
        //Given
        String input = "SD, AD, G";

        //When
        ExampleGraph exampleGraph = new ExampleGraph(input, ROUTES_DELIMITER, ROUTES_REG_EXP);

        //Then
        Assert.assertTrue(exampleGraph.getGraph().isEmpty());
    }

    @Test
    public void create_a_graph_with_valid_routes_but_invalid_delimiter_should_return_an_empty_graph() throws Exception {
        //Given
        String input = "AB1 BC3";

        //When
        ExampleGraph exampleGraph = new ExampleGraph(input, ROUTES_DELIMITER, ROUTES_REG_EXP);

        //Then
        Assert.assertTrue(exampleGraph.getGraph().isEmpty());
    }

    @Test
    public void create_a_graph_with_AB1_should_return_a_graph_with_two_vertices_and_one_edge() throws Exception {
        //Given
        String input = "AB1";

        //When
        ExampleGraph exampleGraph = new ExampleGraph(input, ROUTES_DELIMITER, ROUTES_REG_EXP);

        //Then
        Assert.assertEquals(exampleGraph.getGraph().getNumberOfVertices(), 2);
        Assert.assertEquals(exampleGraph.getGraph().getNumberOfEdges(), 1);
    }

    @Test
    public void createAGraph_AB1_BC2_should_return_a_graph_with_three_vertices_and_two_edges() throws Exception {
        //Given
        String input = "AB1, BC2";

        //When
        ExampleGraph exampleGraph = new ExampleGraph(input, ROUTES_DELIMITER, ROUTES_REG_EXP);

        //Then
        Assert.assertEquals(exampleGraph.getGraph().getNumberOfVertices(), 3);
        Assert.assertEquals(exampleGraph.getGraph().getNumberOfEdges(), 2);
    }

    @Test
    public void create_a_graph_AB1_B_BC3_should_return_a_graph_with_three_vertices_and_two_edges() throws Exception {
        //Given
        String input = "AB1, B, BC3";

        //When
        ExampleGraph exampleGraph = new ExampleGraph(input, ROUTES_DELIMITER, ROUTES_REG_EXP);

        //Then
        Assert.assertEquals(exampleGraph.getGraph().getNumberOfVertices(), 3);
        Assert.assertEquals(exampleGraph.getGraph().getNumberOfEdges(), 2);
    }

    @Test
    public void create_a_graph_AB5_BC4_CD8_DC8_DE6_AD5_CE2_EB3_AE7_should_return_a_valid_graph() throws Exception {
        //Given
        String input = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";

        //When
        ExampleGraph exampleGraph = new ExampleGraph(input, ROUTES_DELIMITER, ROUTES_REG_EXP);

        //Then
        Assert.assertEquals(exampleGraph.getGraph().getNumberOfVertices(), 5);
        Assert.assertEquals(exampleGraph.getGraph().getNumberOfEdges(), 9);
        assertThat(exampleGraph.getGraph().adjacent(exampleGraph.index("A")), IsCollectionContaining.hasItems(new Edge(exampleGraph.index("A"), exampleGraph.index("B"), 5), new Edge(exampleGraph.index("A"), exampleGraph.index("D"), 5), new Edge(exampleGraph.index("A"), exampleGraph.index("E"), 7)));
        assertThat(exampleGraph.getGraph().adjacent(exampleGraph.index("B")), IsCollectionContaining.hasItems(new Edge(exampleGraph.index("B"),exampleGraph.index("C"), 4)));
        assertThat(exampleGraph.getGraph().adjacent(exampleGraph.index("C")), IsCollectionContaining.hasItems(new Edge(exampleGraph.index("C"), exampleGraph.index("D"), 8), new Edge(exampleGraph.index("C"), exampleGraph.index("E"), 2)));
        assertThat(exampleGraph.getGraph().adjacent(exampleGraph.index("D")), IsCollectionContaining.hasItems(new Edge(exampleGraph.index("D"), exampleGraph.index("C"), 8), new Edge(exampleGraph.index("D"), exampleGraph.index("E"), 6)));
        assertThat(exampleGraph.getGraph().adjacent(exampleGraph.index("E")), IsCollectionContaining.hasItems(new Edge(exampleGraph.index("E"), exampleGraph.index("B"), 3)));
    }
}


