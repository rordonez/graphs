package rafael.ordonez.graphs.algorithms;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static rafael.ordonez.graphs.datastructure.mock.GraphTestUtils.createGraph;

public class ShortestDirectedCycleTest {

    @Test
    public void calculate_shortest_distance_in_the_cycle_of_vertex_B_should_return_9() throws Exception {
        //Given
        int vertex = 1;  //B
        ShortestDirectedCycle shortestDirectedCycle = new ShortestDirectedCycle(createGraph(), vertex);

        //When
        int distance = shortestDirectedCycle.getShortestDistance();

        //Then
        assertThat(distance, is(9));  //Route B-C-E-B
    }

    @Test
    public void calculate_shortest_distance_in_the_cycle_of_the_vertex_C_should_return_8() throws Exception {
        //Given
        int vertex = 2;  // C
        ShortestDirectedCycle shortestDirectedCycle = new ShortestDirectedCycle(createGraph(), vertex);

        //When
        int distance = shortestDirectedCycle.getShortestDistance();

        //Then
        assertThat(distance, is(9));  //Route C-E-B-C
    }

    @Test
    public void calculate_shortest_distance_in_the_cycle_of_the_vertex_D_should_return_16() throws Exception {
        //Given
        int vertex = 3;  //D
        ShortestDirectedCycle shortestDirectedCycle = new ShortestDirectedCycle(createGraph(), vertex);

        //When
        int distance = shortestDirectedCycle.getShortestDistance();

        //Then
        assertThat(distance, is(16));  //Route C-D-C
    }

    @Test
    public void calculate_shortest_distance_in_the_cycle_of_the_vertex_E_should_return_9() throws Exception {
        //Given
        int vertex = 4;  //E
        ShortestDirectedCycle shortestDirectedCycle = new ShortestDirectedCycle(createGraph(), vertex);

        //When
        int distance = shortestDirectedCycle.getShortestDistance();

        //Then
        assertThat(distance, is(9));  //Route E-B-C-E
    }
}
