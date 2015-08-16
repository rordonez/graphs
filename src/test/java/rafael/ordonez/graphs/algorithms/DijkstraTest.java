package rafael.ordonez.graphs.algorithms;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static rafael.ordonez.graphs.datastructure.mock.GraphTestUtils.createGraph;

public class DijkstraTest {

    @Test
    public void calculate_shortest_route_between_B_A_with_no_route_should_throw_an_exception() throws Exception {
        //Given
        int sourceVertex = 1;  //B
        int targetVertex = 0;  //A
        Dijkstra dijkstra = new Dijkstra(createGraph(), sourceVertex);

        //When
        int distance = dijkstra.shortestDistance(targetVertex);
        assertThat(distance, is(lessThan(0)));
    }

    @Test
    public void calculate_shortest_route_between_A_B_should_return_5() throws Exception {
        //Given
        int sourceVertex = 0;  //A
        int targetVertex = 1;  //B
        Dijkstra dijkstra = new Dijkstra(createGraph(), sourceVertex);

        //When
        int distance = dijkstra.shortestDistance(targetVertex);

        //Then
        assertThat(distance, is(5));
    }

    @Test
    public void calculate_shortest_route_between_A_C_should_return_9() throws Exception {
        //Given
        int sourceVertex = 0;  //A
        int targetVertex = 2;  //C
        Dijkstra dijkstra = new Dijkstra(createGraph(), sourceVertex);

        //When
        int distance = dijkstra.shortestDistance(targetVertex);

        //Then
        assertThat(distance, is(9));
    }
}
